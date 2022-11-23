package com.bazuka_cafer_xd.terminalgiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ISIM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.isim)
        val ad =findViewById<TextView>(R.id.ad)
        val mailbox=findViewById<TextView>(R.id.mailbox)
        val durum=findViewById<TextView>(R.id.mailbox)
        val DATATEXT=findViewById<TextView>(R.id.DATATEXT)

        val nameMessage =intent.getStringExtra("Name_Message")
        val mailMessage =intent.getStringExtra("Mail_Message")
        val statusMessage =intent.getStringExtra("Status_Message")

        ad.setOnClickListener{
            DATATEXT.text=nameMessage.toString()
        }
        mailbox.setOnClickListener{
            DATATEXT.text=mailMessage.toString()
        }
        durum.setOnClickListener{
            DATATEXT.text=statusMessage.toString()
        }
    }

}