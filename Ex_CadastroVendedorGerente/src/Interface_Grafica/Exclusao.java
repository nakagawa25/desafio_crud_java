package Interface_Grafica;

import Camada_Negocio.Gerente;
import Camada_Negocio.Profissional;
import Camada_Negocio.Vendedor;

import java.util.Scanner;

public class Exclusao extends PadraoTela {
    @Override
    public void Printar(Profissional profissional) {
        try {
            LimpaTela();
            if (ValidarGerente(profissional)) {
                Gerente gerente = (Gerente) profissional;
                Desenha("Escolha uma opção");
                Desenha("1 - Excluir Cliente");
                Desenha("2 - Excluir Funcionario");
                Desenha("3 - Excluir Pedido");
                Desenha("4 - Excluir Produto");
                Desenha("Escolha: ");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        Desenha("Digite o ID:");
                        int idCliente = scanner.nextInt();
                        gerente.ExcluirCliente(idCliente);
                        break;
                    case 2:
                        Desenha("Digite o ID:");
                        int idFuncionario = scanner.nextInt();
                        gerente.ExcluirFuncionario(idFuncionario);
                        break;
                    case 3:
                        Desenha("Digite o ID:");
                        int idPedido = scanner.nextInt();
                        gerente.ExcluirPedido(idPedido);
                        break;
                    case 4:
                        Desenha("Digite o ID:");
                        int idProduto = scanner.nextInt();
                        gerente.ExcluirProduto(idProduto);
                        break;
                    default:
                        Desenha("Opção incorreta!");
                        break;
                }
            } else {
                Vendedor vendedor = (Vendedor) profissional;
                Desenha("Escolha uma opção");
                Desenha("1 - Excluir Cliente");
                Desenha("2 - Excluir Pedido");
                Desenha("3 - Excluir Produto");
                Desenha("Escolha: ");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        Desenha("Digite o ID:");
                        int idCliente = scanner.nextInt();
                        vendedor.ExcluirCliente(idCliente);
                        break;
                    case 2:
                        Desenha("Digite o ID:");
                        int idPedido = scanner.nextInt();
                        vendedor.ExcluirPedido(idPedido);
                        break;
                    case 3:
                        Desenha("Digite o ID:");
                        int idProduto = scanner.nextInt();
                        vendedor.ExcluirProduto(idProduto);
                        break;
                    default:
                        Desenha("Opção inválida!");
                        break;
                }
            }
        } catch (Exception erro) {
            Desenha("Erro na Exclusão. Erro: " + erro.getMessage());
        }
    }
}

