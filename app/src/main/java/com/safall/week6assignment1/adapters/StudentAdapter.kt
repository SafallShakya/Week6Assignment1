package com.safall.week6assignment1.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.safall.week6assignment1.R
import com.bumptech.glide.Glide
import com.safall.week6assignment1.Storage
import com.safall.week6assignment1.Models.Student
import com.safall.week6assignment1.Fragments.HomeFragment

private var storage = Storage()
private var students = storage.returnStudent()


class StudentAdapter(
        val context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){

        val imgProfile :ImageView
        val tvName : TextView
        val tvAddress : TextView
        val tvAge : TextView
        val tvGender : TextView
        val imgdelete : ImageView


        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvAge = view.findViewById(R.id.tvAge)
            tvGender = view.findViewById(R.id.tvGender)
            imgdelete = view.findViewById(R.id.delete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mero_student_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.tvName.text = student.studentName
        holder.tvAddress.text = student.studentAddress
        holder.tvAge.text = student.studentAge.toString()
        holder.tvGender.text = student.studentGender

        holder.imgdelete.setOnClickListener(View.OnClickListener {
            storage.deleteStudent(student)
            notifyItemRemoved(position)
        })
        Glide.with(context)
            .load(student.studentImageURL)
            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}