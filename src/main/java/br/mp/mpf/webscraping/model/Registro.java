package br.mp.mpf.webscraping.model;

/**
 *
 * @author Edgar Dantas Nóbrega
 */


/**
 * Registro conforme estrutura da COSEMRN
 *  https://www.cosemsrn.org.br/secretarias/
 * 
 */
public class Registro {
    private Integer id;
    private String nomeCidade;
    private String nomeResponsavel;
    private String telefones;
    private String CEP;
    private String emails;

    public Registro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

}
