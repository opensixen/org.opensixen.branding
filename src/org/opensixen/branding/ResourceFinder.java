package org.opensixen.branding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.compiere.apps.AEnv;
import org.opensixen.osgi.interfaces.IResourceFinder;

public class ResourceFinder implements IResourceFinder {

	public ResourceFinder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public URL getResource(String name) {
		URL url = getClass().getResource("/" + name);
	
		if (url == null)	{
			copy(name);					
		}
				
		url = getClass().getResource("/" + name);
		return url;
	}
	
	private void copy (String name)	{
		try{
			File f1 = new File("/home/harlock/workspace/workspace-opensixen-born//client/src/org/compiere/" + name);
			
			if (!f1.exists())	{
				return;
			}
			File f2 = new File("/home/harlock//workspace/workspace-opensixen-born/org.opensixen.branding/"+name);
			
		      InputStream in = new FileInputStream(f1);
		      
		      //For Append the file.
//		      OutputStream out = new FileOutputStream(f2,true);

		      //For Overwrite the file.
		      OutputStream out = new FileOutputStream(f2);

		      byte[] buf = new byte[1024];
		      int len;
		      while ((len = in.read(buf)) > 0){
		        out.write(buf, 0, len);
		      }
		      in.close();
		      out.close();
		      System.out.println("File copied.");
		    }
		    catch(FileNotFoundException ex){
		      System.out.println(ex.getMessage() + " in the specified directory.");
		      System.exit(0);
		    }
		    catch(IOException e){
		      System.out.println(e.getMessage());      
		    }
	}
}
