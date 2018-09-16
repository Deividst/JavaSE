
public class ContaCorrente{
    private int numero;
    private Cliente cliente;
    private double saldo;

    public int getNumero(){
        return this.numero;   
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public ContaCorrente(int numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
    }

    public void deposita(double deposito){
        this.saldo += deposito;
        cliente.deposita(deposito);
    }

    public boolean retira(double valor){
        if (valor < this.saldo){
            this.saldo -= valor;
            cliente.retira(valor);
            return true;

        }else {
            return false;
        }
    }

}
