buildscript {
    repositories {
        maven(
            url = uri("https://plugins.gradle.org/m2/")
        )
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.gradle.kotlin:plugins:1.3.6")
    }
}

apply(plugin = "org.gradle.kotlin.kotlin-dsl")

repositories {
    maven(
        url = uri("https://plugins.gradle.org/m2/")
    )
    google()
    mavenCentral()
}

dependencies {
    "implementation"("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
    "implementation"("com.android.tools.build:gradle:4.0.1")
    "implementation"("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.0")
}
