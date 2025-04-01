public class Pedido {
    private Pizza pizza;
    private String tamanho;
    private String ende;
    private InputHelp inputHelp = new InputHelp();

    public Pedido(Pizza pizza, String tamanho, String ende) {
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.ende = ende;
    }

    public double calcularTotal() {
        double valor = pizza.getValor();
        if (tamanho.equalsIgnoreCase("Média")) {
            valor *= 1.1;
        } else if (tamanho.equalsIgnoreCase("Grande")) {
            valor *= 1.25;
        }
        return valor;
    }

    public void exibirInfo() {
        inputHelp.InputText("Pizza: " + pizza.getNome());
        inputHelp.InputText("Tamanho: " + tamanho);
        inputHelp.InputText("Valor: R$" + calcularTotal());
        inputHelp.InputText("Endereço: " + ende);
    }

    public Pizza getPizza() {

        return pizza;
    }

    public String getEnde() {

        return ende;
    }


}