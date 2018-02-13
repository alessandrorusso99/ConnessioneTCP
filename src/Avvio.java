/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.in;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.net.InetAddress;

/**
 *
 * @author Monica Ciuchetti
 */
public class Avvio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connessioneServer s=new connessioneServer();
        connessioneClient c=new connessioneClient();
        s.connetti();
        c.napoli();
        
       
        
        
        
        
    }
}
    /*
        //oggetto da usare per realizzare la connessione TCP
        Socket connection = null;
        //nome o IP del server
        String serverAddress = "localhost";
        //porta del server in ascolto
        int port = 2000;

        //apertura della connessione al server sulla porta specificata
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
*/