package com.and.cmason.quotesphoto

import base.BaseContract
import data.CombinedListModel
import data.PhotoListModel
import data.PhotoModel
import data.QuoteModel

/**
 * Created by cmason on 08/02/2018.
 */
interface HomeActivityInterface: BaseContract.View
{
    fun showList(combinedList: CombinedListModel)
}