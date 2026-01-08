# aidx4j

Library for generating IDs in the AID or AIDX format in Java.

AID is deprecated since it is no longer default in Misskey and is likely to collide, whereas AIDX is not. It's only
included for compatability purposes.

AID is composed of two components: the current time minus time since 2000 (8 chars), then an ending from a global
counter (2 chars).

An example AID would be `ah8ccctf0j`.

AIDX is composed of three components: the current time minus time since 2000 (8 chars), random lowercase letters or
numbers (4 chars), then an ending from a global counter (4 chars).

An example AIDX would be `ah8ccyxnft8p002p`.

## Examples

```java
// In Java
public static void main() {
    System.out.println("Generated AIDX " + generateAidx());
}
```

```kotlin
// In Kotlin
fun main() {
   println("Generated AIDX ${generateAidx()}")
}
```

## Installing

aidx4j is available in the remlit.site repository. You can install it like below.

```kotlin
repositories {
    maven("https://repo.remlit.site/releases")
}

dependencies {
    implementation("site.remlit:aidx4j:1.0.0")
}
```