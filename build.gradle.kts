plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    implementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    implementation("org.assertj:assertj-core:3.24.2")
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.5"
    }
    test {
        useJUnitPlatform()
    }
}
