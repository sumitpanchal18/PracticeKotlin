package com.example.practicekt.activity.sp

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.practicekt.R
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class BarCodeScanner : AppCompatActivity() {

    private lateinit var barcodeView: DecoratedBarcodeView
    private val CAMERA_PERMISSION_REQUEST = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the ActionBar if present
        supportActionBar?.hide()

        // Enable full-screen immersive mode
        enableImmersiveMode()

        setContentView(R.layout.activity_bar_code_scanner)
        barcodeView = findViewById(R.id.scanner_view)

        if (checkCameraPermission()) {
            setupBarcodeScanner()
        } else {
            requestCameraPermission()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            enableImmersiveMode()
        }
    }

    /**
     * Enables immersive mode to hide system UI elements.
     */
    private fun enableImmersiveMode() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                )
    }

    /**
     * Sets up the barcode scanner to continuously decode barcodes and handle the results.
     */
    private fun setupBarcodeScanner() {
        barcodeView.decodeContinuous { result ->
            result.text?.let { barcode ->
                Log.d(TAG, "Barcode text : $barcode")
                handleBarcodeResult(barcode)
            }
        }

        barcodeView.initializeFromIntent(intent)
        barcodeView.setStatusText("")
    }

    /**
     * Checks if the camera permission has been granted.
     */
    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Requests the camera permission from the user.
     */
    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            CAMERA_PERMISSION_REQUEST
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupBarcodeScanner()
            } else {
                Toast.makeText(this, "Camera permission is required", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (checkCameraPermission()) {
            barcodeView.resume()
        }
    }

    override fun onPause() {
        super.onPause()
        barcodeView.pause()
    }

    /**
     * Analyzes the scanned barcode and launches the appropriate app based on its content.
     */
    private fun handleBarcodeResult(barcode: String) {
        when {
            // Email: if the text starts with "mailto:" or matches an email address pattern.
            barcode.startsWith("mailto:") || android.util.Patterns.EMAIL_ADDRESS.matcher(barcode).matches() -> {
                openEmailApp(barcode)
            }
            // Phone: if the text starts with "tel:" or matches a phone number pattern.
            barcode.startsWith("tel:") || android.util.Patterns.PHONE.matcher(barcode).matches() -> {
                openDialer(barcode)
            }
            // Maps: if the text starts with "geo:".
            barcode.startsWith("geo:") -> {
                openMaps(barcode)
            }
            // URL: if the text matches a web URL pattern.
            android.util.Patterns.WEB_URL.matcher(barcode).matches() -> {
                openBrowser(barcode)
            }
            // Fallback: if none of the above match, offer to share the text.
            else -> {
                shareText(barcode)
            }
        }
    }

    /**
     * Opens the email app using the scanned email address or mailto link.
     */
    private fun openEmailApp(emailData: String) {
        val emailUri = if (!emailData.startsWith("mailto:")) "mailto:$emailData" else emailData
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse(emailUri)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Opens the dialer with the scanned phone number.
     */
    private fun openDialer(phoneData: String) {
        val phoneUri = if (!phoneData.startsWith("tel:")) "tel:$phoneData" else phoneData
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse(phoneUri)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No dialer app found", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Opens the browser with the scanned URL.
     */
    private fun openBrowser(urlData: String) {
        // Ensure the URL has a valid scheme
        val url = if (!urlData.startsWith("http://") && !urlData.startsWith("https://")) "http://$urlData" else urlData
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No browser app found", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Opens the maps application with the scanned geo URI.
     */
    private fun openMaps(geoData: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(geoData)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No maps app found", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Offers a share intent for the scanned text.
     */
    private fun shareText(text: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        startActivity(Intent.createChooser(intent, "Share via"))
    }
}
