package com.example.mapplaceapi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Nullable


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_next.setOnClickListener {
            openActivityForResult()
        }
    }

    fun openActivityForResult() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivityForResult(intent, 123)
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && requestCode == 123) {
            var lat = data?.getStringExtra("location")
            var lang = data?.getStringExtra("latlang")
            txt_address.text= lat+","+lang
        }

    }
}