/**
 *
 * @author Edgar Dantas
 */
package br.mp.mpf.webscraping.scraping;

import br.mp.mpf.webscraping.model.Pesquisa;
import br.mp.mpf.webscraping.model.Registro;
import java.text.Normalizer;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extrator {

    private int ultimoId = 0;

    public Extrator() {
    }

    public Pesquisa processarPagina(Document doc) {
        Pesquisa pesquisa = new Pesquisa(ultimoId);
        Elements regioes = doc.select("div[data-regiaoconteudo]");
        for (Element regiao : regioes) {
            Elements cidades = regiao.select("div.media-perfis");
            for (Element cidade : cidades) {
                pesquisa.addRegistro(extrairRegistro(cidade));
            }
        }
        this.ultimoId = pesquisa.getLastId();
        return pesquisa;
    }

    public Registro extrairRegistro(Element registroDom) {
        Registro registro = new Registro();
        String labelDado;
        registro.setNomeCidade(extrairValorString(registroDom.selectFirst("div.media-perfis > h4.media-heading")));
        registro.setNomeResponsavel(extrairValorString(registroDom.selectFirst("div.media-perfis > span.sub-title")));
        for (Element dado : registroDom.select("div.media-perfis > div.mg-tb-20")) {
            labelDado = Normalizer.normalize(extrairValorString(dado.selectFirst("span")), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            if(labelDado.equals("Endereco da SMS")) {
                if(dado.ownText()!=null) {
                    String textos[] = dado.ownText().split(":\\s|\\s");
                    if(textos.length>1) {
                        registro.setCEP(textos[1]);
                    } else {
                        System.out.println(registro.getNomeCidade() + " - Erro no CEP: " + dado.ownText());
                    }
                }
            }
            if(labelDado.equals("Email(s)")) registro.setEmails(extrairValorString(dado.selectFirst("a")).trim());
            if(labelDado.equals("Telefone(s)")) registro.setTelefones(dado.ownText().trim());
        }
        return registro;
    }
    
    
    private Integer extrairValorInteiro(Element item) {
        if(item==null) return null;
        return Integer.parseInt(item.text());
    }
    
     private String extrairValorString(Element item) {
        if(item==null) return null;
        return item.text();
    }
    

}
