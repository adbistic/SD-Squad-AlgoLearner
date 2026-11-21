package com.algolearn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * One lesson of a level, with the same parts as our learning material:
 * a summary, an explanation, the "how it works" steps, extra notes
 * (an example, "good to know", ...), a real-life example, Java code and the complexity.
 *
 * @param title           lesson title, e.g. "Bubble Sort"
 * @param summary         one sentence shown under the title and on the level page
 * @param explanation     the main teaching text
 * @param steps           the "How it works" steps, in order
 * @param notes           extra boxes such as "Example" or "Good to know"
 * @param realLife        a real-life example
 * @param javaCode        an example implementation shown in a code box
 * @param timeComplexity  Big-O running time, e.g. "O(n²)"
 * @param spaceComplexity Big-O extra memory, e.g. "O(1)"
 * @param visualization   which animation "Watch it run" opens, or {@link Visualization#NONE}
 */
public record Lesson(
        String title,
        String summary,
        String explanation,
        List<String> steps,
        List<Note> notes,
        String realLife,
        String javaCode,
        String timeComplexity,
        String spaceComplexity,
        Visualization visualization) {

    /** A short titled box shown under the steps, e.g. "Good to know". */
    public record Note(String label, String text) {
        public Note {
            Objects.requireNonNull(label, "label");
            Objects.requireNonNull(text, "text");
        }
    }

    public Lesson {
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(summary, "summary");
        Objects.requireNonNull(explanation, "explanation");
        Objects.requireNonNull(realLife, "realLife");
        Objects.requireNonNull(javaCode, "javaCode");
        Objects.requireNonNull(timeComplexity, "timeComplexity");
        Objects.requireNonNull(spaceComplexity, "spaceComplexity");
        Objects.requireNonNull(visualization, "visualization");
        steps = List.copyOf(steps);
        notes = List.copyOf(notes);
        explanation = explanation.strip();
        javaCode = javaCode.strip();
    }

    public boolean hasVisualization() {
        return visualization != Visualization.NONE;
    }

    /** Starts building a lesson, so the content classes stay easy to read. */
    public static Builder named(String title) {
        return new Builder(title);
    }

    /** Fills in a lesson one part at a time. */
    public static final class Builder {
        private final String title;
        private String summary = "";
        private String explanation = "";
        private final List<String> steps = new ArrayList<>();
        private final List<Note> notes = new ArrayList<>();
        private String realLife = "";
        private String javaCode = "";
        private String time = "";
        private String space = "";
        private Visualization visualization = Visualization.NONE;

        private Builder(String title) {
            this.title = title;
        }

        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder explanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public Builder steps(String... steps) {
            this.steps.addAll(List.of(steps));
            return this;
        }

        public Builder note(String label, String text) {
            this.notes.add(new Note(label, text));
            return this;
        }

        public Builder realLife(String realLife) {
            this.realLife = realLife;
            return this;
        }

        public Builder code(String javaCode) {
            this.javaCode = javaCode;
            return this;
        }

        public Builder complexity(String time, String space) {
            this.time = time;
            this.space = space;
            return this;
        }

        public Builder visualization(Visualization visualization) {
            this.visualization = visualization;
            return this;
        }

        public Lesson build() {
            return new Lesson(title, summary, explanation, steps, notes, realLife,
                    javaCode, time, space, visualization);
        }
    }
}
