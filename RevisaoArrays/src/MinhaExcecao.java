
public class MinhaExcecao extends Exception {

	private String mensagem;
	
    public MinhaExcecao(String mensagem){
        this.mensagem = mensagem;
    }
    public String toString() {
        return "MinhaExcecao [" + mensagem + "]";
    }
}
	

