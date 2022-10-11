package com.batu.imageloadersample

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlin.time.ExperimentalTime
import kotlin.time.TimeMark

@OptIn(ExperimentalTime::class)
fun ImageView.loadImageByGlide(url: String, mark: TimeMark) {
    val tag = "ImageLoading"
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(object : CustomTarget<Drawable>() {
            override fun onLoadCleared(placeholder: Drawable?) {
            }

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                this@loadImageByGlide.setImageDrawable(resource)
                Log.d(tag, "Elapsed time: ${mark.elapsedNow()} $url")
            }
        })
}

@OptIn(ExperimentalTime::class)
fun ImageView.loadImageByCoil(url: String, mark: TimeMark) {
    val tag = "ImageLoading"
    this.load(url) {
        diskCachePolicy(CachePolicy.ENABLED)
        target { drawable ->
            this@loadImageByCoil.setImageDrawable(drawable)
            Log.d(tag, "Elapsed time: ${mark.elapsedNow()} $url")
        }
    }
}