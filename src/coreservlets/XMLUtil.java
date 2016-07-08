package coreservlets;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;


public class XMLUtil {
	
	public static String readXML(String fileAbsolutePath)  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        try  
        {  
        	File source = new File(fileAbsolutePath);
        	String newFilePathDir = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("."));
            File tempXMLFile = new File(newFilePathDir + ".xml");
        	source.renameTo(tempXMLFile);
            System.out.println(tempXMLFile.getAbsolutePath());
            
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(tempXMLFile); 
  
            NodeList mediaList = null;
            NodeList tvshow = doc.getElementsByTagName("tvshow");
            NodeList episodedetails = doc.getElementsByTagName("episodedetails");
            NodeList album = doc.getElementsByTagName("album");
            
            if (tvshow.getLength() != 0) {
            	mediaList = tvshow;
			}else if (episodedetails.getLength() != 0) {
				mediaList = episodedetails;
			}else {
				mediaList = album;
			}
//            System.out.println("have " + mediaList.getLength() + " ");  
            for (int i = 0; i < mediaList.getLength(); i++)  
            {  
                Node oneOfMedia = mediaList.item(i);  
                NodeList oneOfMediaList = oneOfMedia.getChildNodes();
                Element elem = (Element) oneOfMedia;  
//                System.out.println("id:" + elem.getAttribute("id"));  
                for (int j = 0; j < oneOfMediaList.getLength(); j++) {
                	
                	Node node = oneOfMediaList.item(j);
                    NodeList nestXML = node.getChildNodes();
                    if (nestXML.getLength() == 1) {
                    	String name = node.getNodeName();
                        String value = node.getFirstChild().getNodeValue();
                        System.out.print(name + ":" + value + "\t");
					} else {
						for (int k = 0; k < nestXML.getLength(); k++) {
	                    	node = nestXML.item(j);
	                    	String name = node.getNodeName();
	                    	String value = node.getNodeValue();
							System.out.print(":" + value + "\t");
							
						}
					}
                     
                    
                    
                    
				}
//                for (Node node = oneOfMedia.getFirstChild(); node != null; node = node.getNextSibling())  
//                {  
//                    if (node.getNodeType() == Node.ELEMENT_NODE)
//                    {  
//                        String name = node.getNodeName();  
//                        String value = node.getFirstChild().getNodeValue();
//                        for(;node.getFirstChild() != null; node.getFirstChild().getNextSibling()){
//                        	value = node.getFirstChild().getNodeValue();
//                        }
//                        System.out.print(name + ":" + value + "\t");  
//                        
//                    }  
//                }  
                System.out.println();  
            }  
            
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        return null;
    }  
}
