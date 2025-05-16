;

public class contaCorrente extends Banco {
    public contaCorrente() {
        super();
    }

    @Override
    public String toString() {
        return "Conta Corrente - Agência: " + getAgencia() + ", Número: " + getNum() + ", Saldo: R$ " + getSaldo();
    }
}
