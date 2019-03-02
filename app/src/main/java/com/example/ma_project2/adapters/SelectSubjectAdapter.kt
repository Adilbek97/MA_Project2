package com.example.ma_project2.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ma_project2.R
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.teachers_page.add_question_page.AddQuestionActivity
import com.example.ma_project2.teachers_page.see_result_page.SeeResultActivity
import kotlinx.android.synthetic.main.select_subject_item.view.*

class SelectSubjectAdapter(val context: Context, var result: ArrayList<Subject>,val activity_id:Int): RecyclerView.Adapter<SelectSubjectAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.select_subject_item,viewGroup,false)
        return MyViewHolder(view)
    }
    override fun getItemCount(): Int {
        return result.size
    }
    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val res: Subject? = result[position]
        viewHolder.setData(res,position)
    }
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val intent:Intent
        var currentSubject: Subject? = null
        var currentPosition:Int = 0
            init {
                if(activity_id==1){
                    intent=Intent(context, SeeResultActivity::class.java)

                }else{
                    intent=Intent(context, AddQuestionActivity::class.java)
                }
                itemView.setOnClickListener {
                    Toast.makeText(context,currentSubject!!.name+" clicked",Toast.LENGTH_SHORT).show()
//                    intent.putExtra("subject_id",currentSubject!!.id)
//                    intent.putExtra("subject_name",currentSubject!!.name)
                    intent.putExtra("subject_key",currentSubject)
                    intent.putExtra("results_key", currentSubject?.results)
                    context.startActivity(intent)
                }
            }
        fun setData(subject: Subject?, position:Int){
            this.currentSubject=subject
            this.currentPosition=position
            itemView.select_subject_name_tv.text=currentSubject!!.name
        }
    }
}


