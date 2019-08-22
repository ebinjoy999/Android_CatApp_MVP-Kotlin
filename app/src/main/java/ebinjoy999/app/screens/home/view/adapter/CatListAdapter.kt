package ebinjoy999.app.screens.home.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import ebinjoy999.app.R
import kotlinx.android.synthetic.main.cat_list_row.view.*
import ebinjoy999.app.screens.home.model.CatBreed

/**
 * Created by macadmin on 8/18/19.
 */

class CarListAdapter(internal var  picasso: Picasso, internal var context: Context, internal var catBreeds :ArrayList<CatBreed>)
    : RecyclerView.Adapter<MyViewHolder>() {

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
        holder.bind(catBreed, this@CarListAdapter);

    }

    override fun getItemCount(): Int {
        return catBreeds.size
    }




}
