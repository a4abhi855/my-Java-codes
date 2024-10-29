package com.springRest.springRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springRest.springRest.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list= new ArrayList<>();
		list.add(new Course(145, "Java Core course", "basics of java"));
		list.add(new Course(4343, "spring boot course", "basics of spring boot"));

	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c= null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		for(Course coe: list) {
			if(coe.getId()==course.getId()) {
				coe.setTitle(course.getTitle());
				coe.setDescription(course.getDescription());
				return coe;
			}
		}
		list.add(course);
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		for(Course course:list) {
			if(course.getId()==courseId) {
				list.remove(course);
				return course;
			}
		}
		return null;
	}

}
