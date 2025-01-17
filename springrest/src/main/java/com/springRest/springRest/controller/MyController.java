package com.springRest.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.model.Course;
import com.springRest.springRest.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to courses Application";
	}
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		
		return this.courseService.getCourses();
	}
	
	//get single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		return this.courseService.getCourse(Long.parseLong(courseId));
		
	}
	
	//post single course
	@PostMapping(path= "/courses",consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
	}
	
	//put or update course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public Course deleteCourse(@PathVariable String courseId) {
		return this.courseService.deleteCourse(Long.parseLong(courseId));
	}
}
