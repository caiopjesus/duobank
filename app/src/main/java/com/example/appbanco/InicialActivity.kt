package com.example.appbanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class InicialActivity : AppCompatActivity() {
    val COD_TELA = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_TELA && resultCode == Activity.RESULT_OK) {
            val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
            val sSaldo = data!!.getStringExtra("sSaldo")
            txtSaldo.setText(sSaldo)
        }
    }

    fun btnPix(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, PixActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    fun btnPagar(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, PagarActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }
    fun btnTransferir(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, TransferirActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }
    fun btnDepositar(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, DepositarActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }
}
