package Banco;

public class Clinte {
    private String nome;
    private String senha;
    private Banco conta;

    public Clinte(String nome, String senha, Banco conta) {
        this.nome = nome;
        this.senha = senha;
        this.conta = conta;
    }

    public boolean autenticar(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }

    public Banco getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + "\n" + conta.toString();
    }
}
