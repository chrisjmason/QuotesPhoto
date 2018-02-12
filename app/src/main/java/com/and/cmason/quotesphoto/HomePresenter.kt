package com.and.cmason.quotesphoto

import base.BaseContract
import data.PhotoListModel
import data.PhotoService
import data.QuoteService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import repository.Repo
import javax.inject.Inject

/**
 * Created by cmason on 08/02/2018.
 */


class HomePresenter : BaseContract.Presenter
{
    var view: HomeActivityInterface
    var repo: Repo

    constructor(repo: Repo, view: HomeActivityInterface){
        this.view = view
        this.repo = repo
    }

    fun getList(){
        repo
            .getCombinedList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t ->  view.showList(t)})

    }
}