package com.and.cmason.quotesphoto

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.and.cmason.quotesphoto.HomeAdapter.HomeViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import data.CombinedListModel
import data.PhotoModel
import data.QuoteModel
import kotlinx.android.synthetic.main.photo_card.view.author_text
import kotlinx.android.synthetic.main.photo_card.view.photo_card_image
import kotlinx.android.synthetic.main.photo_card.view.quote_text

/**
 * Created by cmason on 08/02/2018.
 */
class HomeAdapter(var combinedList: CombinedListModel) : RecyclerView.Adapter<HomeViewHolder>()
{

    override fun getItemCount(): Int = combinedList.photoList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int){
        holder.bind(combinedList.photoList.get(position), combinedList.quoteList.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder{
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.photo_card, parent, false)
        return HomeViewHolder(view)
    }

    class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: PhotoModel, quote: QuoteModel){
            val options = RequestOptions()
            options.centerCrop()

            itemView.quote_text.text = quote.quote
            itemView.author_text.text = quote.author

            Glide.with(itemView.context)
                .load(item.url)
                .apply(options)
                .into(itemView.photo_card_image)
        }
    }


}
