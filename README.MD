# netty-boot Project
Netty-boot is an utility for user to start a HTTP/MQTT server base on Netty quickly. 
##Download
Netty-boot is published to jitpack.
For Maven:  
Step 1: Add the JitPack repository to your pom.xml

```xml
  <repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
    </repository>
  </repositories>
```

Step 2. Add the dependency

```
    <dependency>
      <groupId>com.github.ttting.netty-boot</groupId>
      <artifactId>netty-boot</artifactId>
      <version>ce67bf00b4</version>
    </dependency>
```

For Gradle:
Step 1: Add the JitPack repository to your  build.gradle 

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2: Add the dependency

```groovy
		dependencies {
	        compile 'com.github.ttting.netty-boot:netty-boot:ce67bf00b4'
	}
```
##How to use
Use ServerBuidler to build a Http Server and Start a default http server.

```
public class DefaultHttpServerExample {
    public static void main(String[] args) throws InterruptedException {
        new ServerBuilder().setPort(8080).setiChInitializer((ch -> { ch.pipeline().addLast(new DispatcherHttpHandler());} )).build().start();
    }
}
```

Build a DispatcherHttpHandler and Register handler. Add the DispatcherHttpHandler to the childhandler pipeline. 

```
public class CustomHttpServerExample {
    public static void main(String[] args) throws InterruptedException {
        DispatcherHttpHandler dispatcherHttpHandler = new DispatcherHttpHandler();
        dispatcherHttpHandler.register("/ping", HttpMethod.GET, new PingHttpRequestExecutor());

        new ServerBuilder().setPort(8080).setiChInitializer((ch -> ch.pipeline().addLast(dispatcherHttpHandler))).build().start();
    }

    static class PingHttpRequestExecutor extends OneResponseExecutor{
        @Override
        protected FullHttpResponse handle(HttpRequest httpRequest, Map<String, List<String>> params, ByteBuf byteBuf) throws Exception {
            FullHttpResponse response;
            byte[] responseBytes = "Pong".getBytes();
            ByteBuf responseContent = Unpooled.wrappedBuffer(responseBytes);
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, responseContent);
            response.headers().set("Content-Length", responseBytes.length);
            return response;
        }
    }
}
```
For more details , see the [netty-boot-samples](https://github.com/ttting/netty-boot/tree/master/netty-boot-samples/src/main/java/me/ttting/netty/server/example)


License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

