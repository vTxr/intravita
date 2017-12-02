package com.mensubiqua.intravita.model;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Mac {
	String mac;	
	
	public Mac() {
		obtenMac();
	}
	
	protected void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getMac() {
		return this.mac;
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
