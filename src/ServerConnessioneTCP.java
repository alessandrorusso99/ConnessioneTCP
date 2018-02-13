/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monica Ciuchetti
 */
/*
public class ServerConnessioneTCP {

    public static void main(String[] args) {
        // porta del server maggiore di 1024 
        int port = 2000;
        //oggetto ServerSocket necessario per accettare richieste dal client
        //oggetto da usare per realizzare la connessione TCP
        Socket connection = null;
        ServerSocket sSocket = null;
        try {
            sSocket = new ServerSocket(port);
            System.out.println("In attesa di connessioni!");
            while (true) {

                // il server si mette in ascolto sulla porta voluta
                //si è stabilita la connessione
                connection = sSocket.accept();
                System.out.println("Connessione stabilita!");
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String a = br.readLine();
                System.out.println("il messaggio inviato dal client è " + a);

                System.out.println("Socket server: " + connection.getLocalSocketAddress());
                System.out.println("Socket client: " + connection.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            System.err.println("Errore di I/O!");
        } finally {
            //chiusura della connessione con il client
            try {
                connection.close();
                sSocket.close();
            } catch (IOException ex) {
                System.err.println("Errore nella chiusura della connessione!");
            }
        }
        System.out.println("Connessione chiusa!");
    }

}
