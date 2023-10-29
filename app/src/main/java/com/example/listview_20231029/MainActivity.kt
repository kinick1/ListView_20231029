package com.example.listview_20231029

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.listview_20231029.adapters.StudentAdapter
import com.example.listview_20231029.databinding.ActivityMainBinding
import com.example.listview_20231029.datas.studentData

class MainActivity : AppCompatActivity() {

    val  mStudentList=ArrayList<studentData>()

    lateinit var mStdAdapter: StudentAdapter

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

       mStudentList.add(studentData("조철뚝",1999,"010-9999-9999"))
        mStudentList.add(studentData("김준",2000,"010-9999-9999"))
        mStudentList.add(studentData("우짤래미",2222,"010-9999-9999"))
        mStudentList.add(studentData("저짤래미",2313,"010-9999-9999"))
        mStudentList.add(studentData("굿",4212,"010-9999-9999"))
        mStudentList.add(studentData("ㅇㅇ",4232,"010-9999-9999"))
        mStudentList.add(studentData("쥰킴",1254,"010-9999-9999"))
        mStudentList.add(studentData("쥬시",2000,"010-9999-9999"))
        mStudentList.add(studentData("쥬시",2000))
//      어뎁터 변수도 객체생성

        mStdAdapter= StudentAdapter(this,R.layout.student_list_item,mStudentList)


//        만들어진 어댑터를 리스트뷰의 어댑터로 연결
        binding.stdListView.adapter = mStdAdapter


//        한명의 학생을 클릭하면 => 토스트로 "이름 : 연락처" 토스트로 출력

        binding.stdListView.setOnItemClickListener { adapterView, view, position, l ->

            // 이 함수의 세번째 (i, position) 변수 => 클릭 된 위치를 알려주는 역할.

//            mStudentList 중, 클릭된 위치에 맞는 학생 추출 => 활용

            val clickedStd = mStudentList[position]

            Toast.makeText(this, "${clickedStd.name} : ${clickedStd.phoneNum}", Toast.LENGTH_SHORT).show()

        }

//        한명의 학생을 오래 클릭하면=> 정말 지울건지? ok라면=> 해당학생 삭제
        binding.stdListView.setOnItemLongClickListener { adapterView, view, position, l ->

            val std=mStudentList[position]

            //경고창을 띄어 확인

            val alert=AlertDialog.Builder(this)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 ${std.name}학생을 삭제하겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

                // 삭제 기능은 확인버튼이 눌릴때 실행

                // 오래 클릭된 학생 => (목록에서) 삭제

                mStudentList.removeAt(position)  // 내용물 변경 발생

                // 어댑터에게 통보
                mStdAdapter.notifyDataSetChanged()


            })
            alert.setNegativeButton("취소", null)
            alert.show()

            // LongClick이벤트는 Bool 타입의 리턴값을 받도록 되어있음.


            return@setOnItemLongClickListener true
        }

    }
}