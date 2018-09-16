
public class CarroTeste {

	public static void main(String[] args) {
		
		Teclado t = new Teclado();
		
		Proprietario p = new Proprietario("Deivid");
		Carro car = new CarroLuxo(t.leString("Informe a Placa do veiculo:"),t.leDouble("Informe o consumo médio:"), p);
		
		boolean ok = true;
		int op;
		do {	
			do {
			System.out.println("1 - Abastece\n"
								+"2 - Anda\n"
								+"3 - Liga ar Condicionado\n"
								+"4 - Desliga ar condicionado\n"
								+"5 - Mostra computador de bordo\n"
								+"6 - Fim");
			op = t.leInt("Informe uma opção valida");
			
			if (op < 1 || op > 6) {
				System.out.println("Opção invalida! Redigite!");
			} else {
				ok = false;
			}
			
			}while(ok);
			
			ok = true;
			
			switch (op) {
			case 1:
				boolean aux = car.abastece(t.leInt("Informe a quantidade de litros abastecida"), t.leDouble("Informe o valor por litro de combustivel"));
				if (aux == true) {
					System.out.println("Carro abastecido com sucesso");
				} else {
					System.out.println("Quantidade superior ao limite do tanque");
				}
				
				break;
				
			case 2:
				car.anda(t.leInt("informe a distancia que deseja percorrer"));
				break;
				
			case 3:
				if (car instanceof CarroLuxo) {
					((CarroLuxo) car).ligaAr();
					System.out.println("Ar condicionado ligado");
				}
				break;
				
			case 4:
				if (car instanceof CarroLuxo) {
					((CarroLuxo) car).desligaAr();
					System.out.println("Ar condicionado desligado");
				}
				break;
			case 5:
				if (car instanceof CarroLuxo) {
					((CarroLuxo) car).computadorDeBordo();		
				}
				break;
			case 6:
				ok = false;
				System.exit(0);
			
			}
			
		} while (ok);
		
	}

}
