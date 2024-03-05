package com.dicoding.githublistuser.detail

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.dicoding.core.domain.model.User
import com.dicoding.githublistuser.R
import com.dicoding.githublistuser.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val viewModel: DetailViewModel by viewModel()

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val PREF_NAME = "favorite_status"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val detailUser = intent.getParcelableExtra<User>(EXTRA_DATA)
        showDetailUser(detailUser)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.addFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
        } else {
            binding.addFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unfavorite))
        }
    }

    private fun showDetailUser(user: User?) {
        user?.let {
            supportActionBar?.title = "detail- ${user.name}"
            Glide.with(this@DetailActivity)
                .load(user.image)
                .into(binding.image)
            binding.itemName.text = user.name

            var statusFavorite = sharedPreferences.getBoolean(user.id.toString(), false)

//            if (statusFavorite) {
//                Toast.makeText(this, "remove from favorite ", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Add favorite ", Toast.LENGTH_SHORT).show()
//            }
            setStatusFavorite(statusFavorite)

            binding.addFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                viewModel.setFavorite(user, statusFavorite)
                setStatusFavorite(statusFavorite)

                with(sharedPreferences.edit()) {
                    putBoolean(user.id.toString(), statusFavorite)
                    apply()
                }
            }
        }
    }
}