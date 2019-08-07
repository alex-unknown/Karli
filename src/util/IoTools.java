package util;

import java.io.*;
/**
 * Input/Output Tools
 */
public abstract class IoTools
{
	public static String newLine = "\r\n";
	
    public static String[] getInput(String fileName) throws IOException{
        FileInputStream in = null;
        try {
            String text = "";
            in = new FileInputStream(fileName);
            int inC;
            while ((inC=in.read())!=-1){
                text=text+(char) inC;   //nur ASCII-Zeichen
            }
            //System.out.println("Input "+ fileName + ": " + text);
            String[] zeilen=text.split(newLine);  // geht nur mit dem Windows Dateisystem!!!
            return zeilen;
        }
        catch (IOException e){
            //System.out.println("Die Datei input.txt konnte nicht gelesen werden: " + e.getMessage());
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
        return null;
    }

    public static void printOut(String fileName, String s) {
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(fileName);
            for (int i=0;i<s.length();i++){
                int c=(int) s.charAt(i);
                out.write(c);
            }
            out.write(10);
        }
        catch (IOException e){
            System.out.println("Die Datei output.txt konnte nicht beschrieben werden: " + e.getMessage());
        }
        finally{
            try{
                if (out!=null)out.close();
            }catch(Exception e){System.out.println("Fehler in einer Ausgabedatei");}
        }
    }
    
}
