package testQa.teste.qa;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import testQa.google.tela.TelaFakeName;
import testQa.teste.qa.dto.DTNascimento;
import testQa.teste.qa.dto.Pessoa;
import testQa.teste.qa.utils.Utils;



public class GeraMassa 
{

        
    /**
     * Gerador de nomes.
     */
    public void getGeradordeNome() 
	{	
    	String ph = getPath();
    	System.out.println(ph+"/browser");
    	System.setProperty("webdriver.chrome.driver", ph+"/browser/chromedriver.exe"); 
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
        options.addArguments("enable-automation"); 
        options.addArguments("--headless"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars"); 
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--disable-browser-side-navigation"); 
        options.addArguments("--disable-gpu"); 
        options.addArguments("--dns-prefetch-disable");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        
        WebDriver driver = new ChromeDriver(options); 
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);

		List<Pessoa> massa = new ArrayList<Pessoa>();
		
		Pessoa p1 = new Pessoa();
		p1.setGenero("masculino");
		p1.setPais("Australia");
		p1.setConfig("gen-male-au-au");
		
		
		Pessoa p2 = new Pessoa();
		p2.setGenero("masculino");
		p2.setPais("Alemanha");
		p2.setConfig("gen-male-gr-gr");
		
		Pessoa p3 = new Pessoa();
		p3.setGenero("masculino");
		p3.setPais("Republica Tcheca");
		p3.setConfig("gen-male-cs-cz");
		
		massa.add(p1);
		massa.add(p2);
		massa.add(p3);
		
		TelaFakeName fk = new TelaFakeName(driver);
		
		for (int i = 0; i < massa.size(); i++) {

			driver.get("https://www.fakenamegenerator.com/"+massa.get(i).getConfig()+".php");
			
			fk.waitButton();			
			fk.clickGenerate();
			
			formataNome( massa.get(i), fk.getNome());
			formataDTNascimento(massa.get(i),fk.getDataNascimento());
			massa.get(i).setTelefone(fk.getFone());
			massa.get(i).setCodigoPais(fk.getCodigoPais());
			
		}
		String arquivoMassa = getPath()+"/massa/massa.csv";
		Utils.removeArquivo(arquivoMassa);
		Utils.geraArquivoCSV(massa, arquivoMassa);
		driver.quit();
	}
    
    /**
     * Formata a data de nascimento.
     * 
     * @param pessoa
     * @param data
     */
    private void formataDTNascimento(Pessoa pessoa, String data)
    {
    	DTNascimento aniv = new DTNascimento();
    	
    	try {
	    	String[] dt = data.split(" ");
	    	
	    	String dia = dt[1].replace(",", "").trim();
	    	if(dia.length()==1) dia = "0"+dia;
	    	aniv.setDia(dia);
	    	aniv.setMes(traduzMes(dt[0]));
	    	aniv.setAno(dt[2]);
	
	    	pessoa.setDtNascimento(aniv);
    	}catch (Exception e) {
			System.out.println("Erro no parse: "+data);
		}
    }
    
    /**
     * Traduz o mes.
     * 
     * @param mesExtenso
     * @return
     */
    private String traduzMes(String mesExtenso)
    {
    	HashMap<String,String> mes = new HashMap<String,String>();
    	
    	mes.put("january", "01");
    	mes.put("february", "02");
    	mes.put("march", "03");
    	mes.put("april", "04");
    	mes.put("may", "05");
    	mes.put("june", "06");
    	mes.put("july", "07");
    	mes.put("august", "08");
    	mes.put("september", "09");
    	mes.put("october", "10");
    	mes.put("november", "11");
    	mes.put("december", "12");

    	String ret = "";
    	if(mes.containsKey(mesExtenso.toLowerCase())){
    		ret = mes.get(mesExtenso.toLowerCase());
    	}
   	
    	return ret;
    }
    
    /**
     * Formata o nome e sobrenome.
     * 
     * @param pessoa
     * @param nome
     */
    private void formataNome(Pessoa pessoa, String nome)
    {
    	try {
	    	String[] nm =  nome.split(" ");
	    	
	    	pessoa.setNome(nm[0]);
	    	pessoa.setSobrenome(nome.replace(nm[0], "").trim());
    	}catch (Exception e) { }
    }
    
    /**
     * Pega o caminho atual dos arquivos.
     * @return
     */
    public String getPath()
    {
    	Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        
    	return s;
    }
    
}
