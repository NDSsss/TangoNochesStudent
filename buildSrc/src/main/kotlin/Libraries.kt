@file:Suppress("MayBeConstant")

object Libraries {

    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val betterLinkMovementMethod = "me.saket:better-link-movement-method:${Versions.betterLinkMovementMethod}"
    val libPhoneNumberAndroid = "io.michaelrocks:libphonenumber-android:${Versions.libPhoneNumber}"
    val inputMask = "com.redmadrobot:input-mask-android:${Versions.inputMask}"
    val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    val okio = "com.squareup.okio:okio:${Versions.okio}"
    val progressButton = "com.github.razir.progressbutton:progressbutton:${Versions.progressButton}"
    val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
    val konfetti = "nl.dionsegijn:konfetti:${Versions.konfetti}"
    val threetenabp = "com.jakewharton.threetenabp:threetenabp:${Versions.threetenabp}"
    val threetenbp = "org.threeten:threetenbp:${Versions.threetenbp}"
    val pageIndicator = "ru.tinkoff.scrollingpagerindicator:scrollingpagerindicator:${Versions.pageIndicator}"
    val branchIO = "io.branch.sdk.android:library:${Versions.branchIO}"
    val photoView = "com.github.chrisbanes:PhotoView:${Versions.photoView}"
    val exoPlayer = "com.google.android.exoplayer:exoplayer-core:${Versions.exoPlayer}"
    val barcodeProcessing = "com.google.zxing:core:${Versions.barcodeProcessing}"

    object OkHttp3 {

        val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
        val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp3}"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    }

    object Retrofit2 {
        val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"

        object Converter {

            val kotlinXSerialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:" +
                    Versions.kotlinXSerializationRetrofitAdapter
            val gson = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
        }
    }

    object AndroidX {
        val cardView = "androidx.cardview:cardview:${Versions.AndroidX.cardView}"
        val exifInterface = "androidx.exifinterface:exifinterface:${Versions.AndroidX.exifInterface}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        val emojiAppcompat = "androidx.emoji:emoji-appcompat:${Versions.AndroidX.emojiAppcompat}"
        val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
        val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragment}"
        val fragment = "androidx.fragment:fragment:${Versions.AndroidX.fragment}"
        val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        val core = "androidx.core:core:${Versions.AndroidX.core}"
        val recyclerView = "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerView}"
        val annotation = "androidx.annotation:annotation:${Versions.AndroidX.annotation}"
        val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.AndroidX.coordinatorLayout}"
        val browser = "androidx.browser:browser:${Versions.AndroidX.browser}"
        val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.AndroidX.viewPager2}"
        val biometric = "androidx.biometric:biometric:${Versions.AndroidX.biometric}"
        val customView = "androidx.customview:customview:${Versions.AndroidX.customview}"
        val collection = "androidx.collection:collection:${Versions.AndroidX.collection}"
        val versionedparcelable = "androidx.versionedparcelable:versionedparcelable:${Versions.AndroidX.versionedparcelable}"
        val viewBinding = "androidx.databinding:viewbinding:${Versions.AndroidX.viewBinding}"
        val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.swipeRefreshLayout}"

        object Arch {
            val coreCommon = "androidx.arch.core:core-common:${Versions.AndroidX.arch}"
            val coreRuntime = "androidx.arch.core:core-runtime:${Versions.AndroidX.arch}"
        }

        object Paging {
            val runtimeKtx = "androidx.paging:paging-runtime-ktx:${Versions.AndroidX.paging}"

            // alternatively - without Android dependencies for testing
            val commonKtx = "androidx.paging:paging-common-ktx:${Versions.AndroidX.paging}"
        }

        object WorkManager {

            val runtimeKtx = "androidx.work:work-runtime-ktx:${Versions.AndroidX.workManager}"
            val testing = "androidx.work:work-testing:${Versions.AndroidX.workManager}"
        }

        object Lifecycle {

            val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifecycle}"
            val common = "androidx.lifecycle:lifecycle-common:${Versions.AndroidX.lifecycle}"
            val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.AndroidX.lifecycle}"
            val runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.AndroidX.lifecycle}"
            val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"

            val liveDataCore = "androidx.lifecycle:lifecycle-livedata-core:${Versions.AndroidX.lifecycle}"
            val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.AndroidX.lifecycle}"
            val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.lifecycle}"

            val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
            val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.AndroidX.lifecycle}"
            val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.AndroidX.lifecycle}"
        }

        object Test {

            val core = "androidx.test:core:${Versions.AndroidX.Test.core}"
            val coreKtx = "androidx.test:core-ktx:${Versions.AndroidX.Test.core}"
            val runner = "androidx.test:runner:${Versions.AndroidX.Test.core}"
            val rules = "androidx.test:rules:${Versions.AndroidX.Test.core}"
            val fragmentScenario = "androidx.fragment:fragment-testing:${Versions.AndroidX.Test.core}"

            object Ext {

                val junitKtx = "androidx.test.ext:junit-ktx:${Versions.AndroidX.Test.ext}"
            }

            object Espresso {

                val core = "androidx.test.espresso:espresso-core:${Versions.AndroidX.Test.espresso}"
            }
        }

        object Room {

            val runtime = "androidx.room:room-runtime:${Versions.AndroidX.room}"
            val compiler = "androidx.room:room-compiler:${Versions.AndroidX.room}"
            val ktx = "androidx.room:room-ktx:${Versions.AndroidX.room}"
            val testing = "androidx.room:room-testing:${Versions.AndroidX.room}"
        }

        object Navigation {

            // Kotlin
            val commonKtx = "androidx.navigation:navigation-common-ktx:${Versions.AndroidX.navigation}"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.navigation}"
            val runtime = "androidx.navigation:navigation-runtime:${Versions.AndroidX.navigation}"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.navigation}"
            val safeArgsGradlePlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.AndroidX.navigation}"
        }
    }

    object GradlePlugin {
        val android = "com.android.tools.build:gradle:${Versions.GradlePlugins.android}"
        val googleServices = "com.google.gms:google-services:${Versions.GradlePlugins.googleServices}"
        val detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.GradlePlugins.detekt}"
        val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.GradlePlugins.desugarJdkLibs}"
        val androidJar = "gradle.plugin.com.stepango.androidjar:androidjar:${Versions.GradlePlugins.androidJar}"
        val aarToJar = "gradle.plugin.com.stepango.aar2jar:aar2jar:${Versions.GradlePlugins.aar2jar}"
        val versions = "com.github.ben-manes:gradle-versions-plugin:${Versions.GradlePlugins.versions}"
        val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Versions.GradlePlugins.firebaseCrashlytics}"
        val sonarqube = "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${Versions.GradlePlugins.sonarqube}"
        val benManesVersions = "com.github.ben-manes:gradle-versions-plugin:${Versions.GradlePlugins.benManesVersions}"
    }

    object Kotlin {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    }

    object ApolloGraphQL {
        val gradlePlugin = "com.apollographql.apollo:apollo-gradle-plugin:${Versions.apolloGraphQL}"
        val runtime = "com.apollographql.apollo:apollo-runtime:${Versions.apolloGraphQL}"
        val api = "com.apollographql.apollo:apollo-api:${Versions.apolloGraphQL}"
        val httpCache = "com.apollographql.apollo:apollo-http-cache:${Versions.apolloGraphQL}"
        val normalizedCache = "com.apollographql.apollo:apollo-normalized-cache-sqlite:${Versions.apolloGraphQL}"
        val coroutinesSupport = "com.apollographql.apollo:apollo-coroutines-support:${Versions.apolloGraphQL}"
        val espressoSupport = "com.apollographql.apollo:apollo-espresso-support:${Versions.apolloGraphQL}"
    }

    object Firebase {
        val analytics = "com.google.firebase:firebase-analytics:${Versions.Firebase.analytics}"
        val analyticsKtx = "com.google.firebase:firebase-analytics-ktx:${Versions.Firebase.analytics}"
        val messaging = "com.google.firebase:firebase-messaging:${Versions.Firebase.messaging}"
        val iid = "com.google.firebase:firebase-iid:${Versions.Firebase.iid}"
        val crashlytics = "com.google.firebase:firebase-crashlytics:${Versions.Firebase.crashlytics}"
        val appIndexing = "com.google.firebase:firebase-appindexing:${Versions.Firebase.appIndexing}"
        val configKtx = "com.google.firebase:firebase-config-ktx:${Versions.Firebase.appIndexing}"
    }

    object PlayServices {
        val adsIdentifier = "com.google.android.gms:play-services-ads-identifier:${Versions.PlayServices.adsIdentifier}"
    }

    object Stetho {
        val core = "com.facebook.stetho:stetho:${Versions.stetho}"
        val okhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    }

    object Koin {
        val core = "org.koin:koin-core:${Versions.koin}"
        val coreExt = "org.koin:koin-core-ext:${Versions.koin}"
        val test = "org.koin:koin-test:${Versions.koin}"

        object Android {
            val scope = "org.koin:koin-androidx-scope:${Versions.koin}"
            val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

            // Will be available as part of 2.1.0
            // val fragment = "org.koin:koin-androidx-fragment:${Versions.koin}"

            // Koin AndroidX Experimental features
            val ext = "org.koin:koin-androidx-ext:${Versions.koin}"
            val fragment = "org.koin:koin-androidx-fragment:${Versions.koin}"
        }
    }

    object Coil {
        val core = "io.coil-kt:coil:${Versions.coil}"
        val gif = "io.coil-kt:coil-gif:${Versions.coil}"
        val svg = "io.coil-kt:coil-svg:${Versions.coil}"
    }

    object Mapbox {
        val core = "com.mapbox.mapboxsdk:mapbox-android-sdk:${Versions.Mapbox.core}"

        //https://docs.mapbox.com/android/core/overview/
        val androidCore = "com.mapbox.mapboxsdk:mapbox-android-core:${Versions.Mapbox.androidCore}"

        // https://docs.mapbox.com/android/java/overview/turf/
        val turf = "com.mapbox.mapboxsdk:mapbox-sdk-turf:${Versions.Mapbox.turf}"
    }

    object KotlinX {

        object Coroutines {
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KotlinX.coroutines}"
            val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KotlinX.coroutines}"
            val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KotlinX.coroutines}"
        }

        object Serialization {

            val runtime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.KotlinX.serialization}"
        }
    }

    object Robolectric {

        @Suppress("MemberNameEqualsClassName")
        val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    }

    object Strikt {

        val core = "io.strikt:strikt-core:${Versions.strikt}"
    }

    object Test {

        val junit4 = "junit:junit:${Versions.junit4}"
        val kaspresso = "com.kaspersky.android-components:kaspresso:${Versions.Test.kaspresso}"
        val leakcanary = "com.squareup.leakcanary:leakcanary-android-instrumentation:${Versions.leakCanary}"
    }

    object Facebook {

        val login = "com.facebook.android:facebook-login:${Versions.Facebook.login}"
        val common = "com.facebook.android:facebook-android-sdk:${Versions.Facebook.common}"
        val core = "com.facebook.android:facebook-core:${Versions.Facebook.core}"
    }

    object WebIM {

        val sdk = "com.webimapp.sdk:webimclientsdkandroid:${Versions.WebIM.sdk}"
    }

    object Material {

        @Suppress("MemberNameEqualsClassName")
        val material = "com.google.android.material:material:${Versions.Material.material}"
    }
}
