plugins {
    id ("java-library")
    id ("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.2.6")

    // Gson
    implementation ("com.google.code.gson:gson:2.8.6")
}