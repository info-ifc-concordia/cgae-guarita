package br.edu.ifc.concordia.inf.cgaeguarita;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;


public class ImagesUpload {

	private File imagesFile;
	
	public ImagesUpload(ServletContext context) {
		String imagesPath = context.getRealPath("/WEB-INF/images");
		imagesFile = new File(imagesPath);
		imagesFile.mkdir();
	}
	
	@UploadSizeLimit(sizeLimit=40 * 1024 * 1024, fileSizeLimit=10 * 1024 * 1024)
	public void saveImage(UploadedFile image,
			String studentRegistration) {
		File fileTo = new File(imagesFile, image.getFileName());
		try {
		      IOUtils.copy(image.getFile(), new FileOutputStream(fileTo));
		    } catch (IOException e) {
		    	throw new RuntimeException("Erro ao copiar imagem", e);
		    }
	}
	
	public File showImage(String studentRegistration) {
		return new File(imagesFile, studentRegistration + ".jpg");
	}
	
}
