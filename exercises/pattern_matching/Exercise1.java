
/*
PATTERN MATCHING: Exercise 1
-------------

This code mocks an API Response similar to HTTP.
The Response contains a String `content` and an int `code`. 

`ResponseUtils.processResponse` converts a `Response` object
    to a user-friendly String message:

1) Implement `ResponseUtils.processResponse`. The `assert` statements
    in `main` have the expected return values.
    * For any other `content` or `code` values it should return
        "Can not process response".

2) Run this file and make sure you don't see any assertion errors.

*/

record Response(int code, String content) { }

class ResponseUtils {
    public static String processResponse(Response response) {
        // TODO: Your code goes here
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Response[] responses = {
            new Response(200, "login successful"),
            new Response(401, "bad username"),
            new Response(504, "gateway timeout"),
            new Response(301, "moved permanently")
        };

        for (var response: responses) {
            System.out.println(ResponseUtils.processResponse(response));
        }

        assert ResponseUtils.processResponse(responses[0]) == "OK, login successful";
        assert ResponseUtils.processResponse(responses[1]) == "Error, bad username";
        assert ResponseUtils.processResponse(responses[2]) == "Error, gateway timeout";
        assert ResponseUtils.processResponse(responses[3]) == "Can not process response";
    }
}
