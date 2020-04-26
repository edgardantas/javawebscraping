
package br.mp.mpf.webscraping.dao;

import br.mp.mpf.webscraping.model.Pesquisa;
import br.mp.mpf.webscraping.model.Registro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author Edgar Dantas
 */
public class PesquisaDAO {
    
    public final String NOME_ARQUIVO = "cadastroSecretarias.csv";
    private FileWriter arquivo;

    public PesquisaDAO() throws IOException {
        File arquivoDB = new File(NOME_ARQUIVO);
        if (arquivoDB.exists()) {
            arquivo = new FileWriter(NOME_ARQUIVO, true);
        } else {
            arquivo = new FileWriter(NOME_ARQUIVO);
            iniciaArquivo();
        }
    }
    
    public void addPesquisa(Pesquisa pesquisa) throws IOException {
        for(Registro registro : pesquisa.getRegistros()) {
            gravaRegistro(registro);
        }
        arquivo.flush();
    }
    
    private void gravaRegistro(Registro registro) throws IOException {
        arquivo.append(registro.getId().toString());
        arquivo.append(",");
        arquivo.append(preparaTexto(registro.getNomeCidade()));
        arquivo.append(",");
        arquivo.append(preparaTexto(registro.getNomeResponsavel()));
        arquivo.append(",");
        arquivo.append(preparaTexto(registro.getCEP()));
        arquivo.append(",");
        arquivo.append(preparaTexto(registro.getEmails()));
        arquivo.append(",");
        arquivo.append(preparaTexto(registro.getTelefones()));
        arquivo.append("\n");
    }
    
    public void fechar() throws IOException {
        arquivo.close();
    }
    
    private String preparaInteiro(Integer valor) {
        if(valor == null) return "";
        return valor.toString();
    }
    
    private String preparaDecimal(BigDecimal valor) {
        if(valor == null) return "";
        return valor.toString();
    }
    
    private String preparaTexto(String texto) {
        if(texto == null) return "";
         return "\"" + texto + "\"";
    }
    
    private void iniciaArquivo() throws IOException {
        arquivo.append("id");
        arquivo.append(",");
        arquivo.append("nomeCidade");
        arquivo.append(",");
        arquivo.append("nomeResponsavel");
        arquivo.append(",");
        arquivo.append("CEP");
        arquivo.append(",");
        arquivo.append("emails");
        arquivo.append(",");
        arquivo.append("telefones");
        arquivo.append("\n");
    }
    
}
