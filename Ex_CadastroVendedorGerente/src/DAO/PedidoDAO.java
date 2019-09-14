package DAO;

import VO.PadraoVO;
import VO.PedidoVO;

import java.util.ArrayList;

public class PedidoDAO extends PadraoDAO {
    @Override
    public String CriaParametros(PadraoVO vo) {
        PedidoVO pedido = (PedidoVO)vo;
        String cadastro = pedido.GetID() + ";";
        cadastro += pedido.GetIdCliente() + ";";
        cadastro += pedido.GetIdProduto();

        return cadastro;
    }

    public ArrayList<PedidoVO> Retornar(int id) throws Exception {
        PedidoVO pedido = null;
        if (id != -1) {
            pedido = new PedidoVO();
            pedido.SetID(id);
        }
        ArrayList<PadraoVO> listaRetornada = Ler(pedido);
        if(listaRetornada == null)
            throw  new Exception("Não há registro de Pedidos com essas especificações.");
        ArrayList<PedidoVO> lista = new ArrayList<PedidoVO>();
        for (int i = 0; i < listaRetornada.size(); i++) {
            lista.add((PedidoVO) listaRetornada.get(i));
        }
        return lista;
    }

    @Override
    public String GetNomeArquivo() {
        return ConexaoBD.GetConexao() + "\\Pedido.txt";
    }

    @Override
    public PadraoVO CriaVO(String consulta) {
        PedidoVO pedido = new PedidoVO();
        String vetorConsulta[] = consulta.split(";");
        pedido.SetID(Integer.parseInt(vetorConsulta[0]));
        pedido.SetIdCliente(Integer.parseInt(vetorConsulta[1]));
        pedido.SetIdProduto(Integer.parseInt(vetorConsulta[2]));

        return pedido;
    }
}
