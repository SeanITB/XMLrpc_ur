plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/xmlrpc-helma/xmlrpc-helma
    implementation("xmlrpc-helma:xmlrpc-helma:1.0")
    // https://mvnrepository.com/artifact/xerces/xercesImpl
    implementation("xerces:xercesImpl:2.6.2")

    //https://kotlin.github.io/kotlinx-rpc/get-started.html#configure-the-repositories
    implementation("org.jetbrains.kotlinx:kotlinx-rpc-krpc-client:0.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-rpc-krpc-server:0.4.0")

    //apache
    implementation("org.apache.xmlrpc:xmlrpc-server:3.1.3")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}