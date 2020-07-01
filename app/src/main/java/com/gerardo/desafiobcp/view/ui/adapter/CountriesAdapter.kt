package com.gerardo.desafiobcp.view.ui.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.data.entity.MoneyEntity
import com.gerardo.desafiobcp.view.ui.utils.inflate
import kotlinx.android.synthetic.main.item_country.view.*

class CountriesAdapter(private val listener: (MoneyEntity) -> Unit) : RecyclerView.Adapter<CountriesAdapter.ArticleHolder>() {

    var data: List<MoneyEntity> = arrayListOf()

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) = holder.bind(data[position], listener)

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleHolder.init(parent, viewType)

    override fun getItemViewType(position: Int) = position

    class ArticleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MoneyEntity, listener: (MoneyEntity) -> Unit) = with(itemView) {
            Glide.with(this@with)
                .load(item.urlFlag)
                .apply(
                    RequestOptions()
                        .centerCrop()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .priority(Priority.HIGH))
                .listener(object : RequestListener<Drawable> {
                    @SuppressLint("CheckResult")
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                .into(image_url)
            text_currency.text = item.moneyNameCountry
            type_changed.text = item.factoryMoney
            item_country_linear.setOnClickListener {
                listener(item)
            }
        }

        companion object {
            fun init(parent: ViewGroup, viewType: Int) : CountriesAdapter.ArticleHolder {
                val view = parent.inflate(R.layout.item_country)
                return CountriesAdapter.ArticleHolder(view)
            }
        }
    }
}