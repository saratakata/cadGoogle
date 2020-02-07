package testQa.teste.qa.dto;

public class ReportConfig {
	
	private String projeto = "";
	
	private String responsavel = "";
	
	private String casodeTeste = "";
	
	private String outputDir = "";
	
	
	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public String getCasodeTeste() {
		return casodeTeste;
	}

	public void setCasodeTeste(String casodeTeste) {
		this.casodeTeste = casodeTeste;
	}

	public String getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
	
}
