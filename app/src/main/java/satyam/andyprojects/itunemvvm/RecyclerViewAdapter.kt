package satyam.andyprojects.itunemvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.artist.view.*
import satyam.andyprojects.model.ArtistDetails
import satyam.andyprojects.model.Results

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var mResultList = ArrayList<Results>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

          val v =  LayoutInflater.from(parent.context).inflate(R.layout.artist, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.text1.text = mResultList[position].artistName
        holder.text2.text = mResultList[position].collectionName
        holder.text3.text = mResultList[position].trackName
        holder.text4.text = mResultList[position].collectionCensoredName
        holder.text5.text = mResultList[position].trackCensoredName
        holder.text6.text = mResultList[position].collectionArtistName

    }

    fun updateData(resultsList : ArrayList<Results>) {
        this.mResultList = resultsList
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {

        return mResultList.size
    }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val text1 = itemView.artistName
            val text2 = itemView.collectionName
            val text3 = itemView.trackName
            val text4 = itemView.collectionCensoredName
            val text5 = itemView.trackCensoredName
            val text6 = itemView.collectionArtistName

        }

    }



