import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import html.HtmlNode;
import html.HtmlAttribute;
import html.HtmlUtils;
import java.util.Arrays;
import java.util.ArrayList;

/*
-----------------------
DATACLASSES: Exercise 4
-----------------------

1) Make `HtmlNode` a record class.
    * Make sure you make all lists immutable.
    * Run the code and make sure it renders correctly.

2) Uncomment the code in this file that tries to add an attribute to `htmlTree`.
    * It shouldn't work!

3) Move the `render` function to `HtmlUtils.renderHtmlNode`.
    * Update the code in this file accordingly.

HINT: You will need to add a constructor that makes `attrs` optional.
*/

public class Exercise4 {
    public static void main(String[] args) {
        HtmlNode htmlTree = new HtmlNode("html", "", new ArrayList<>(Arrays.asList(
            new HtmlNode("head", "", List.of(
                new HtmlNode("title", "Hello, World", List.of())
            )),
            new HtmlNode("body", "", List.of(
                new HtmlNode("h1", "Hi, there!", List.of()),
                new HtmlNode("a", "Example link", List.of(
                    new HtmlKeyValueAttribute("href", "http://example.com")
                ), List.of()),
                new HtmlNode("button", "test button", List.of(
                    new HtmlKeyAttribute("disabled")
                ), List.of())
            ))
        )));

        // [Part 2] uncomment this after making `HtmlNode.children` immutable.
        htmlTree.children().add(new HtmlNode("whale", "hello there", List.of()));
        
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
