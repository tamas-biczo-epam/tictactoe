package com.epam.training.tictactoe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client 
{
    private static final String URL = "http://10.0.8.110:8080/xoxo";
    private final String USER_AGENT = "Mozilla/5.0";
    private JsonParserResponse responseParser = new JsonParserResponse();
    private JsonParserRequest requestParser = new JsonParserRequest();
    private String uuid;
    private String type;
    private Strategy strategy = new Strategy();
    
    public static void main( String[] args ) throws Exception
    {
        Client client = new Client();
        client.registration();
        while(true){
        try {
            if(client.isMyTurn()){
                client.put();
            }
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    private void registration() throws Exception {

        URL obj = new URL(URL+"/reg");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        responseParser.registration(response);
        uuid = responseParser.getUuid();
        type = responseParser.getType();
        strategy.setType(type);
        

    }
    
    private void put() throws Exception {

        URL obj = new URL(URL+"/put");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = requestParser.put(uuid, strategy);
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        System.out.println(response.toString());
        responseParser.putResponse(response);

    }

    private boolean isMyTurn() throws IOException{
        URL obj = new URL(URL+"/ismyturn");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = requestParser.isMyTurn(uuid);
        
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        System.out.println(response.toString());
        in.close();
        
        return responseParser.isMyTurnResponse(response, strategy);
    }
    
}
