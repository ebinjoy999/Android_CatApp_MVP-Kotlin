package ebinjoy999.app.screens.home.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import ebinjoy999.app.screens.home.model.CatBreed
import kotlinx.android.synthetic.main.cat_list_row.view.*

/**
 * Created by macadmin on 8/22/19.
 */

 class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(catBreed: CatBreed, context: CarListAdapter){
        if(catBreed.breeds?.size!! > 0) {
            itemView.textViewBreedName.text = catBreed.breeds?.get(0)?.name
            itemView.textViewDesc.text = catBreed.breeds?.get(0)?.description
            itemView.textViewLifeSpan.text = catBreed.breeds?.get(0)?.lifeSpan + " years"
        }
        try {
            context.picasso.load(catBreed.url).into(itemView.imageViewCat)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}