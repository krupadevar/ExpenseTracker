import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class SimpleServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Serve static files from webapp directory
        server.createContext("/", new StaticFileHandler());
        
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
        
        System.out.println("Server started at: http://localhost:8080");
        System.out.println("Open your browser and go to: http://localhost:8080/index.jsp");
        System.out.println("Press Ctrl+C to stop the server");
    }
    
    static class StaticFileHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) path = "/index.jsp";
            
            File file = new File("webapp" + path);
            if (file.exists()) {
                byte[] response = Files.readAllBytes(file.toPath());
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            } else {
                String notFound = "404 - File not found";
                exchange.sendResponseHeaders(404, notFound.length());
                OutputStream os = exchange.getResponseBody();
                os.write(notFound.getBytes());
                os.close();
            }
        }
    }
}