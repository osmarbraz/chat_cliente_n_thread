
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente extends Thread {

    private Socket con;
    private BufferedReader in;

    public Cliente(Socket socket) {
        try {
            con = socket;
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } catch (IOException ioe) {
            System.out.println("Excecao: " + ioe.getMessage());
        }
    }

    public void run() {
        try {
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem); //Escreve mensagens do servidor
            }
        } catch (IOException ioe) {
            System.out.println("Excecao: " + ioe.getMessage());
        }
    }
}
