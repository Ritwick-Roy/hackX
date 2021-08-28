package com.example.hackx.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hackx.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_complete_profile.*

class CompleteProfileActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_profile)
        submit.setOnClickListener {
            val emp = empid.text.toString()
            val nam = name.text.toString()
            val age = age.text.toString()
            val gen = gender.text.toString()
            val dep = department.text.toString()
            val tc = teamCode.text.toString()
            val oh = officeHours.text.toString()
            var i: Intent = getIntent()
            var email = i.getStringExtra("email").toString()
            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = Users(email, emp, nam, age, gen, dep, tc, oh)
            if(emp.trim().isNotEmpty() && nam.trim().isNotEmpty() && age.trim().isNotEmpty() && gen.trim().isNotEmpty() && dep.trim().isNotEmpty() && tc.trim().isNotEmpty() && oh.trim().isNotEmpty())
            {
                database.child(emp).setValue(user).addOnSuccessListener {
                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, AccountActivity::class.java))
                    finish()

                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
            else Toast.makeText(this, "Fill all the fields!", Toast.LENGTH_SHORT).show()

        }
    }
}