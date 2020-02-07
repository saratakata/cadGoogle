package testQa.google.tela;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TelaVerificarTel extends AbstractTela {
	
	public TelaVerificarTel(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public void informarPais(String codPais) throws InterruptedException {
		driver.findElement(By.id("phoneNumberId")).click();
		driver.findElement(By.id("phoneNumberId")).sendKeys(codPais);
		
	}

	public void preencherTel(String tel) {
		
		driver.findElement(By.id("phoneNumberId")).sendKeys(tel);
	}	
	
	public void selecionarProximo() {
		driver.findElement(By.id("gradsIdvPhoneNext")).click();
	}
	
	public String validarMsgErro() throws InterruptedException{
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//*[@id='view_container']/form/div[2]/div/div[1]/div/div[2]/div[2]")).getText();
	}
	
}