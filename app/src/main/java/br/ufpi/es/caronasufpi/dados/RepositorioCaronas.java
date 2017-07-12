package br.ufpi.es.caronasufpi.dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rfeba on 11/07/2017.
 */

public class RepositorioCaronas {
    private List<Carona> caronas;

    public RepositorioCaronas(){
        this.caronas = new LinkedList<Carona>();
        popularRepositorio();
    }

    public void insereCarona(Carona c){
        caronas.add(c);
    }

    public List<Carona> buscaCaronas(String origem, String destino){
        List<Carona> c = new ArrayList<Carona>();
        for(Carona carona:caronas){
            if(carona.getOrigem().equals(origem) && carona.getDestino().equals(destino)){
                c.add(carona);
            }
        }
        return c;
    }

    public Carona pesqId(int id){
        for(Carona c: caronas){
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    public void adicionarPassageiro(Carona c,Usuario u){
        c.adicionarCaroneiro(u);
    }

    public List<Carona> getCaronas(){
        return caronas;
    }

    private void popularRepositorio(){
        RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios();
        Usuario u = repositorioUsuarios.buscaUsuario("rafael");
        Carona c1 = new Carona("15:00","CCN / RU1","CCA RU3",3,u);
        Carona c2 = new Carona("12:00","CCN / RU1","CCA RU3",2,u);
        Carona c3 = new Carona("07:00","CCN / RU1","CCA RU3",1,u);
        Carona c4 = new Carona("19:00","CCN / RU1","CCA RU3",4,u);

        u = repositorioUsuarios.buscaUsuario("mauboa");
        System.out.println("---"+u.getNome());
        c1.setId(1);
        c2.setId(2);
        c3.setId(3);
        c4.setId(4);
        c1.adicionarCaroneiro(u);
        c2.adicionarCaroneiro(u);
        c3.adicionarCaroneiro(u);
        c4.adicionarCaroneiro(u);

        insereCarona(c1);
        insereCarona(c2);
        insereCarona(c3);
        insereCarona(c4);
    }


}
