package programmersbackendapi.project;

import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import programmersbackendapi.project.handler.CheckHandler;
import programmersbackendapi.project.handler.SumHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
		int port = 5678;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

		server.createContext("/", new CheckHandler());
		server.createContext("/sum", new SumHandler());
		server.setExecutor(null); //기본 executor 사용
		server.start();
		System.out.println("Server started on port" + port);
	}

}
