package com.dicoding.fav.favorite

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.core.data.Resource
import com.dicoding.core.ui.MainAdapter
import com.dicoding.fav.databinding.ActivityFavoriteBinding
import com.dicoding.githublistuser.detail.DetailActivity
//import com.dicoding.githublistuser.R
//import com.dicoding.githublistuser.databinding.ActivityFavoriteBinding
//import com.dicoding.githublistuser.detail.DetailActivity
//import com.dicoding.githublistuser.detail.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData(){
        val adapter = MainAdapter()
        adapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("extra_data", selectedData)
            startActivity(intent)
        }

        viewModel.favorite.observe(this) {
            binding.empty.visibility=View.VISIBLE
            if (it != null) {
                binding.progressBar.visibility = View.GONE
                adapter.submitList(it)

                Toast.makeText(this,"Success load favorite ", Toast.LENGTH_SHORT).show()
            }
            binding.empty.visibility=View.GONE

        }
        binding.favoriteRv.adapter = adapter

        with(binding.favoriteRv) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
        }
    }
}