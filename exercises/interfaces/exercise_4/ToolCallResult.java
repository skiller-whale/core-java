class ToolCallResult {
    private String toolName;
    private String result;

    public ToolCallResult(String toolName, String result) {
        this.toolName = toolName;
        this.result = result;
    }

    public String getToolName() {
        return toolName;
    }

    public String getResult() {
        return result;
    }

    public String getContent() {
        return String.format("tool_result: %s: \n%s", toolName, result);
    }

    public String render() {
        return String.format("<|im_start|>%s<|im_end|>", getContent());
    }
}
