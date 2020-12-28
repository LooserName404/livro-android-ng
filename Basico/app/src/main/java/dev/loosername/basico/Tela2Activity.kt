package dev.loosername.basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_tela2.*
import org.parceler.Parcels

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val cliente = Parcels.unwrap<Cliente?>(intent.getParcelableExtra("cliente"))
        val pessoa = intent.getParcelableExtra<Pessoa>("pessoa")
        textMensagem.text = if (cliente != null) {
            getString(R.string.tela2_texto1, cliente.nome, cliente.codigo)
        } else if (pessoa != null) {
            getString(R.string.tela2_texto2, pessoa.nome, pessoa.idade)
        } else {
            getString(R.string.tela2_texto2, nome, idade)
        }

        Log.i("TV2C", "Tela2::onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TV2C", "Tela2::onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TV2C", "Tela2::onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TV2C", "Tela2::onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TV2C", "Tela2::onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("TV2C", "Tela2::onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TV2C", "Tela2::onDestroy")
    }
}