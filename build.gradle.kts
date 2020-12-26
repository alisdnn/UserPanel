plugins {
    kotlin("jvm") version com.alisdnn.userpanel.buildsrc.Depends.Versions.kotlinVersion
    id("org.sonarqube") version com.alisdnn.userpanel.buildsrc.Depends.Versions.sonarqubeVersion
    detekt
    id("com.github.ben-manes.versions") version com.alisdnn.userpanel.buildsrc.Depends.Versions.checkDependencyVersionsVersion
    id("com.osacky.doctor") version com.alisdnn.userpanel.buildsrc.Depends.Versions.gradleDoctorVersion
}

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(com.alisdnn.userpanel.buildsrc.Depends.ClassPaths.gradle)
        classpath(
            kotlin(
                com.alisdnn.userpanel.buildsrc.Depends.ClassPaths.kotlin_gradle_plugin,
                version = com.alisdnn.userpanel.buildsrc.Depends.Versions.kotlinVersion
            )
        )
        classpath(com.alisdnn.userpanel.buildsrc.Depends.ClassPaths.navigation_safe_args_gradle_plugin)
        classpath(com.alisdnn.userpanel.buildsrc.Depends.ClassPaths.hilt_android_gradle_plugin)
        classpath(com.alisdnn.userpanel.buildsrc.Depends.ClassPaths.sonarqube_gradle_plugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://maven.google.com/")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}
