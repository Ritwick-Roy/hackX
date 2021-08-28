package com.example.hackx.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackx.R
import com.example.hackx.extensions.Extensions.toast
import com.example.hackx.utils.FirebaseUtils.firebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
// sign out a user

        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, CreateAccountActivity::class.java))
            toast("signed out")
            finish()
        }
    }
}