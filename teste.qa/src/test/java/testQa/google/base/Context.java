package testQa.google.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Context {

	private static Context context = null;
	private static final String FILE_NAME = "test.properties";
	private Properties config = null;

	private Context() {
		config = getProperties();
	}

	/**
	 * Retorna a instancia do contexto.
	 * 
	 * @return Objeto Context
	 */
	public static Context getInstance() {
		if (context == null) { 
			context = new Context(); 
		} 
		return context;
	}

	private Properties getProperties() {

		Properties properties = new Properties();
		try {
			//FileInputStream fis = new FileInputStream(new File(path));
			FileInputStream fis = new FileInputStream(new File(FILE_NAME));
			properties.load(fis);
			fis.close();
		} catch (Exception e) {
			
		}
		return properties;
	}

	/**
	 * Retorna o valor da propriedade informada.
	 * 
	 * @param propertyKey
	 *            propriedade existente no arquivo.
	 * @return valor da propriedade informada.
	 */
	public String getProperty(String propertyKey) {
		if (config.containsKey(propertyKey)) {
			return config.getProperty(propertyKey);
		}
		return null;
	}

	/**
	 * Retorna as configuracoes disponiveis.
	 * 
	 * @return Array com as configuracoes disponiveis.
	 */
	public String[] getKeys() {
		String[] arr = new String[config.size()];
		Enumeration<Object> en = config.keys();
		if (en != null) {
			int i = 0;
			while (en.hasMoreElements()) {
				arr[i] = (String) en.nextElement();
				i++;
			}
			return arr;
		}
		return new String[] {};
	}

	public void printProperties() {
		config.list(System.out);
	}
	
	

}
