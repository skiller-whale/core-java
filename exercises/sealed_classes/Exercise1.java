import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
SEALED CLASSES: Exercise 1
-------------

This code implements a simple 'ChatServer' that just echos messages to the standard output.
It has one method called `sendMessage` that records the message and then prints it.

1) Read briefly through the code, run this file and type a few messages
    to familiarize yourself with how it works.

2) Make the following changes to the classes:
    * Add two classes - `EmojiMessage` and `TextMessage` - that both inherit from `Message`.
    * `EmojiMessage` should only contain emojis and `TextMessage` - only text.
    * Make `Message` a sealed class that is only extended by `EmojiMessage` and `TextMessage`.

3) Run this script, and ensure that the chat still works as before.

[Optional]
4) Think about the printing of messages.
    * Would you leave this functionality in `ChatServer` or move it somewhere else?
    * Why or why not? Discuss with your coach.
*/

class Message {
    public static enum MessageType {
        TEXT,
        EMOJI
    }

    public static enum Emoji {
        CTHULHU,
        CAT,
        FISH,
        LAUGH
    }

    public final Message.MessageType messageType;
    public final String from;
    public final String textContent;
    public final Message.Emoji emoji;

    public Message(Message.MessageType messageType, String from, String textContent, Message.Emoji emoji) {
        this.messageType = messageType;
        this.from = from;
        this.textContent = textContent;
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

        String output = switch(message.messageType) {
            case Message.MessageType.TEXT ->
                "[%s] %s".formatted(message.from, message.textContent);
            case Message.MessageType.EMOJI ->
                "[%s] %s".formatted(message.from, ChatServer.renderEmoji(message.emoji));
        };
        
        System.out.println(output);
    }

    public static String renderEmoji(Message.Emoji type) {
        return switch(type) {
            case Message.Emoji.CTHULHU -> "^(;,;)^";
            case Message.Emoji.CAT -> "=^..^=";
            case Message.Emoji.FISH -> "><((((`>";
            case Message.Emoji.LAUGH -> "(^^)";
        };
    }
}


public class Exercise1 {
    public static void main(String[] args) {
        var server = new ChatServer();
        // Placeholder for username
        String from = "user";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Type something: >>> ");
            String userInput = scanner.nextLine();

            Message message = switch(userInput) {
                case ":cthulhu" -> new Message(Message.MessageType.EMOJI, from, "", Message.Emoji.CTHULHU);
                case ":cat" -> new Message(Message.MessageType.EMOJI, from, "", Message.Emoji.CAT);
                case ":fish" -> new Message(Message.MessageType.EMOJI, from, "", Message.Emoji.FISH);
                case ":laugh" -> new Message(Message.MessageType.EMOJI, from, "", Message.Emoji.LAUGH);
                default -> new Message(Message.MessageType.TEXT, from, userInput, null);
            };

            server.sendMessage(message);
        }
    }
}
