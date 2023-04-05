package com.laioffer.jupiter;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "helloServlet", value = "/game")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        JSONObject game = new JSONObject();
        game.put ("name ", "World of Warcraft");
        game.put ("deve loper", "Blizzard Entertainment");
        game.put ("release_time", "Feb 11， 2005");
        game.put("website", "https://www.wor1dofwarcraft.com");
        game.put("price" , 49.99);

        // Write game information to Response Body
        response.getWriter().print(game);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read game information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String name = jsonRequest.getString("name");
        String developer = jsonRequest.getString("developer");
        String releaseTime = jsonRequest.getString("release_time");
        String website = jsonRequest .getString("website");
        float price = jsonRequest.getFloat("price");

        // Print game information to IDE console System.out .println( "Name is: + name)；
        System.out.println("Developer is: " + developer);
        System.out.println("Release time is: " + releaseTime);
        System.out.println("Website is: " + website);
        System.out.println("price is: " + price);

        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);

    }

    public void destroy() {
    }
}