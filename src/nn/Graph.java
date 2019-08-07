package nn;

import util.geom.*;

public class Graph {
	int matrix[][];
	
	public Graph(VektorI size) {
		this.matrix = new int[size.x][size.y];
	}

	public String toString() {
		String s  = "";
		for(int y = 0; y<matrix[0].length; y++) {
			for(int x = 0; x<matrix.length; x++) {
				if(matrix[x][y] != -1)s += matrix[x][y];
				s += ";";
			}
			s += util.IoTools.newLine;
		}
		return s;
	}
	
	public boolean set(int x, int y, int value) {
		try {
			matrix[x][y]=value;
			return true;
		}catch(Exception e) {return false;}
	}
	
	public int get(int x, int y) {
		try {
			return matrix[x][y];
		}catch(Exception e) {return -1;}
	}
	
	public int getX() {
		try {
			return matrix.length;
		}catch(Exception e) {return 0;}
	}
	
	public int getY() {
		try {
			return matrix[0].length;
		}catch(Exception e) {return 0;}
	}
	
	public VektorI getSize() {
		return new VektorI(getX(), getY());
	}
}
