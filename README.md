# aws-serverless-spring-pojo-mapper

A Java library that eliminates boilerplate code to enable Spring Framework DI and object mapping between AwsProxyRequest/AwsProxyResponse models and Plain Old Java Object (POJO) Request/Response for building Amazon Gateway API with Lambda Proxy Integration.


# To get a Git project into your build:

## Step 1. Add the JitPack repository to your build file
Gradle
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Maven
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

```

## Step 2. Add the dependency
Gradle  
```groovy
  	dependencies {
	        compile 'com.github.honnamkuan:aws-serverless-spring-pojo-mapper:1.0.0'
	}
```
Maven
```xml
	<dependency>
	    <groupId>com.github.honnamkuan</groupId>
	    <artifactId>aws-serverless-spring-pojo-mapper</artifactId>
	    <version>1.0.0</version>
	</dependency>
```

**That's it!** The first time you request a project JitPack checks out the code, builds it and serves the build artifacts.
