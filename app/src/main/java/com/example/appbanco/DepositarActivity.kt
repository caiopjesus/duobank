package com.example.appbanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DepositarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depositar)
        setSupportActionBar(findViewById(R.id.toolbar5))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnConcdeposit)
        val edtChave = findViewById<EditText>(R.id.editNumconta)
        val edtCodagencia = findViewById<EditText>(R.id.editNumagencia)
        btConf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.editValdeposit)
            val nvalor = valorPix.text.toString().toDouble()
            nsaldo += nvalor
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtChave.setText("".toString())
            edtCodagencia.setText("".toString())
            finish()
        }
    }
}