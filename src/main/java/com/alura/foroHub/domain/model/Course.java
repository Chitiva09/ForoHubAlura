package com.alura.foroHub.domain.model;

import com.alura.foroHub.domain.valueObject.course.CategoryVO;
import com.alura.foroHub.domain.valueObject.course.NameCourseVO;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private Long id;
    private NameCourseVO nameCourse;
    private CategoryVO category;
    private List<Topic> topic;

    public Course(Long id, NameCourseVO nameCourse, CategoryVO category) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.category = category;
    }

    public Course() {
    }

    // Constructor privado para el Builder
    private Course(CourseBuilder builder) {
        this.id = builder.id;
        this.nameCourse = builder.nameCourse;
        this.category = builder.category;
        this.topic = builder.topic;
    }

    // Método estático para crear el Builder
    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    // Clase Builder interna
    public static class CourseBuilder {
        private Long id;
        private NameCourseVO nameCourse;
        private CategoryVO category;
        private List<Topic> topic = new ArrayList<>();

        public CourseBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CourseBuilder withNameCourse(NameCourseVO nameCourse) {
            this.nameCourse = nameCourse;
            return this;
        }

        public CourseBuilder withCategory(CategoryVO category) {
            this.category = category;
            return this;
        }

        public CourseBuilder withTopic(List<Topic> topic) {
            this.topic = topic != null ? new ArrayList<>(topic) : new ArrayList<>();
            return this;
        }

        public CourseBuilder addTopic(Topic topic) {
            if (this.topic == null) {
                this.topic = new ArrayList<>();
            }
            this.topic.add(topic);
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

    public NameCourseVO getNameCourse() {
        return nameCourse;
    }

    public CategoryVO getCategory() {
        return category;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public Long getId() {
        return id;
    }


}
