class SystemPrompt {
    private String prompt;

    public SystemPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getContent() {
        return String.format("system: %s", prompt);
    }

    public String render() {
        return String.format("<|im_start|>%s<|im_end|>", getContent());
    }
}
