package programmersbackendapi.project.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import programmersbackendapi.project.domain.User;
import programmersbackendapi.project.dto.CheckResponse;
import programmersbackendapi.project.dto.SumResponse;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class SumHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String filePath = "C:\\Users\\user\\OneDrive\\바탕 화면\\jpa_study\\project\\src\\main\\java\\programmersbackendapi\\project\\data\\input\\user.json";
        ObjectMapper objectMapper = new ObjectMapper();
        int sum = 0;

        //Json 파일 읽기
        User[] users = objectMapper.readValue(new File(filePath), User[].class);
        for (User user : users) {
            System.out.println(user.getPost_count());
            sum += user.getPost_count();
        }

        SumResponse sumResponse = new SumResponse();
        sumResponse.setSum(sum);

        ObjectMapper objectMapper1 = new ObjectMapper();
        String response = objectMapper1.writeValueAsString(sumResponse);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}
