package com.algolearn.ui;

import javafx.scene.shape.SVGPath;

/**
 * Small vector icons, drawn from SVG path data so they look sharp at any size
 * and never depend on emoji fonts. Their colour comes from styles.css (".icon").
 */
public final class Icons {

    private Icons() {
    }

    public static SVGPath check() {
        return icon("M2 8.5 L6 12.5 L14 4 L12.6 2.6 L6 9.7 L3.4 7.1 Z");
    }

    public static SVGPath cross() {
        return icon("M3.4 2 L8 6.6 L12.6 2 L14 3.4 L9.4 8 L14 12.6 L12.6 14 L8 9.4 L3.4 14 L2 12.6 L6.6 8 L2 3.4 Z");
    }

    public static SVGPath play() {
        return icon("M4 2 L14 8 L4 14 Z");
    }

    public static SVGPath pause() {
        return icon("M3 2 H7 V14 H3 Z M9 2 H13 V14 H9 Z");
    }

    public static SVGPath restart() {
        return icon("M8 2 A6 6 0 1 0 14 8 H12 A4 4 0 1 1 8 4 V6.5 L11.5 3 L8 -0.5 Z");
    }

    public static SVGPath lock() {
        return icon("M4 7 V5 A4 4 0 0 1 12 5 V7 H13 V15 H3 V7 Z M6 7 H10 V5 A2 2 0 0 0 6 5 Z");
    }

    private static SVGPath icon(String path) {
        SVGPath icon = new SVGPath();
        icon.setContent(path);
        icon.getStyleClass().add("icon");
        return icon;
    }
}
