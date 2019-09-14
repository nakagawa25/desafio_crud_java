package Camada_Negocio;

public class Controle_Seguranca {
    public static void RealizarLog(String cadastro){
        System.out.println("Alerta de Cadastro: " + cadastro.replace(";"," "));
    }
}
