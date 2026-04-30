class Main {
    public static void main(String[] args) {
        var llmContext = new ContextItem[] {
            new SystemPrompt("You are a helpful assistant that provides information about the weather and can read files."),
            new AssistantMessage("Hello! How can I assist you today?"),
            new UserMessage("What services are defined in docker-compose.yml?"),
            new ReadFileToolCall( "docker-compose.yml"),
            new ToolCallResult("ReadFile", """
                services:
                    db:
                        image: postgres
                        ports:
                            - "5432:5432"
            """),
            new AssistantMessage("There is one service defined in the docker-compose.yml file - 'db'."),
        };

        System.out.println("LLM Context:");
        for (ContextItem item : llmContext) {
            System.out.println(item.render());
        }
    }
}
