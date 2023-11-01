package ir.oraclej.springbootproject_studentcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class SpringBootProjectStudentCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectStudentCourseApplication.class, args);
    }
}
