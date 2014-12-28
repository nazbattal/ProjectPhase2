package Domain;



public class Lokum {

	private String speciality;
	private int coordX;
	private int coordY;
	private int lokumID; // 0-rose, 1-coconut, 2-brown hazelnut, 3-greenpistachio 
	private boolean marked = false;
	
	
	public void setMarked() {
		this.marked = true;
	}
	
	public boolean getMarked() {
		return marked;
	}
	

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int Xcoord) {
		this.coordX = Xcoord;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	public void setLokum(int id, int x, int y) {
		this.setCoordX(x);
		this.setCoordY(y);
		this.setLokumID(id);
		
		
	}

	public int getLokumID() {
		return lokumID;
	}

	public void setLokumID(int lokumID) {
		this.lokumID = lokumID;
	}


}
