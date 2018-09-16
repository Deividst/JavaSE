

public class Servidor {
	private CaixaPostal[] caixaPostal = new CaixaPostal[5];
	
	
	public void add(CaixaPostal cp) {
		try {
			for (int i = 0; i < caixaPostal.length; i++) {
				if(caixaPostal[i] == null) {
					caixaPostal[i] = cp;
					break;
				}
			}
			
	
		} catch (IllegalArgumentException e) {
			System.out.println("Valor informado é invalido");
		}
	}
	
	public CaixaPostal procuraDestinatario(Email em) {
		
		CaixaPostal cp;
		for (int i = 0; i < caixaPostal.length; i++) {
			
			try {
				if(em.getDestinatario().equalsIgnoreCase(caixaPostal[i].getRemetente())) {
					cp = caixaPostal[i];
					return cp;
				}
				
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
		}
		
		return null;
		
	}

	public void sendReceive() {
		for (int i = 0; i < caixaPostal.length; i++) {
			if(caixaPostal[i] != null) {
				for (int j = 0; j < caixaPostal[i].getCaixaSaida().length; j++) {
					if(caixaPostal[i].getCaixaSaida()[j] != null) {
						Email em = caixaPostal[i].getCaixaSaida()[j];
						caixaPostal[i].getCaixaSaida()[j] = null;
						CaixaPostal cp = procuraDestinatario(em);
							if(cp != null) {
								for (int k = 0; k < caixaPostal[i].getCaixaEntrada().length; k++) {
									if(caixaPostal[i].getCaixaEntrada()[k] == null ) {
									cp.getCaixaEntrada()[k] = em;
									break;
									}
								}
							} else {
								System.out.println("Destinatário não encontrado \n");
							}
				}
			}
			
		}
	}
	
	}
}



