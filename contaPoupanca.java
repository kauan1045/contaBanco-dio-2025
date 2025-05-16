package Banco;


public class ContaPoupanca extends Banco {
    private double taxaJuros = 0.01; // 1% ao mês

    public ContaPoupanca() {
        super();
    }

    public void aplicarRendimentoMensal() {
        double rendimento = saldo * taxaJuros;
        saldo += rendimento;
        historico.add("Rendimento mensal: +R$ " + rendimento);
    }

    @Override
    public String toString() {
        return "Conta Poupança - Agência: " + getAgencia() + ", Número: " + getNum() + ", Saldo: R$ " + getSaldo();
    }
}
