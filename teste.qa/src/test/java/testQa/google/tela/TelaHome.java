package testQa.google.tela;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class TelaHome extends AbstractTela {
	
	public TelaHome(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public void abrirSite(String url) {
		driver.get(url);
	}

	public void preencherNome(String nome) {
		driver.findElement(By.id("firstName")).click();
		driver.findElement(By.id("firstName")).sendKeys(nome);
	}	
	
	public void preencherSobreNome(String sobreNome){
		driver.findElement(By.id("lastName")).click();
		driver.findElement(By.id("lastName")).sendKeys(sobreNome);
	}
	
	public void preencherUserName(String user){
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys(user);
	}
	
	public void preencherSenha(String senha){
		driver.findElement(By.xpath("//*[@id='passwd']/div[1]/div/div[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='passwd']/div[1]/div/div[1]/input")).sendKeys(senha);
	}
	
	public void preencherConfirmarSenha(String senha){
		driver.findElement(By.xpath("//*[@id='confirm-passwd']/div[1]/div/div[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='confirm-passwd']/div[1]/div/div[1]/input")).sendKeys(senha);
	}
	
	public void selecionarProximo(){
		driver.findElement(By.id("accountDetailsNext")).click();
	}
}