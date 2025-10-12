package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Serveur en attente de connexion...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté.");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            int nbr;

            while (true) {
                nbr = dis.readInt();
                if (nbr == 0) {
                    System.out.println("Le client a envoyé 0. Fermeture de la connexion.");
                    break;
                }

                int resp = nbr * 5;
                dos.writeInt(resp);
                dos.flush();
            }

            dis.close();
            dos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Serveur arrêté.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
