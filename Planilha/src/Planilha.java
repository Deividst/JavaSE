import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;

public class Planilha implements Serializable{
	
	private Celula[][] planilha;
	
	
	public Planilha(int linha, int coluna) {
		this.planilha = new Celula[linha][coluna];
	}
	
	public void setCel(Object valor, int linha, int coluna) {
		this.planilha[linha][coluna] = new Celula(valor);
	}

	public Celula[][] getPlanilha() {
		return planilha;
	}

	public void setPlanilha(Celula[][] planilha) {
		this.planilha = planilha;
	}
	
	public void mostraPlan(int linhaI, int colunaI, int linhaF, int colunaF) {
		for(int i = linhaI;i <= linhaF; i++ ) {
			for(int j = colunaI ; j < colunaF; j++) {
				if(planilha[i][j] == null) {
					System.out.print("[ " + "]");
				}else {
				System.out.print("[" + planilha[i][j].getValor() + "]");
				}
			}
			System.out.println();
		}
				
	}
	
	public void salvaPlan(Planilha plan){
		try {
			//cria uma planilha
			HSSFWorkbook workbook = new HSSFWorkbook();
			//cria uma aba na planilha
			HSSFSheet sheetTeste = workbook.createSheet("teste");
			
			int rownum = 0;
			for (int i = 0; i < plan.getPlanilha().length; i++) {
				//cria uma linha na planilha
				Row row = sheetTeste.createRow(rownum++);
				int cellnum = 0;
				for (int j = 0; j < plan.getPlanilha()[i].length; j++) {
					//cria uma celula na planilha
					Cell cell = row.createCell(cellnum++);
					if(plan.getPlanilha()[i][j] != null) {
						if(plan.getPlanilha()[i][j].getValor() instanceof Double) {
							cell.setCellValue((double) plan.getPlanilha()[i][j].getValor());
						}else if(plan.getPlanilha()[i][j].getValor() instanceof String) {
							cell.setCellValue((String)plan.getPlanilha()[i][j].getValor());
						}
					}
				}
			}
			
			//cria o arquivo
			FileOutputStream arquivo = new FileOutputStream(new File("planteste.xls"));
			
			workbook.write(arquivo);
            arquivo.close();
            System.out.println("Arquivo Excel criado com sucesso!");
			
		} catch (FileNotFoundException e) {
           e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
         e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
     }
		
		
	}
	
	public void carregaPlan(Planilha plan){
		
		File f = new File("planteste.xls");
		

		try {
			//pega o arquivo da planilha
			FileInputStream fis = new FileInputStream(f);
			//Cria planilha com todas as abas
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			//recupera a primeira aba da planilha
			HSSFSheet planilha = workbook.getSheetAt(0);
			
			//Iteretor retorna todas as linhas da planilha
			Iterator<Row> rowIterator = planilha.iterator();
			int i = 0;
			//Varre todas as linhas
			while(rowIterator.hasNext()) {
				int j = 0;
				//objeto row recebe cada linha da planilha
				Row row = rowIterator.next();
				
				//retorna todas as celulas da linha
				Iterator<Cell> celIterator = row.iterator();
					//varre todas as celulas da linha
					while(celIterator.hasNext()) {
		
						//cria uma celula
						Cell cell = celIterator.next();
						
						if(plan.getPlanilha()[i][j] != null) {
							
							//verifica qual tipo da celula
							switch (cell.getCellType()) {
							
							//coloca o conteudo da celula no objeto planilha
							case Cell.CELL_TYPE_NUMERIC:
								plan.getPlanilha()[i][j].setValor(cell.getNumericCellValue());
								break;
								
							case Cell.CELL_TYPE_STRING:
								plan.getPlanilha()[i][j].setValor(cell.getStringCellValue());
								break;
							}
						}
						j++;
						
					}
					i++;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	  }	
	
	private void limpaCels(int linhaI, int colunaI,int linhaF,int colunaF,int i, int j) {
		
		if(i < linhaF) {
			if(j > colunaF) {
				limpaCels(linhaI,colunaI,linhaF,colunaF,i+1,colunaI);
			}else {
			if(planilha[i][j] != null) {
			this.planilha[i][j].setValor("");
			}
			limpaCels(linhaI, colunaI, linhaF, colunaF, i, j+1);
			}
			
		}
		
	}
	
	public void limpaCels(int linhaI,int colunaI,int linhaF,int colunaF) {
		limpaCels(linhaI, colunaI, linhaF, colunaF, linhaI, colunaI);
		
	}
	
	

}
