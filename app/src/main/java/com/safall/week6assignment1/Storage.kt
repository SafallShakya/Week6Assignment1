package com.safall.week6assignment1
import com.safall.week6assignment1.Models.Student
var students = mutableListOf<Student>()

class Storage{
    fun addStudent(student:Student){
        students.add(student)
    }
    fun returnStudent():MutableList<Student>{
        return students
    }
    fun deleteStudent(student:Student){
        students.remove(student)
    }
}





