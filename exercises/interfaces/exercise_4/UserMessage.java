class UserMessage {
    private String content;

    public UserMessage(String content) {
        this.content = content;
    }

    public String getRole() {
        return "user";
    }

    public String getContent() {
        return String.format("%s: %s", getRole(), content);
    }

    public String render() {
        return String.format("<|im_start|>%s<|im_end|>", getContent());
    }
}
