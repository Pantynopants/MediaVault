package myapp.coreservlets;


import java.io.* ;
import java.util.* ;

import org.jdom2.* ;
import org.jdom2.input.* ;


public class XMLTVShowReader {
	private ArrayList<String> title;
	private ArrayList<String> plot;
	private ArrayList<String> runtime;
	private ArrayList<String> genre;
	private ArrayList<String> studio;
	private ArrayList<String> thumb;
	
	public XMLTVShowReader(String filepath) throws Exception {
        SAXBuilder builder = new SAXBuilder() ;
		title = new ArrayList<String>();
		plot = new ArrayList<String>();
		runtime = new ArrayList<String>();
		genre = new ArrayList<String>();
		studio = new ArrayList<String>();
		thumb = new ArrayList<String>();
		
		File files = new File(filepath);
		if(files.isDirectory()){
		    File[] filelist = files.listFiles();
		    for (int i = 0; i < filelist.length; i++) {
		        File readfile = new File(filepath + "/" + filelist[i].getName());
		 		if (!readfile.isHidden()) {
					Document read_doc = builder.build(readfile);
					Element root = read_doc.getRootElement();

					
					title.add(root.getChildText("title"));
					plot.add(root.getChildText("plot"));
					runtime.add(root.getChildText("runtime"));
					genre.add(root.getChildText("genre"));
					studio.add(root.getChildText("studio"));
					thumb.add(root.getChildText("thumb"));
				}

		    }

		}
		
		
	}
	
	public ArrayList<String> getTitle(){
		return this.title;
	}
	
	public ArrayList<String> getPlot(){
		return this.plot;
	}
	
	public ArrayList<String> getRuntime(){
		return this.runtime;
	}
	
	public ArrayList<String> getGenre(){
		return this.genre;
	}
	
	public ArrayList<String> getStudio(){
		return this.studio;
	}
	public ArrayList<String> getThumb(){
		return this.thumb;
	}
}


