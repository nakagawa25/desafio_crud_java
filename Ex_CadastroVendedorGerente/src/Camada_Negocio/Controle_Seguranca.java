package Camada_Negocio;

public class Controle_Seguranca {
    public static void RealizarLogCadastro(String cadastro){
        System.out.println("Alerta de Cadastro: " + cadastro.replace(";"," "));
    }

    public static void RealizarLogExclusao(String cadastro){
        System.out.println("Alerta de Exclusão: " + cadastro.replace(";"," "));
    }
}
