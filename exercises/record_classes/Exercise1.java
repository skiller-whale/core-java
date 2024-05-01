import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import html.HtmlNode;
import html.HtmlAttribute;
import html.HtmlUtils;

/*
DATACLASSES: Exercise 1
-------------

This code lets you define and render HTML programmatically.

1) Run this script and read briefly through the code in
    `html/HtmlNode.java` and `html/HtmlAttribute.java`.
    
    * You can also open `output.html` in a browser to view it.

2) Make the following changes to the classes in html/:
  * Make `HtmlAttribute` a record class.
  * Move the functionality in `render` to `HtmlUtils.renderHtmlAttribute`.
  * Update `HtmlNode.render` accordingly.

3) Run this script, and ensure that the rendering still works.
    You shouldn't need to change anything in this file.

*/

public class Exercise1 {
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
