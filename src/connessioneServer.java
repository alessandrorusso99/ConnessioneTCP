
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author root
 */
public class connessioneServer {

    int port;
    Socket connection;
    ServerSocket sSocket;

    void connessioneServer() {
        port = 2000;
        connection = null;
        sSocket = null;

    }

    //oggetto ServerSocket necessario per accettare richieste dal client
    //oggetto da usare per realizzare la connessione TCP
    public void connetti() {
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
            }// 
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
