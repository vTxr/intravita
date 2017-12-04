package com.mensubiqua.intravita.dao;

import org.bson.Document;

import com.mensubiqua.intravita.model.Mac;

public class MacDAOImpl {
	private final String COLLECTION = "mac";
	
	public void insert(Mac mac) {
		DBBroker.get().delete("mac", mac.getMac(), COLLECTION);
        DBBroker.get().insertOne(mac, COLLECTION);
    }
	
	public boolean find(Mac mac) {
        Document document = DBBroker.get().find("mac", mac.getMac(), COLLECTION);

        if (document != null){
        	if(document.get("mac").toString().equalsIgnoreCase("mac")) {
        		 DBBroker.get().insertOne(mac, COLLECTION);
        		return true;
        	}        
        }
        return false;
    }
	
}
