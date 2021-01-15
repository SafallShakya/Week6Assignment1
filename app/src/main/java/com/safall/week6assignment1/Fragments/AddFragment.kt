package com.safall.week6assignment1.Fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.safall.week6assignment1.Models.Student
import com.safall.week6assignment1.R
import com.safall.week6assignment1.Storage


class AddFragment : Fragment() {
    private lateinit var etfullname : EditText
    private lateinit var etage : EditText
    private lateinit var etaddress : EditText
    private lateinit var etimgurl : EditText
    private lateinit var btnsave : Button
    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var rdoOthers : RadioButton
    private lateinit var fullname : String
    private lateinit var age : Number
    private lateinit var address : String
    private lateinit var imgurl : String
    private lateinit var gender : String
    private lateinit var rdoGroup : RadioGroup


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        etaddress = view.findViewById(R.id.etaddress)
        etimgurl = view.findViewById(R.id.etimgurl)
        btnsave = view.findViewById(R.id.btnsave)
        rdoMale = view.findViewById(R.id.rdoMale)
        rdoFemale = view.findViewById(R.id.rdoFemale)
        rdoOthers = view.findViewById(R.id.rdoOthers)
        rdoGroup = view.findViewById(R.id.radioGroup)

        btnsave.setOnClickListener{
            if (isValid()) {
                val checkID = rdoGroup.checkedRadioButtonId
                val checkedrdo: RadioButton = view.findViewById(checkID)
                gender = checkedrdo.text.toString();
                val storage = Storage()
                fullname = etfullname.text.toString()
                age = etage.text.toString().toInt()
                address = etaddress.text.toString()
                imgurl = etimgurl.text.toString()
                storage.addStudent(Student(fullname, imgurl, address, age.toInt(), gender))

                Toast.makeText(activity?.applicationContext,"Student Added", Toast.LENGTH_LONG).show()
                clearFields()
            }
        }
        return view
    }
    private fun clearFields() {
        etfullname.setText("")
        etage.setText("")
        rdoGroup.clearCheck()
        etaddress.setText("")
        etimgurl.setText("")
        rdoMale.isChecked = true
    }
    private fun isValid(): Boolean {
        var flag = true
        if (TextUtils.isEmpty(etfullname.text)) {
            etfullname.error = "Please enter Username"
            etfullname.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etage.text)){
            etage.error="Please enter age"
            etage.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etaddress.text)){
            etaddress.error="Please enter address"
            etaddress.requestFocus()
            flag = false
        }else if (TextUtils.isEmpty(etimgurl.text)){
            etimgurl.error="Please enter image URL"
            etimgurl.requestFocus()
            flag = false
        }
        return flag
    }
}