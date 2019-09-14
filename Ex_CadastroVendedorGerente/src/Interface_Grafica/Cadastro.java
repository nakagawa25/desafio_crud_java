package Interface_Grafica;

import Camada_Negocio.Gerente;
import Camada_Negocio.Profissional;
import Camada_Negocio.Vendedor;

import java.util.Scanner;

public class Cadastro extends PadraoTela {
    @Override
    public void Printar(Profissional profissional) {
        try {
            LimpaTela();
            if (ValidarGerente(profissional)) {
                Gerente gerente = (Gerente) profissional;
                Desenha("Escolha uma opção");
                Desenha("1 - Cadastrar Cliente");
                Desenha("2 - Cadastrar Funcionario");
                Desenha("3 - Cadastrar Pedido");
                Desenha("4 - Cadastrar Produto");
                Desenha("Escolha: ");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha){
                    case 1:
                        Desenha("Digite o ID:");
                        int idCliente = scanner.nextInt();
                        Desenha("Digite o Nome: ");
                        String nomeCliente = scanner.next();
                        gerente.CadastrarCliente(idCliente, nomeCliente);
                        break;
                    case 2:
                        Desenha("Digite o ID:");
                        int idFuncionario = scanner.nextInt();
                        Desenha("Digite o Nome:");
                        String nomeFuncionario = scanner.next();
                        gerente.CadastrarFuncionario(idFuncionario, nomeFuncionario);
                        break;
                    case 3:
                        Desenha("Digite o ID:");
                        int idPedido = scanner.nextInt();
                        Desenha("Digite o ID do Cliente: ");
                        int idClienteP = scanner.nextInt();
                        Desenha("Digite o ID do Produto: ");
                        int idProdutoP = scanner.nextInt();
                        gerente.CadastrarPedido(idPedido, idClienteP, idProdutoP);
                        break;
                    case 4:
                        Desenha("Digite o ID:");
                        int idProduto = scanner.nextInt();
                        Desenha("Digite a descriacao: ");
                        String descricao = scanner.next();
                        gerente.CadastrarProduto(idProduto, descricao);
                        break;
                    default:
                        Desenha("Opção incorreta!");
                        break;
                }
            } else {
                Vendedor vendedor = (Vendedor) profissional;
                Desenha("Escolha uma opção");
                Desenha("1 - Cadastrar Cliente");
                Desenha("2 - Cadastrar Pedido");
                Desenha("3 - Cadastrar Produto");
                Desenha("Escolha: ");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                switch (escolha){
                    case 1:
                        Desenha("Digite o ID:");
                        int idCliente = scanner.nextInt();
                        Desenha("Digite o Nome: ");
                        String nomeCliente = scanner.next();
                        vendedor.CadastrarCliente(idCliente, nomeCliente);
                        break;
                    case 2:
                        Desenha("Digite o ID:");
                        int idPedido = scanner.nextInt();
                        Desenha("Digite o ID Cliente: ");
                        int idClienteP = scanner.nextInt();
                        Desenha("Digite o ID Produto: ");
                        int idProdutoP = scanner.nextInt();
                        vendedor.CadastrarPedido(idPedido, idClienteP, idProdutoP);
                        break;
                    case 3:
                        Desenha("Digite o ID:");
                        int idProduto = scanner.nextInt();
                        Desenha("Digite a Descricao: ");
                        String descricao = scanner.next();
                        vendedor.CadastrarProduto(idProduto, descricao);
                        break;
                    default:
                        Desenha("Opção inválida!");
                        break;
                }
            }
        }catch (Exception erro){
            Desenha(erro.getMessage());
        }
    }
}

