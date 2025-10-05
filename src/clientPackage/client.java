package clientPackage;
import java.io.IOException;
import java.net.Socket;
public class client {
    public static void main(String[] args) throws IOException {
        // La première étape :

        System.out.println("Je suis un client pas encore connecté...");
        Socket clientSocket = new Socket("127.0.0.1", 1234);
        System.out.println("je suis un client connecté");
        // La dernière étape : Fermer socket
        clientSocket.close();
    }
    }

