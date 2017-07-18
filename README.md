## 这是一个基于zookeeper的Dubbo运行例子
<p>DubboControler是消费者</p>
<p>DubboService是提供者</p>
<p>上面全部基于jdk8和tomcat8.4测试</p>
### 下面是运行需要准备的事情：
1. 到zookeeper官网下载 [zookeeper](https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.4.8/zookeeper-3.4.8.tar.gz)，然后在bin目录启动zookeeper,一般zookeeper的默认端口是2181。
2. 配置消费者dubbo配置，我这里配置在spring-config.xml里面，因为这是一个简单的demo，所以我没有分开写，直接写在spring配置里面就好了。
```xml
<!-- 扫描springUtils组件 -->
<context:component-scan base-package="util"></context:component-scan>
<!-- 消费方应用名，用于计算依赖关系，不是匹配条件，不要与提供方一样 -->
<dubbo:application name="DubboController" />
<!-- 使用multicast广播注册中心暴露发现服务地址 -->
<dubbo:registry address="192.168.31.108:2181" protocol="zookeeper" check="false"/>
<!-- 配置消费 -->
<dubbo:reference id="testService" interface="interfaces.ITestService" />
```
3. 配置提供者，我这里配置在spring-config.xml。
```xml
<!-- 配置提供 -->
<dubbo:service interface="interfaces.ITestService" ref="testService" />
<bean id="testService" class="service.TestService" />

<!-- 提供方应用信息，用于计算依赖关系 -->
 <dubbo:application name="DubboService" />

<!-- 使用zookeeper广播注册中心暴露服务地址 -->
<dubbo:registry address="192.168.31.108:2181" protocol="zookeeper" check="false"/>

<!-- 用dubbo协议在20880端口暴露服务 -->
<dubbo:protocol name="dubbo" port="20889" />
```

4. 消费者和提供者分别部署在不同端口上，或者提供者可以部署在不同机器上提高性能。消费者也可以部署多台机器，然后用nginx做负载均衡。

5. 调用测试http://ip:port/消费者项目名/Test/test.do
