package com.blinets.dependency.injection;

import com.blinets.dependency.injection.configuration.PropertiesBindingConfiguration;
import com.blinets.dependency.injection.controllers.*;
import com.blinets.dependency.injection.datasource.FakeDataSource;
import com.blinets.dependency.injection.services.scope.PrototypeBean;
import com.blinets.dependency.injection.services.scope.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"com.example.component.scan", "com.blinets.dependency.injection"})
@SpringBootApplication
public class SfPetClinicApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfPetClinicApplication.class, args);

        System.out.println("------- Profile Bean");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("------ Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("-------- Best Pet");
        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println(petController.whichPetIsTheBest());

        System.out.println("---- Bean Scopes ---------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        System.out.println("---- FakeDataSource ---------");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());

        System.out.println("---- Properties Binding Configuration ---------");
        PropertiesBindingConfiguration propertiesBindingConfiguration = ctx.getBean(PropertiesBindingConfiguration.class);
        System.out.println(propertiesBindingConfiguration.getUsername());
        System.out.println(propertiesBindingConfiguration.getPassword());
        System.out.println(propertiesBindingConfiguration.getJdbcUrl());

//        System.out.println("---- Properties Binding Constructor Configuration ---------");
//        PropertiesBindingConstructorConfiguration propertiesBindingConstructorConfiguration = ctx.getBean(PropertiesBindingConstructorConfiguration.class);
//        System.out.println(propertiesBindingConstructorConfiguration.getUsername());
//        System.out.println(propertiesBindingConstructorConfiguration.getPassword());
//        System.out.println(propertiesBindingConstructorConfiguration.getJdbcUrl());

    }

}
