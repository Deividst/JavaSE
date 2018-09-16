
public class TestaAtleta{
 public static void main (String[] args){
     
     Data d = new Data(5, 2, 1992);
     
     Atleta a1 = new Atleta("Neymar", 1.8, d);
     
     Atleta a2 = new Atleta("Messi", 1.6, 24, 6, 1987);
     
     a1.exibiDados();
     a2.exibiDados();
     
     Atleta a3 = new Atleta(a2.getNome(),
       a1.getAltura(),
       a2.getDataNascimento().getDia(),
       a2.getDataNascimento().getMes(),
       a2.getDataNascimento().getAno()+1);
       
       a3.exibiDados();
     
     
     
    }
}