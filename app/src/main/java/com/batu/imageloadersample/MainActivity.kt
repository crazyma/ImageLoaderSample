package com.batu.imageloadersample

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.batu.imageloadersample.databinding.ActivityMainBinding
import kotlin.time.ExperimentalTime
import kotlin.time.TimeMark
import kotlin.time.TimeSource

@OptIn(ExperimentalTime::class)
class MainActivity : AppCompatActivity() {

    companion object {
        private const val url =
            "https://w7.pngwing.com/pngs/1000/635/png-transparent-super-mario-bros-donkey-kong" +
                "-super-mario-world-mario-bros-super-mario-bros-donkey-kong-super-mario-world" +
                "-thumbnail.png" // 360*408

        // 246 KB
        private const val url1 =
            "https://images.nintendolife.com/d63a0e81bb26f/mario-strikers-battle-league.large.jpg"

        // 369 KB
        private const val url2 =
            "https://staticctf.akamaized.net/J3yJr34U2pZ2Ieem48Dwy9uqj5PNUQTn/3MN69tPhVvfQzmLFJqRlTx/fb7720ad648739b85dc43e3e0566e2a7/RKB2_UCS21580_KEYART_wide_RGB-NO_LOGO.jpg"

        // 58 KB
        private const val url3 =
            "https://media.wired.com/photos/5926c1288d4ebc5ab806b602/master/pass/SuperMarioRunHP.jpg"

        // 1.1 MB
        private const val url4 = "https://i1.wp.com/popbee.com/image/2022/10/fotojet-62.jpg"

        // 79 KB
        private const val url5 =
            "https://assets.reedpopcdn.com/Chris-Pratt---Super-Mario-Remake---TRAILER-0-21-screenshot.png/BROK/resize/1200x1200%3E/format/jpg/quality/70/Chris-Pratt---Super-Mario-Remake---TRAILER-0-21-screenshot.png"

        // 202 KB
        private const val url6 = "https://cdn.mos.cms.futurecdn.net/fnCUp2iAAm7qfSP6dJqL6U.jpg"

        // 219 KB
        private const val url7 =
            "https://gettotext.com/wp-content/uploads/2022/08/A-version-of-Mario-prohibited-for-children-under-18-would.jpeg"

        // 304 KB
        private const val url8 =
            "https://www.jotform.com/blog/wp-content/uploads/2012/07/mario-luigi-yoschi-figures-163036.jpeg"

        // 36 KB
        private const val url9 =
            "https://i0.wp.com/mynintendonews.com/wp-content/uploads/2021/02/super_mario_3d_world_bowsers_fury.jpg"

        // 426 KB
        private const val url10 =
            "https://www.gematsu.com/wp-content/uploads/2022/05/Mario-Strikers-Battle-League_2022_05-05-22_010.jpg"

        // 147 KB
        private const val url11 =
            "https://cdn.vox-cdn.com/thumbor/R-gm7dugGLH5txdRaGnJDVuno8s=/0x0:1920x1080/1200x800/filters:focal(807x387:1113x693)/cdn.vox-cdn.com/uploads/chorus_image/image/69900882/Sw_SuperMarioParty_090618_PressKit_SCRN_01_bmp_jpgcopy.0.jpg"

        // 149 KB
        private const val url12 =
            "https://assets1.ignimgs.com/2020/09/15/mario35allstarspack-blogroll-1600209099732_160w.jpg?width=1280"
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
        val mark: TimeMark = TimeSource.Monotonic.markNow()
        setupImage(imageView1, url1, mark)
        setupImage(imageView2, url2, mark)
        setupImage(imageView3, url3, mark)
        setupImage(imageView4, url4, mark)
        setupImage(imageView5, url5, mark)
        setupImage(imageView6, url6, mark)
        setupImage(imageView7, url7, mark)
        setupImage(imageView8, url8, mark)
        setupImage(imageView9, url9, mark)
        setupImage(imageView10, url10, mark)
        setupImage(imageView11, url11, mark)
        setupImage(imageView12, url12, mark)
    }

    private fun setupImage(
        imageView: ImageView,
        url: String,
        mark: TimeMark,
    ) {
        imageView.loadImageByGlide(url, mark)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenCreated {

        }
    }
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