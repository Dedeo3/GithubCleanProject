package com.dicoding.githublistuser.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        supportActionBar?.title="Github users"
        searchBar()


    }

    private fun searchBar(){
        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { textView, i, keyEvent ->
                searchBar.setText(searchView.text.toString())
                let {
                    searchBar
                }
                searchView.hide()
                false
            }

            searchView.editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    searchBar.hint = if (s.isNullOrEmpty()) getString(R.string.searchbar_hint) else s.toString()
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
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