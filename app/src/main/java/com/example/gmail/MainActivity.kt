package com.example.gmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter
    private var emailList = ArrayList<EmailModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tạo dữ liệu giả
        generateFakeData()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        emailAdapter = EmailAdapter(emailList)
        recyclerView.adapter = emailAdapter
    }

    private fun generateFakeData() {
        // Tạo và thêm dữ liệu giả vào danh sách emailList
        emailList.add(
            EmailModel(
                "SophieAdams",
                "Discussion on the proposal",
                "avatar11",
                "10:00 AM",
                true
            )
        )
        emailList.add(
            EmailModel(
                "WilliamTurner",
                "Upcoming event details",
                "avatar12",
                "11:20 AM",
                false
            )
        )
        emailList.add(
            EmailModel(
                "AvaCampbell",
                "Follow-up on the meeting",
                "avatar13",
                "Yesterday",
                true
            )
        )
        emailList.add(
            EmailModel(
                "JamesParker",
                "Review the budget report",
                "avatar14",
                "2 days ago",
                false
            )
        )
        emailList.add(EmailModel("AnnaGreen", "Project update", "avatar7", "11:45 AM", false))
        emailList.add(EmailModel("MichaelBrown", "New product launch", "avatar8", "12:30 PM", true))
        emailList.add(EmailModel("OliviaMiller", "Weekend plans", "avatar9", "Yesterday", false))
        emailList.add(
            EmailModel(
                "DanielWilson",
                "Important announcement",
                "avatar10",
                "2 days ago",
                true
            )
        )
        emailList.add(EmailModel("JohnDoe", "Hello there!", "avatar3", "10:15 AM", true))
        emailList.add(EmailModel("EmilySmith", "Meeting tomorrow", "avatar4", "Yesterday", false))
        emailList.add(
            EmailModel(
                "DavidJohnson",
                "Don't forget the deadline",
                "avatar5",
                "2 days ago",
                false
            )
        )
        emailList.add(EmailModel("SophiaWilliams", "Vacation plans", "avatar6", "Last week", true))
        // Thêm các mục email khác tương tự ở đây
    }
}