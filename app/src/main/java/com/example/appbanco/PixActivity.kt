package com.example.appbanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.result.ActivityResult

class PixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix2)
        setSupportActionBar(findViewById(R.id.toolbar3))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnConfirmar)
        val edtChave = findViewById<EditText>(R.id.editChavepix)
        btConf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.editPix)
            val nvalor = valorPix.text.toString().toDouble()
            if (nvalor>nsaldo) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "$nsaldo", LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtChave.setText("".toString())
            finish()
        }

    }
}