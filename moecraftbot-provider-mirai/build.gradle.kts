plugins {
    id("kotlin")
}

configure<JavaPluginConvention> {
    this.sourceCompatibility = JavaVersion.VERSION_1_8
}

val kotlinVersion: String by rootProject.ext

val miraiCoreVersion: String by rootProject.ext

dependencies {
    compile(fileTree("libs"))
    compile("com.squareup.okhttp3:okhttp:3.5.0")
    compile("com.google.code.gson:gson:2.8.5")
    compile("com.squareup.retrofit2:retrofit:2.7.2")
    compile("com.squareup.retrofit2:converter-gson:2.7.2")
    compile("net.mamoe:mirai-core-jvm:$miraiCoreVersion")
    compile("net.mamoe:mirai-core-qqandroid-jvm:$miraiCoreVersion")
}

val libDirName = "libs"

tasks {
    withType<Jar> {
        dependsOn("copyJarLibs")
        destinationDir = file("${buildDir}/output")
    }

    register("copyJarLibs", Copy::class.java) {
        into("${buildDir}/output/$libDirName")
        from(configurations.runtime)
    }
}