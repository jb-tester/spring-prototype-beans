
For the beans that are not prototypes the autowiring errors should be shown despite the matching BeanFactory#getBean(bean, args...) method found

the ```@Bean```-annotated methods and the ```@Component```-annotated class constructors can have parameters that are not backed by the context beans, if we deal with prototype-scoped beans. So no autowiring error should be shown for the following bean definition
```
@Bean @Scope("prototype")
    public Bean2 prototypeBean21(Bean1 bean1, String str1){
        return new Bean2(bean1, str1);
    }

```
if no beans of String type are available, but the bean is instantiated using the BeanFactory#getBean(type, args...) method that provides the matching arguments:
```
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        Bean1 bean1 = ctx.getBean(Bean1.class);
        Bean2 bean2_1 = (Bean2) ctx.getBean("prototypeBean21",bean1, "foo");
```
IDEA treats this case correctly.

However, if the considered bean has the singleton scope, the autowiring error should be shown for it, if no autowiring candidates are found, and the BeanFactory#getBean() method should not be considered.

Actually IDEA doesn't show errors in this case. For example, the following bean

```
    @Bean 
    public Bean4 singletonBean(String str1, String str2){
        return new Bean4(str1,str2);
    }
```
displays no errors if it is instantiated as
```
ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
Bean4 singletonbean4 = (Bean4) ctx.getBean("singletonBean", "aaa","bbb");
```
and the gutter navigation icon for its constructor navigates to this method. 
But this code will fail in runtime.

===========================================================
Spring: show error for multiple same-type prototype beans instantiated using the BeanFactory#getBean(requiredType, args...) method

if we have the multiple same-type beans of prototype scope, then attempt to instantiate them using the BeanFactory#getBean(requiredType, args...) method should be detected as an error:
```
 @Bean @Scope("prototype")
    public Bean3 prototypeBean31(String str1, String str2, String str3){
        Bean3 bean3 = new Bean3(str1,str2);
        bean3.setStr3(str3);
        return bean3;
    }
   // @Bean @Scope("prototype")
    public Bean3 prototypeBean32(String str1, String str2){
        return new Bean3(str1,str2);
    }
```
```
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        Bean3 bean3_1 = ctx.getBean(Bean3.class, "foo","bar");
        Bean3 bean3_2 = ctx.getBean(Bean3.class, "foo","bar","boo");
```
 In this case the  BeanFactory#getBean(bean_name, args...) method should be used to avoid NoUniqueBeanDefinitionException
 
=====================================================

Spring: prototype beans: autowiring errors are shown if bean is instantiated using ObjectFactory interface

the autowiring errors are shown for the protoBean() method though it is annotated with ```@Scope("prototype")``` and the matching arguments are provided to the ObjectProvider#getObject(args...) method:
```
@Configuration
public class MyConfig3 {

    @Bean @Scope("prototype")
    public ProtoBean protoBean(String str1, String str2) {
        return new ProtoBean(str1, str2);
    }

    @Bean
    public UsageBean usageBean() {
        return new UsageBean();
    }
}

```
```
public class UsageBean {
    @Autowired
    private ObjectProvider<ProtoBean> protoBeanObjectProvider;

    public ProtoBean getProtoBeanInstance() {
        return protoBeanObjectProvider.getObject("foo","bar");
    }
}
```

======================================
Spring: prototype beans: autowiring errors are shown if bean is instantiated using the Function interface

the prototype bean can define some parameter that should be provided in runtime and no autowiring candidate bean can be found for it in the context. This parameter can be passed using the Function interface:
```
@Configuration
public class MyConfig2 {
    @Bean
    public Function<String, PBean> beanFactory() {
        return str1 -> pBean(str1);
    } 

    @Bean
    @Scope("prototype")
    public PBean pBean(String str1) {
       return new PBean(str1);
    }
    
    @Bean
    public SBean singletonFunctionBean() {
        return new SBean();
    }
    
}
```
```
public class SBean {
    @Autowired
    private Function<String, PBean> beanFactory;

    public PBean getPBeanInstance(String str1) {
        PBean bean = beanFactory.apply(str1);
        return bean;
    }
}
```
IDEA doesn't understand this configuration and reports an error for the prototype bean definition (autowiring error for the String argument, if no beans of String type is found)