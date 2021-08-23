import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}
buildscript {
    repositories {
        maven(url = "https://maven.aliyun.com/repository/public/")
        mavenCentral()
    }
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    maven(url = "https://maven.aliyun.com/repository/public/")
    mavenCentral()
}

extra["springCloudVersion"] = "Hoxton.SR9"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // actuator & prometheus
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // implementation("io.micrometer:micrometer-registry-prometheus:1.1.3")

    // nacos
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery:2.2.1.RELEASE")
    // implementation("org.springframework.cloud:spring-cloud-starter-alibaba-nacos-config:2.2.1.RELEASE")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
