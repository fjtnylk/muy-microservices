package com.muy.api.docs.b2b;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2Doc
@SpringBootApplication
public class MuyApiDocumentB2bApplication {

  public static void main(String[] args) {
    SpringApplication.run(MuyApiDocumentB2bApplication.class, args);
  }
}
