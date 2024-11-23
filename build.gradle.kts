plugins {
    id("java")
    id("com.diffplug.spotless") version "6.25.0"
}

group = "com.clarity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

spotless {
    java {
        palantirJavaFormat("2.40.0")
        endWithNewline()
    }
}


tasks.test {
    useJUnitPlatform()
}