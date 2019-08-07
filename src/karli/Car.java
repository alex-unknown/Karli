package karli;
import util.geom.*;
import java.awt.*;


public class Car
{
	/**
	 * Postion des Autos in Pixeln
	 */
    public VektorI pos;
    
    /**
     * Rotation relativ zu VektorI(1|0)  (gegen Uhrzeigersinn positiv)
     */
    public double rotation;
    
    /**
     * Geschwindigkeit in Pixel/s
     */
    public VektorI velocity;
    
    /**
     * Größe des Autos; aktuell muss x = 2y sein
     */
    public VektorI hitbox = new VektorI(20,10);
    
    /**
     * Erstellt ein neues Auto
     * @param pos
     * @param rotation
     */
    public Car(VektorI pos, double rotation){
        this.pos = pos;
        this.rotation = rotation;
        this.velocity = new VektorI(0,0);
    }
    
    
    
    /**
     * Zeichnet ein rechteckiges "Auto"
     * Kann aktuell nur Autos mit Hitbox x=2y zeichnen. Sollte überarbeitet werden...
     * @param g
     */
    public void paint(Graphics g){
    	// die Länge von der Mitte des Autos in eine der beiden Ecken
        double d = hitbox.toDouble().multiply(0.5).getLength();
        // ermittelt alle Koords der Eckpkts mithilfe von Winkeln ausgehend vom Mittelpunkt
        int[]px = {pos.x + (int)(Math.sin(rotation + 1.107147866)*d),
                   pos.x + (int)(Math.sin(rotation + 2.034443043)*d),
                   pos.x + (int)(Math.sin(rotation + 4.248742265)*d),
                   pos.x + (int)(Math.sin(rotation + 5.176035696)*d)};
        int[]py = {pos.y + (int)(Math.cos(rotation + 1.107147866)*d),
                   pos.y + (int)(Math.cos(rotation + 2.034443043)*d),
                   pos.y + (int)(Math.cos(rotation + 4.248742265)*d),
                   pos.y + (int)(Math.cos(rotation + 5.176035696)*d)};           
        g.fillPolygon(px, py, 4);
    }
}
