package dev.loosername.intents

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.intent_actions))
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            openIntentAtPosition(position)
        }
    }

    private fun openIntentAtPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?
        when (position) {
            0 -> {
                uri = Uri.parse("http://www.loosername.dev")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            1 -> {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.CALL_PHONE), 0)
                } else {
                    callNumber()
                }
            }
            2 -> {
                uri = Uri.parse("geo:0,0?q=Rua+Manoel+de+Souza+Dias+Negrão+1247,Curitiba")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            3 -> {
                uri = Uri.parse("sms:8000")
                intent = Intent(Intent.ACTION_VIEW, uri)
                        .putExtra("sms_body", "Saldo")
                openIntent(intent)
            }
            4 -> {
                intent = Intent()
                        .setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent.")
                        .setType("text/plain")
                openIntent(intent)
            }
            5 -> {
                intent = Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                        .putExtra(AlarmClock.EXTRA_HOUR, 23)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 59)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                        .putExtra(AlarmClock.EXTRA_DAYS, arrayListOf(
                                Calendar.MONDAY,
                                Calendar.WEDNESDAY,
                                Calendar.FRIDAY
                        ))
                openIntent(intent)
            }

            6 -> {
                intent = Intent(Intent.ACTION_SEARCH)
                        .putExtra(SearchManager.QUERY, "Kotlin")
                openIntent(intent)
            }
            7 -> {
                intent = Intent(Settings.ACTION_SETTINGS)
                openIntent(intent)
            }
            8 -> {
                intent = Intent("dev.loosername.CUSTOM_ACTION")
                openIntent(intent)
            }
            9 -> {
                uri = Uri.parse("game://teste/dev")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.first() == PackageManager.PERMISSION_GRANTED) {
            callNumber()
        }
    }

    private fun callNumber() {
        val uri = Uri.parse("tel:+5541995812773")
        val intent = Intent(Intent.ACTION_CALL, uri)
        openIntent(intent)
    }

    private fun openIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.error_intent, Toast.LENGTH_SHORT).show()
        }
    }
}