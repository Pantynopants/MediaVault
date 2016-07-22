package myapp.util;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jdom2.*;
import org.jdom2.output.XMLOutputter;

import com.jspsmart.upload.*;
import com.jspsmart.*;

import myapp.coreservlets.*;
import myapp.model.*;
import myapp.modelDAO.*;
import myapp.util.*;
import myapp.service.*;

public class SaveFile {
	public static Map<String, String> savefile(com.jspsmart.upload.File myfile, String localPath) throws SmartUploadException, IOException {
		String fileName = "";
		fileName = myfile.getFileName();  
        System.out.println(fileName);
        
        String fileRootPath = "";
        String relativePath = "";
        String fileType = "";
        
        if (fileName.endsWith("mp4") || fileName.endsWith("wmv")) {
        	relativePath = "\\video\\";
        	fileType = "Address";
		}else if (fileName.endsWith("mp3") || fileName.endsWith("wav")) {
			relativePath = "\\music\\";
			fileType = "Address";
		}else if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
			relativePath = "\\images\\";
			fileType = "Cover";
		}else {
			relativePath = "\\resources\\";
			fileType = "Address";
		}
        
        fileRootPath = localPath + relativePath;
        System.out.println(fileRootPath);
//        count = mySmartUpload.save("/upload");  
//        realPath = request.getSession().getServletContext().getRealPath("/");
        
        File file = new File(fileRootPath);  
        if(!file.exists()) {  
      	  	file.mkdir();
            System.out.println("create folder " + file.getPath() + " OK");  
            
        } 
        
        fileRootPath += fileName;        
//        mySmartUpload.save(rootPath);        
        myfile.saveAs(fileRootPath);
        
        Map<String, String> files = new HashMap<>();
        files.put(fileType, relativePath + fileName);
        return files;
	}
}
