/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class RevisorArtigo extends Especialista {

	public RevisorArtigo(String cPF, String nome, String nascimento, String tituloAcademico, String senha,
			String areaEspecialidade) {
		super(cPF, nome, nascimento, tituloAcademico, senha, areaEspecialidade);
		// TODO Auto-generated constructor stub
	}

	public void analisarArtigo() {}
	
	public String avaliarArtigo() {
		return areaEspecialidade;}
}
