package DAO;

import Camada_Negocio.Controle_Seguranca;
import VO.PadraoVO;

import java.io.*;
import java.util.ArrayList;

public abstract class PadraoDAO {

    public abstract String CriaParametros(PadraoVO vo);
    public abstract String GetNomeArquivo();
    public abstract PadraoVO CriaVO(String consulta);
    private String GetIdPadraoVO(PadraoVO padraoVO)
    {
        int id = padraoVO.GetID();
        return Integer.toString(id);
    }

    public boolean Cadastrar(PadraoVO padraoVO){
        try {
            String cadastro = CriaParametros(padraoVO);
            FileWriter arquivo = new FileWriter(GetNomeArquivo(), true);
            BufferedWriter bw = new BufferedWriter(arquivo);
            bw.write(cadastro);
            //PrintWriter gravadorArquivo = new PrintWriter(arquivo);
            //gravadorArquivo.printf(cadastro + "%n");
            bw.newLine();
            bw.close();
            Controle_Seguranca.RealizarLog(cadastro);
            return true;
        } catch (IOException e) {
            System.out.println("Não foi possível cadastrar. Erro: " + e.getMessage());

            return false;
        }
    }

    protected ArrayList<PadraoVO> Ler(PadraoVO padraoVO){
        try{
            ArrayList<String> retorno = new ArrayList<>();

            FileReader arq = new FileReader(GetNomeArquivo());
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                if(padraoVO != null){
                    String vetor[] = linha.split(";");
                    if(vetor[0].equals(GetIdPadraoVO(padraoVO)))
                        retorno.add(linha);
                }
                else
                    retorno.add(linha);
                linha = lerArq.readLine();
            }

            ArrayList<PadraoVO> retornoObjeto = new ArrayList<PadraoVO>();

            for(int i = 0; i < retorno.size(); i++){
                retornoObjeto.add(CriaVO(retorno.get(i)));
            }

            arq.close();
            return  retornoObjeto;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
