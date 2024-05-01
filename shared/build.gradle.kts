plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    id("maven-publish")
}

group = "jvv.yandexads"
version = "0.1-alpha03"

//publishing {
//    repositories {
//        maven {
//            //...
//        }
//    }
//}

kotlin {
    androidTarget()
    jvmToolchain(17)

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "15"
        framework {
            baseName = "shared"
            isStatic = true
        }
        pod("YandexMobileAds"){
            version = "7.0.1"
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.yandex.ads)
        }
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.runtime)
        }
    }
    task("testClasses")
}

android {
    namespace = "jvv.yandexads"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
