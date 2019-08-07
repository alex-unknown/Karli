package util.geom;
import java.awt.Graphics;
public class LineI
{
    VektorI p1;
    VektorI p2;
    public LineI(VektorI p1,VektorI p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public LineI(int x1, int y1, int x2, int y2){
        this(new VektorI(x1,y1), new VektorI(x2, y2));
    }
    public VektorI getVektor(){
        return p2.subtract(p1);
    }
    public double getLength(){
        return getVektor().getLength();
    }
    public void paint(Graphics g){
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
