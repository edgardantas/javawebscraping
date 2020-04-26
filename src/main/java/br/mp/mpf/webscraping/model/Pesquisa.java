/**
 *
 * @author Edgar Dantas Nóbrega
 */

package br.mp.mpf.webscraping.model;

import java.util.ArrayList;
import java.util.List;

public class Pesquisa {

    private List<Registro> registros;
    private int lastId;

    public Pesquisa(int lastId) {
        this.lastId = lastId;
        registros = new ArrayList<>();
    }
   
    public void addRegistro(Registro registro) {
        registro.setId(++lastId);
        registros.add(registro);
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public int getLastId() {
        return lastId;
    }
  
}
