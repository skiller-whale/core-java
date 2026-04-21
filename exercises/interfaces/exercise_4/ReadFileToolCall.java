class ReadFileToolCall {
    private String filePath;

    public ReadFileToolCall(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return "ReadFile";
    }

    public String getParameterName() {
        return "filePath";
    }

    public String getParameterValue() {
        return filePath;
    }

    public String getContent() {
        return String.format("tool_call: %s(%s=%s)", getName(), getParameterName(), getParameterValue());
    }

    public String render() {
        return String.format("<|im_start|>%s<|im_end|>", getContent());
    }
}
