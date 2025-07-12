package domain;

import exceptions.SaldoException;

public abstract class Conta implements IConta{
    private static final Integer AGENCIA_PADRAO_CODE = 1;
    private static Integer SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO_CODE;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(Double valor) throws SaldoException {
        if(valor > saldo){
            throw new SaldoException();
        }
        saldo -= valor;
    }

    @Override
    public void transferir(Double valor, IConta contaDestino) throws SaldoException {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void imprimirInfosComuns() {
        System.out.printf("Titular: %s\n", this.cliente.getNome());
        System.out.printf("Agência: %s\n", getAgencia());
        System.out.printf("Número: %s\n", getNumero());
        System.out.printf("Saldo: %s\n", getSaldo());
    }

    public Integer getAgencia(){
        return agencia;
    }

    public Integer getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }
}
