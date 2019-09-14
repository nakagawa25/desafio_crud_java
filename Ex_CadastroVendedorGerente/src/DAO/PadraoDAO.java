package DAO;

import Camada_Negocio.Controle_Seguranca;
import Interface_Grafica.Leitura;
import VO.PadraoVO;

import java.io.*;
import java.util.ArrayList;

public abstract class PadraoDAO {

    public abstract String CriaParametros(PadraoVO vo);

    public abstract String GetNomeArquivo();

    public abstract PadraoVO CriaVO(String consulta);

    private String GetIdPadraoVO(PadraoVO padraoVO) {
        int id = padraoVO.GetID();
        return Integer.toString(id);
    }

    public void Excluir(PadraoVO padraoVO) throws IOException {
        ArrayList<PadraoVO> listaRetornada = Ler(null);
        File fileToDelete = new File(GetNomeArquivo());
        if (fileToDelete.delete()) {
            for (int i = 0; i < listaRetornada.size(); i++) {
                if (listaRetornada.get(i).GetID() != padraoVO.GetID())
                    Cadastrar(listaRetornada.get(i));
                else
                    Controle_Seguranca.RealizarLogExclusao(CriaParametros(listaRetornada.get(i)));
            }
        }
    }

    public boolean Cadastrar(PadraoVO padraoVO) throws IOException {

        String cadastro = CriaParametros(padraoVO);
        FileWriter arquivo = new FileWriter(GetNomeArquivo(), true);
        BufferedWriter bw = new BufferedWriter(arquivo);
        bw.write(cadastro);
        bw.newLine();
        bw.close();
        Controle_Seguranca.RealizarLogCadastro(cadastro);
        return true;
    }

    protected ArrayList<PadraoVO> Ler(PadraoVO padraoVO) throws IOException {

        ArrayList<String> retorno = new ArrayList<>();
        FileReader arq = new FileReader(GetNomeArquivo());
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        while (linha != null) {
            if (padraoVO != null) {
                String vetor[] = linha.split(";");
                if (vetor[0].equals(GetIdPadraoVO(padraoVO)))
                    retorno.add(linha);
            } else
                retorno.add(linha);
            linha = lerArq.readLine();
        }
        ArrayList<PadraoVO> retornoObjeto = new ArrayList<PadraoVO>();
        for (int i = 0; i < retorno.size(); i++) {
            retornoObjeto.add(CriaVO(retorno.get(i)));
        }
        arq.close();
        return retornoObjeto;
    }
}
