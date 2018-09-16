
public class SocioAtleta extends Socio{
    private double altura;
    private String categoria;

    public SocioAtleta(String nome, int idade, double altura){
        super(nome, idade);
        this.altura = altura;
        calculoCategoria();
    }

    public void calculoCategoria(){

        if (super.getIdade() <= 12){
            if (this.altura <= 1.55){
                this.categoria =  "Infantil";
            } else {
                this.categoria = "Infanto Juvenil";   
            }
        }else {
            if (this.altura <= 1.68){
                this.categoria = "Juvenil";
            }else {
                this.categoria = "Adulto";
            }
        }

    }
    @Override
    public void aniversario(){
        aniversario();
        calculoCategoria();

    }

    @Override
    public String toString(){
        super.toString();
        return "Altura:" + this.altura + "Categoria: " + this.categoria;
    }

    public void exameSaude(double altura){
        this.altura = altura;
        calculoCategoria();

    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public double getAltura(){
        return this.altura;
    }

   
    public String getCategoria(){
        return this.categoria;
    }

}
