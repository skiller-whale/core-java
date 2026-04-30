class SystemPrompt implements ContextItem {
    private String prompt;

    public SystemPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getContent() {
        return String.format("system: %s", prompt);
    }

    @Override
    public String render() {
        return String.format("<|im_start|>%s<|im_end|>", getContent());
    }
}
