package testQa.teste.qa.dto;

import java.io.Serializable;
import java.util.List;
public class TestCase implements Serializable {

	private static final long serialVersionUID = 7944514266528757334L;
	private String status;
	
	private List<Step> steps;
	
	public TestCase(){}
	
	public TestCase(Integer id, String name, String status, List<Step> steps)
	{
		this.status = status;
		this.steps = steps;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}