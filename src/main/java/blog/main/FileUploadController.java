package blog.main;

 
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import blog.main.services.FileUploadService;


@RestController
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;
	
	@PostMapping
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		String fileUploadPath = fileUploadService.uploadFile(file);
		return fileUploadPath;
	}
	  
}
