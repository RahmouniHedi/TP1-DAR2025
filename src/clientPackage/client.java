package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté...");
            Socket clientSocket = new Socket("127.0.0.1", 1234);
            System.out.println("Je suis un client connecté");

            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            int nbr;

            do {
                System.out.print("Entrez un nombre (0 pour quitter) : ");
                nbr = sc.nextInt();

                dos.writeInt(nbr);
                dos.flush();

                if (nbr != 0) {
                    int result = dis.readInt();
                    System.out.println("Le multiple de " + nbr + " est = " + result);
                }

            } while (nbr != 0);

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
