package html;

import java.util.ArrayList;
import java.util.List;

public class HtmlNode {
    private final String tag;
    private final String content;
    private final List<HtmlAttribute> attrs;
    private final List<HtmlNode> children;

    public HtmlNode(String tag, String content, List<HtmlAttribute> attrs, List<HtmlNode> children) {
        this.tag = tag;
        this.content = content;
        this.attrs = attrs;
        this.children = children;
    }

    public HtmlNode(String tag, String content, List<HtmlNode> children) {
        this.tag = tag;
        this.content = content;
        this.attrs = List.of();
        this.children = children;
    }

    private String render(int tabs) {
        StringBuilder childContent = new StringBuilder();
        for (HtmlNode child : this.children) {
            childContent.append(child.render(tabs + 1));
        }

        StringBuilder attrContent = new StringBuilder();
        for (HtmlAttribute attr : this.attrs) {
            attrContent.append(attr.render());
        }

        String tabsString = "  ".repeat(tabs);

        // (formatting) add leading space
        if (attrContent.length() > 0) {
            attrContent.insert(0, " ");
        }

        // (formatting) add a new line at the start
        if (childContent.length() > 0) {
            childContent.insert(0, "\n" + tabsString);
        }

        String renderedContent = this.content + childContent.toString();

        return tabsString +
            "<" + this.tag + attrContent.toString() + ">" +
            renderedContent +
            "</" + this.tag + ">\n";
    }

    public String render() {
        return this.render(0);
    }
}
