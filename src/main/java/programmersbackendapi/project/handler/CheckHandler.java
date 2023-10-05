package programmersbackendapi.project.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import programmersbackendapi.project.dto.CheckResponse;

import java.io.IOException;
import java.io.OutputStream;

public class CheckHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equals("GET")) {
            CheckResponse checkResponse = new CheckResponse("server check");

            ObjectMapper objectMapper = new ObjectMapper();
            String response = objectMapper.writeValueAsString(checkResponse);

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        else {
            exchange.sendResponseHeaders(405, -1);
        }


    }
}
