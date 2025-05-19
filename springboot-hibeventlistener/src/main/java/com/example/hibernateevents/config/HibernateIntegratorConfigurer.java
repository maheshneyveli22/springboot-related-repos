package com.example.hibernateevents.config;

import com.example.hibernateevents.integrator.MyIntegrator;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class HibernateIntegratorConfigurer implements HibernatePropertiesCustomizer {


    // Add a constructor to see if the bean is even created
    public HibernateIntegratorConfigurer() {
        System.out.println("### HibernateIntegratorConfigurer: Bean INSTANTIATED ###");
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        // You can directly add an Integrator instance to the properties map.
        // Hibernate will pick this up during SessionFactory creation.
      //   hibernateProperties.put("hibernate.integrator", new MyIntegrator());
        System.out.println("### HibernateIntegratorConfigurer: customize method called by Spring Boot ###");
        // Alternatively, if you had multiple integrators:
        // List<Integrator> integrators = new ArrayList<>();
        // integrators.add(new MyIntegrator());
        // integrators.add(new AnotherIntegrator());
        // hibernateProperties.put("hibernate.integrator", integrators);
    }
}