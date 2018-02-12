package repository

import data.CombinedListModel
import data.PhotoModel
import data.PhotoService
import data.QuoteModel
import data.QuoteService
import io.reactivex.Single
import io.reactivex.functions.BiFunction

/**
 * Created by cmason on 09/02/2018.
 */
class Repo
{
    val photoService:PhotoService
    val quoteService:QuoteService

    constructor(photoService: PhotoService, quoteService: QuoteService){
        this.photoService = photoService
        this.quoteService = quoteService
    }

    fun getCombinedList(): Single<CombinedListModel>{
        return Single.zip(
            photoService.getPhoto(),
            quoteService.getQuotes(),
            BiFunction { photoList:List<PhotoModel>, quoteList:List<QuoteModel> ->  CombinedListModel(photoList, quoteList)})
    }
}