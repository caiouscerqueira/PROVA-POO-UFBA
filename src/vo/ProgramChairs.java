/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class ProgramChairs extends Organizador {
	
	
	
	
	public ProgramChairs(String tipo, String subTipo) {
		super(tipo);
		this.setSubTipo("P");
	}
	
	

	public boolean aceitarArtigo() {
		
		return false;
		
	}
}
