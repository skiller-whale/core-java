import java.util.List;
import java.util.stream.Collectors;

// NEW FEATURES JAVA 11-21: Exercise 4
// -------------
// The below code mocks a rendering of an HTMl page programmatically, and also
// tests this code.
//
// The expected return value is coded via string addition, making it harder
// to see what the final string will actually look like.

// Part 1.
// Update `testHomepage` to use a text blocks for the expected html instead of
// string addition.

// Part 2.
// The message in the assertion error is a bit hard to read. Update this to use
// a text block, so the structure of the error message is easier to see.


public class Exercise4 {
    public static void testHomepage() {
        // TODO: rewrite using text blocks
        String expected =
            "<html>\n" +
            "<title>\n    Skiller Whaler\n</title>".indent(4) +
            "    <body>\n" + ("<h1>\n" +
                "    The whale editing platform that allows you to seamlessly retrieve and edit whale names." +
            "\n</h1>").indent(8) +
            "</body>".indent(4) +
            "</html>";

        String result = new HtmlTemplateGenerator().getHomepage();
        if (!expected.equals(result)) {
            throw new AssertionError("Expected:\n" + expected + "\n\nGot:\n" + result + "\n\nHighlighted differences:\n" + StringDiffHighlighter.highlightDifferences(expected, result));
        }
    }

    public static void main(String[] args) {
        testHomepage();
        System.out.println("\ntest passed OK!\n");

        // Uncomment this to see what the page should look like:
        System.out.println(new HtmlTemplateGenerator().getHomepage());
    }
}

// You don't need to touch any code below here

class HtmlTemplateGenerator {
    final String title = "Skiller Whaler";
    final String header = "The whale editing platform that allows you to seamlessly retrieve and edit whale names.";

    private String renderHtml(String title, String h1) {
        return new HtmlObject<>("html",
            new HtmlChildren<>(List.of(
                new HtmlObject<>("title", new HtmlStringContent(title)),
                new HtmlObject<>("body",
                    new HtmlObject<>("h1", new HtmlStringContent(h1))
                )
            ))
        ).render();
    }

    public String getHomepage() { return renderHtml(title, header); }

    interface HtmlContent { String render(); }

    record HtmlStringContent(String content) implements HtmlContent { public String render() { return content; } }
    record HtmlObject<T extends HtmlContent>(String tag, T content) implements HtmlContent {
        public String render() {
            return "<" + tag() + ">\n" + content.render().indent(4) + "</" + tag() + ">";
        }
    }
    record HtmlChildren<T extends HtmlContent>(List<T> children) implements HtmlContent {
        public String render() {
            return children()
                .stream()
                .map(child -> child.render())
                .collect(Collectors.joining("\n"));
        }
    }
}

class StringDiffHighlighter {
    public static String highlightDifferences(String original, String revised) {
        String[] originalLines = original.split("\n", -1);
        String[] revisedLines = revised.split("\n", -1);

        int maxLength = Math.max(originalLines.length, revisedLines.length);
        StringBuilder highlighted = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            String originalLine = i < originalLines.length ? originalLines[i] : null;
            String revisedLine = i < revisedLines.length ? revisedLines[i] : null;

            if (originalLine == null) {
                highlighted.append("[")
                           .append("<line-missing>")
                           .append("|")
                           .append(revisedLine.isEmpty() ? " " : revisedLine)
                           .append("]")
                           .append("\n");
                continue;
            } else if (revisedLine == null) {
                highlighted.append("[")
                           .append(originalLine.isEmpty() ? " " : originalLine)
                           .append("|")
                           .append("<line-missing>")
                           .append("]")
                           .append("\n");
                continue;
            } else if (originalLine.equals(revisedLine)) {
                highlighted.append(originalLine).append("\n");
            } else {
                highlighted.append("[")
                           .append(originalLine.isEmpty() ? " " : originalLine)
                           .append("|")
                           .append(revisedLine.isEmpty() ? " " : revisedLine)
                           .append("]")
                           .append("\n");
            }
        }

        return highlighted.toString();
    }
}
