package Interface_Grafica;

import Camada_Negocio.Gerente;
import Camada_Negocio.Profissional;

import java.util.Scanner;

public abstract class PadraoTela {
    public abstract void Printar(Profissional profissional);
    protected void LimpaTela(){
        Desenha("Digite ENTER para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Desenha("|+================================================================+|");
    }
    protected void Desenha(String texto){
        System.out.println(texto);
    }

    protected boolean ValidarGerente(Profissional profissional){
        try{
            Gerente gerente = (Gerente)profissional;
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
