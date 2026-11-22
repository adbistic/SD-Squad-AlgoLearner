package com.algolearn.model;

import java.util.List;
import java.util.Objects;

/**
 * A multiple-choice quiz question.
 *
 * @param topic        a short name for the question, shown on the results page
 * @param prompt       the question text
 * @param options      the possible answers (at least two)
 * @param correctIndex index into {@code options} of the right answer
 * @param explanation  why the right answer is right, shown after answering
 */
public record Question(String topic, String prompt, List<String> options, int correctIndex, String explanation) {

    public Question {
        Objects.requireNonNull(topic, "topic");
        Objects.requireNonNull(prompt, "prompt");
        Objects.requireNonNull(explanation, "explanation");
        options = List.copyOf(options);
        if (options.size() < 2) {
            throw new IllegalArgumentException("A question needs at least two options");
        }
        if (correctIndex < 0 || correctIndex >= options.size()) {
            throw new IllegalArgumentException("correctIndex " + correctIndex + " is not a valid option");
        }
    }

    public boolean isCorrect(int optionIndex) {
        return optionIndex == correctIndex;
    }

    public String correctAnswer() {
        return options.get(correctIndex);
    }

    /** The letter shown next to an option: A, B, C, D... */
    public static String letter(int optionIndex) {
        return String.valueOf((char) ('A' + optionIndex));
    }
}
