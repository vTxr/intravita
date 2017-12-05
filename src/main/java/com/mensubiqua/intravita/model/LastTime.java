package com.mensubiqua.intravita.model;

import java.util.Date;


public class LastTime {
	String user, fecha;
	
	public LastTime(String user) {
		setUser(user);
		obtenerFecha();
	}
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void obtenerFecha() {
		setFecha(new Date().toString());
	}
}

