package com.learning.androidcore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.*

class MainActivity : AppCompatActivity() {

    private val TAG = "Manga"

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this) // StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL) or GridLayoutManager(this, 2)

        // val divider = DividerItemDecoration(recyclerView.getContext(), layoutManager.orientation)
        
        // recyclerView.addItemDecoration()

        val gson = Gson()
        val json = loadJSONFromAsset("data.json", this)
        val listType = object : TypeToken<List<Manga>>() {}.type

        val value: List<Manga> = gson.fromJson(json, listType)

        val adapter = CustomAdapter(value, this)
        recyclerView.adapter = adapter


    }

    fun loadJSONFromAsset(filename: String, context: Context): String? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            Log.e(TAG, "Error reading from $filename", ex)
        }
        return json
    }

}