class GetWeatherToolCall implements ContextItem {
    private String location;

    public GetWeatherToolCall(String location) {
        this.location = location;
    }

    public String getName() {
        return "GetWeather";
    }

    public String getParameterName() {
        return "location";
    }

    public String getParameterValue() {
        return location;
    }

    public String getContent() {
        return String.format("tool_call: %s(%s=%s)", getName(), getParameterName(), getParameterValue());
    }

    @Override
    public String render() {
        return String.format("<|im_start|>%s<|im_end|>", getContent());
    }
}
