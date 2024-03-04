package com.dicoding.githublistuser.main

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.githublistuser.R
import com.dicoding.githublistuser.databinding.ActivityMainBinding
import com.dicoding.githublistuser.favorite.FavoriteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.Menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnFav -> {
                startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}