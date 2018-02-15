
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.in;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author root
 */
public class connessioneClient {

    Socket connection;
    //nome o IP del server
    String serverAddress;
    //porta del server in ascolto
    int port;

    void connessioneClient() {
        connection = null;
        //nome o IP del server
    }

    void avvioClient(String serverAddress,int port) {
        //apertura della connessione al server sulla porta specificata
        this.serverAddress=serverAddress;
        this.port=port;
        System.out.println("tentativo connessione");
        try {
            InetAddress address = InetAddress.getByName(serverAddress); //traduzione in formato indirizzo per il socket
            connection = new Socket(address, port);
            System.out.println("Connessione aperta");
        } catch (ConnectException e) {
            System.err.println("Server non disponibile!");
        } catch (UnknownHostException e1) {
            System.err.println("Errore DNS!");
        } catch (IOException e2) {//
            System.err.println(e2);
            e2.printStackTrace();
        }
    }

    void invioClient() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            String b = "5" + "\n";
            bw.write(b);
            bw.flush();

        } catch (IOException a) {
        } //chiusura della connnessione
        finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connessione chiusa!");
                }
            } catch (IOException e) {
                System.err.println("Errore nella chiusura della connessione!");
            }
        }
    }
}
