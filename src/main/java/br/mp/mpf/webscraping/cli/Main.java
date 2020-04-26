/**
 *
 * @author Edgar Dantas Nóbrega
 */

package br.mp.mpf.webscraping.cli;

import br.mp.mpf.webscraping.dao.PesquisaDAO;
import br.mp.mpf.webscraping.model.Fonte;
import br.mp.mpf.webscraping.model.Pesquisa;
import br.mp.mpf.webscraping.scraping.Extrator;
import br.mp.mpf.webscraping.scraping.Motor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static public void main(String[] args) {

        Fonte fonte = new Fonte();
        fonte.setNome("cosemsrn");
        fonte.setUrl("https://www.cosemsrn.org.br/secretarias/");
        Motor motor = new Motor();
        Pesquisa pesquisa;
        Extrator extrator = new Extrator();
        try {

            PesquisaDAO pesquisaDao = new PesquisaDAO();
            try {
                motor.conecta(fonte);
                pesquisa = extrator.processarPagina(motor.getDoc());
                pesquisaDao.addPesquisa(pesquisa);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
               pesquisaDao.fechar(); 
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
