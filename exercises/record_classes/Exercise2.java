import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import html.HtmlNode;
import html.HtmlAttribute;
import html.HtmlUtils;

/*
-----------------------
DATACLASSES: Exercise 2
-----------------------

Instead of using `HtmlUtils.renderHtmlAttribute`, you can override
    `toString` in `HtmlAttribute`.

1) Instead of using a separate render function for `HtmlAttribute`, override `toString`:
    * Define and implement `toString` in `HtmlAttribute` - it takes no arguments.
    * Use it inside `HtmlNode`.

2) Is this better or worse than a separate render function and why?
    * Discuss this with your coach.

3) Add a default constructor for `HtmlAttribute` with no key and value
    equal to an empty string.
    * Once done, update the code here to reflect that.

*/

public class Exercise2 {
    public static void main(String[] args) {
        HtmlNode htmlTree = new HtmlNode("html", "", List.of(
            new HtmlNode("head", "", List.of(
                new HtmlNode("title", "Hello, World", List.of())
            )),
            new HtmlNode("body", "", List.of(
                new HtmlNode("h1", "Hi, there!", List.of()),
                new HtmlNode("a", "Example link", List.of(
                    new HtmlAttribute("href", "http://example.com")
                ), List.of()),
                new HtmlNode("button", "test button", List.of(
                    new HtmlAttribute("disabled", "")
                ), List.of())
            ))
        ));

        String renderedHtml = htmlTree.render();
        System.out.println(renderedHtml);

        try {
            FileWriter htmlFile = new FileWriter("output.html");
            htmlFile.write(renderedHtml);
            htmlFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
