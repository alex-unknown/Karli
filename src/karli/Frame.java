package karli;
import util.geom.*;
import nn.Net;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static VektorI size = new VektorI(800,700);
    public Track t;
    public Frame(Track t){
        // Grafik:
        super("Karli");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(size.x, size.y);
        setVisible(true);
        
        // Anderes
        this.t = t;
    }
    
    
    public void paint(Graphics g){
        t.paint(g);
    }
    
    public static void main(String[]args) {
    	new Track();
        Net net = new Net("default.net");
        System.out.println(net);
    }
}
