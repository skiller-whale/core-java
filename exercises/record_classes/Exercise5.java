import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import html.HtmlNode;
import html.HtmlKeyAttribute;
import html.HtmlKeyValueAttribute;
import html.HtmlUtils;
import java.util.Arrays;
import java.util.ArrayList;

/*
-----------------------
DATACLASSES: Exercise 5
-----------------------

`HtmlNode` should only accept the following node tags:

ALLOWED_NODE_NAMES = List.of(
    "html", "head", "title", "body",
    "a", "button", "input",
    "h1", "h2", "h3", "h4", "h5"
);

If you run this file now you will see a `<whale>` tag.

1) Add validation logic to `HtmlNode`. You should throw the following on failure:      

    throw new IllegalArgumentException("Tag '" + tag + "' not allowed!");

2) Run this file and make sure that `<whale>` node is not allowed.

-----------------------
DATACLASSES: Exercise 6
-----------------------

1) Make `ALLOWED_NODE_NAMES` a static attribute.

*/

public class Exercise5 {
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

        // [Part 2] uncomment this after making `HtmlNode` frozen
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
