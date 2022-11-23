package com.bazuka_cafer_xd.terminalgiri

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://gorest.co.in/"
class MainActivity : AppCompatActivity() {
    val userNameList = arrayListOf<Any>()
    val emailList = arrayListOf<Any>()
    val genderList = arrayListOf<Any>()
    val idList = arrayListOf<Any>()
    val statusList = arrayListOf<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData()


        val myBtn = findViewById<Button>(R.id.enter)
        myBtn.setOnClickListener {
            btnClick()
        }
    }
    private fun btnClick(){
        /*
            var i: String
            var j: String
            for (i in userNameList.toString()) {
                if (i.equals("Kullanıcı adı")) {
                    for (j in idList.toString()){
                        if(j.equals("Kullanıcı şifresi")){
                            val intent = Intent(this,Welcome::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
            */
        /* if(findViewById<EditText>(R.id.name).text.equals("asd")) {
            if (findViewById<EditText>(R.id.pin).toString().equals("Evrenüz")) {

                val nameMessage = userNameList.toString()
                val mailMessage = emailList.toString()
                val statusMessage = statusList.toString()
                val intent = Intent(this, ISIM::class.java).also {
                    it.putExtra("Name_Message", nameMessage)
                    it.putExtra("Mail_Message", mailMessage)
                    it.putExtra("Status_Message", statusMessage)
                    startActivity(it)
                }
                startActivity(intent)
            }
        }

         */
         var status:String =if(findViewById<EditText>(R.id.name_et).text.toString().equals("Cafer")
            && findViewById<EditText>(R.id.pin_et).text.toString().equals("1234"))
            "Logged in succesfully"
        else
            "Login Fail"
        Toast.makeText(this,status,Toast.LENGTH_SHORT).show()

        if(status.equals("Logged in succesfully")){
            val nameMessage = userNameList.toString()
            val mailMessage = emailList.toString()
            val statusMessage = statusList.toString()
            val intent = Intent(this, ISIM::class.java).also {
                it.putExtra("Name_Message", nameMessage)
                it.putExtra("Mail_Message", mailMessage)
                it.putExtra("Status_Message", statusMessage)
            }
            startActivity(intent)
        }


    }


    private fun getMyData() {


        val nameList = arrayListOf<Any>()
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(APIInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<DATAItem>?> {
            override fun onResponse(
                call: Call<List<DATAItem>?>?,
                response: Response<List<DATAItem>?>?
            ) {
                val responseBody = response!!.body()!!
                for (DATA in responseBody) {
                    userNameList.add(DATA.name)
                    emailList.add(DATA.email)
                    genderList.add(DATA.gender)
                    idList.add(DATA.id)
                    statusList.add(DATA.status)
                }

            }

            override fun onFailure(call: Call<List<DATAItem>?>?, t: Throwable?) {
                Log.d("MainActivity", "onFailure:    " + t!!.message)
            }


        })
    }
}















