package com.mensubiqua.intravita.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.bson.Document;

import com.mensubiqua.intravita.model.LastTime;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

public class LastTimeDAOImpl {
	private final String COLLECTION = "lastTime";

    public void insert(LastTime lt) {
    	DBBroker.get().delete("user", lt.getUser(), COLLECTION);
        DBBroker.get().insertOne(lt, COLLECTION);
    }
    public boolean find(String user) {
        FindIterable<Document>documents = DBBroker.get().findAll("user", user, COLLECTION);
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
