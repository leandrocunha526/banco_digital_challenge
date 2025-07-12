import domain.Cliente;
import domain.Conta;
import domain.ContaCorrente;
import domain.ContaPoupanca;
import exceptions.SaldoException;

public class Main {
    public static void main(String[] args) throws SaldoException {
        Cliente cliente = new Cliente();
        cliente.setNome("Leandro");

        Conta conta_corrente = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        //System.out.printf("Exibindo dados para o cliente %s \n", cliente.getNome());
        conta_corrente.depositar(250.10);
        conta_corrente.transferir(250.10, poupanca);

        conta_corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
