package data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cmason on 07/02/2018.
 */
@Module class NetworkModule{
    @Named("PhotoRetrofit")
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://homepageapi.chrisjmason.com/")
            .build()
    }

    @Named("QuotesRetrofit")
    @Provides
    @Singleton
    fun provideQuotesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://quoteapi.chrisjmason.com/")
            .build()
    }

    @Provides
    @Singleton
    fun providePhotoService(@Named("PhotoRetrofit") retrofit: Retrofit): PhotoService = retrofit.create(PhotoService::class.java)

    @Provides
    @Singleton
    fun provideQuoteService(@Named("QuotesRetrofit") retrofit: Retrofit): QuoteService = retrofit.create(QuoteService::class.java)
}