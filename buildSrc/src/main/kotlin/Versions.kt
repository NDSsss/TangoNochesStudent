@file:Suppress("MayBeConstant")

object Versions {
    val compileSdk = 29
    val targetSdk = 28
    val minSdk = 21
    val androidBuildTools = "29.0.3"

    val kotlin = "1.3.72"
    val mockk = "1.9.3"
    val ktlint = "0.36.0"
    val stetho = "1.5.1"
    val okhttp3 = "4.7.2"
    val apolloGraphQL = "2.2.2"
    val leakCanary = "2.3"
    val koin = "2.1.6"
    val coil = "0.9.5"
    val retrofit2 = "2.8.0"
    val kotlinXSerializationRetrofitAdapter = "0.4.0"
    val gsonConverter = "2.2.0"
    val robolectric = "4.4"
    val strikt = "0.24.0"
    val betterLinkMovementMethod = "2.2.0"
    val libPhoneNumber = "8.11.1"
    val junit4 = "4.13"
    val inputMask = "5.0.0"
    val shimmer = "0.5.0"
    val okio = "2.4.3"
    val progressButton = "2.1.0"
    val konfetti = "1.2.0"
    val threetenabp = "1.2.4"
    val threetenbp = "1.4.4"
    val pageIndicator = "1.2.1"
    val branchIO = "5.0.3"
    val photoView = "2.3.0"
    val exoPlayer = "2.11.7"
    val barcodeProcessing = "3.4.0"

    object KotlinX {
        val coroutines = "1.3.7"
        val serialization = "0.20.0"
    }

    object AndroidX {
        val cardView = "1.0.0"
        val exifInterface = "1.2.0"
        val constraintLayout = "2.0.0-beta6"
        val emojiAppcompat = "1.0.0"
        val appcompat = "1.2.0-rc01"
        val fragment = "1.2.5"
        val core = "1.3.0"
        val recyclerView = "1.1.0"
        val annotation = "1.1.0"
        val room = "2.2.5"
        val coordinatorLayout = "1.1.0"
        val navigation = "2.3.0"
        val viewPager2 = "1.0.0"
        val lifecycle = "2.2.0"
        val workManager = "2.3.4"
        val browser = "1.2.0"
        val biometric = "1.0.1"
        val paging = "2.1.2"
        val customview = "1.0.0"
        val collection = "1.1.0"
        val arch = "2.1.0"
        val versionedparcelable = "1.1.1"
        val viewBinding = "4.0.0"
        val swipeRefreshLayout = "1.1.0"

        object Test {

            val core = "1.2.0"
            val espresso = "3.2.0"
            val ext = "1.1.1"
        }
    }

    object GradlePlugins {

        val android = "4.0.1"
        val googleServices = "4.3.3"
        val kotlin = Versions.kotlin
        val detekt = "1.10.0"
        val desugarJdkLibs = "1.0.9"
        val androidJar = "0.1"
        val aar2jar = "0.6"
        val versions = "0.27.0"
        val firebaseCrashlytics = "2.0.0-beta02"
        val sonarqube = "3.0"
        val triplet = "2.8.0"
        val benManesVersions = "0.29.0"
    }

    /**
     * Release notes: https://firebase.google.com/support/release-notes/android
     */
    object Firebase {
        val messaging = "20.2.1"
        val iid = "20.2.0"
        val analytics = "17.4.3"
        val crashlytics = "17.1.0"
        val appIndexing = "19.1.0"
        val config = "19.1.4"
    }

    object PlayServices {
        val adsIdentifier = "17.0.0"
    }

    object Mapbox {
        val core = "9.1.0"
        val androidCore = "2.0.0"
        val turf = "5.0.0"
        val markerView = "0.3.0"
        val localization = "0.3.0"
    }

    object Test {
        val kaspresso = "1.0.1"
    }

    object CodeCoverage {
        val jacoco = "0.8.5"
    }

    object Facebook {

        val core = "7.0.0"
        val login = core
        val common = core
    }

    object WebIM {

        val sdk = "3.34.1.1"
    }

    object Material {

        val material = "1.2.1"
    }

    const val graphQlSchemaVersion = "0.0.246"
}
