plugins {
    id("java-library")

    id("kotlin")
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

    //Android RX
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.2.19")


//    // Room
//    implementation ("androidx.room:room-rxjava2:2.2.6")
//
//
//    // Retrofit
//    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

}