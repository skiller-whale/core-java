package html;

public class HtmlAttribute {
    private final String key;
    private final String value;

    public HtmlAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String render() {
        return key + "='" + value + "'";
    }
}
