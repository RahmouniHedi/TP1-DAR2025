package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté...");
            Socket clientSocket = new Socket("127.0.0.1", 1234);
            System.out.println("Je suis un client connecté.");

            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            while (true) {
                System.out.println("\n=== Menu de calcul ===");
                System.out.println("1. Addition (+)");
                System.out.println("2. Soustraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("0. Quitter");
                System.out.print("Choix : ");
                int choix = sc.nextInt();

                if (choix == 0) {
                    dos.writeUTF("exit");
                    dos.flush();
                    break;
                }

                String operation = switch (choix) {
                    case 1 -> "+";
                    case 2 -> "-";
                    case 3 -> "*";
                    case 4 -> "/";
                    default -> "?";
                };

                System.out.print("Entrez une valeur x : ");
                int x = sc.nextInt();

                // Envoi au serveur
                dos.writeUTF(operation);
                dos.writeInt(x);
                dos.flush();

                // Réception du résultat
                String result = dis.readUTF();
                System.out.println(result);
            }

            dos.close();
            dis.close();
            sc.close();
            clientSocket.close();
            System.out.println("Client déconnecté.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
