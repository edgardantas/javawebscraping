package br.mp.mpf.webscraping.scraping;

import br.mp.mpf.webscraping.model.Fonte;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edgar Dantas Nóbrega
 */
public class MotorIT {
    
    private Motor motor;
    private boolean result;
  
    public MotorIT() {
        motor = new Motor();
    }
    
    
    @Before
    public void setUp() throws IOException {
        Fonte fonte = new Fonte();
        fonte.setNome("cosemsrn");
        fonte.setUrl("https://www.cosemsrn.org.br/secretarias/");
        result = motor.conecta(fonte);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConecta() {
       
        assertEquals(true, result);
       
    }
    
  
    
}
