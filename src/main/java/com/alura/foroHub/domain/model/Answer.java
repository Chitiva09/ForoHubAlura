package com.alura.foroHub.domain.model;

import com.alura.foroHub.domain.valueObject.answer.AuthorAnswerVO;
import com.alura.foroHub.domain.valueObject.answer.CreationDateAnswerVO;
import com.alura.foroHub.domain.valueObject.answer.MessageAnswerVO;
import com.alura.foroHub.domain.valueObject.answer.SolutionVO;


public class Answer {

    private Long id;
    private MessageAnswerVO messageAnswer;
    private Topic topic;
    private CreationDateAnswerVO creationDate;
    private AuthorAnswerVO authorAnswer;
    private SolutionVO solution;
    private UserModel userModel;

    public Answer() {
    }

    public Answer(Long id, MessageAnswerVO messageAnswer, Topic topic, CreationDateAnswerVO creationDate, AuthorAnswerVO authorAnswer, SolutionVO solution, UserModel userModel) {
        this.id = id;
        this.messageAnswer = messageAnswer;
        this.topic = topic;
        this.creationDate = creationDate;
        this.authorAnswer = authorAnswer;
        this.solution = solution;
        this.userModel = userModel;
    }

    // Constructor privado para el Builder
    private Answer(AnswerBuilder builder) {
        this.id = builder.id;
        this.messageAnswer = builder.messageAnswer;
        this.topic = builder.topic;
        this.creationDate = builder.creationDate;
        this.authorAnswer = builder.authorAnswer;
        this.solution = builder.solution;
        this.userModel = builder.userModel;
    }

    // Método estático para crear el Builder
    public static AnswerBuilder builder() {
        return new AnswerBuilder();
    }

    // Clase Builder interna
    public static class AnswerBuilder {
        private Long id;
        private MessageAnswerVO messageAnswer;
        private Topic topic;
        private CreationDateAnswerVO creationDate;
        private AuthorAnswerVO authorAnswer;
        private SolutionVO solution;
        private UserModel userModel;

        public AnswerBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AnswerBuilder withMessageAnswer(MessageAnswerVO messageAnswer) {
            this.messageAnswer = messageAnswer;
            return this;
        }

        public AnswerBuilder withTopic(Topic topic) {
            this.topic = topic;
            return this;
        }

        public AnswerBuilder withCreationDate(CreationDateAnswerVO creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public AnswerBuilder withAuthorAnswer(AuthorAnswerVO authorAnswer) {
            this.authorAnswer = authorAnswer;
            return this;
        }

        public AnswerBuilder withSolution(SolutionVO solution) {
            this.solution = solution;
            return this;
        }

        public AnswerBuilder withUserModel(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public Answer build() {
            return new Answer(this);
        }
    }

    public Long getId() {
        return id;
    }

    public MessageAnswerVO getMessageAnswer() {
        return messageAnswer;
    }

    public Topic getTopic() {
        return topic;
    }

    public CreationDateAnswerVO getCreationDate() {
        return creationDate;
    }

    public AuthorAnswerVO getAuthorAnswer() {
        return authorAnswer;
    }

    public SolutionVO getSolution() {
        return solution;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserEntity(UserModel userModel) {
        this.userModel = userModel;
    }
}
