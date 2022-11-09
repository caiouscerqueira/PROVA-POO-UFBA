/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class Especialista extends Pessoa {
	
	public String areaEspecialidade;

	/**
	 * @param cpf
	 * @param nome
	 * @param nascimento
	 * @param tituloAcademico
	 * @param senha
	 * @param areaEspecialidade
	 */
	public Especialista(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String areaEspecialidade) {
		super(cpf, nome, nascimento, tituloAcademico, senha);
		this.areaEspecialidade = areaEspecialidade;
	}

	
	
	
	
	

}
