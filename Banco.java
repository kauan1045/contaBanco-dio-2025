package Banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Banco implements Ibanco {
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int num;
    protected double saldo;
    protected List<String> historico;

    public Banco() {
        this.agencia = 1;
        this.num = SEQUENCIAL++;
        this.historico = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            historico.add("Saque: -R$ " + valor);
        } else {
            historico.add("Tentativa de saque falhou (saldo insuficiente): -R$ " + valor);
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historico.add("Depósito: +R$ " + valor);
    }

    @Override
    public void transferir(double valor, Banco contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historico.add("Transferência de R$ " + valor + " para conta " + contaDestino.getNum());
        } else {
            historico.add("Tentativa de transferência falhou: R$ " + valor);
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNum() {
        return num;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getHistorico() {
        return historico;
    }
}
