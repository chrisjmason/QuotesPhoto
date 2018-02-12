package com.and.cmason.quotesphoto

import dagger.Component
import dagger.Provides
import data.NetworkModule
import di.modules.ContextModule
import javax.inject.Singleton

/**
 * Created by cmason on 08/02/2018.
 */

@Singleton
@Component(modules = arrayOf(NetworkModule::class, ContextModule::class, HomeModule::class))
interface HomeComponent
{
    fun inject(homeActivity: HomeActivity)
}