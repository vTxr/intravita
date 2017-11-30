package com.mensubiqua.intravita.dao;

import com.mensubiqua.intravita.model.LastTime;

public interface LastTimeDAO {
	public void insert(LastTime lt);
	public boolean find(String user);
}
