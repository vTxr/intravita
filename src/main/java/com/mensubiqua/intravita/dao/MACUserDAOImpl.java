package com.mensubiqua.intravita.dao;

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
    public boolean find(String user, String mac) {
        FindIterable<Document>documents = DBBroker.get().findAll("user", user, COLLECTION);
        if(documents!=null) {
	        MongoCursor<Document>documentos = documents.iterator();
	        while(documentos.hasNext()) {
	        	if(documentos.next().get("mac").toString().equalsIgnoreCase(mac)) {
	        		return true;
	        	}
	        }
        }
        return false;
    }
}
