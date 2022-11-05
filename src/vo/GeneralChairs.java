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
	
	public boolean validarInscricao() {
		
		return false;
		
	}
	
	public String emitirCertificado() {
		
		return "CERTIFICADO EMITIDO";
		
	}
}
