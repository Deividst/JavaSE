package Lista05;




public class TestaCompra{
    
    public static void main (String[] args){
        
        Cliente c1 = new Cliente("Deivid");
        
        Compra cmp1 = new Compra(1,((Math.random() * 2000) +10), c1);
        Compra cmp2 = new Compra(2,((Math.random() * 2000) +10),"João");
        
        Data dia1 = new Data(10,5,2017);
        cmp1.calculaDesconto();
        cmp1.emiteNota();
        cmp1.emiteNota(dia1);
        
        Data dia2 = new Data(11,5,2017);
        cmp2.calculaDesconto();
        cmp2.emiteNota();
        cmp2.emiteNota(dia2);
        
        if (cmp1.getValorFinal() > cmp2.getValorFinal()){
            
        System.out.printf("%s%10.2f", "A maior compra é a 1, no valor de ", cmp1.getValorFinal());
    } else {
        System.out.printf("%s%10.2f", "A maior compra é a 2, no valor de ", cmp2.getValorFinal());
        
    }
        
    
    
    }
}