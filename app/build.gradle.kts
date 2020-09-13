plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    logger.warn("TEST android")
    val ext = rootProject.extra
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(19)
        targetSdkVersion(29)
        versionCode = 2
        versionName = "2"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    compileOptions {
        sourceCompatibility = ext["javaVer"] as JavaVersion
        targetCompatibility = ext["javaVer"] as JavaVersion
    }

    signingConfigs {
        create("release") {
            logger.warn("Some warn message")
            storeFile = file("${project.projectDir.absolutePath}/../tango_noches_student.jks")
            storePassword = "Parolmoi1997"
            keyAlias = "tango_noches_alias"
            keyPassword = "Parolmoi1997"
        }
    }

    buildTypes {
        val appName = "TangoNoches"
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            buildConfigField("String", "BASE_URL", "\"http://tangonoches.famedev-stage.online/api/\"")
            resValue("string", "app_name_build", "$appName Stage")
        }
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            buildConfigField("String", "BASE_URL", "\"http://tangonoches.famedev.ru/api/\"")
            resValue("string", "app_name_build", appName)
        }
    }
}

dependencies {
    logger.warn("TEST dependencies")
    val ext = rootProject.extra
    implementation(fileTree("dir" to "libs", "include" to "*.jar"))

    implementation(ext["kotlin-stdlib"] as String)

    (ext["baseAndroidDependencies"] as List<String>)
            .plus(ext["baseRxDependencies"] as List<String>)
            .plus(ext["baseNetworkDependencies"] as List<String>)
            .forEach {
                implementation(it)
            }

    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.1")
    implementation("me.dm7.barcodescanner:zxing:1.9.13")
    implementation("me.dm7.barcodescanner:zbar:1.9.13")
    implementation("org.conscrypt:conscrypt-android:2.2.1")
    implementation("com.google.firebase:firebase-messaging:20.2.4")
    implementation("com.google.firebase:firebase-analytics:17.5.0")
    implementation("com.android.support:multidex:1.0.3")

    implementation(ext["dagger"] as String)
    kapt(ext["daggerCompiler"] as String)
    kaptAndroidTest(ext["daggerCompiler"] as String)
    compileOnly(ext["daggerAnnotations"] as String)
    kaptTest(ext["daggerCompiler"] as String)
    testAnnotationProcessor(ext["daggerAnnotations"] as String)

    testImplementation(ext["jUnit"] as String)
    androidTestImplementation(ext["testRunner"] as String)
    androidTestImplementation(ext["espressoCore"] as String)
}
