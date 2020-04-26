package br.mp.mpf.webscraping.scraping;

import br.mp.mpf.webscraping.model.Registro;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ExtratorTest {

    public ExtratorTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Teste extrair registro do Elemento HTML
     */
    @Test
    public void testExtrairRegistro() {
        String idRegiao = "regiao1";
        String codigoHtml = getCodigoHtml();
        Document doc = Jsoup.parse(codigoHtml);
        Element regiao = doc.select("div[data-regiaoconteudo=" + idRegiao + "]").get(0);
        Elements cidades = regiao.select("div.media-perfis");
        Element primeiraCidade = cidades.get(0);


        Extrator extrator = new Extrator();
        Registro registro = extrator.extrairRegistro(primeiraCidade);
        assertEquals("AREZ", registro.getNomeCidade());
        assertEquals("59.170-000", registro.getCEP());
        assertEquals("smsarez@rn.gov.br", registro.getEmails());
        assertEquals("Ingrid de Souza Cavalcante", registro.getNomeResponsavel());
        assertEquals("(84) 3242.2448/99614-0000", registro.getTelefones());
    }

    private String getCodigoHtml() {

        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/br/mp/mpf/webscraping/scraping/regiao.html")), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(ExtratorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
