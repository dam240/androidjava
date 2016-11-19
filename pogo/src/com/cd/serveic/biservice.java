package com.cd.serveic;

import com.cd.po.Info;

public interface biservice {

	
	public boolean saveandupdate(Info in);

	public Info load(String username);
}
