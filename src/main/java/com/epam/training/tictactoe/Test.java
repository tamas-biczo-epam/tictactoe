package com.epam.training.tictactoe;

import org.json.JSONObject;

public class Test {
    
    
    public static void main(String[] args) {
        JsonParserResponse responseParser = new JsonParserResponse();
        
        JSONObject obj = new JSONObject("{ \"ismyturn\": \"true\", \"lastmove\": {\"x\": 10, \"y\": 10, \"t\": \"x\"} }");
        StringBuffer buffer = new StringBuffer("{ \"ismyturn\": \"true\", \"lastmove\": {\"x\": 10, \"y\": 10, \"t\": \"x\"} }");
        
        responseParser.isMyTurnResponse(buffer);
    }
}
