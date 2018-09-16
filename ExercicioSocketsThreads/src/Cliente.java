import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	public static void escreveArquivo() {
		File arquivo = new File("arquivo.txt");

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))){
			bw.write("A maria é safada");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static byte[] converteFileToByteArray() throws FileNotFoundException, IOException{
        File f = new File("arquivo.txt");
        FileInputStream fs = new FileInputStream(f);
        byte[] byt = new byte[(int)f.length()];
        for(int i = 0;i < f.length();i++){
            byt[i] = (byte) fs.read();
        }
        return byt;
    }

	public static void lerArquivo() {
		File arquivo = new File("arquivo.txt");
		String texto = null;
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			while(texto != null) {
				System.out.println(texto);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//conecta o cliente com o servidor
		Socket cliente = new Socket("127.0.0.1", 5000);
		System.out.println("O cliente se conectou ao servidor");
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		
		Cliente.escreveArquivo();
		FileInputStream arquivo = new FileInputStream("arquivo.txt");
		ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
		
		byte[] buff = new byte[5000];
		
		while(true) {
			int len = arquivo.read(buff);
			if(len == -1) break;
			
			out.write(buff,0,len);
		}
		
		out.close();
		
		while(teclado.hasNext()) {
			saida.println(teclado.nextLine());
		}
		
		saida.close();
		cliente.close();
	}
	
}
