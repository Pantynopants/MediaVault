package myapp.coreservlets;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

//http://www.iteye.com/topic/763926
//http://blog.csdn.net/fznf1010/article/details/8054165
public class XMLUtil {
	
	public static void readXML(String fileAbsolutePath){  
		
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        try {  
        	
        	File source = new File(fileAbsolutePath);
        	String newFilePathDir = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("."));
            File tempXMLFile = new File(newFilePathDir + ".xml");
        	source.renameTo(tempXMLFile);
            System.out.println(tempXMLFile.getAbsolutePath());
            
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(tempXMLFile); 
            
            Element element = doc.getDocumentElement();  
            // 鉂衡叅鐢ㄦ柟娉曢亶鍘嗛�掑綊鎵撳嵃鏍瑰厓绱犱笅闈㈡墍鏈夌殑ElementNode(鍖呮嫭灞炴��,TextNode闈炵┖鐨勫��),鐢ㄧ┖鏍煎垎灞傛鏄剧ず.  
            listAllChildNodes(element, 0);// 鍙傛暟0琛ㄧず璁惧畾鏍硅妭鐐瑰眰娆′负0,瀹冪殑鍓嶉潰涓嶆墦鍗扮┖鏍�.  
  
//            NodeList mediaList = null;
//            NodeList tvshow = doc.getElementsByTagName("tvshow");
//            NodeList episodedetails = doc.getElementsByTagName("episodedetails");
//            NodeList album = doc.getElementsByTagName("album");
//            
//            if (tvshow.getLength() != 0) {
//            	mediaList = tvshow;
//			}else if (episodedetails.getLength() != 0) {
//				mediaList = episodedetails;
//			}else {
//				mediaList = album;
//			}
////            System.out.println("have " + mediaList.getLength() + " ");  
//            for (int i = 0; i < mediaList.getLength(); i++)  
//            {  
//                Node oneOfMedia = mediaList.item(i);  
//                NodeList oneOfMediaList = oneOfMedia.getChildNodes();
//                Element elem = (Element) oneOfMedia;  
////                System.out.println("id:" + elem.getAttribute("id"));  
//                for (int j = 0; j < oneOfMediaList.getLength(); j++) {
//                	
//                	Node node = oneOfMediaList.item(j);
//                    NodeList nestXML = node.getChildNodes();
//                    if (nestXML.getLength() == 1) {
//                    	String name = node.getNodeName();
//                        String value = node.getFirstChild().getNodeValue();
//                        System.out.print(name + ":" + value + "\t");
//					} else {
//						for (int k = 0; k < nestXML.getLength(); k++) {
//	                    	node = nestXML.item(j);
//	                    	String name = node.getNodeName();
//	                    	String value = node.getNodeValue();
//							System.out.print(":" + value + "\t");
//							
//						}
//					}
//                     
//                    
//                    
//                    
//				}
////                for (Node node = oneOfMedia.getFirstChild(); node != null; node = node.getNextSibling())  
////                {  
////                    if (node.getNodeType() == Node.ELEMENT_NODE)
////                    {  
////                        String name = node.getNodeName();  
////                        String value = node.getFirstChild().getNodeValue();
////                        for(;node.getFirstChild() != null; node.getFirstChild().getNextSibling()){
////                        	value = node.getFirstChild().getNodeValue();
////                        }
////                        System.out.print(name + ":" + value + "\t");  
////                        
////                    }  
////                }  
//                System.out.println();  
//            }  
//            
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
//        return null;
    }  
	
	
	public static void listAllChildNodes(Node node, int level) {  
        // 鍙鐞咵lementNode绫诲瀷鐨勮妭鐐�,鎰熻杩欑绫诲瀷鐨勮妭鐐�(杩樻湁鏈夋晥鐨勬枃鏈妭鐐�)鎵嶆槸鐪熸鏈夌敤鐨勬暟鎹�,鍏朵粬娉ㄩ噴鑺傜偣,绌虹櫧鑺傜偣绛夐兘鐢ㄤ笉涓�.  
        if (node.getNodeType() == Node.ELEMENT_NODE) {  
            boolean hasTextChild = false;// 鍙橀噺琛ㄧず璇ヨ妭鐐圭殑绗竴涓瓙鑺傜偣鏄惁灏辨槸涓�涓湁鏈夋晥鍐呭鐨勬枃鏈妭鐐�)  
            // 鈪犫澏銆愭墦鍗� - 绌烘牸銆戠┖鏍肩殑闀垮害 - level(n绾lementNode鏈塶涓暱搴︾殑绌烘牸鍦ㄥ墠闈�)  
            String levelSpace = "";  
            for (int i = 0; i < level; i++) {  
                levelSpace += "    ";  
            }  
            // 鈪♀澐銆愭墦鍗� - 寮�濮嬫爣绛俱�戝厛鎵撳嵃ElementNode鐨勫紑濮嬫爣绛�(鏈夊睘鎬х殑璇濅篃瑕佹墦鍗�)  
            System.out.print(levelSpace + "<" + node.getNodeName()  
                    + (node.hasAttributes() ? " " : ">"));// 鏈夊睘鎬х殑璇濊妭鐐圭殑寮�濮嬫爣绛惧悗闈㈢殑灏栨嫭鍙�">"灏辩暀寰呭睘鎬ф墦鍗板畬鍐嶆墦鍗�  
            // 鈪⑩澑銆愭墦鍗� - 灞炴�с�戦亶鍘嗘墦鍗拌妭鐐圭殑鎵�鏈夊睘鎬�  
            if (node.hasAttributes()) {  
                NamedNodeMap nnmap = node.getAttributes();  
                for (int i = 0; i < nnmap.getLength(); i++) {  
                    System.out.print(nnmap.item(i).getNodeName()  
                            + "=\""// 瀛楃涓查噷鍚弻寮曞彿瑕佺敤鍒拌浆涔夊瓧绗  
                            + nnmap.item(i).getNodeValue() + "\""  
                            + (i == (nnmap.getLength() - 1) ? "" : " "));// 涓嶆槸鏈�鍚庝竴涓睘鎬х殑璇濆睘鎬т箣闂磋鐣欑┖闅�  
                }  
                System.out.print(">");// 寮�濮嬫爣绛鹃噷鐨勫睘鎬у叏閮ㄦ墦鍗板畬鍔犱笂灏栨嫭鍙�">"  
            }  
            // 鈪ｂ澒銆愭墦鍗� - 瀛愯妭鐐广�戣ElementNode鍖呭惈瀛愯妭鐐规椂鍊欑殑澶勭悊  
            if (node.hasChildNodes()) {  
                level++;// 鏈変笅涓�绾у瓙鑺傜偣,灞傛鍔�1,鏂扮殑灞傛琛ㄧず鐨勬槸杩欎釜瀛愯妭鐐圭殑灞傛(閫掑綊璋冪敤鏃朵紶缁欎簡瀹�)  
                // 鑾峰緱鎵�鏈夌殑瀛愯妭鐐瑰垪琛�  
                NodeList nodelist = node.getChildNodes();  
                // 寰幆閬嶅巻鍙栧埌鎵�鏈夌殑瀛愯妭鐐�  
                for (int i = 0; i < nodelist.getLength(); i++) {  
                    // 鈪ｂ澒鉂躲�愭湁鏁堟枃鏈瓙鑺傜偣銆戝瓙鑺傜偣涓篢extNode绫诲瀷,骞朵笖鍖呭惈鐨勬枃鏈唴瀹规湁鏁�  
                    if (nodelist.item(i).getNodeType() == Node.TEXT_NODE  
                            && (!nodelist.item(i).getNodeValue()  
                                    .matches("\\s+"))) {// 鐢ㄦ鍒欓�夊彇鍐呭鍖呭惈闈炵┖鏍肩殑鏈夋晥瀛楃鐨勬枃鏈妭鐐�  
                        hasTextChild = true;// 璇lementNode鐨勪竴绾у瓙鑺傜偣鏄瓨鍦ㄦ湁鏁堝瓧绗︾殑鏂囨湰鑺傜偣  
                        System.out.print(nodelist.item(i).getNodeValue()  );// 鍦ㄥ紑濮嬫爣绛惧悗闈㈡坊鍔犳枃鏈唴瀹�  
                        // 鈪ｂ澒鉂枫�怑lementNode瀛愯妭鐐广�戝瓙鑺傜偣鏄甯哥殑ElementNode鐨勫鐞�  
                    } else if (nodelist.item(i).getNodeType() == Node.ELEMENT_NODE) {  
                        System.out.println();  
                        // 閫掑綊璋冪敤鏂规硶 - 浠ラ亶鍘嗚鑺傜偣涓嬮潰鎵�鏈夌殑瀛愯妭鐐�  
                        listAllChildNodes(nodelist.item(i), level);// level琛ㄧず璇ヨ妭鐐瑰浜庣鍑犱釜灞傛(鐩稿簲绌烘牸)  
                    }  
                }  
                level--;
            }   
            System.out.print(((hasTextChild) ? "" : "\n" + levelSpace) + "</"  
                    + node.getNodeName() + ">");  
        }  
    } 
	
	
}
