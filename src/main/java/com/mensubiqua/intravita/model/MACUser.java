package com.mensubiqua.intravita.model;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class MACUser {
	String user, mac;
	public MACUser(String user) {
		setUser(user);
		obtenMac();
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public void obtenMac() {
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
