package VO;

public class ClienteVO extends PadraoVO {
    private String nome;
    public void SetNome(String valor){
        nome = valor;
    }
    public String GetNome(){
        return nome;
    }
}
