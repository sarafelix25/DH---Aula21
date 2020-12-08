package com.example.snackbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_body.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //apenas "Boas vindas"
        showSnack()


        //evento que carrega info usuario e vai para a tela main
        login_body_button.setOnClickListener {
            //Toast.makeText(this, "Botão LOGIN clicado", Toast.LENGTH_SHORT).show()
            val usuario = getInfoUsuario()
            val intentVaiParaMain = Intent(this, MainActivity::class.java)
            intentVaiParaMain.putExtra("Chave", usuario)
            startActivity(intentVaiParaMain)
        }


        //evento que abre a tela de cadastro
        login_cadastrar.setOnClickListener {
            // Toast.makeText(this, "CADASTRE-SE clicado", Toast.LENGTH_SHORT).show()
            val intentVaiParaCadastro = Intent(this, CadastroActivity::class.java)
            startActivity(intentVaiParaCadastro)
        }

    }

    //pegando info do usuario
    fun getInfoUsuario(): Usuario {
        val username = edUserName.text.toString()
        val password = edPassword.text.toString()
        return Usuario(1, username, password)
    }


    fun showSnack() {
        val snack = Snackbar.make(login_coordinator, "Bem vindo!!!", Snackbar.LENGTH_LONG)
        snack.setDuration(1000)
        snack.show()
    }

    fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}