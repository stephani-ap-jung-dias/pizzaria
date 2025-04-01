public class Pizza {
    private String nome;
    private double valor;
    private String ingre;
    private InputHelp inputHelp = new InputHelp();

    public Pizza(String nome, double valor, String ingre) {
        this.nome = nome;
        this.valor = valor;
        this.ingre = ingre;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getIngre() {
        return ingre;
    }

    public void exibirInfo() {
        inputHelp.InputText("Nome: " + nome);
        inputHelp.InputText("Valor: R$" + valor);
        inputHelp.InputText("Ingredientes: " + ingre);
    }
}