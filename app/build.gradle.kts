plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}


android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.thomy.tmdbmoviestom"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}



dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":usecase"))

    implementation(fileTree("libs") { include(listOf("*.jar")) })

    // Support libraries
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.palette:palette:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0-alpha2")

//    implementation ("com.google.guava:guava:24.1-jre")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")


    kapt("androidx.room:room-compiler:2.2.6")

    // Room
    implementation("androidx.room:room-rxjava2:2.2.6")


    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.2.6")

    // Architecture components
    implementation("androidx.paging:paging-runtime:2.1.2")
    implementation("androidx.lifecycle:lifecycle-runtime:2.2.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Gson
    implementation("com.google.code.gson:gson:2.8.6")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit-mock:2.9.0")

    // Dagger
    implementation("com.google.dagger:dagger:2.30.1")
    kapt("com.google.dagger:dagger-compiler:2.30.1")
    implementation("com.google.dagger:dagger-android:2.28.1")
    implementation("com.google.dagger:dagger-android-support:2.28.1")
    kapt("com.google.dagger:dagger-android-processor:2.28.1")

    //Android RX
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.19")

    // Network
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
//    implementation ("de.hdodenhof:circleimageview:2.2.0")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    // Timber
    implementation("com.jakewharton.timber:timber:4.7.1")

    // Dependencies for local unit tests
    testImplementation("junit:junit:4.13.1")
//    testImplementation ("org.mockito:mockito-core:3.5.13")

    testImplementation("android.arch.core:core-testing:2.2.0")
    // mock extension function
    testImplementation("io.mockk:mockk:3.5.13")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:2.2.6")

    // Android Testing Support Library's runner and rules
    androidTestImplementation("com.android.support.test:runner:1.1.0")
    androidTestImplementation("com.android.support.test:rules:1.1.0")

    // Espresso UI Testing
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.1.0")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:3.1.0")
    androidTestImplementation("com.android.support.test.espresso:espresso-intents:3.1.0")
    implementation("com.android.support.test.espresso:espresso-idling-resource:3.1.0")

    // optional - Test helpers
    androidTestImplementation("androidx.room:room-testing:2.2.6")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.3")
}

