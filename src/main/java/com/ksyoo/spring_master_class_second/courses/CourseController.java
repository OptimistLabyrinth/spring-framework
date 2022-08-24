package com.ksyoo.spring_master_class_second.courses;

import com.ksyoo.spring_master_class_second.courses.bean.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/courses")
    public List<Course> getManyCourses() {
        return List.of(
                new Course(1, "Learn Microservices", "in28minutes"),
                new Course(2, "Learn Full STack with React", "in28minutes")
        );
    }

    @GetMapping("/courses/{id}")
    public Course getOneCourse(@PathVariable(name = "id") Integer id) {
        System.out.println("id: " + id);
        return new Course(1, "Learn Microservices", "in28minutes");
    }
}
