package com.mensubiqua.intravita.dao;

import java.io.File;
import java.util.ArrayList;

import com.mensubiqua.intravita.model.Publicacion;
import com.mensubiqua.intravita.model.User;

/**
 * PublicacionDAO - Interfaz que declara los métodos que comunican las publicaciones con la BBDD
 * 
 *
 * @author Ulises Ceca, Ignacio Dones, José María Simón, Miguel Ampuero, Eduardo Parra
 * @since 1.4
 * @version 1.8
 */
public interface PublicacionDAO {

    public void insert(Publicacion p);
    public void delete(String id, File foto);
    public Publicacion find(String id);
    public Publicacion findNick(String nick);
    public ArrayList<Publicacion> findAll(String user);
    public ArrayList<Publicacion> selectAll();
    public void update(Publicacion p);
    public void deleteUser(String nick);
    public void limpiarCompartidas(Publicacion p);
    public long contCompartida(String id);
}
