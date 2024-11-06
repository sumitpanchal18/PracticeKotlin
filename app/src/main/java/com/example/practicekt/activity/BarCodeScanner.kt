package com.example.practicekt.activity

import android.Manifest
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
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
        setContentView(R.layout.activity_bar_code_scanner)

        barcodeView = findViewById(R.id.scanner_view)

        if (checkCameraPermission()) {
            setupBarcodeScanner()
        } else {
            requestCameraPermission()
        }
    }

    private fun setupBarcodeScanner() {
        barcodeView.decodeContinuous { result ->
            result.text?.let { barcode ->
                Log.d(TAG, "Barcode text : $barcode")
                Toast.makeText(this, barcode, Toast.LENGTH_SHORT).show()
            }
        }

        barcodeView.initializeFromIntent(intent)
        barcodeView.setStatusText("")
    }

    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

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
}