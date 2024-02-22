package com.example.appbanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class TransferirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferir)
        setSupportActionBar(findViewById(R.id.toolbar6))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnConctransfer)
        val edtChave = findViewById<EditText>(R.id.editConta)
        val edtagencia = findViewById<EditText>(R.id.editAgencia)
        btConf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.editValtransfer)
            val nvalor = valorPix.text.toString().toDouble()
            if (nvalor>nsaldo) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                nsaldo -= nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtChave.setText("".toString())
            edtagencia.setText("".toString())
            finish()
        }
    }
}