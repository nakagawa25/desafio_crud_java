package DAO;

import VO.PadraoVO;
import VO.ProdutoVO;

import java.util.ArrayList;

public class ProdutoDAO extends PadraoDAO {
    @Override
    public String CriaParametros(PadraoVO vo) {
        ProdutoVO produto = (ProdutoVO)vo;
        String cadastro = produto.GetID() + ";";
        cadastro += produto.GetDescricao();

        return cadastro;
    }

    public ArrayList<ProdutoVO> Retornar(int id) throws Exception {
        ProdutoVO produto = null;
        if(id != -1) {
            produto = new ProdutoVO();
            produto.SetID(id);
        }
        ArrayList<PadraoVO> listaRetornada = Ler(produto);
        if(listaRetornada == null)
            throw  new Exception("Não há registro de Produtos com essas especificações.");
        ArrayList<ProdutoVO> lista = new ArrayList<ProdutoVO>();
        for (int i = 0; i < listaRetornada.size(); i++) {
            lista.add((ProdutoVO) listaRetornada.get(i));
        }
        return lista;
    }

    @Override
    public String GetNomeArquivo() {
        return ConexaoBD.GetConexao() + "\\Produto.txt";
    }

    @Override
    public PadraoVO CriaVO(String consulta) {
        ProdutoVO produto = new ProdutoVO();
        String vetorConsulta[] = consulta.split(";");
        produto.SetID(Integer.parseInt(vetorConsulta[0]));
        produto.SetDescricao(vetorConsulta[1]);

        return produto;
    }
}
