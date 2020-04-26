package br.mp.mpf.webscraping.scraping;

import br.mp.mpf.webscraping.model.Fonte;
import br.mp.mpf.webscraping.model.Pesquisa;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExtratorIT {
    
    private Motor motor;
    
    public ExtratorIT() throws IOException {
        Fonte fonte = new Fonte();
        fonte.setNome("cosemsrn");
        fonte.setUrl("https://www.cosemsrn.org.br/secretarias/");
        motor = new Motor();
        motor.conecta(fonte);
    }
    
     @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testProcessarPagina() {
        
        Extrator extrator = new Extrator();
        Pesquisa pesquisa = extrator.processarPagina(motor.getDoc());
        assertEquals(167, pesquisa.getRegistros().size());
        
    }
    
}
