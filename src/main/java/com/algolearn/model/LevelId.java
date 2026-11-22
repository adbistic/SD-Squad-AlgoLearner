package com.algolearn.model;

/**
 * The three difficulty levels of the app, in the order a student unlocks them.
 */
public enum LevelId {
    EASY("Easy"),
    INTERMEDIATE("Intermediate"),
    HARD("Hard");

    private final String displayName;

    LevelId(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    /** 1 for Easy, 2 for Intermediate, 3 for Hard. */
    public int number() {
        return ordinal() + 1;
    }

    /** The level that must be passed before this one unlocks, or null for the first level. */
    public LevelId previous() {
        return ordinal() == 0 ? null : values()[ordinal() - 1];
    }

    /** The level that unlocks after this one is passed, or null for the last level. */
    public LevelId next() {
        return ordinal() == values().length - 1 ? null : values()[ordinal() + 1];
    }

    /** CSS style class that gives this level its colour, e.g. "level-easy". */
    public String styleClass() {
        return "level-" + name().toLowerCase();
    }
}
