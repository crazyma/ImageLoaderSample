@file:OptIn(ExperimentalTime::class)

package com.batu.imageloadersample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.batu.imageloadersample.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource

class MainActivity : AppCompatActivity() {

    companion object {
        private const val url =
            "https://w7.pngwing.com/pngs/1000/635/png-transparent-super-mario-bros-donkey-kong" +
                "-super-mario-world-mario-bros-super-mario-bros-donkey-kong-super-mario-world" +
                "-thumbnail.png" // 360*408

        private const val url2 =
            "https://megapx-assets.dcard.tw/images/42b6ddc8-8b51-4769-9925-75190b486c9f/1280.jpeg"

        // lFIXv,EO?b%LsXRP~pn3M|MdRjwI$fIV%1IW$$RP
        private const val blurHashString = "L?N9-1?]XSR6kXn~oIW=bbjYj[bH"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        Glide.with(originalImageView)
            .load(url2)
            .into(originalImageView)

//        Glide.with(blurImageView)
//            .load(url2)
//            .into(blurImageView)

//        val blurHash = BlurHash(this@MainActivity)
//        Glide.with(blurImageView)
//            .load(url2)
//            .blurPlaceHolder(blurHashString, blurImageView, blurHash) { requestBuilder ->
//                requestBuilder.into(blurImageView)
//            }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {
            val bitmap = withContext(Dispatchers.IO) {
                delay(1_000)
                val mark = TimeSource.Monotonic.markNow()
                BlurHashDecoder2.decode(
                    blurHashString,
                    16,
                    16,
                    1f,
                    useCache = true
                ).also {
                    Log.d("badu", "Elapsed time: ${mark.elapsedNow()} $url")
                }

                delay(1_000)

                val mark2 = TimeSource.Monotonic.markNow()
                BlurHashDecoder2.decode(
                    blurHashString,
                    16,
                    16,
                    1f,
                    useCache = true
                ).also {
                    Log.i("badu", "Elapsed time: ${mark2.elapsedNow()} $url")
                }

            }
            binding.blurImageView.setImageBitmap(bitmap)
        }
    }
}