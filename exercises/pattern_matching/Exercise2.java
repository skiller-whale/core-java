/*
PATTERN MATCHING: Exercise 2
-------------

This code mocks an API Response similar to HTTP.
`ResponseUtils.processResponse` converts a `Response` object
    to a user-friendly String message:

Now there are two types of `Response` content:
    - `StringResponse`, which contains a `String` (as in Exercise1)
    - `KVResponse`, which contains a key-value pair (`KVPair`) for content.

1) Implement `ResponseUtils.processResponse` so it processes
    `StringResponse` objects.

    * Run this file and make sure there are no assertion errors.

2) Uncomment the Part 2 section in `main` and implement
    `ResponseUtils.processResponse` so it processes `KVResponse` objects.

    * Run this file and make sure there are no assertion errors.

HINT 1: You may need to write a nested switch statement:
    - outer level on the `response` object
    - inner level on the response `code`
HINT 2: You can use the code you wrote for Exercise 1 for the inner `switch`.
*/

record KVPair(String key, String value) { }

interface IResponse { }

// `message` is just a String message
record StringResponse(int code, String content) implements IResponse { }
record KVResponse(int code, KVPair content) implements IResponse { }

class ResponseUtils {
    public static String processResponse(IResponse response) {
        return switch(response) {
            // TODO: Your code goes here
        };
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        IResponse[] stringResponses = {
            new StringResponse(200, "login successful"),
            new StringResponse(504, "gateway timeout"),
            new StringResponse(301, "moved permanently")
        };

        System.out.println("String responses:");
        for (var response: stringResponses) {
            System.out.println(ResponseUtils.processResponse(response));
        }

        assert ResponseUtils.processResponse(stringResponses[0]) == "OK, login successful";
        assert ResponseUtils.processResponse(stringResponses[1]) == "Error, gateway timeout";
        assert ResponseUtils.processResponse(stringResponses[2]) == "Can not process response";

        // Part 2: Uncomment this to test handling of `KVResponse`
        // 
        // IResponse[] kvResponses = {
        //     new KVResponse(401, new KVPair("auth", "bad_username")),
        //     new KVResponse(403, new KVPair("auth", "bad_password"))
        // };

        // System.out.println("\nKV responses:");
        // for (var response: kvResponses) {
        //     System.out.println(ResponseUtils.processResponse(response));
        // }

        // assert ResponseUtils.processResponse(kvResponses[0]) == "Error, auth: bad_username";
        // assert ResponseUtils.processResponse(kvResponses[1]) == "Error, auth: bad_password";
    }
}
