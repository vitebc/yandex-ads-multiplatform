/*
 * Created by Vitebc (JVV) on 25.04.2024, 10:27.
 * Copyright (c) 2024. All rights reserved
 */

package jvv.yandexads

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds

class YandexAdsImpl : YandexAds {

    private var _visible = false
    private val openId = ""
    private val openIdDemo = "demo-appopenad-yandex"
    private val bannerId = "R-M-4833079-2"
    private val bannerIdDemo = "demo-banner-yandex"

    override var visible: Boolean
        get() = _visible
        set(value) {
            _visible = value
        }

    @SuppressLint("SuspiciousIndentation")
    @Composable
    override fun initAds() {
        val context = LocalContext.current
            MobileAds.initialize(context) {
                //logs("MobileAds initialize Android completion handler")
            }
    }

    @Composable
    override fun OpenAd() {

    }

    @Composable
    override fun ShowBanner() {
//        visible.ifTrue {
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = {
                BannerAdView(it).apply {
                    setAdUnitId(bannerIdDemo)
                    setAdSize(BannerAdSize.stickySize(it, 1200))
                    val adRequest = AdRequest.Builder().build()
                    loadAd(adRequest)
                }
            },
        )
//        }
    }
}
