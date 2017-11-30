package com.mensubiqua.intravita.model;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;

public class MACUser {
	String mac;
	String fecha;
	public MACUser() {
		obtenFecha();
		obtenMac();
	}
	public MACUser(String mac) {
		obtenFecha();
		setMac(mac);
	}
	public String getFecha() {
		return this.fecha;
	}
	private void obtenFecha() {
		this.fecha = new Date().toString();
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	private void obtenMac() {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			setMac(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
