package Main;

public class Util {

	public static boolean valida_cpf(String cpf){
		 if(cpf.isEmpty()){
				
				return false;
			}else if(!cpf.matches("[0-9]+")) {
				
				return false;
			}else if(cpf.length() != 11) {
				
				return false;
			}   
		 return true;
	}

}
