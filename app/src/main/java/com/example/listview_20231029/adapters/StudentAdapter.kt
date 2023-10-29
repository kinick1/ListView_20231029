package com.example.listview_20231029.adapters
import android.content.Context
import android.widget.ArrayAdapter
import com.example.listview_20231029.datas.studentData

class StudentAdapter(mContext:Context, resID:Int,mList:ArrayList<studentData> ):ArrayAdapter<studentData>(mContext,resID,mList) {


}