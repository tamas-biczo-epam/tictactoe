package com.epam.training.tictactoe;

import java.io.StringWriter;

import org.json.JSONObject;

public class JsonParserRequest {
    
    
    public String isMyTurn(String uuid){
        JSONObject obj = new JSONObject();
        obj.put("uuid",uuid);     
        StringWriter out = new StringWriter();
        obj.write(out);
        String jsonText = out.toString();
        return jsonText;
    }

    public String put(String uuid, Strategy strategy) {
        JSONObject obj = new JSONObject();
        Coordinate nextMove = strategy.nextMove();
        obj.put("uuid",uuid);
        obj.put("x", nextMove.getX());
        obj.put("y", nextMove.getY());   
        StringWriter out = new StringWriter();
        obj.write(out);
        String jsonText = out.toString();
        System.out.println(jsonText);
        return jsonText;
    }
    
    public String registration(){
        JSONObject obj = new JSONObject();
        obj.put("name","Tomi");     
        StringWriter out = new StringWriter();
        obj.write(out);
        String jsonText = out.toString();
        return jsonText;
        
    }
    
}
