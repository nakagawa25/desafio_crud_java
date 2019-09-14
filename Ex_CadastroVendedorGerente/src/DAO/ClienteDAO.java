package DAO;

import VO.ClienteVO;
import VO.PadraoVO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClienteDAO extends PadraoDAO {
    @Override
    public String CriaParametros(PadraoVO vo) {
        ClienteVO cliente = (ClienteVO) vo;
        String cadastro = cliente.GetID() + ";";
        cadastro += cliente.GetNome();

        return cadastro;
    }

    public ArrayList<ClienteVO> Retornar(int id) throws Exception {
        ClienteVO cliente = null;
        if (id != -1){
            cliente = new ClienteVO();
            cliente.SetID(id);
        }
        ArrayList<PadraoVO> listaRetornada = Ler(cliente);
        if(listaRetornada == null)
            throw  new Exception("Não há registro de Clientes com essas especificações.");
        ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
        for (int i = 0; i < listaRetornada.size(); i++) {
            lista.add((ClienteVO) listaRetornada.get(i));
        }
        return lista;
    }

    @Override
    public String GetNomeArquivo() {
        return ConexaoBD.GetConexao() + "\\Cliente.txt";
    }

    @Override
    public PadraoVO CriaVO(String consulta) {
        ClienteVO clienteVO = new ClienteVO();
        String vetorConsulta[] = consulta.split(";");
        clienteVO.SetID(Integer.parseInt(vetorConsulta[0]));
        clienteVO.SetNome(vetorConsulta[1]);
        return clienteVO;
    }
}
