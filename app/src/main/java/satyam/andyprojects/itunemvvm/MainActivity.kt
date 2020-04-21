package satyam.andyprojects.itunemvvm

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import satyam.andyprojects.model.ArtistDetails
import satyam.andyprojects.model.DataViewModel
import satyam.andyprojects.model.Results

class MainActivity : AppCompatActivity() {

   private var queryText: String? = null
   private var searchItem: SpannableStringBuilder? = null
   private var SearchBar: SearchView? = null
   private lateinit var rvAdapter:RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this,2)
        rvAdapter = RecyclerAdapter()
        recyclerView.adapter =rvAdapter
        SearchBar?.setIconifiedByDefault(false)
        searchItem = SearchBar?.query as? SpannableStringBuilder
        SearchBar = findViewById(R.id.searchBar) as SearchView

        Log.i("oncreate","running")
        searchFun()
    }

    fun searchFun() {
        val model: DataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        SearchBar?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                queryText = query.toString()

                Log.e("SATTY", queryText)
                model.getAllDet(queryText).observe(this@MainActivity, Observer {
                    Log.e("SATTY", it.toString())

                    initRecyclerView(it.results)
                })

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("SATTY - new Text", newText)
                return true
            }
        })
    }

    fun initRecyclerView(resultsList : ArrayList<Results>){

        rvAdapter.updateData(resultsList)

    }


}
