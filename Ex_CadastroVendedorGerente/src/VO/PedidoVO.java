package VO;

public class PedidoVO extends PadraoVO{
    private int idCliente;
    private int idProduto;

    public void SetIdCliente(int valor){
        idCliente = valor;
    }
    public int GetIdCliente(){
        return idCliente;
    }

    public void SetIdProduto(int valor){
        idProduto = valor;
    }
    public int GetIdProduto(){
        return idProduto;
    }
}
