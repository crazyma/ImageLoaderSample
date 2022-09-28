package com.batu.imageloadersample

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.batu.imageloadersample.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    companion object {
        private const val url =
            "https://w7.pngwing.com/pngs/1000/635/png-transparent-super-mario-bros-donkey-kong" +
                "-super-mario-world-mario-bros-super-mario-bros-donkey-kong-super-mario-world" +
                "-thumbnail.png" // 360*408
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
        Glide.with(glideImageView1)
            .load(url)
            .into(glideImageView1)

        Glide.with(glideImageView2)
            .load(url)
            .into(glideImageView2)

        Glide.with(glideImageView3)
            .load(url)
            .into(glideImageView3)

        Glide.with(glideImageView4)
            .load(url)
            .into(glideImageView4)

        coilImageView1.load(url)
        coilImageView2.load(url)
        coilImageView3.load(url)
        coilImageView4.load(url)

        fixedImageView.setImageResource(R.drawable.mario)
        wrapContentImageView.setImageResource(R.drawable.mario)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenCreated {
            delay(2_000)
            with(binding) {
                Log.d("badu", "fixedImageView width: ${fixedImageView.width}, height: ${fixedImageView.width}")
                Log.d("badu", "wrapContentImageView width: ${wrapContentImageView.width}, height: ${wrapContentImageView.width}")
                Log.d("badu", "glide image 1 : ${getSizeInfo(glideImageView1)}")
                Log.d("badu", "glide image 2 : ${getSizeInfo(glideImageView2)}")
                Log.d("badu", "glide image 3 : ${getSizeInfo(glideImageView3)}")
                Log.d("badu", "glide image 4 : ${getSizeInfo(glideImageView4)}")
                Log.d("badu", "coil image 1 : ${getSizeInfo(coilImageView1)}")
                Log.d("badu", "coil image 2 : ${getSizeInfo(coilImageView2)}")
                Log.d("badu", "coil image 3 : ${getSizeInfo(coilImageView3)}")
                Log.d("badu", "coil image 4 : ${getSizeInfo(coilImageView4)}")
                Log.d("badu", "fix image: ${getSizeInfo(fixedImageView)}")
                Log.d("badu", "wrap content image : ${getSizeInfo(wrapContentImageView)}")
            }
        }
    }

    private fun getSizeInfo(imageView: ImageView): String =
        "width: ${imageView.drawable.intrinsicWidth}, height: ${imageView.drawable.intrinsicHeight}"
}

/*

RequestOptions.circleCropTransform()

public static RequestOptions circleCropTransform() {
    if (circleCropOptions == null) {
      circleCropOptions = new RequestOptions().circleCrop().autoClone();
    }
    return circleCropOptions;
  }

  @NonNull
  @CheckResult
  public T circleCrop() {
    return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
  }


 */