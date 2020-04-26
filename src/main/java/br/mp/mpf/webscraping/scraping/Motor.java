package br.mp.mpf.webscraping.scraping;

import br.mp.mpf.webscraping.model.Fonte;
import java.io.IOException;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Edgar Dantas Nóbrega
 */
public class Motor {
    
    
    private Document doc;
    private Connection conn;
    private String url;
    
    public Motor() {
    }
    
    public boolean conecta(Fonte fonte) throws IOException {
        conn = Jsoup.connect(fonte.getUrl());
        url = fonte.getUrl();
        doc = conn.get();
        return doc!=null;
    }
    
    public boolean carregaPagina(Map<String, String> parametros) throws IOException {
        doc = conn.url(url).data(parametros).get();
        return doc!=null;
     }
    
    public Document getDoc() {
        return doc;
    }
    
    public String getUrl() {
        return doc.location();
    }
    
}
