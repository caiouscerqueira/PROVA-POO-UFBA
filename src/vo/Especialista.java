/**
 * 
 */
package vo;

import java.util.Objects;

/**
 * @author CaiS2Lai
 *
 */
public class Especialista extends Usuario {
	
	private String subTipo;
	public String areaEspecialidade;
	
	
	/**
	 * @param tipo
	 * @param subTipo
	 */
	public Especialista(String tipo, String subTipo) {
		this.setTipo("E");
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
	 * @param areaEspecialidade
	 */
	public Especialista(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada, String tipo, String subTipo, String areaEspecialidade) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada, tipo);
		this.subTipo = subTipo;
		this.areaEspecialidade = areaEspecialidade;
	}
	public Especialista(String tipo) {
		this.setTipo("E");
	}
	public Especialista(String cpf, String senha, String tipo) {
		super(cpf,senha);
		this.setTipo("E");
	}
	/**
	 * @return the areaEspecialidade
	 */
	public String getAreaEspecialidade() {
		return areaEspecialidade;
	}
	/**
	 * @param areaEspecialidade the areaEspecialidade to set
	 */
	public void setAreaEspecialidade(String areaEspecialidade) {
		this.areaEspecialidade = areaEspecialidade;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(areaEspecialidade, subTipo);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Especialista)) {
			return false;
		}
		Especialista other = (Especialista) obj;
		return Objects.equals(areaEspecialidade, other.areaEspecialidade) && Objects.equals(subTipo, other.subTipo);
	}
	
	
	
	
	

	

	
	
	
	
	

}
