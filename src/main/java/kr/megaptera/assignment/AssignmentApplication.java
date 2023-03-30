package kr.megaptera.assignment;

import kr.megaptera.assignment.application.PostService;
import kr.megaptera.assignment.application.PostWithCommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(AssignmentApplication.class, args);

        var postWithCommentService = context.getBean(PostWithCommentService.class);
        postWithCommentService.init();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedOrigins("http://localhost:8000");
            }
        };
    }
}
