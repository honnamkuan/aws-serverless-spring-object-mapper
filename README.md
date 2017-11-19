# aws-serverless-spring-pojo-mapper

A Java library that eliminates boilerplate code to enable Spring Framework DI and object mapping between AwsProxyRequest/AwsProxyResponse models and Plain Old Java Object (POJO) Request/Response for building Amazon Gateway API with Lambda Proxy Integration.

Refer [samples package](https://github.com/honnamkuan/aws-serverless-spring-pojo-mapper/tree/master/src/main/java/com/hnkuan/aws/serverless/spring/samples) for integration steps.

1. Spring Context Configuration need to be provided by implementing `AbstractAwsProxyRequestHandler#getContext` in a custom class. [example: AwsProxyRequestHandlerImpl#getContext](https://github.com/honnamkuan/aws-serverless-spring-pojo-mapper/blob/master/src/main/java/com/hnkuan/aws/serverless/spring/samples/handler/AwsProxyRequestHandlerImpl.java)

2. The implementation of `AbstractAwsProxyRequestHandler` and the interface method `execute` is to be configured as AWS Lambda Function Handler method. [example: AwsProxyRequestHandlerImpl#handle](https://github.com/honnamkuan/aws-serverless-spring-pojo-mapper/blob/master/src/main/java/com/hnkuan/aws/serverless/spring/samples/handler/AwsProxyRequestHandlerImpl.java)

3. An instance of `AwsRequestHandler` need to be implemented and made dependency injectable by Spring, this will be an implementation of handler that accept customized POJO request and response through the interface method `handle(I, ApiGatewayRequestContext)` which returns flexible ResponseEntity [example: AwsRequestHandlerImpl](https://github.com/honnamkuan/aws-serverless-spring-pojo-mapper/blob/master/src/main/java/com/hnkuan/aws/serverless/spring/samples/handler/AwsRequestHandlerImpl.java)

**That's it!** The library will handle the rest, including bean lookups and type conversion during AWS Lambda execution time.


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
	        compile 'com.github.honnamkuan:aws-serverless-spring-pojo-mapper:1.0.2'
	}
```
Maven
```xml
	<dependency>
	    <groupId>com.github.honnamkuan</groupId>
	    <artifactId>aws-serverless-spring-pojo-mapper</artifactId>
	    <version>1.0.2</version>
	</dependency>
```

The first time you request a project JitPack checks out the code, builds it and serves the build artifacts.
