package dev.loosername.basico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToast.setOnClickListener {
            val texto = editTexto.text.toString()
            Toast.makeText(this, texto, Toast.LENGTH_LONG).show()
        }

        buttonTela2.setOnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("nome", "Thyago")
            intent.putExtra("idade", 20)
            startActivity(intent)
        }

        buttonParcel.setOnClickListener {
            val cliente = Cliente(1, "Glauber")
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("cliente", Parcels.wrap(cliente))
            startActivity(intent)
        }

        buttonSerializable.setOnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("pessoa", Pessoa(nome = "Nelso", idade = 35))
            startActivity(intent)
        }

        Log.i("TV2C", "Tela1::onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TV2C", "Tela1::onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TV2C", "Tela1::onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TV2C", "Tela1::onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TV2C", "Tela1::onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("TV2C", "Tela1::onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TV2C", "Tela1::onDestroy")
    }
}