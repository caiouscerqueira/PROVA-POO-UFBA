/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class RevisorArtigo extends Especialista {

	


	public RevisorArtigo(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada, String tipo, String subTipo, String areaEspecialidade) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada, tipo, "R", areaEspecialidade);
		// TODO Auto-generated constructor stub
	}

	public RevisorArtigo(String tipo, String subTipo) {
		super(tipo);
		this.setSubTipo("R");
	}

	public void analisarArtigo() {}
	
	public String avaliarArtigo() {
		return areaEspecialidade;}
}
