package com.mensubiqua.intravita.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mensubiqua.intravita.model.MACUser;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

public class MACUserDAOImpl implements MACUserDAO{
	private final String COLLECTION = "ultimaConexion";

    public void insert(MACUser mac) {
    	DBBroker.get().delete("mac", mac.getMac(), COLLECTION);
        DBBroker.get().insertOne(mac, COLLECTION);
    }
    public boolean find(String mac) {
        FindIterable<Document>documents = DBBroker.get().findAll("mac", mac, COLLECTION);
        Date fecha = new Date();
        Date fecha2;
        long dif;
    	DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        if(documents!=null) {
	        MongoCursor<Document>documentos = documents.iterator();
	        while(documentos.hasNext()) {
				try {
					fecha2 = format.parse(documentos.next().get("fecha").toString());
					dif = fecha.getTime()-fecha2.getTime();
					if(dif>=Math.pow(7.884, 9)) {
						return false;
					}else {
						return true;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
        }
        return false;
    }
}
