import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOTeste {

	public static void main(String[] args) {

		Path p1 = Paths.get("arquivo.txt");
		Path caminhoPasta = Paths.get("pasta");
		Path copiaArquivo = Paths.get("pasta", "arquivoCopiado.txt");

		try {

			if (Files.notExists(caminhoPasta)) {
				Files.createDirectory(caminhoPasta);
			}
			if (Files.notExists(p1)) {
				Files.createFile(p1);
			}

			Files.copy(p1, copiaArquivo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
