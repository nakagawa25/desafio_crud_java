package Camada_Negocio;

import DAO.FuncionarioDAO;
import VO.FuncionarioVO;

import java.io.IOException;
import java.util.ArrayList;

public class Gerente extends Profissional {
    public void CadastrarFuncionario(int id, String nome) throws IOException {
        FuncionarioVO funcionario = new FuncionarioVO();
        funcionario.SetID(id);
        funcionario.SetNome(nome);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        funcionarioDAO.Cadastrar(funcionario);
    }

    public void LerFuncionario(int id) throws Exception {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ArrayList<FuncionarioVO> listaFuncionarios = funcionarioDAO.Retornar(id);
        for(int i = 0; i < listaFuncionarios.size(); i++){
            System.out.println(listaFuncionarios.get(i).GetID() + " " + listaFuncionarios.get(i).GetNome());
        }
    }

    public void ExcluirFuncionario(int id) throws IOException {
        FuncionarioVO funcionario = new FuncionarioVO();
        funcionario.SetID(id);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.Excluir(funcionario);
        System.out.println("Funcionario excluído com sucesso! ");
    }
}

