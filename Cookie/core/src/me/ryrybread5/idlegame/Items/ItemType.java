package me.ryrybread5.idlegame.Items;

public enum ItemType {
	
	SPRINKLES("Sprinkles", 15, .1),
	CHERRY("Cherries",100, 1),
	MM("M&M's", 1100, 7),
	REESE("Reese's Peices", 12000, 40),
	CHOCLATES("Choclate Syrup", 130000, 300),
	STRAWBERRIES("Strawberries", 1400000, 2000),
	BANANAS("Bananas", 15000000, 13000),
	COOKIEDOUGH("Cookie Dough", 160000000, 90000),;
	
	private String id;
	private double addPs;
	private int cost;
	private ItemType(String id, int cost, double addPs) {
		this.id = id;
		this.cost= cost;
		this.addPs = addPs;
	}


	public String getId() {
		return id;
	}

	public void setCost(int nCost) {
		this.cost=nCost;
	}
	public int getCost() {
		return cost;
	}

	public double getaddPS() {
		return addPs;
	}


}
