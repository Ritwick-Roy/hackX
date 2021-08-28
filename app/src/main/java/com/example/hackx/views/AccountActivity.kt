package com.example.hackx.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hackx.R

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val bu1: Button =findViewById(R.id.b1)
        val bu2: Button =findViewById(R.id.b2)
        bu1.setOnClickListener {
            val intent = Intent(this, BossActivity::class.java)
            startActivity(intent)
        }
        bu2.setOnClickListener {
            val intent = Intent(this, EmployeeActivity::class.java)
            startActivity(intent)
        }
    }
}