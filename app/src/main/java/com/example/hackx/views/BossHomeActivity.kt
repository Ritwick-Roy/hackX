package com.example.hackx.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackx.R
import com.example.hackx.extensions.Extensions.toast
import com.example.hackx.utils.FirebaseUtils.firebaseAuth
import kotlinx.android.synthetic.main.activity_boss_home.*

class BossHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boss_home)
// sign out a user

        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, AccountActivity::class.java))
            toast("signed out")
            finish()
        }
    }
}