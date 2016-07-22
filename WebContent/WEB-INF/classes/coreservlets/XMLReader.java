package coreservlets;

import java.io.* ;
import java.util.* ;

import org.jdom2.* ;
import org.jdom2.input.* ;


public class XMLReader {
	private ArrayList<String> title;
	private ArrayList<String> artist;
	private ArrayList<String> genre;
	private ArrayList<String> review;
	private ArrayList<String> thumb;
	
	public XMLReader(String filepath) throws Exception {
        SAXBuilder builder = new SAXBuilder() ;
		title = new ArrayList<String>();
		artist = new ArrayList<String>();
		genre = new ArrayList<String>();
		review = new ArrayList<String>();
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
					artist.add(root.getChildText("artist"));
					genre.add(root.getChildText("genre"));
					review.add(root.getChildText("review"));
					thumb.add(root.getChildText("thumb"));
					System.out.println(title.size());
				}

		    }

		}
		
		
	}
	
	public ArrayList<String> getTitle(){
		return this.title;
	}
	
	public ArrayList<String> getArtist(){
		return this.artist;
	}
	
	public ArrayList<String> getGenre(){
		return this.genre;
	}
	
	public ArrayList<String> getReview(){
		return this.review;
	}
	public ArrayList<String> getThumb(){
		return this.thumb;
	}
}

