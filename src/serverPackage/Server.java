package serverPackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
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
            InputStream in = clientsocket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            int nbr = dis.readInt();
            int resp = nbr*5;
            OutputStream os = clientsocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(resp);
// La dernière étape : Fermer socket
        clientsocket.close();
        serverSocket.close();
        dis.close();
        dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }}