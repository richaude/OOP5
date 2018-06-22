package kochkurven;

import java.util.ArrayList;
import java.util.List;

public class Initiator {
	private String eingabe;
	private List<Linie> linien;
	
	public Initiator(String eingabe) {
		this.eingabe = eingabe;
		this.linien = new ArrayList<Linie>();
	}

	public void parseString() {
		
	}
	public List<Linie> getLinien() {
		return this.linien;
	}
}
