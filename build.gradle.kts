plugins {
    id("java")
}

group = "site.remlit"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.remlit.site/releases")
}

dependencies {
    compileOnly("org.jetbrains:annotations:26.0.2-1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}