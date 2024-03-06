package com.dicoding.githublistuser.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.core.data.Resource
import com.dicoding.core.data.local.entity.UserEntity
import com.dicoding.core.data.remote.response.ItemsItem
import com.dicoding.core.ui.MainAdapter
import com.dicoding.githublistuser.R
import com.dicoding.githublistuser.databinding.ActivityMainBinding
import com.dicoding.githublistuser.detail.DetailActivity
//import com.dicoding.fav.favorite.FavoriteActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title="Github users"

        getData()

    }

   private fun getData(){
       val adapter = MainAdapter()
       adapter.onItemClick = { selectedData ->
           val intent = Intent(this, DetailActivity::class.java)
           intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
           startActivity(intent)
       }

       viewModel.user().observe(this) {
           if (it != null) {
               when (it) {
                   is Resource.Loading -> binding.progressBar.visibility =
                       View.VISIBLE

                   is Resource.Success -> {
                       binding.progressBar.visibility = View.GONE
                       adapter.submitList(it.data)
                       Toast.makeText(this,"Success load user ",Toast.LENGTH_SHORT).show()
                   }

                   is Resource.Error -> {
                       binding.progressBar.visibility = View.GONE
                       Toast.makeText(this,"Error load user ",Toast.LENGTH_SHORT).show()
                   }
               }
           }
       }
       binding.mainRv.adapter = adapter

       with(binding.mainRv) {
           layoutManager = LinearLayoutManager(this@MainActivity)
           setHasFixedSize(true)
       }
   }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnFav -> {
                try {
                    val favoriteActivityClass = Class.forName("com.dicoding.fav.favorite.FavoriteActivity")
                    startActivity(Intent(this@MainActivity, favoriteActivityClass))
                    Log.d("fav:","found")
                    return true
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                    Log.d("fav:","not found")
                    return false
                }

            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}