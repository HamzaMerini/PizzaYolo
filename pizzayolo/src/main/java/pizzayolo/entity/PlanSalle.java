package pizzayolo.entity;

public enum PlanSalle {
	Emporte(0), TableSalle1(2), TableSalle2(2), TableSalle3(2), TableSalle4(4), TableSalle5(6), TableTerrasse1(2),
	TableTerrasse2(2), TableTerrasse3(4), TableTerrasse4(6);

	private int couvert;

	private PlanSalle(int couvert) {
		this.couvert = couvert;
	}

	public int getCouvert() {
		return couvert;
	}

	public void setCouvert(int couvert) {
		this.couvert = couvert;
	}

}
