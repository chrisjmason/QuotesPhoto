package com.and.cmason.quotesphoto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import data.CombinedListModel
import data.PhotoModel
import data.QuoteModel
import kotlinx.android.synthetic.main.activity_main.photo_recycler_view
import kotlinx.android.synthetic.main.activity_main.refresh_layout
import java.util.Collections
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeActivityInterface {

    @Inject
    lateinit var presenter: HomePresenter

    lateinit var adapter: HomeAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerHomeComponent
            .builder()
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        setContentView(R.layout.activity_main)
        presenter.getList()
        setUpUi()

    }

    override fun showList(combinedList: CombinedListModel)
    {
        refresh_layout.setRefreshing(false)
        Collections.shuffle(combinedList.photoList)
        Collections.shuffle(combinedList.quoteList)
        adapter.combinedList = combinedList
        adapter.notifyDataSetChanged()
    }

    fun setUpUi(){
        supportActionBar?.hide()
        refresh_layout.setOnRefreshListener { presenter.getList() }
        adapter = HomeAdapter(CombinedListModel(ArrayList<PhotoModel>(), ArrayList<QuoteModel>()))
        photo_recycler_view.layoutManager = LinearLayoutManager(this)
        photo_recycler_view.adapter = adapter
    }

}
