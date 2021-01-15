package com.safall.week6assignment1.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.safall.week6assignment1.R
import com.safall.week6assignment1.adapters.StudentAdapter




class HomeFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<StudentAdapter.StudentViewHolder>? = null
    private lateinit var review: RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        review = root.findViewById(R.id.recyclerView)

        return root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        review.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = StudentAdapter(context)
        }
    }


}