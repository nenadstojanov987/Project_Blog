package blog.main.services;

import java.nio.file.Path;

import org.springframework.stereotype.Service;

 

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
 
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
 
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
 

@Service
public class FileUploadService {
	@Autowired
	private ServletContext servletContext;
	 
	public String  uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		   
		 String uploadDirectory = System.getProperty("user.home")+"/Desktop/Project_Blog_Nenad/src/main/webapp/resources/images/";
		 
		 Instant instant = Instant.now();
		 long timestamp = instant.toEpochMilli();
		 
		 String originalFileName = file.getOriginalFilename();
		 originalFileName = originalFileName.replace(" ", "_");
			String newFileName = "ts_"+timestamp+"_"+originalFileName;
			 
			 File uploadFile = new File(uploadDirectory + newFileName);
			  
			 
		    try {				
				file.transferTo(uploadFile);
				System.out.println(uploadFile.getAbsolutePath());
				String filePath = "images/"+ newFileName;
				return filePath;
		         
		    } catch (IOException e) {
		       e.printStackTrace();
		       return null;
		    }
		 
		  
		 
	}
	
	
	 
}
