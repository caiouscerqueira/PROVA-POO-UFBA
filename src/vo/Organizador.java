/**
 * 
 */
package vo;

import java.util.Objects;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(subTipo);
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
		if (!(obj instanceof Organizador)) {
			return false;
		}
		Organizador other = (Organizador) obj;
		return Objects.equals(subTipo, other.subTipo);
	}
	
			
	
	

}
