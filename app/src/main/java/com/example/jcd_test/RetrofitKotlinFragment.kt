package com.example.jcd_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jcd_test.Adapter.UserPostAdapter

public class RetrofitKotlinFragment: Fragment() {

    lateinit var retroFitView: View
    lateinit var retrofitRecyclerView: RecyclerView
    lateinit var retroViewModel: RetroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retroViewModel = ViewModelProviders.of(activity!!).get(RetroViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retroFitView = inflater.inflate(R.layout.fragment_retro_fit_post,container,false)
        initViews(retroFitView)
        setAdapter()
        retroViewModel.getProjectRetroListObservable().observe(viewLifecycleOwner,object :Observer<List<ResultModel>>{
            override fun onChanged(t: List<ResultModel>?) {
                userPostAdapter.setListItems(t)
            }

        })

        /*
        userViewModel.getAllUsers().observe(this, object : Observer <List<User>> {
            override fun onChanged(users: List<User>?) {
                // Update the cached copy of the words in the adapter.
                userAdapter.setListItems(users)
            }
        })
         */

        return retroFitView
    }


    private fun initViews(view: View){
        retrofitRecyclerView = view.findViewById(R.id.post_list)as RecyclerView
    }
    lateinit var userPostAdapter: UserPostAdapter
    @SuppressLint("WrongConstant")
    private  fun setAdapter(){
        userPostAdapter = UserPostAdapter()
        retrofitRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        retrofitRecyclerView.adapter = userPostAdapter

    }

}