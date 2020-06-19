package application.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadDati {
	
	private static String url = "http://webservices.ingv.it/fdsnws/event/1/query?starttime=2019-04-28T00%3A00%3A00&minmag=2&maxmag=10&mindepth=-10&maxdepth=1000&minlat=-90&maxlat=90&minlon=-180&maxlon=180&minversion=100&orderby=time-asc&format=text&limit=10000";
	
	private static String localFile = "dati.txt";
	
	
	
	public static void downloadFile() {
		
		try
        {
			URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(localFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
	}
	
	
}
