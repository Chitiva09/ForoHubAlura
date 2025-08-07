-- V1__initial_schema.sql para Flyway y PostgreSQL

CREATE TABLE profile (
    id SERIAL PRIMARY KEY,
    name_profile VARCHAR(100) NOT NULL
);

CREATE TABLE user_model (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL
);

CREATE TABLE course (
    id SERIAL PRIMARY KEY,
    name_course VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL
);

CREATE TABLE topic (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    author VARCHAR(100) NOT NULL,
    course_id INTEGER REFERENCES course(id),
    user_model_id INTEGER REFERENCES user_model(id)
);

CREATE TABLE answer (
    id SERIAL PRIMARY KEY,
    message_answer TEXT NOT NULL,
    topic_id INTEGER REFERENCES topic(id),
    creation_date TIMESTAMP NOT NULL,
    author_answer VARCHAR(100) NOT NULL,
    solution TEXT,
    user_model_id INTEGER REFERENCES user_model(id)
);

-- Relaciones muchos a muchos
CREATE TABLE user_profile (
    user_model_id INTEGER REFERENCES user_model(id),
    profile_id INTEGER REFERENCES profile(id),
    PRIMARY KEY (user_model_id, profile_id)
);

CREATE TABLE course_topic (
    course_id INTEGER REFERENCES course(id),
    topic_id INTEGER REFERENCES topic(id),
    PRIMARY KEY (course_id, topic_id)
);

-- Puedes agregar índices y constraints adicionales según tu lógica de negocio
