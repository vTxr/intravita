package com.mensubiqua.intravita.dao;

import com.mensubiqua.intravita.model.MACUser;

public interface MACUserDAO {
	public void insert(MACUser mac);
    public MACUser find(String id);
}
