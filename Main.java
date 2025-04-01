import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        InputHelp inputHelp = new InputHelp();

        while (true) {
            inputHelp.InputText("------------------");
            inputHelp.InputText("Pizzaria");
            inputHelp.InputText("1. Fazer pedido");
            inputHelp.InputText("2. Cancelar pedido");
            inputHelp.InputText("3. Relatório de pedidos");
            inputHelp.InputText("4. Adicionar nova pizza ao menu");
            inputHelp.InputText("5. Sair");
            int opcao = inputHelp.InputInt("Escolha uma opção: ");
            inputHelp.InputText("------------------");

            switch (opcao) {
                case 1:
                    menu.fazerPedido(scanner);
                    inputHelp.InputText("------------------");
                    break;
                case 2:
                    menu.cancelarPedido(scanner);
                    inputHelp.InputText("------------------");
                    break;
                case 3:
                    menu.gerarRelatorio();
                    inputHelp.InputText("------------------");
                    break;
                case 4:
                    menu.adicionarPizza(scanner);
                    inputHelp.InputText("------------------");
                    break;
                case 5:
                    inputHelp.InputText("Saindo do sistema...");
                    return;
                default:
                    inputHelp.InputText("Opção inválida.");
            }
        }
    }
}