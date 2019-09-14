package Interface_Grafica;

import Camada_Negocio.Profissional;

import java.util.Scanner;

public class Menu extends PadraoTela {
    @Override
    public void Printar(Profissional profissional) {
        try {
            Scanner scanner = new Scanner(System.in);

            int opcao = 0;
            while (opcao != 3) {
                Desenha("Opções:     1 - Cadastro       2 - Leitura     3 - Sair");
                Desenha("Escolha: ");
                int escolha = 0;
                try{
                    Scanner scannerEscolha = new Scanner(System.in);
                    escolha = scannerEscolha.nextInt();
                }catch (Exception erro) {
                    Desenha("Digite apenas Números inteiros. Erro: " + erro.getMessage());
                }
                switch (escolha) {
                    case 1:
                        Desenha("Você escolheu Cadastro!");
                        Cadastro cadastro = new Cadastro();
                        cadastro.Printar(profissional);
                        break;
                    case 2:
                        Desenha("Você escolheu Leitura!");
                        Leitura leitura = new Leitura();
                        leitura.Printar(profissional);
                        break;
                    case 3:
                        opcao = 3;
                        break;
                    default:
                        Desenha("Escolha incorreta!");
                        break;
                }
                LimpaTela();
            }
        }catch (Exception erro){
            Desenha(erro.getMessage());
        }
    }
}
