package pizzayolo.entity;

public enum TypePate {
	Classique(0), Fine(0), Pan(1.50), MozzaCrust(2.90);

	private double prix;

	private TypePate(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
