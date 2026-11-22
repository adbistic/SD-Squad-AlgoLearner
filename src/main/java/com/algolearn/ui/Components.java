package com.algolearn.ui;

import com.algolearn.model.LevelId;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The app's UI kit: small reusable building blocks, so every screen looks like
 * the Figma design. Colours, sizes and shapes live in styles.css.
 */
public final class Components {

    /** Widest the page content gets, so it doesn't stretch on big screens. */
    public static final double MAX_CONTENT_WIDTH = 1200;

    private Components() {
    }

    // ---------- Top bar ----------

    /**
     * The bar at the top of every screen.
     *
     * @param leading  a back button or the logo
     * @param title    bold title, or null for none
     * @param subtitle small grey line under the title, or null
     * @param trailing nodes on the right (a badge, the avatar, ...)
     */
    public static HBox topBar(Node leading, String title, String subtitle, Node... trailing) {
        HBox bar = new HBox(24);
        bar.getStyleClass().add("top-bar");
        bar.setAlignment(Pos.CENTER_LEFT);
        bar.getChildren().add(leading);
        if (title != null) {
            Label titleLabel = label(title, "crumb-title");
            VBox crumb = new VBox(titleLabel);
            if (subtitle != null) {
                crumb.getChildren().add(label(subtitle, "crumb-sub"));
            }
            crumb.setAlignment(Pos.CENTER_LEFT);
            bar.getChildren().add(crumb);
        }
        bar.getChildren().add(hSpacer());
        bar.getChildren().addAll(trailing);
        return bar;
    }

    /** The AlgoLearn logo: a bordeaux "A" tile and the app name. */
    public static HBox logo() {
        Label mark = label("A", "logo-mark");
        HBox logo = new HBox(10, mark, label("AlgoLearn", "logo-text"));
        logo.setAlignment(Pos.CENTER_LEFT);
        return logo;
    }

    /** The round "S" (Student) avatar on the right of the top bar. */
    public static Button avatar() {
        Button avatar = new Button("S");
        avatar.getStyleClass().setAll("avatar");
        avatar.setFocusTraversable(false);
        return avatar;
    }

    /** The small bordeaux button on the left of the top bar, e.g. "‹ Home". */
    public static Button backButton(String text, Runnable action) {
        Button button = button(text, "btn-secondary", action);
        button.getStyleClass().add("btn-small");
        return button;
    }

    // ---------- Buttons, badges and text ----------

    /** A button; {@code style} is "btn-primary", "btn-secondary" or "btn-white". */
    public static Button button(String text, String style, Runnable action) {
        Button button = new Button(text);
        button.getStyleClass().setAll("btn", style);
        button.setOnAction(e -> action.run());
        button.setMinWidth(Region.USE_PREF_SIZE);
        return button;
    }

    public static Button button(String text, String style, Node icon, Runnable action) {
        Button button = button(text, style, action);
        button.setGraphic(icon);
        return button;
    }

    /**
     * A rounded label such as "Easy" or "Passed".
     *
     * @param tone "neutral", "primary", "success", "wrong" or a level style class such as "level-easy"
     */
    public static Label badge(String text, String tone) {
        Label badge = label(text, "badge", "tone-" + tone);
        badge.setWrapText(false);
        badge.setMinWidth(Region.USE_PREF_SIZE);
        return badge;
    }

    /** A smaller badge, used for "Time O(n)" and "Completed". */
    public static Label chip(String text, String tone) {
        Label chip = label(text, "chip", "tone-" + tone);
        chip.setWrapText(false);
        chip.setMinWidth(Region.USE_PREF_SIZE);
        return chip;
    }

    public static Label levelBadge(LevelId level) {
        return badge(level.displayName(), level.styleClass());
    }

    /** A label that wraps long text and uses the given style classes. */
    public static Label label(String text, String... styles) {
        Label label = new Label(text);
        label.getStyleClass().addAll(styles);
        label.setWrapText(true);
        label.setMinHeight(Region.USE_PREF_SIZE);
        return label;
    }

    // ---------- Layout ----------

    public static VBox card(double spacing, Node... children) {
        VBox card = new VBox(spacing, children);
        card.getStyleClass().add("card");
        return card;
    }

    /** Scrollable page area with the standard padding, centred on wide windows. */
    public static ScrollPane page(Node content) {
        StackPane centre = new StackPane(content);
        StackPane.setAlignment(content, Pos.TOP_CENTER);
        centre.setPadding(new Insets(32, 40, 32, 40));
        if (content instanceof Region region) {
            region.setMaxWidth(MAX_CONTENT_WIDTH);
        }
        ScrollPane scroll = new ScrollPane(centre);
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.getStyleClass().add("page-scroll");
        return scroll;
    }

    public static Region hSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    public static Region vSpacer() {
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    public static Region divider() {
        Region line = new Region();
        line.getStyleClass().add("divider");
        return line;
    }

    /** A rounded square with a number, coloured by level (the "1", "2", "3" tiles). */
    public static Label numberTile(LevelId level, double size) {
        Label tile = label(Integer.toString(level.number()), "num-tile", "tone-" + level.styleClass());
        tile.setMinSize(size, size);
        tile.setMaxSize(size, size);
        return tile;
    }

    /** Bordeaux progress bar; {@code fraction} goes from 0 to 1. */
    public static StackPane progressBar(double fraction) {
        Region fill = new Region();
        fill.getStyleClass().add("progress-fill");
        StackPane track = new StackPane(fill);
        track.getStyleClass().add("progress-track");
        StackPane.setAlignment(fill, Pos.CENTER_LEFT);
        fill.maxWidthProperty().bind(track.widthProperty().multiply(Math.max(0, Math.min(1, fraction))));
        return track;
    }

    // ---------- Code ----------

    private static final Set<String> KEYWORDS = Set.of(
            "public", "private", "static", "void", "int", "boolean", "return", "for", "while", "if",
            "else", "new", "continue", "true", "false", "class", "final", "double");
    private static final Pattern TOKENS = Pattern.compile(
            "(?<comment>//[^\\n]*)|(?<string>\"[^\"\\n]*\")|(?<word>[A-Za-z_]\\w*)|(?<number>\\b\\d+\\b)");

    /** Dark box showing Java code with simple syntax colouring (indented by 2 spaces to save room). */
    public static VBox codeBlock(String javaCode) {
        String code = javaCode.lines()
                .map(line -> {
                    int spaces = line.length() - line.stripLeading().length();
                    return " ".repeat(spaces / 2) + line.stripLeading();
                })
                .collect(Collectors.joining("\n"));
        TextFlow flow = new TextFlow();
        Matcher matcher = TOKENS.matcher(code);
        int last = 0;
        while (matcher.find()) {
            if (matcher.start() > last) {
                flow.getChildren().add(codeText(code.substring(last, matcher.start())));
            }
            Text token = codeText(matcher.group());
            if (matcher.group("comment") != null) {
                token.getStyleClass().add("code-comment");
            } else if (matcher.group("string") != null) {
                token.getStyleClass().add("code-string");
            } else if (matcher.group("number") != null) {
                token.getStyleClass().add("code-number");
            } else if (KEYWORDS.contains(matcher.group())) {
                token.getStyleClass().add("code-keyword");
            }
            flow.getChildren().add(token);
            last = matcher.end();
        }
        if (last < code.length()) {
            flow.getChildren().add(codeText(code.substring(last)));
        }
        flow.setLineSpacing(3);
        VBox box = new VBox(flow);
        box.getStyleClass().add("code-box");
        return box;
    }

    private static Text codeText(String text) {
        Text node = new Text(text);
        node.getStyleClass().add("code-text");
        return node;
    }

    // ---------- Dialogs ----------

    /** Asks a yes/no question in the app's style. Returns true if the user confirmed. */
    public static boolean confirm(Node owner, String title, String message, String confirmText) {
        ButtonType confirm = new ButtonType(confirmText, ButtonType.OK.getButtonData());
        Alert alert = new Alert(Alert.AlertType.NONE, message, ButtonType.CANCEL, confirm);
        alert.setTitle("AlgoLearn");
        alert.setHeaderText(title);
        alert.setGraphic(null);
        if (owner.getScene() != null) {
            alert.initOwner(owner.getScene().getWindow());
            alert.getDialogPane().getStylesheets().addAll(owner.getScene().getStylesheets());
        }
        return alert.showAndWait().filter(button -> button == confirm).isPresent();
    }
}
