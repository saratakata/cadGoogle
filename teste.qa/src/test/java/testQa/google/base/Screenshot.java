package testQa.google.base;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	private WebDriver driver = null;
	
	private WebDriver getDriver() {
		return driver;
	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public Screenshot( WebDriver driver)
	{
		setDriver(driver);
	}
	
	
	/**
	 * Tira o 'print screen' da tela
	 * 
	 */
	public InputStream getScreenshot()
	{
		InputStream targetStream = null;
		byte[] byteArray = null;
		
		if(getDriver()!=null){			
						
			byteArray = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
			
			targetStream  = new ByteArrayInputStream(byteArray);
		}
		return targetStream;
	}

}
