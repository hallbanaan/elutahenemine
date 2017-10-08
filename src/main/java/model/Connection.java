package model;

import javax.imageio.IIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

    public static boolean internetConnectionExisting(){
        try{
            final URL url = new URL("http://www.google.com");
            final URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (IIOException e){
            return false;
        }
    }
}
