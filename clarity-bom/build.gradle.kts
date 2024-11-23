plugins {
    id("java-platform")
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("org.reflections:reflections:0.10.2")
        api("org.junit:junit-bom:5.10.3")
    }
}