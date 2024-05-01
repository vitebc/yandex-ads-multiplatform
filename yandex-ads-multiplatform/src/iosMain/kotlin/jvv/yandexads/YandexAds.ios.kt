/*
 * Created by Vitebc (JVV) on 25.04.2024, 10:25.
 * Copyright (c) 2024. All rights reserved
 */

package jvv.yandexads

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

actual interface YandexAds {
    actual var visible: Boolean
    @Composable
    actual fun initAds()

    @Composable
    actual fun OpenAd()

    @Composable
    actual fun ShowBanner()

}

@Composable
actual fun setYandexAds(content: @Composable () -> Unit) {
//    logs("InitYandexAds ios")
    CompositionLocalProvider(
        LocalYandexAds provides YandexAdsImpl(),
    ) {
        LocalYandexAds.current.apply {
            initAds()
        }
        content.invoke()
    }
}
