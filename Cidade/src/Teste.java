


public class Teste {

	public static void main(String[] args) {
		
		Cidade cd = new Cidade(5, 5, "SaoLeo");
			
		
		Edificacao c = new Casa(1, "alvenaria", 82.4, true, true);  
		Edificacao e = new Edificio(10, "alvenaria", 1000.4, 2, 20, 5);
		
		cd.associa(1, 2, c);
	    cd.associa(2, 2, e);
		cd.associa(3, 3, e);
		
		cd.visualizarMapa();
		
		System.out.println("Numero Casas: " + cd.qtdCasas());
		
		
		cd.calculaIPTU(0, 0, 3, 3);
		
		cd.removerEdificacao(1, 2);
		cd.visualizarMapa();
		cd.pesquisarTerreno();
		
		
		Cidade vi = new Cidade(10,80,"Viamao");
		 Cidade poa = new Cidade(10,80,"Poa");
		 Municipio mu = new Municipio(5); //terá 5 cidades

		 mu.insereCid(cd);
		 mu.insereCid(poa);
		 mu.insereCid(new Cidade(10,80,"Alvorada"));
		 mu.insereCid(vi);
		 mu.insereCid(new Cidade(10,80,"Gravatai"));

		 mu.mostraMunicipio(); //mostra todas cidades

		 mu.removeCid("Alvorada");

		 System.out.println("Alvorada removida:\n\n");
		 mu.mostraMunicipio();
		 System.out.println("Num. medio de casas: "+mu.numMedioCasas());
		 
		 Sala s1 = new ApResidencial("Deivid", 30);
		 Sala s2 = new SalaComercial("Academia", 50);
		 
		 mu.ocupaSala(s2);
		 mu.ocupaSala(s1);
		 
		 mu.mostrarSalas();


	}

}

