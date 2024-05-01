/*
 * Created by Vitebc (JVV) on 29.04.2024, 23:27.
 * Copyright (c) 2024. All rights reserved
 */

package jvv.yandexads

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import cocoapods.YandexMobileAds.YMAAdView
import cocoapods.YandexMobileAds.YMABannerAdSize
import cocoapods.YandexMobileAds.YMAMobileAds
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIColor
import platform.UIKit.UIView

internal class YandexAdsImpl : YandexAds {
    private var _visible = false

    private val openId = ""
    private val openIdDemo = "demo-appopenad-yandex"
    private val bannerId = "R-M-4833077-1"
    private val bannerIdDemo = "demo-banner-yandex"

    @Composable
    override fun OpenAd() {
    }

    @OptIn(ExperimentalForeignApi::class)
    @Composable
    override fun initAds() {
        YMAMobileAds.apply {
            setUserConsent(true)
            enableLogging()
            initializeSDKWithCompletionHandler {
                //logs("YMAMobileAds initialize ios completion handler")
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    @Composable
    override fun ShowBanner() {
//        visible.ifTrue {
            val width = 1200.0
            val adSize = YMABannerAdSize.stickySizeWithContainerWidth(width)
            val adView = YMAAdView(bannerIdDemo, adSize)
            adView.translatesAutoresizingMaskIntoConstraints = false
            adView.loadAd()
            val background = Color.Gray //MaterialTheme.colorScheme.background
            UIView().let { uiView ->
                uiView.backgroundColor = UIColor.darkGrayColor//MaterialTheme.colorScheme.background.toUIColor()
                adView.displayAtBottomInView(uiView)
                UIKitView(
                    background = background,
                    factory = {
                        uiView
                    },
                    modifier = Modifier
                        .height(80.dp)
//                    .wrapContentHeight()
                        .fillMaxWidth()
                        .background(background),
                )
            }

//            UIKitView(
//                background = MaterialTheme.colorScheme.background,
//                factory = {
//                    UIView().apply {
//                        adView.displayAtBottomInView(this)
//                    }
//                },
//                modifier = Modifier
//                    .height(80.dp)
////                    .wrapContentHeight()
//                    .fillMaxWidth()
//                    .background(MaterialTheme.colorScheme.background)
//                ,
//            )
//        }
    }

    override var visible: Boolean
        get() = _visible
        set(value) {
            _visible = value
        }
}
