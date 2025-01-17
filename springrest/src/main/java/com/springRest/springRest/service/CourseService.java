package com.springRest.springRest.service;

import java.util.List;

import com.springRest.springRest.model.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public Course deleteCourse(long courseId);
}
