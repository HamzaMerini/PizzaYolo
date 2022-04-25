package pizzayolo.entity;

public class Adresse {
		
	private int id	;
	private int numVoie;
		private String nomVoie;
		private String complement;
		private String CP;
		private String Ville;
		
	public Adresse() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse(int numVoie, String nomVoie, String complement, String cP, String ville) {
		this.numVoie = numVoie;
		this.nomVoie = nomVoie;
		this.complement = complement;
		CP = cP;
		Ville = ville;
	}

	public int getNumVoie() {
		return numVoie;
	}

	public void setNumVoie(int numVoie) {
		this.numVoie = numVoie;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	@Override
	public String toString() {
		return "Adresses [numVoie=" + numVoie + ", nomVoie=" + nomVoie + ", complement=" + complement + ", CP=" + CP
				+ ", Ville=" + Ville + "]";
	}

}
