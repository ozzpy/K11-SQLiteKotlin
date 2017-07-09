package com.example.atilsamancioglu.sqlitekotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        try {

            val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE,null)

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT(2))")

            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('James', 50)")

            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Kirk', 60)")

            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Lars', 56)")

            //myDatabase.execSQL("INSERT INTO musicians (name, age) VALUES ('Rob', 70)")

            //myDatabase.execSQL("UPDATE musicians SET age = 55 WHERE name = 'Lars'")

            //myDatabase.execSQL("DELETE FROM musicians WHERE name = 'Rob'")


            val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'",null)

            val nameIndex = cursor.getColumnIndex("name")
            val ageIndex = cursor.getColumnIndex("age")

            cursor.moveToFirst()

            while (cursor != null) {

                println("Name: " + cursor.getString(nameIndex))
                println("Age: " + cursor.getInt(ageIndex))


                cursor.moveToNext()
            }

            if (cursor != null) {
                cursor!!.close()
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }


    }
}
