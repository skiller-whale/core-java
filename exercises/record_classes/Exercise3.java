import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import html.HtmlNode;
import html.HtmlKeyAttribute;
import html.HtmlKeyValueAttribute;
import html.HtmlUtils;

/*
-----------------------
DATACLASSES: Exercise 3
-----------------------

There's a bug when rendering 'disabled' for the button, as it has no value:

    <button disabled=''>test button</button>

It instead should be:

    <button disabled>test button</button>

This is because sometimes `HtmlAttribute.value` is an empty string.
To fix this, you will use interfaces and inheritance.

1) Add a new interface called `HtmlAttributeBase` to `html/HtmlAttributeBase.java`.
    * Should it specify any methods?

2) Instead of using `HtmlAttribute`, create two classes:
    * `HtmlKeyAttribute` - it contains only a key.
    * `HtmlKeyValueAttribute` - it contains a key and a value.
        * Both of these should implement `HtmlAttributeBase` and define `toString`.

3) Update the definition of `HtmlNode` to use `HtmlAttributeBase`.

4) Update the definition of `htmlTree` in this file.

5) Make sure everything renders correctly once done.

NOTE: At the end of this `HtmlAttribute` will be deprecated and not used anymore.

*/

public class Exercise3 {
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
                ), List.of()) //,
                // new HtmlNode("whale", "hello there", List.of())
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
