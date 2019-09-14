package Interface_Grafica;

import Camada_Negocio.Gerente;
import Camada_Negocio.Profissional;
import Camada_Negocio.Vendedor;

import java.util.Scanner;

public class Login extends PadraoTela {
    @Override
    public void Printar(Profissional profissional) {
        try {
            Desenha("Faça o Login.");
            Desenha("1 - Vendedor");
            Desenha("2 - Gerente");
            Desenha("Escolha: ");
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
            Menu menu = new Menu();
            switch (escolha) {
                case 1:
                    Vendedor vendedor = new Vendedor();
                    menu.Printar(vendedor);
                    break;
                case 2:
                    Gerente gerente = new Gerente();
                    menu.Printar(gerente);
                    break;
                default:
                    Desenha("Opção Inválida!");
                    break;
            }
        }catch (Exception erro){
            Desenha("Digite Apenas uma opção válida. Erro: " + erro.getMessage());
        }
    }
}
