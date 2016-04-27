package com.epam.training.tictactoe;

import org.json.JSONObject;

public class JsonParserResponse {
    
    private String uuid;
    private String type;
    private int status;
    
    public void registration(StringBuffer response) {
        JSONObject obj = new JSONObject(response.toString());
        uuid = obj.getString("uuid");
        type = obj.getString("type"); 
    }

    public boolean isMyTurnResponse(StringBuffer response, Strategy strategy) {      
        JSONObject obj = new JSONObject(response.toString());
        boolean isMyTurn = obj.getBoolean("isMyTurn");
        status = obj.getInt("statusCode");
        
        JSONObject obj2 = obj.getJSONObject("lastMove");
        int x = obj2.getInt("x");
        int y = obj2.getInt("y");
        String type = obj2.getString("t");
        strategy.setEnemyLastMove(new Coordinate(x, y, type));
        return isMyTurn;
    }

    public void putResponse(StringBuffer response) {
        JSONObject obj = new JSONObject(response.toString());
        int statusCode = obj.getInt("statusCode");
        String message = obj.getString("message");
        
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public String getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }
    
    
}
