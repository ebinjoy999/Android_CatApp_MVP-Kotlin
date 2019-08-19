package ebinjoy999.app.screens.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import ebinjoy999.app.R
import kotlinx.android.synthetic.main.cat_list_row.view.*
import ebinjoy999.app.screens.home.model.CatBreed
import java.util.Collections.addAll

/**
 * Created by macadmin on 8/18/19.
 */

class CarListAdapter(internal var  picasso: Picasso, internal var context: Context, internal var catBreeds :ArrayList<CatBreed>)
    : RecyclerView.Adapter<CarListAdapter.MyViewHolder>() {

    fun addItems(catBreedList: List<CatBreed>){
        this.catBreeds.addAll(catBreedList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cat_list_row, parent, false)
        return MyViewHolder(rootView)
    }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val catBreed = catBreeds[position]
        holder.bind(catBreed);

    }

    override fun getItemCount(): Int {
        return catBreeds.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(catBreed: CatBreed){
            if(catBreed.breeds?.size!! > 0) {
                itemView.textViewBreedName.text = catBreed.breeds?.get(0)?.name
                itemView.textViewDesc.text = catBreed.breeds?.get(0)?.description
                itemView.textViewLifeSpan.text = catBreed.breeds?.get(0)?.lifeSpan + " years"
            }
            try {
                this@CarListAdapter.picasso.load(catBreed.url).into(itemView.imageViewCat)
            } catch (e: Exception) {
                e.printStackTrace()
            }
       }
    }


}
