package com.safall.week6assignment1.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.safall.week6assignment1.R


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

        rdoMale.setOnClickListener{
            gender = "Male"
        }
        rdoFemale.setOnClickListener{
            gender = "Female"
        }
        rdoOthers.setOnClickListener{
            gender = "Others"
        }

        btnsave.setOnClickListener{
            fullname = etfullname.text.toString()
            age = etage.text.toString().toInt()
            address = etaddress.text.toString()
            imgurl = etimgurl.text.toString()
        }



        return view
    }


}