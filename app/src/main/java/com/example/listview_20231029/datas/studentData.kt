package com.example.listview_20231029.datas

import android.util.Log
import java.time.Year

class studentData (
    val name: String,
    val birthYear: Int,
    val phoneNum: String ) {


//    생성자 문법 체험 => 폰번을 안받는 생성자도 쓰고싶다. Main : 전부 다 받는. Sub : 폰번은 안받는 (보조)

    constructor( name: String, birthYear: Int ) : this(name, birthYear, "폰번 모름")

    fun getKoreanAge(year:Int):Int{
        return year-this.birthYear+1
    }

    fun printSimplePhoneNum(){
        Log.d("학생데이터", this.phoneNum.replace("-", ""))
    }

}