package libs.resources;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Resources {

//    public static File getFile(String path) {
//        return new File(Resources.getURI(path));
//    }

//    public static String readFile(String path) {
//        try {
//            String read = Files.readString(Resources.getFile(path).toPath());
//            return read;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
    public static String readFile(String path) {
        InputStreamReader s = new InputStreamReader(ClassLoader.getSystemResourceAsStream(path));
        BufferedReader reader = new BufferedReader(s);
        
        StringBuffer sb = new StringBuffer();
        String str;
        try {
            while((str = reader.readLine())!= null){
               sb.append(str + "\n");
            }
            return sb.toString();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
    
    public static Image getSwingImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(ClassLoader.getSystemResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
