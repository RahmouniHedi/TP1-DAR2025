package clientPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
            os.write(nbr);
            InputStream is = clientSocket.getInputStream();
            int result = is.read();
            System.out.println("Le multiple de " + nbr + " est = " + result);
            // La dernière étape : Fermer socket
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } }

