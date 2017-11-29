package com.mensubiqua.intravita.dao;

import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mensubiqua.intravita.model.MACUser;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

public class MACUserDAOImpl implements MACUserDAO{
	private final String COLLECTION = "ultimaConexion";

    public void insert(MACUser mac) {
        DBBroker.get().insertOne(mac, COLLECTION);
    }
    public boolean find(String mac) {
        FindIterable<Document>documents = DBBroker.get().findAll("mac", mac, COLLECTION);
        Date fecha = new Date();
        if(documents!=null) {
	        MongoCursor<Document>documentos = documents.iterator();
	        while(documentos.hasNext()) {
	        	if(documentos.next().get("fecha").toString().equalsIgnoreCase(fecha.toString())) {
	        		return true;
	        	}
	        }
        }
        return false;
    }
}
