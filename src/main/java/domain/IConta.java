package domain;

import exceptions.SaldoException;

public interface IConta {
    void depositar(Double valor);
    void transferir(Double valor, IConta contaDestino) throws SaldoException;
    void imprimirExtrato();
    void sacar(Double valor) throws SaldoException;
}
