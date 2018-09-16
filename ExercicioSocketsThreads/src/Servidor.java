import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		//Abre a porta do servidor
		ServerSocket serverSocket = new ServerSocket(5000);
		System.out.println("Porta aberta!");
		
		//aceita a conexão com cliente
		Socket cliente = serverSocket.accept();
		
		System.out.println("Nova conexão com o cliente: " + cliente.getInetAddress().getHostAddress());
		ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
		
		FileOutputStream arquivo = new FileOutputStream("ArquivoRecebido.txt");
		
		byte[] buff = new byte[500];
		
		while(true) {
			int len = ois.read(buff);
			if(len == -1) break;
			
			arquivo.write(buff,0,len);
		}
		
		
		Scanner entrada = new Scanner(cliente.getInputStream());
		
		while(entrada.hasNextLine()) {
			System.out.println(entrada.nextLine());
		}
		
		entrada.close();
		serverSocket.close();
	}

}
