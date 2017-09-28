package br.edu.ifc.concordia.inf.cgaeguarita;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.edu.ifc.concordia.inf.cgaeguarita.model.Student;


@ApplicationScoped
public class ImagesUpload {

	private String IMG_PATH;
	
	public void IMG_PATH(@Observes ServletContext ctx) {
		IMG_PATH = ctx.getRealPath("/WEB-INF/images");
		File imagesDir = new File(IMG_PATH);
		if (!imagesDir.exists())
			imagesDir.mkdir();
	}
	
	public void saveImage(UploadedFile image, Student student) {
		File fileTo = new File(IMG_PATH, student.getRegistration()+"-"+image.getFileName());
		try {
			OutputStream out = new FileOutputStream(fileTo);
			IOUtils.copy(image.getFile(), out);
			out.close();
	    } catch (IOException e) {
	    	throw new RuntimeException("Erro ao copiar imagem", e);
	    }
		student.setImage(fileTo.getAbsolutePath());
		student.setImageType(image.getContentType());
	}
	
}
