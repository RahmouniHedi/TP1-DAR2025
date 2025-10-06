package clientPackage;
import java.io.*;
import java.net.Socket;

import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        // La première étape :
        try {
            System.out.println("Je suis un client pas encore connecté...");
            Socket clientSocket = new Socket("127.0.0.1", 1234);
            System.out.println("je suis un client connecté");
            Scanner sc = new Scanner(System.in);
            System.out.println("Entre un nombre :");

            int nbr = sc.nextInt();
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(nbr);
            InputStream is = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            int result = dis.readInt();
            System.out.println("Le multiple de " + nbr + " est = " + result);
            // La dernière étape : Fermer socket
            clientSocket.close();
            sc.close();
            dos.close();
            dis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } }

