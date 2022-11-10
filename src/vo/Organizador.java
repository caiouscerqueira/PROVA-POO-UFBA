/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class Organizador extends Usuario {
	
	private String subTipo;
	
	
	
	/**
	 * @param tipo
	 * @param subTipo
	 */
	public Organizador(String tipo, String subTipo) {
		this.setTipo("O");
		this.subTipo = subTipo;
	}
	

	/**
	 * @param cpf
	 * @param nome
	 * @param nascimento
	 * @param tituloAcademico
	 * @param senha
	 * @param instituicaoVinculada
	 * @param tipo
	 * @param subTipo
	 */
	public Organizador(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada, String tipo, String subTipo) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada, tipo);
		this.subTipo = subTipo;
	}

	public Organizador(String tipo) {
		this.setTipo("O");
	}
	
	public Organizador(String cpf, String senha, String tipo) {
		super(cpf, senha);
		this.setTipo("O");
	}


	/**
	 * @return the subTipo
	 */
	public String getSubTipo() {
		return subTipo;
	}

	/**
	 * @param subTipo the subTipo to set
	 */
	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}
	
			
	
	

}
