package kochkurven;

import java.util.List;

public class Verwaltung {
	
	private Initiator initiator;
	private Generator generator;
	private Display display;
	private List<Linie> alleLinien;
	

	public Verwaltung(Display display) {
		this.display = display;
	}
	
	
	
	public void initInitiator(String eingabe, boolean innen) {
		
	}
	public void initGenerator(int code, String eingabe) {
		// 0 fuer Gen 1
		// 1 fuer Gen 2
		// 2 fuer GenCustom
		
		
	}
	
	
	public void verwalten() {
		display.communicate("Works");
		
	}
	
}
