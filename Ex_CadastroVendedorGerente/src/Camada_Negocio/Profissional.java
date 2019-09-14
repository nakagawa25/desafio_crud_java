package Camada_Negocio;

import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import VO.ClienteVO;
import VO.FuncionarioVO;
import VO.PedidoVO;
import VO.ProdutoVO;

import java.util.ArrayList;

public class Profissional {
    public void CadastrarCliente(int id, String nome){
        ClienteVO cliente = new ClienteVO();
        cliente.SetID(id);
        cliente.SetNome(nome);
        ClienteDAO clienteDAO = new ClienteDAO();

        clienteDAO.Cadastrar(cliente);
    }

    public void CadastrarPedido(int id, int idCliente, int idProduto){
        PedidoVO pedido = new PedidoVO();
        pedido.SetID(id);
        pedido.SetIdCliente(idCliente);
        pedido.SetIdProduto(idProduto);
        PedidoDAO pedidoDAO = new PedidoDAO();

        pedidoDAO.Cadastrar(pedido);
    }

    public void CadastrarProduto(int id, String descricao){
        ProdutoVO produto = new ProdutoVO();
        produto.SetID(id);
        produto.SetDescricao(descricao);
        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.Cadastrar(produto);
    }

    public void LerCliente(int id) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<ClienteVO> listaClientes = clienteDAO.Retornar(id);
        for(int i = 0; i < listaClientes.size(); i++){
            System.out.println(listaClientes.get(i).GetID() + " " + listaClientes.get(i).GetNome());
        }
    }

    public void LerPedido(int id) throws Exception {
        PedidoDAO pedidoDAO = new PedidoDAO();
        ArrayList<PedidoVO> listaPedido = pedidoDAO.Retornar(id);
        for(int i = 0; i < listaPedido.size(); i++){
            System.out.println(listaPedido.get(i).GetID() + " " + listaPedido.get(i).GetIdCliente()
                    + " " + listaPedido.get(i).GetIdProduto());
        }
    }

    public void LerProduto(int id) throws Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<ProdutoVO> listaProdutos = produtoDAO.Retornar(id);
        for(int i = 0; i < listaProdutos.size(); i++){
            System.out.println(listaProdutos.get(i).GetID() + " " + listaProdutos.get(i).GetDescricao());
        }
    }
}
