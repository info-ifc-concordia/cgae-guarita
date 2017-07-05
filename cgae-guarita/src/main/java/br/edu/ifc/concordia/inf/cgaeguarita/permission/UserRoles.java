package br.edu.ifc.concordia.inf.cgaeguarita.permission;

public enum UserRoles {
	
	NORMAL(1),
	MANAGER(4),
	ADMIN(7),
	SYS_ADMIN(10);
	
	private int accessLevel;
	
	private UserRoles(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public int getAccessLevel() {
		return this.accessLevel;
	}
	
}
