import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {


        ServerSocket server = new ServerSocket(8000);

        System.out.println("Server started");
    }
    }
