package com.safall.week6assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

        etPassword = findViewById(R.id.etpassword)
        etUsername = findViewById(R.id.etusername)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(this)
}
    override fun onClick(v: View?) {
        when(v?.id){
            btnLogin.id->{
                if (isValid()){
                    if (etUsername.text.toString()=="softwarica" && etPassword.text.toString()=="coventry"){
                        Intent(this, DashboardActivity::class.java).also {
                            startActivity(it)
                        }
                    } else {
                        Toast.makeText(applicationContext, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
                        etUsername.setText("")
                        etPassword.setText("")

                    }
                }

            }
        }
    }
    private fun isValid(): Boolean {
        var flag = true
        if (TextUtils.isEmpty(etUsername.text)) {
            etUsername.error = "Please enter Username"
            etUsername.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etPassword.text)){
            etPassword.error="Please enter Paasword"
            etPassword.requestFocus()
            flag = false
        }
        return flag
    }}
