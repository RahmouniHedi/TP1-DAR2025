package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main() throws IOException {
        // La première étape :
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client ");

            Socket clientsocket = serverSocket.accept();
            // La deuxième étape :


            System.out.println("un client est connecté");
// La dernière étape : Fermer socket
        clientsocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }}