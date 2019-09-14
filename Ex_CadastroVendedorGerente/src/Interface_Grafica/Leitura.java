package Interface_Grafica;

import Camada_Negocio.Gerente;
import Camada_Negocio.Profissional;
import Camada_Negocio.Vendedor;

import java.util.Scanner;

public class Leitura extends PadraoTela {
    @Override
    public void Printar(Profissional profissional) {
        try {
            LimpaTela();
            if (ValidarGerente(profissional)) {
                Gerente gerente = new Gerente();
                Desenha("Escolha uma opção");
                Desenha("1 - Ler Cliente");
                Desenha("2 - Ler Funcionario");
                Desenha("3 - Ler Pedido");
                Desenha("4 - Ler Produto");
                Desenha("Escolha: ");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idCliente = scanner.nextInt();
                        gerente.LerCliente(idCliente);
                        break;
                    case 2:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idFuncionario = scanner.nextInt();
                        gerente.LerFuncionario(idFuncionario);
                        break;
                    case 3:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idPedido = scanner.nextInt();
                        gerente.LerPedido(idPedido);
                        break;
                    case 4:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idProduto = scanner.nextInt();
                        gerente.LerProduto(idProduto);
                        break;
                    default:
                        Desenha("Opção Inválida!");
                        break;
                }
            } else {
                Vendedor vendedor = new Vendedor();
                Desenha("Escolha uma opção");
                Desenha("1 - Ler Cliente");
                Desenha("2 - Ler Pedido");
                Desenha("3 - Ler Produto");
                Desenha("Escolha: ");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idCliente = scanner.nextInt();
                        vendedor.LerCliente(idCliente);
                        break;
                    case 2:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idPedido = scanner.nextInt();
                        vendedor.LerPedido(idPedido);
                        break;
                    case 3:
                        Desenha("Digite o ID para consulta (-1 para retornar tudo):");
                        int idProduto = scanner.nextInt();
                        vendedor.LerProduto(idProduto);
                        break;
                    default:
                        Desenha("Opção Inválida!");
                        break;
                }
            }
        } catch (Exception erro) {
            Desenha(erro.getMessage());
        }
    }
}
