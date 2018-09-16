public class ElementoQuimico  {

    private String simboloElemento;
    private String nomeElemento;
    private int numeroAtomico;
    private double pesoAtomico;

    public ElementoQuimico(String simboloElemento, String nomeElemento, int numeroAtomico, double pesoAtomico) {
        this.simboloElemento = simboloElemento;
        this.nomeElemento = nomeElemento;
        this.numeroAtomico = numeroAtomico;
        this.pesoAtomico = pesoAtomico;
    }

    public String getSimboloElemento() {
        return simboloElemento;
    }

    public void setSimboloElemento(String simboloElemento) {
        this.simboloElemento = simboloElemento;
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }

    public int getNumeroAtomico() {
        return numeroAtomico;
    }

    public void setNumeroAtomico(int numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }

    public double getPesoAtomico() {
        return pesoAtomico;
    }

    public void setPesoAtomico(double pesoAtomico) {
        this.pesoAtomico = pesoAtomico;
    }
}
