package com.epam.training.tictactoe;

import org.json.JSONObject;

public class JsonParserResponse {
    
    private String uuid;
    private String type;
    private Strategy strategy = new Strategy();
    
    public void registration(StringBuffer response) {
        JSONObject obj = new JSONObject(response.toString());
        uuid = obj.getString("uuid");
        type = obj.getString("type"); 
        System.out.println("UUID: "+ uuid + "Type: "+type);
    }

    public void isMyTurnResponse(StringBuffer response) {      
        JSONObject obj = new JSONObject(response.toString());
        String isMyTurn = obj.getString("ismyturn");

        JSONObject obj2 = obj.getJSONObject("lastmove");
        int x = obj2.getInt("x");
        int y = obj2.getInt("y");
        String type = obj2.getString("t");
        strategy.setEnemyLastMove(new Coordinate(x, y, type));
    }

    public void putResponse(StringBuffer response) {
        JSONObject obj = new JSONObject(response.toString());
        int statusCode = obj.getInt("statuscode");
        String message = obj.getString("message");
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public String getType() {
        return type;
    }
}
