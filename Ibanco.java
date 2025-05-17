package Banco;

public interface Ibanco {
	void sacar(double valor);  
	void depositar(double valor);
	void transferir(double valor,Banco contaDestino);
}
