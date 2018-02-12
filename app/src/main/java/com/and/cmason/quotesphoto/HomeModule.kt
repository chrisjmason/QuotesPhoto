package com.and.cmason.quotesphoto

import base.BaseContract
import dagger.Module
import dagger.Provides
import data.PhotoService
import data.QuoteService
import repository.Repo

/**
 * Created by cmason on 08/02/2018.
 */
@Module
class HomeModule(val homeView: HomeActivity)
{
    @Provides
    fun provideHomeView(): HomeActivityInterface{
        return homeView
    }

    @Provides
    fun providePresenter(repo:Repo, view:HomeActivityInterface) = HomePresenter(repo, view)

    @Provides
    fun provideRepository(photoService: PhotoService, quoteService: QuoteService) = Repo(photoService, quoteService)
}