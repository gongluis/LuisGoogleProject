package com.luis.luisgoogleproject.kotlin.filepersistence

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.luis.luisgoogleproject.R
import com.luis.luisgoogleproject.kotlin.activity.FirstActivity

/**
 * remember pwd sample
 */
class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var accountEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var sp: SharedPreferences
    private lateinit var rememberCb: CheckBox

    companion object {
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        accountEdit = findViewById(R.id.value_account)
        passwordEdit = findViewById(R.id.value_password)
        val loginBtn = findViewById<Button>(R.id.login)
        rememberCb = findViewById(R.id.cb_remember)


        loginBtn.setOnClickListener(this)

        sp = getPreferences(Context.MODE_PRIVATE)
        val isRemember = sp.getBoolean("remember_password", false)
        if (isRemember) {
            val account = sp.getString("account", "")
            val password = sp.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberCb.isChecked = true
        }

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.login -> {
                val account = accountEdit.text.toString()
                val password = passwordEdit.text.toString()

                if (account == "admin" && password == "123456") {
                    val spEdit = sp.edit()
                    if (rememberCb.isChecked) {
                        spEdit.putBoolean("remember_password", true)
                        spEdit.putString("account", account)
                        spEdit.putString("password", password)
                    } else {
                        spEdit.clear()
                    }
                    spEdit.apply()
                    val intent = Intent(this, FirstActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


}