package com.example.practicekt.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.practicekt.R
import com.example.practicekt.fragments.CustomDialogFragment

class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        val button = findViewById<AppCompatButton>(R.id.btnDialog)

        /*button.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "CustomDialogFragment")
        }*/
            button.setOnClickListener {
                val buildDialog = AlertDialog.Builder(this)
                buildDialog.setIcon(R.drawable.img)
                buildDialog.setTitle("E2Logy software solution")
                buildDialog.setMessage("HostComposition ext ANDROID_EMU_CHECKSUM_HELPER_v1 ANDROID_EMU_native_sync_v2 ANDROID_EMU_native_sync_v3 ANDROID_EMU_native_sync_v4 ANDROID_EMU_dma_v1 ANDROID_EMU_direct_mem ANDROID_EMU_")

                buildDialog.setPositiveButton("Yes"
                ) { _, _ -> Log.d(TAG, "Successfully Clicked on Yes") }

    //            buildDialog.setPositiveButtonIcon(resources.getDrawable(R.drawable.img_1))

                buildDialog.setNeutralButton("Cancel"
                ) { _, _ -> Log.d(TAG, "Successfully Clicked on Cancel") }

                buildDialog.setNegativeButton("No"
                ) { _, _ -> Log.d(TAG, "Successfully Clicked on No") }

                val create : AlertDialog = buildDialog.create()
                create.show()
                create.window?.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.edittext_bg))
            }
    }

}