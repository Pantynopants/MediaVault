package myapp.coreservlets;

import java.io.* ;
import java.util.* ;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.*;
import org.jdom2.*;

public class XMLReaderTrack {
	public static ArrayList<HashMap<String, String>> readXML(String fileAbsolutePath) {
		ArrayList<HashMap<String, String>> returnStr = new ArrayList<HashMap<String, String>>();
		
		
		System.out.println("in XMLReaderTrack");
		System.out.println(fileAbsolutePath);
		SAXBuilder builder = new SAXBuilder();
		
		Document read_doc = null;
		try {
			read_doc = builder.build(new File(fileAbsolutePath));
		} catch (JDOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Element root = read_doc.getRootElement();	// ȡ�ø�
		System.out.println(root.getChild("artist").getText());
		root = root.getChild("tracks");
		List<Element> list = root.getChildren("track");
		
//		List<Element> list = root.getChildren();	// get all the album in albums
//		System.out.println(root.getChildText("title") );
		System.out.println(list.size());
		for(Element e : list){
			
			HashMap<String, String> tempMap = new HashMap<>();
			tempMap.put("link", "index.jsp");
			//Element e = (Element) list.get(x);
			String name = e.getChildText("title") ;	// �õ�name�ӽڵ������
//			String id = e.getChild("name").getAttribute("id").getValue() ;
			String position = e.getChildText("position") ;
			String duration = e.getChildText("duration") ;
			
			tempMap.put("title", name);
			tempMap.put("position", position);
			tempMap.put("duration", duration);
			
			System.out.println("-------------- item -------------") ;
			System.out.println("name: " + name ) ;
//			returnStr.set(2, e.getChildText("name"));
			System.out.println("position: " + position) ;
			System.out.println("duration: " + duration) ;
			
			System.out.println("-----------------------------------") ;
			
			returnStr.add(tempMap);
		}
		
		System.out.println("end ReadXML");
		return returnStr;
		
	}
}