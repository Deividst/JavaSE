
public class TestaBiblioteca{
    public static void main (String [] args){

        Pessoa a,p,f,t;

        a = new Pessoa(101, 'A', "Deivid");
        p = new Pessoa(102, 'P', "João");
        f = new Pessoa(103, 'F', "Maria");
        t = new Pessoa(104, 'T', "Junior");

        a.exibirDados();
        p.exibirDados();
        f.exibirDados();
        t.exibirDados();

        Teclado tec = new Teclado();
        Data compra1;
        Livro l1 = new Livro(tec.leInt("Informe o codigo:"),
                tec.leString("Informe o titulo do livro:"),
                compra1 = new Data(tec.leInt("Dia da compra:"),
                    tec.leInt("Mes da compra:"),
                    tec.leInt("Ano da compra:")),
                tec.leInt("Informe a Quantidade em estoque:"), t );

        l1.exibirDados();
        Data locacao1;
        Locacao loc = new Locacao((int)Math.random() * 1+ 100, l1, a, f, locacao1 = new Data(tec.leInt("Dia da locação:"),
                                                                                            tec.leInt("Mes da locação:"),
                                                                                            tec.leInt("Ano da locação:")));
                    
        loc.exibirDados();
        loc.setUsuario(p);
        loc.exibirDados();
                    
                    

    }
}