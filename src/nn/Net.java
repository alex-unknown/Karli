package nn;

import util.geom.*;

public class Net {
	Graph g;
	/**
	 * enthält wichtige Informationen über das Netz (z.B.: Alter)
	 * darf keine "[", "]" und newLine Zeichen enthalten
	 */
	String info;  
	
	public Net(String data) {
		// Der Inhalt der Datei data (txt) wird ausgelesen
		String[] in;
        try{
            in = util.IoTools.getInput(data);
        }catch(Exception e){System.out.println("Fehler in der Datei "+ data + " #001"); return;}; // wenn Datei nicht vorhanden
        if(in.length <= 1){System.out.println("Fehler in der Datei "+ data + " #002"); return;} // oder die Datei 0 oder 1 Zeilen lang => abbruch
        
        // Die erste Zeile enthält den InfoString und die Größe des Netzes (<infoString> <Leertaste> <LängeX> <Leertaste> <GrößeY>)
        String[]infoLine = in[0].split(" ");
        if(infoLine.length <= 2 || !setInfo(infoLine[0])) {System.out.println("Fehler in der Datei "+ data + " #003"); return;}
        VektorI size;
        try {
        	size = new VektorI(Integer.parseInt(infoLine[1]), Integer.parseInt(infoLine[2]));
        }catch(Exception e) {System.out.println("Fehler in der Datei "+ data + " #004"); return;}
        this.g = new Graph(size);

        // Mit den anderen Zeilen wird die Matrix gefüllt
        for(int y = 0; y < size.y; y++) {
        	String[]yLine;
        	try {
        		yLine = in[y+1].split(";");
        	}catch(Exception e) {
        		yLine = new String[0];
        	}
        	
        	for(int x = 0; x < size.x; x++) {
        		try {
            		g.set(x, y, Integer.parseInt(yLine[x]));
            	}catch(Exception e) {
            		g.set(x, y, -1);  // Knoten nicht miteinander verbunden
            	}
            }
        }
        
        
	}
	
	
	public boolean setInfo(String info) {
		this.info = info;
		return true;
	}
	
	public String getMatrixString() {
		String s  = "";
		for(int y = 0; y<g.getY(); y++) {
			for(int x = 0; x<g.getX(); x++) {
				if(g.get(x, y) != -1)s += g.get(x, y);
				s += ";";
			}
			s += util.IoTools.newLine;
		}
		return s;
	}
	
	public String toString() {
		String s = info + " " + g.getX() + " " + g.getY() + util.IoTools.newLine;
		s += getMatrixString();
		return s;
	}
	
}
