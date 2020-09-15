plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {

    val defPath = " ${buildDir.parentFile.parentFile.path}${File.separator}apks"
    val tryDir = File(buildDir.parentFile.parentFile, "apks")
    logger.warn("default path $defPath")
    val majorVersion = 1
    val minorVersion = 0
    val buildNumber = 0
    val verName = "$majorVersion.$minorVersion.$buildNumber"
//    val newDir = File(defPath)
//    newDir.createNewFile()
//    buildDir = tryDir
    val ext = rootProject.extra
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(19)
        targetSdkVersion(29)
        versionCode = 100
        versionName = verName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true

    }
    val apkName = "TangoNoches_v$verName"

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
            setProperty("archivesBaseName", apkName)
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            buildConfigField("String", "BASE_URL", "\"http://tangonoches.famedev-stage.online/api/\"")
            resValue("string", "app_name_build", "$appName Stage")
        }
        getByName("release") {
            setProperty("archivesBaseName", apkName)
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            buildConfigField("String", "BASE_URL", "\"http://tangonoches.famedev.ru/api/\"")
            resValue("string", "app_name_build", appName)
        }
    }
    tasks.whenTaskAdded{
        this.doLast {
            logger.warn("whenTaskAdded doLast ${this.name} outputs ${this.outputs.files.count()} files: ")
            if(this.name == "packageDebug" || this.name == "packageRelease"){
                val outFiles = this.outputs.files
                outFiles.forEach { rrr->
                    if(rrr.isDirectory){
                        copyApk(rrr.listFiles(), tryDir)
                    }
                }
            }
        }
    }
//    tasks.whenObjectRemoved{
//        logger.warn("whenObjectRemoved ${this.name}")
//    }
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
