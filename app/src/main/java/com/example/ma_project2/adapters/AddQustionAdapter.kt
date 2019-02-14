package com.example.ma_project2.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ma_project2.R
import com.example.ma_project2.model.Predmet
import com.example.ma_project2.model.Result
import kotlinx.android.synthetic.main.see_result_item.view.*

class AddQustionAdapter(val context: Context, var result: List<Predmet>): RecyclerView.Adapter<AddQustionAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.see_result_item,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size-1
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val res: Predmet? = result[p1]
        p0.setData(res,p1)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var curRredmet: Predmet? = null
        var curPositin:Int = 0

            init {
                itemView.setOnClickListener {
                    Toast.makeText(context,curRredmet!!.name+" clicked",Toast.LENGTH_SHORT).show()
                }
            }

        fun setData(predmet: Predmet?, position:Int){
            this.curRredmet=predmet
            this.curPositin=position
            itemView.tv_subject.text=curRredmet!!.name

        }
    }
}


