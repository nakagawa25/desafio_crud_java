package VO;

public class ProdutoVO extends PadraoVO {
    private String descricao;
    public void SetDescricao(String valor){
        descricao = valor;
    }
    public String GetDescricao(){
        return descricao;
    }
}
