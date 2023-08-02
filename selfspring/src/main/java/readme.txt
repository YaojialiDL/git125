1. maven中的依赖继承, 父子模块的关系.
2. 日志的配置
3. spring分析. spring原版注解:

    ElementType.TYPE：能修饰类、接口或枚举类型
    ElementType.FIELD：能修饰成员变量
    ElementType.METHOD：能修饰方法
    ElementType.PARAMETER：能修饰参数
    ElementType.CONSTRUCTOR：能修饰构造器
    ElementType.LOCAL_VARIABLE：能修饰局部变量
    ElementType.ANNOTATION_TYPE：能修饰注解
    ElementType.PACKAGE：能修饰包

    RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
    RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
    RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息

     (1)容器配置相关注解
         @Configuration:  加了 Component,说明此配置类也要被spring托管.
         @ComponentScan

     (2)IOC相关注解
         @Component:  基础IOC注解,以下IOC注解都是 此注解的具体实现.
         @Repository
         @Service
         @Controller

         @Bean:  在配置类中加在方法上,用于托管第三方类

     (3)DI注解:
         @Autowired
         @Qualifier
         @Value

     (4)生命周期管理注解
          @Lazy
          @Scope

     并请根据你的理解，做自定义的实现( 要求名字稍改一下，在前面加一个Yc以示区分).

         重点:
          1. 这些注解是加在什么位置(类，方法，属性。。。。)?, 怎么定义?
          2. 这些注解是否有参数？参数是什么，有没有默认值？如何实现?
          3. 这些注解的retentionPolicy保持策略( 即什么时候有效,取值有  source->compile->runtime )
