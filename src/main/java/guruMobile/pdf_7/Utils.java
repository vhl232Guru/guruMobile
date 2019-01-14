package guruMobile.pdf_7;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;

public class Utils {
	public static void saveInPDF(WebDriver driver, String fileName){
		try{
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("screenshot.png"));
			Document document = new Document(PageSize.A3, 20, 20, 20, 20);
			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			Image image = Image.getInstance("screenshot.png");
			document.add(image);
			document.close();

		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
