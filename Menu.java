import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Pizza> pizzas;
    private List<Pedido> pedidos;
    private InputHelp inputHelp; // Adiciona InputHelp

    public Menu() {
        this.pizzas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.inputHelp = new InputHelp(); // Inicializa InputHelp

        pizzas.add(new Pizza("Mussarela", 30.0, "Mussarela, tomate, orégano"));
        pizzas.add(new Pizza("Calabresa", 35.0, "Calabresa, cebola, azeitona"));
        pizzas.add(new Pizza("Portuguesa", 40.0, "Presunto, ovo, cebola, pimentão"));
    }

    public void fazerPedido(Scanner scanner) {
        inputHelp.InputText("Fazer Pedido");
        inputHelp.InputText("Pizzas disponíveis:");
        for (int i = 0; i < pizzas.size(); i++) {
            inputHelp.InputText((i + 1) + ". " + pizzas.get(i).getNome() + " (R$" + pizzas.get(i).getValor() + ")");
        }
        int escolhaPizza = inputHelp.InputInt("Escolha o número da pizza: ");

        if (escolhaPizza < 1 || escolhaPizza > pizzas.size()) {
            inputHelp.InputText("Opção inválida.");
            return;
        }

        Pizza pizzaEscolhida = pizzas.get(escolhaPizza - 1);

        String tamanho = inputHelp.InputString("Digite o tamanho (Pequena, Média, Grande): ");
        String endereco = inputHelp.InputString("Digite o endereço de entrega: ");

        Pedido pedido = new Pedido(pizzaEscolhida, tamanho, endereco);
        pedidos.add(pedido);
        inputHelp.InputText("Pedido realizado com sucesso!");
    }

    public void cancelarPedido(Scanner scanner) {
        inputHelp.InputText(" Cancelar Pedido");
        if (pedidos.isEmpty()) {
            inputHelp.InputText("Nenhum pedido cadastrado.");
            return;
        }

        inputHelp.InputText("Pedidos cadastrados:");
        for (int i = 0; i < pedidos.size(); i++) {
            inputHelp.InputText((i + 1) + ". " + pedidos.get(i).getPizza().getNome() + " - " + pedidos.get(i).getEnde());
        }
        int escolhaPedido = inputHelp.InputInt("Escolha o número do pedido para cancelar: ");

        if (escolhaPedido < 1 || escolhaPedido > pedidos.size()) {
            inputHelp.InputText("Opção inválida.");
            return;
        }

        pedidos.remove(escolhaPedido - 1);
        inputHelp.InputText("Pedido cancelado com sucesso!");
    }

    public void gerarRelatorio() {
        inputHelp.InputText("Relatório de Pedidos");
        if (pedidos.isEmpty()) {
            inputHelp.InputText("Nenhum pedido cadastrado.");
            return;
        }

        float totalPedidos = 0;
        float somaValores = 0;

        for (Pedido pedido : pedidos) {
            pedido.exibirInfo();
            inputHelp.InputText("------------------");
            totalPedidos++;
            somaValores += (float) pedido.calcularTotal();
        }

        inputHelp.InputText("Total de pedidos: " + (int) totalPedidos);
        inputHelp.InputText(String.format("Média de preço dos pedidos: R$%.2f", (somaValores / totalPedidos)));
    }



    public void adicionarPizza(Scanner scanner) {
        inputHelp.InputText(" Adicionar Pizza ao Menu ");
        String nome = inputHelp.InputString("Digite o nome da pizza: ");
        double valor = inputHelp.InputDouble("Digite o valor da pizza(R$): ");
        String ingredientes = inputHelp.InputString("Digite os ingredientes da pizza: ");

        Pizza novaPizza = new Pizza(nome, valor, ingredientes);
        pizzas.add(novaPizza);
        inputHelp.InputText("Pizza adicionada ao menu com sucesso!");
    }
}
