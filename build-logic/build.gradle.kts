plugins {
    `kotlin-dsl`
    id("checkstyle")
}

repositories {
    gradlePluginPortal()
    mavenCentral()  // Add this if you have dependencies that are not plugins
}

checkstyle {
    toolVersion = "8.45" // You can specify the version of Checkstyle you want to use
    configFile = file("config/checkstyle/checkstyle.xml")
}

tasks.withType<Checkstyle> {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

