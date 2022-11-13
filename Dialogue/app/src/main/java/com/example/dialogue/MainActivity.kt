package com.example.dialogue

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prog = ProgressDialog(this@MainActivity)
        prog.setMessage("Downloading Music")
        prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); prog.setIndeterminate(true)
        prog.setProgress(0)
        prog.show()
        Toast.makeText(this, "Toast Message", Toast.LENGTH_LONG).show()
        var sb1 : Button = findViewById(R.id.sb1)
        sb1.setOnClickListener {
            val Sb = Snackbar.make(it,"connexion impossible",Snackbar.LENGTH_LONG)
            Sb.show()
        }
        var wb :WebView = findViewById(R.id.web)
        wb.settings.javaScriptEnabled = true
        wb.webViewClient = WebViewClient()
        wb.loadUrl("https://isetbz.rnu.tn/")
        wb.settings.setSupportZoom(true)
    }
    fun valider(v: View?) {
        var nom : EditText =findViewById(R.id.nom)
        var prenom : EditText = findViewById(R.id.prenom)
        var email : EditText =findViewById(R.id.email)
        if (nom.getText().length === 0 || prenom.getText().length === 0 || email.getText().length === 0
        ) {
            val ad = AlertDialog.Builder(this)
            ad.setMessage("Les champs ne doivent pas être vide")
            ad.setTitle("Error")
            ad.setIcon(android.R.drawable.btn_dialog)
            ad.setPositiveButton("yes",
                DialogInterface.OnClickListener { dialogInterface, i -> finish() })
            val a: AlertDialog = ad.create()
            a.show()
        }
    }

}