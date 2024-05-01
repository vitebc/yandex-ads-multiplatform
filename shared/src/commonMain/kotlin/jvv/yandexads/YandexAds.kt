/*
 * Created by Vitebc (JVV) on 25.04.2024, 10:01.
 * Copyright (c) 2024. All rights reserved
 */

package jvv.yandexads

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

var LocalYandexAds = staticCompositionLocalOf<YandexAds> { error("no create class") }

@Composable
expect fun setYandexAds(content: @Composable () -> Unit)

expect interface YandexAds {

    var visible: Boolean
    @Composable
    fun initAds()

    @Composable
    fun OpenAd()

    @Composable
    fun ShowBanner()
}
