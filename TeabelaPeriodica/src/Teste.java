

public class Teste {

    public static void main(String[] args) {
        TabelaQuimica tb = new TabelaQuimica(7,18);

        tb.setElemento("Be","Berilio",4,9.012182,0,0);

        System.out.println(tb.getTabela());


    }
}
