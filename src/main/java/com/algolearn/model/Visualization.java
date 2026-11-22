package com.algolearn.model;

/**
 * Which animated demo (if any) a lesson's "Watch it run" button opens.
 */
public enum Visualization {
    NONE("None"),
    BUBBLE_SORT("Bubble Sort"),
    SELECTION_SORT("Selection Sort"),
    INSERTION_SORT("Insertion Sort"),
    MERGE_SORT("Merge Sort"),
    QUICK_SORT("Quick Sort"),
    GRAPH_SEARCH("BFS & DFS"),
    DIJKSTRA("Dijkstra");

    private final String displayName;

    Visualization(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    /** True for the sorting algorithms, which are shown as bars. */
    public boolean isSort() {
        return this != NONE && this != GRAPH_SEARCH && this != DIJKSTRA;
    }

    /** True for the graph algorithms, which are shown as a network of points. */
    public boolean isGraph() {
        return this == GRAPH_SEARCH || this == DIJKSTRA;
    }
}
