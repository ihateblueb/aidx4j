import org.gradle.internal.extensions.stdlib.capitalized

plugins {
    `maven-publish`

    id("java")

    id("org.jetbrains.dokka") version "2.1.0"
    id("org.jetbrains.dokka-javadoc") version "2.1.0"
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

// docs

dokka {
    dokkaPublications.html {
        moduleName.set(project.name.capitalized())
    }
}

val dokkaZip by tasks.registering(Zip::class) {
    dependsOn("dokkaGenerateHtml")
    archiveClassifier.set("dokka")
    from(layout.buildDirectory.dir("dokka/html"))
}

val javadocJar by tasks.registering(Jar::class) {
    dependsOn("dokkaGenerateJavadoc")
    archiveClassifier.set("javadoc")
    from(layout.buildDirectory.dir("dokka/javadoc"))
}

val javadocZip by tasks.registering(Zip::class) {
    dependsOn("dokkaGenerateJavadoc")
    archiveClassifier.set("javadoc")
    from(layout.buildDirectory.dir("dokka/javadoc"))
}

val sourcesJar by tasks.registering(Jar::class) {
    mustRunAfter("processResources")
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

// publishing

tasks.publish {
    dependsOn(":dokkaGenerate")
}

publishing {
    repositories {
        maven {
            name = "remlitSiteMain"
            url = if (version.toString()
                    .contains("SNAPSHOT")
            ) uri("https://repo.remlit.site/snapshots") else uri("https://repo.remlit.site/releases")

            credentials {
                username = System.getenv("REPO_ACTOR")
                password = System.getenv("REPO_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "site.remlit"
            artifactId = "aidx4j"
            version = project.version.toString()

            from(components["java"])

            artifact(dokkaZip)
            artifact(javadocJar)
            artifact(javadocZip)
            artifact(sourcesJar)

            pom {
                name = "aidx4j"
                url = "https://github.com/ihateblueb/aidx4j"

                licenses {
                    license {
                        name = "LGPLv3 License"
                        url = "https://opensource.org/license/lgpl-3-0"
                    }
                }

                developers {
                    developer {
                        id = "ihateblueb"
                        name = "ihateblueb"
                        email = "ihateblueb@proton.me"
                    }
                }

                scm {
                    connection = "scm:git:git://github.com/ihateblueb/aidx4j.git"
                    developerConnection = "scm:git:ssh://github.com/ihateblueb/aidx4j.git"
                    url = "https://github.com/ihateblueb/aidx4j"
                }
            }
        }
    }
}