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

            while (true) {
                String operation = dis.readUTF();
                if (operation.equalsIgnoreCase("exit")) break;

                int x = dis.readInt();

                double result = 0;

                switch (operation) {
                    case "+":
                        result = x + 5;
                        break;
                    case "-":
                        result = x - 5;
                        break;
                    case "*":
                        result = x * 5;
                        break;
                    case "/":
                        if (x == 0) {
                            dos.writeUTF("Erreur : division par zéro !");
                            dos.flush();
                            continue;
                        } else {
                            result = x / 5.0;
                        }
                        break;
                    default:
                        dos.writeUTF("Opération invalide !");
                        dos.flush();
                        continue;
                }

                dos.writeUTF("Résultat : " + result);
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
