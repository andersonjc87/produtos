package br.com.produtos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.produtos")
@EnableAutoConfiguration
public class ProdutosApplication extends SpringBootServletInitializer {

    public ProdutosApplication() {
        super();
        setRegisterErrorPageFilter(false); // <- this one
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProdutosApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProdutosApplication.class, args);
    }

}
