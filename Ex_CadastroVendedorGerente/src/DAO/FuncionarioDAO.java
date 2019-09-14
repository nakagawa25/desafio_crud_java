package DAO;

import VO.FuncionarioVO;
import VO.PadraoVO;

import java.util.ArrayList;

public class FuncionarioDAO extends PadraoDAO {
    @Override
    public String CriaParametros(PadraoVO vo) {
        FuncionarioVO funcionario = (FuncionarioVO)vo;
        String cadastro = funcionario.GetID() + ";";
        cadastro += funcionario.GetNome();

        return cadastro;
    }

    public ArrayList<FuncionarioVO> Retornar(int id) throws Exception {
        FuncionarioVO funcionario = null;
        if (id != -1) {
            funcionario = new FuncionarioVO();
            funcionario.SetID(id);
        }
        ArrayList<PadraoVO> listaRetornada = Ler(funcionario);
        if(listaRetornada == null)
            throw  new Exception("Não há registro de Funcionarios com essas especificações.");
        ArrayList<FuncionarioVO> lista = new ArrayList<FuncionarioVO>();
        for (int i = 0; i < listaRetornada.size(); i++) {
            lista.add((FuncionarioVO) listaRetornada.get(i));
        }
        return lista;
    }

    @Override
    public String GetNomeArquivo() {
        return ConexaoBD.GetConexao() + "\\Funcionario.txt";
    }

    @Override
    public PadraoVO CriaVO(String consulta) {
        FuncionarioVO funcionario = new FuncionarioVO();
        String vetorConsulta[] = consulta.split(";");
        funcionario.SetID(Integer.parseInt(vetorConsulta[0]));
        funcionario.SetNome(vetorConsulta[1]);

        return funcionario;
    }
}
