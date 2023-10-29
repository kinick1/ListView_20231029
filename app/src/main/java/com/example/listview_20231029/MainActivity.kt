package com.example.listview_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listview_20231029.adapters.StudentAdapter
import com.example.listview_20231029.datas.studentData

class MainActivity : AppCompatActivity() {

    val  mStudentList=ArrayList<studentData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       mStudentList.add(studentData("조철뚝",1999,"010-9999-9999"))
        mStudentList.add(studentData("김준",2000,"010-9999-9999"))
        mStudentList.add(studentData("우짤래미",2222,"010-9999-9999"))
        mStudentList.add(studentData("저짤래미",2313,"010-9999-9999"))
        mStudentList.add(studentData("굿",4212,"010-9999-9999"))
        mStudentList.add(studentData("ㅇㅇ",4232,"010-9999-9999"))
        mStudentList.add(studentData("쥰킴",1254,"010-9999-9999"))
        mStudentList.add(studentData("쥬시",2000,"010-9999-9999"))

//      어뎁터 변수도 객체생성



    }
}