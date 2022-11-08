/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class GeneralChairs extends Organizador {

	public GeneralChairs(String cPF, String nome, String nascimento, String tituloAcademico, String senha) {
		super(cPF, nome, nascimento, tituloAcademico, senha);
		// TODO Auto-generated constructor stub
	}
	
	public String validarInscricao(boolean validacao) {
		String validado;
		if(validacao) {
			validado = "Inscrição validada";
		}else {
			validado = "Inscrição invalidada";
		}
				
		return validado;
		
	}
	
	
	
	public String emitirCertificado() {
		
		return "CERTIFICADO EMITIDO";
		
	}
}
