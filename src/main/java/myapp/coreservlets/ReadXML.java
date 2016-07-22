package myapp.coreservlets;

import java.io.* ;
import java.util.* ;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.*;
import org.jdom2.*;

public class ReadXML {
	public static ArrayList<HashMap<String, String>> readXML(String fileAbsolutePath) {
		ArrayList<HashMap<String, String>> returnStr = new ArrayList<HashMap<String, String>>();
		
		
		System.out.println("in ReadXML");
		System.out.println(fileAbsolutePath);
		SAXBuilder builder = new SAXBuilder() ;
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
		Element root = read_doc.getRootElement() ;	// ȡ�ø�
		List<Element> list = root.getChildren() ;	// �õ����е�linkman
		System.out.println(root.getChildText("title") );
		//System.out.println(list.size());
		for(Element e : list){
			
			HashMap<String, String> tempMap = new HashMap<>();
			tempMap.put("link", "songMenu2.html");
			//Element e = (Element) list.get(x);
			String name = e.getChildText("title") ;	// �õ�name�ӽڵ������
//			String id = e.getChild("name").getAttribute("id").getValue() ;
			String artist = e.getChildText("artist") ;
			String genre = e.getChildText("genre") ;
			String review = e.getChildText("review") ;
			String actor = e.getChildText("actor") ;
			
			System.out.println("-------------- item -------------") ;
			System.out.println("name: " + name ) ;
//			returnStr.set(2, e.getChildText("name"));
			tempMap.put("name", name);
			
			System.out.println("artist: " + artist) ;
			System.out.println("genre: " + genre) ;
			System.out.println("review: " + review) ;

			System.out.println("actor: ") ;
			//System.out.println(e.getChildren("actor").size());
			for (Element e1 : e.getChildren("actor")) {
				System.out.println("name: " +e1.getChildText("name"));
				System.out.println("role: " +e1.getChildText("role"));
				String thumb = e1.getChildText("thumb") ;
				System.out.println("thumb: " + thumb);
				
//				returnStr.set(1, e1.getChildText("thumb"));
				tempMap.put("thumb", thumb);
			}
			System.out.println("-----------------------------------") ;
			
			returnStr.add(tempMap);
		}
		
		System.out.println("end ReadXML");
		return returnStr;
		
	}
}