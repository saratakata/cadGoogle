package testQa.google.tela;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testQa.google.base.AbstractTestCase;

public class AbstractTela {

	public static Logger logger = Logger.getLogger(AbstractTela.class);
	protected WebDriver driver;
	public static final int TIMEOUT = 10;
	public static String TELA_HOME_URL = 
			AbstractTestCase.url;
	

	public AbstractTela(WebDriver driver) {
		this.driver = driver;
	}
		
	protected boolean isTextPresent(String validParameter) {
		List<WebElement> elements = driver.findElements(By.partialLinkText(validParameter));
		if (elements.isEmpty() || (elements == null)) {
			logger.info("TST - '" + validParameter + "' não encontrado!");
			return false;
		} else {
			logger.info("TST - '" + validParameter + "' está presente!");
			return true;
		}

	}
}
