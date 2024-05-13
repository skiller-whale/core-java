import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
SEALED CLASSES: Exercise 2
-------------

This code implements a simple echo 'ChatServer'.

1) Add a `non-sealed` class called `CommandMessage` that implements `Message`.
    * It should have one function (`String call();`).
    * `call` should return a String that will be printed out by `ChatServer`.
    
    This class is meant to be extended later by user code to add more functionality.

2) Add two classes - `CommandExit` and `CommandHelp`.
    * `CommandExit` should print "[system-exit]" and exit by calling `System.exit(0)`.
    * `CommandHelp` should print a help message:
        ```java
            "/exit - exits\n" +
            + "/help - prints help (this message)\n\n"
            + "Emojis\n======\n"
            + ":cat\n"
            + ":fish\n"
            + ":laugh\n"
            + ":cthulu\n";
        ```

3) Think about where the logic for exiting the app should be, either:
    * In `CommandExit` - in the `call` function.
    * In `ChatServer`.
    
    Discuss this with your coach.

[Optional]
4) Supppose someboy wants to later add a command called `CommandHistory` (without modifying this code).
    * What would prevent them from doing so with the current setup?
    * How could you solve this?
    
    Discuss this with your coach.
*/

sealed interface Message permits TextMessage, EmojiMessage { }

final class TextMessage implements Message {
    public final String from;
    public final String textContent;

    public TextMessage(String from, String textContent) {
        this.from = from;
        this.textContent = textContent;
    }
}

final class EmojiMessage implements Message {
    static enum Emoji {
        CTHULHU,
        CAT,
        FISH,
        LAUGH
    }
    
    public final String from;
    public final EmojiMessage.Emoji emoji;

    public EmojiMessage(String from, EmojiMessage.Emoji emoji) {
        this.from = from;
        this.emoji = emoji;
    }
}

class ChatServer {
    List<Message> history;

    public ChatServer() {
        this.history = new ArrayList<Message>();
    }
    
    public void sendMessage(Message message) {
        history.add(message);

        String output = switch(message) {
            case TextMessage textMsg -> "[%s] %s".formatted(textMsg.from, textMsg.textContent);
            case EmojiMessage emojiMsg -> "[%s] %s".formatted(emojiMsg.from, ChatServer.renderEmoji(emojiMsg.emoji));
        };
    
        System.out.println(output);
    }

    public static String renderEmoji(EmojiMessage.Emoji type) {
        return switch(type) {
            case EmojiMessage.Emoji.CTHULHU -> "^(;,;)^";
            case EmojiMessage.Emoji.CAT -> "=^..^=";
            case EmojiMessage.Emoji.FISH -> "><((((`>";
            case EmojiMessage.Emoji.LAUGH -> "(^^)";
        };
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        var server = new ChatServer();
        // Placeholder for username
        String from = "user";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Type something: >>> ");
            String userInput = scanner.nextLine();

            Message message = switch(userInput) {
                case ":cthulhu" -> new EmojiMessage(from, EmojiMessage.Emoji.CTHULHU);
                case ":cat" -> new EmojiMessage(from, EmojiMessage.Emoji.CAT);
                case ":fish" -> new EmojiMessage(from, EmojiMessage.Emoji.FISH);
                case ":laugh" -> new EmojiMessage(from, EmojiMessage.Emoji.LAUGH);
                default -> new TextMessage(from, userInput);
            };

            server.sendMessage(message);
        }
    }
}
