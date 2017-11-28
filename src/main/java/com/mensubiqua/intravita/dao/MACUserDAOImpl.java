package com.mensubiqua.intravita.dao;

import com.mensubiqua.intravita.model.MACUser;

public class MACUserDAOImpl implements MACUserDAO{
	private final String COLLECTION = "ultimaConexion";
    private final String ID = "_id"; //TODO

    public void insert(MACUser mac) {
        DBBroker.get().insertOne(mac, COLLECTION);
    }
    public MACUser find(String id) {
       /* Document document = DBBroker.get().find(ID, new ObjectId(id), COLLECTION);
        Publicacion p = null;

        if (document != null) { 
        	p = new Publicacion(document.getString("nickname"), document.getString("texto"),
        		document.getString("privacidad"), document.getString("fecha"));
        	p.setId(document.getObjectId("_id").toString());
        }
        return p;*/
    	return null;
    }
}
