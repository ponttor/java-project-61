plugins {
    id("application")
    id("checkstyle")
    id("com.github.ben-manes.versions") version "0.53.0"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.12.4"
    config = resources.text.fromFile("config/checkstyle/checkstyle.xml")
    configProperties["org.checkstyle.sun.suppressionfilter.config"] =
        file("config/checkstyle/checkstyle-suppressions.xml").absolutePath
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

application {
    mainClass.set("hexlet.code.App")
}
