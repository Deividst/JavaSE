
public class TestaSocio{
    public static void main(String[] args){ 
        Socio s = null;
        Teclado t = new Teclado();
        for (int i = 1; i < 3; i++){ 
            if (i == 1){
                // Instancia um sócio lendo dados do teclado e atribui a s s = new
                s = new Socio(t.leString("Informe o nome:"),
                              t.leInt("Informe a idade"));
            }
            else{
                // Instancia um sócio atleta lendo dados do teclado e atribui a s s = new
                s = new SocioAtleta(t.leString("Informe o nome"),
                                    t.leInt("Informe a idade"),
                                    t.leDouble("Informe a altura"));
            }
            // Exibir dados do objeto instanciado System.out.println(s);
        }
            System.out.println(s);
            // Se for um sócio atleta, comandar o exame medico lendo a altura do
            // teclado, e exibir os dados – usar o instanceof e downcasting
            if (s instanceof SocioAtleta){
            ((SocioAtleta) s).exameSaude(t.leDouble("Informe a nova altura"));
            System.out.println(s.toString());
        }
    
}
}


