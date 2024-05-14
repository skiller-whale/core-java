import java.util.List;
import java.util.stream.Collectors;

// NEW FEATURES JAVA 11-21: Exercise 3
// -------------
// The below code mocks a rendering of an HTMl page programmatically.
//      It also mocks testing of this code.
//      However, the expected return values are coded via string addition (which is ugly). 
// 
// * Update `testEnglishTemplate` and `testSpanishTemplate` to use multiline strings instead
// 

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

class HtmlTemplateGenerator {
    // 
    final String enTitle = "Skiller Whaler";
    final String enH1 = "The whale editing platform that allows you to seamlessly retrieve and edit whale names.";
    final String esTitle = "Skiller Whaler";
    final String esH1 = "La plataforma de edición de ballenas que le permite recuperar y editar nombres de ballenas sin problemas.";
    
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

    public String getEnglishPage() { return renderHtml(enTitle, enH1); }
    public String getSpanishPage() { return renderHtml(esTitle, esH1); }
}

public class Exercise4 {
    public static void testEnglishTemplate() {
        // TODO: rewrite using multiline strings
        String expected =
            "<html>\n" +
            "<title>\n    Skiller Whale\n</title>".indent(4) +
            "    <body>" + ("\n<h1>\n" +
                "    The whale editing platform that allows you to seamlessly retrieve and edit whale names." +
            "\n</h1>").indent(8) +
            "</body>".indent(4) +
            "</html>";

        assert expected == new HtmlTemplateGenerator().getEnglishPage();
    }

    public static void testSpanishTemplate() {
        // TODO: rewrite using multiline strings
        String expected =
            "<html>\n" +
            "<title>\n    Skiller Whale\n</title>".indent(4) +
            "    <body>" + ("\n<h1>\n" +
                "    La plataforma de edición de ballenas que le permite recuperar y editar nombres de ballenas sin problemas." +
            "\n</h1>").indent(8) +
            "</body>".indent(4) +
            "</html>";

        assert expected == new HtmlTemplateGenerator().getSpanishPage();
    }


    public static void main(String[] args) {
        testEnglishTemplate();
        testSpanishTemplate();

        System.out.println("(2) tests passed OK!");

        // Uncomment this to see what the page should look like:
        System.out.println(new HtmlTemplateGenerator().getEnglishPage());
    }
}
