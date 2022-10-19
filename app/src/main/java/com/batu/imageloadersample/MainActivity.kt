package com.batu.imageloadersample

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.batu.imageloadersample.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    companion object {
        private const val url =
            "https://w7.pngwing.com/pngs/1000/635/png-transparent-super-mario-bros-donkey-kong" +
                "-super-mario-world-mario-bros-super-mario-bros-donkey-kong-super-mario-world" +
                "-thumbnail.png" // 360*408

        private const val url2 =
            "https://w7.pngwing.com/pngs/1000/635/png-transpankey-kong" +
                "-super-mario-world-mario-bros-super-mario-bros-donkey-kong-super-mario-world" +
                "-thumbnail.png"
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
        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerCrop()
            .into(glideImageView1)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .fitCenter()
            .into(glideImageView2)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView3)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView4)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerCrop()
            .into(glideImageView5)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .fitCenter()
            .into(glideImageView6)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView7)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView8)

        Glide.with(this@MainActivity)
            .load(url)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView9)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerCrop()
            .into(glideImageView11)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .fitCenter()
            .into(glideImageView12)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView13)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView14)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerCrop()
            .into(glideImageView15)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .fitCenter()
            .into(glideImageView16)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView17)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView18)

        Glide.with(this@MainActivity)
            .load(url2)
            .placeholder(R.drawable.loading_square)
            .error(R.drawable.loading_square_error)
            .centerInside()
            .into(glideImageView19)

    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenCreated {
            delay(2_000)
            with(binding) {
                glideImageView1.drawable.printSize("1")
                glideImageView2.drawable.printSize("2")
                glideImageView3.drawable.printSize("3")
                glideImageView4.drawable.printSize("4")
                glideImageView5.drawable.printSize("5")
                glideImageView6.drawable.printSize("6")
                glideImageView7.drawable.printSize("7")
                glideImageView8.drawable.printSize("8")
                glideImageView9.drawable.printSize("9")
                glideImageView11.drawable.printSize("11")
                glideImageView12.drawable.printSize("12")
                glideImageView13.drawable.printSize("13")
                glideImageView14.drawable.printSize("14")
                glideImageView15.drawable.printSize("15")
                glideImageView16.drawable.printSize("16")
                glideImageView17.drawable.printSize("17")
                glideImageView18.drawable.printSize("18")
                glideImageView19.drawable.printSize("19")
            }
        }
    }

    private fun getDrawableSizeInfo(imageView: ImageView): String =
        "width: ${imageView.drawable.intrinsicWidth}, height: ${imageView.drawable.intrinsicHeight}"
}

private fun Drawable.printSize(msg: String = "") {
    Log.d("badu", "$msg | width: ${intrinsicWidth}, height: ${intrinsicHeight}")
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