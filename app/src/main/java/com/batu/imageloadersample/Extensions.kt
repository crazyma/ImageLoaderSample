package com.batu.imageloadersample

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource

@OptIn(ExperimentalTime::class)
fun ImageView.loadImage(url: String, _mark: TimeSource.Monotonic.ValueTimeMark? = null) {
    val tag = "ImageLoading"
    val mark = _mark ?: TimeSource.Monotonic.markNow()
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .into(object : CustomTarget<Drawable>() {
            override fun onLoadCleared(placeholder: Drawable?) {
            }

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                this@loadImage.setImageDrawable(resource)
                Log.d(tag, "Elapsed time: ${mark.elapsedNow()} $url")
            }
        })
}