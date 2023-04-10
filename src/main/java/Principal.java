
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String args[]) {
        try {
            Socket servidor = new Socket("localhost", 4444);//endereco e porta			
            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);// cria o objeto de saida para o fluxo						
            //Executa uma Thread para receber as mensagens de retorno
            Cliente in = new Cliente(servidor);
            in.start();

            String mensagem = "";
            while (!mensagem.equals("fim")) {
                mensagem = JOptionPane.showInputDialog("Digite a Mensagem ou fim para sair");
                out.println(mensagem); //escreve a mensagem
            }
        } catch (IOException io) {
            System.err.println("Problemas de IO");
        }
    }
}
