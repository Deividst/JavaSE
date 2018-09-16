
public class Teste {

	public static void main(String[] args) {
		
		Planilha p = new Planilha(10, 10);
		Formula f = new Formula(p.getPlanilha());
		p.setCel(10.0, 0, 0);
		p.setCel(5.0, 2, 1);
		p.setCel(1.0, 3, 2);
		p.setCel(3.0, 4, 3);
		p.setCel(4.0, 5, 4);
		p.setCel(2.0, 6, 5);
		p.setCel("uma String", 3, 1);
		
		p.setCel(f.operacao('*', 0, 0, 2, 1), 0, 1);
		p.setCel(f.operacao('-', 0, 0, 2, 1), 0, 2);
		p.setCel(f.operacao('+', 0, 0, 2, 1), 0, 3);
		p.setCel(f.operacao('/', 0, 0, 2, 1), 0, 4);
		
		//System.out.println(p.getPlanilha()[9][9].getValor());
		
		p.mostraPlan(0, 0, 6, 5);
		
		p.salvaPlan(p);
		
		p.limpaCels(0, 0, 6, 5);
		p.mostraPlan(0, 0, 6, 5);
		
		p.carregaPlan(p);
		
		p.mostraPlan(0, 0, 6, 5);
		
	}

}
