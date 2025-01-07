package com.fmg.example1;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmg.example1.entity.Course;
import com.fmg.example1.entity.CourseRepo;
import com.fmg.example1.entity.Student;
import com.fmg.example1.entity.StudentRepo;

@SpringBootApplication
public class Example4Application implements CommandLineRunner {

	
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private CourseRepo courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Example4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course math = new Course(); 
		math.setName("Mathematics"); 
		Course science = new Course(); 
		science.setName("Science"); 
		Course english = new Course();
		english.setName("English"); 
		// Save Courses to Repository 
		//courseRepository.saveAll(Set.of(math, science, english)); 
		// Create Students 
		Student student1 = new Student(); 
		student1.setName("John Doe"); 
		student1.setCourses(new HashSet<>(Set.of(math, science))); 
		Student student2 = new Student();
		student2.setName("Jane Smith");
		student2.setCourses(new HashSet<>(Set.of(science, english)));
		
		// Save Students to Repository 
		studentRepo.saveAll(Set.of(student1, student2));
	}

}
