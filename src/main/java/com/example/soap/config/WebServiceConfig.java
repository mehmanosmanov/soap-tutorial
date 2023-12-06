package com.example.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author Mehman on 15-07-2023
 * @project soap
 */
@Configuration
@EnableWs
public class WebServiceConfig {

   @Bean
   public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
      MessageDispatcherServlet servlet = new MessageDispatcherServlet();
      servlet.setApplicationContext(applicationContext);
      servlet.setTransformSchemaLocations(true);
      return new ServletRegistrationBean(servlet, "/ws/*");
   }

   @Bean(name = "student")
   public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentSchema) {
      DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
      wsdl11Definition.setPortTypeName("StudentsPort");
      wsdl11Definition.setLocationUri("/ws");
      wsdl11Definition.setTargetNamespace("com.example/soap/dto");//??!!
      wsdl11Definition.setSchema(studentSchema);
      return wsdl11Definition;
   }

   @Bean
   public XsdSchema studentsSchema() {
      return new SimpleXsdSchema(new ClassPathResource("wsdl/student.xsd"));
   }

   @Bean
   public Jaxb2Marshaller marshaller() {
      Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
      marshaller.setContextPath("com.example.soap.dto");
      return marshaller;
   }

}
