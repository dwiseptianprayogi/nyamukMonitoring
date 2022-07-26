package com.example.nyamukmonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var fpArray:ArrayList<item>
    private lateinit var fpRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fpRecyclerView = findViewById(R.id.NyamukListHistory)
        fpRecyclerView.layoutManager = LinearLayoutManager(this)
        fpRecyclerView.setHasFixedSize(true)

        fpArray = arrayListOf<item>()
        getData()


    }

    private fun getData() {
        dbRef = FirebaseDatabase.getInstance().getReference("Nyamuk/history")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                    for (fpSnapshot in snapshot.children) {
                        val fp = fpSnapshot.getValue(item::class.java)
                        fpArray.add(fp!!)
                    }
                var adapter = MyAdapter(fpArray)
                fpRecyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed To Get Data", Toast.LENGTH_LONG).show()
            }

        })

        dbRef = FirebaseDatabase.getInstance().getReference("Nyamuk/jumlahNyamuk")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.value.toString()
                val tvStat = findViewById<TextView>(R.id.tvJumlahNyamukVal)
                tvStat.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed To Get Data", Toast.LENGTH_LONG).show()
            }
        })
        dbRef = FirebaseDatabase.getInstance().getReference("Nyamuk/statusNyamuk")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.value.toString()
                val tvStat = findViewById<TextView>(R.id.tvStatusNyamukVal)
                tvStat.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed To Get Data", Toast.LENGTH_LONG).show()
            }
        })
    }
}