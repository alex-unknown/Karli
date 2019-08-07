package karli;
import util.geom.*;


import java.awt.*;
import java.util.*;
public class Track
{
    ArrayList<LineI> edges = new ArrayList<LineI>();
    ArrayList<Car> cars = new ArrayList<Car>();
    public Frame frame;
    public Track(){
        this.frame = new Frame(this);
        String[] in;
        try{
            in = util.IoTools.getInput("track.txt");
        }catch(Exception e){return;};
        for(int i = 0; i<in.length; i++){
            String[]points = in[i].split(" ");
            edges.add(new LineI(Integer.parseInt(points[0]), Integer.parseInt(points[1]), Integer.parseInt(points[2]), Integer.parseInt(points[3])));
        }
        cars.add(new Car(new VektorI(300,100),1));
    }
    public void repaint(){
        if (frame != null)frame.repaint();
    }
    public void paint(Graphics g){
        for(int i = 0; i < edges.size(); i++){
            edges.get(i).paint(g);
        }
        for(int i = 0;i < cars.size(); i++){
            cars.get(i).paint(g);
        }
    }
    
    public static void main(String[]args) {
    	new Track();
    }
}
