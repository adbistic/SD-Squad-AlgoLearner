package com.algolearn.model;

import java.util.List;
import java.util.Objects;

/**
 * A difficulty level: a list of lessons followed by a milestone quiz.
 *
 * @param id          Easy, Intermediate or Hard
 * @param title       the level's name, e.g. "First Steps"
 * @param description one sentence about what the level teaches
 * @param lessons     the lessons, in order
 * @param quiz        the milestone quiz questions
 */
public record Level(LevelId id, String title, String description, List<Lesson> lessons, List<Question> quiz) {

    public Level {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(description, "description");
        lessons = List.copyOf(lessons);
        quiz = List.copyOf(quiz);
        if (lessons.isEmpty()) {
            throw new IllegalArgumentException("A level needs at least one lesson");
        }
        if (quiz.isEmpty()) {
            throw new IllegalArgumentException("A level needs at least one quiz question");
        }
    }

    /** CSS style class used to colour this level, e.g. "level-easy". */
    public String styleClass() {
        return id.styleClass();
    }

    /** For example "Easy · First Steps". */
    public String fullName() {
        return id.displayName() + " · " + title;
    }
}
