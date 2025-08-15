package com.alura.foroHub.domain.model;

import com.alura.foroHub.domain.valueObject.topic.AuthorVO;
import com.alura.foroHub.domain.valueObject.topic.CreationDateVO;
import com.alura.foroHub.domain.valueObject.topic.MessageVO;
import com.alura.foroHub.domain.valueObject.topic.TitleVO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Topic {

    private Long id;
    private TitleVO title;
    private MessageVO message;
    private CreationDateVO creationDate;
    private boolean status = true;
    private AuthorVO author;
    private Course course;
    private List<Answer> answers;
    private UserModel userModel;

    public Topic(){}

    // Constructor privado para el Builder
    private Topic(TopicBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.message = builder.message;
        this.creationDate = builder.creationDate;
        this.status = builder.status;
        this.author = builder.author;
        this.course = builder.course;
        this.answers = builder.answers;
        this.userModel = builder.userModel;
    }

    public Topic(TitleVO title, MessageVO message, CreationDateVO creationDateVO, Course course) {
        this.title = title;
        this.message = message;
        this.creationDate = creationDateVO;
        this.course = course;
    }

    public static Topic createNew(TitleVO title, MessageVO message, Course course) {
        return new Topic(title, message, new CreationDateVO(LocalDateTime.now()), course);
    }


    // Método estático para crear el Builder
    public static TopicBuilder builder() {
        return new TopicBuilder();
    }

    // Clase Builder interna
    public static class TopicBuilder {
        private Long id;
        private TitleVO title;
        private MessageVO message;
        private CreationDateVO creationDate;
        private boolean status = true;
        private AuthorVO author;
        private Course course;
        private List<Answer> answers = new ArrayList<>();
        private UserModel userModel;

        public TopicBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TopicBuilder withTitle(TitleVO title) {
            this.title = title;
            return this;
        }

        public TopicBuilder withMessage(MessageVO message) {
            this.message = message;
            return this;
        }

        public TopicBuilder withCreationDate(CreationDateVO creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public TopicBuilder withStatus(boolean status) {
            this.status = status;
            return this;
        }

        public TopicBuilder withAuthor(AuthorVO author) {
            this.author = author;
            return this;
        }

        public TopicBuilder withCourse(Course course) {
            this.course = course;
            return this;
        }

        public TopicBuilder withAnswers(List<Answer> answers) {
            this.answers = answers != null ? new ArrayList<>(answers) : new ArrayList<>();
            return this;
        }

        public TopicBuilder addAnswer(Answer answer) {
            if (this.answers == null) {
                this.answers = new ArrayList<>();
            }
            this.answers.add(answer);
            return this;
        }

        public TopicBuilder userModel(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public Topic build() {
            return new Topic(this);
        }
    }


    public Long getId() {
        return id;
    }
    public TitleVO getTitle() {
        return title;
    }
    public MessageVO getMessage() {
        return message;
    }
    public CreationDateVO getCreationDate() {
        return creationDate;
    }
    public boolean isStatus() {
        return status;
    }
    public AuthorVO getAuthor() {
        return author;
    }
    public Course getCourse() {
        return course;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public UserModel getUserModel() {
        return userModel;
    }


}
