package testQa.teste.qa;

public enum Status {

	 FAILED(0), PASSED(1), INVALID(2);
	
	 private final int valor;
	 
	 Status(int valorOpcao){
		 valor = valorOpcao;
	 }
	 
	 public int getValor(){
		 return valor;
	 }
	 
	 public static String getStatus(String status)
	 {
		 if(status.equalsIgnoreCase(Status.PASSED.toString())){
			 return Status.PASSED.toString();
		 }else if(status.equalsIgnoreCase(Status.FAILED.toString())){
			 return Status.FAILED.toString();
		 }else{
			 return Status.INVALID.toString();
		 }
	 }
}