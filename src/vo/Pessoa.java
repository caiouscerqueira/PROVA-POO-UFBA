/**
 * 
 */
package vo;

import java.util.Objects;

/**
 * @author CaiS2Lai
 *
 */
public abstract class Pessoa {

	protected String CPF;
	protected String nome;
	protected String nascimento;
	protected String tituloAcademico;
	protected String senha;
	protected String instituicaoVinculada;
	
	
	
	/**
	 * 
	 */
	public Pessoa() {
	}

	/**
	 * @param cPF
	 * @param senha
	 */
	public Pessoa(String cPF, String senha) {
		CPF = cPF;
		this.senha = senha;
	}
	
	/**
	 * @param cPF
	 * @param nome
	 * @param nascimento
	 * @param tituloAcademico
	 * @param senha
	 * @param instituicaoVinculada
	 */
	public Pessoa(String cPF, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada) {
		CPF = cPF;
		this.nome = nome;
		this.nascimento = nascimento;
		this.tituloAcademico = tituloAcademico;
		this.senha = senha;
		this.instituicaoVinculada = instituicaoVinculada;
	}

	/**
	 * @return the cPF
	 */
	public String getCPF() {
		return CPF;
	}
	
		
	/**
	 * @param cPF the cPF to set
	 */
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the nascimento
	 */
	public String getNascimento() {
		return nascimento;
	}
	/**
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	/**
	 * @return the tituloAcademico
	 */
	public String getTituloAcademico() {
		return tituloAcademico;
	}
	/**
	 * @param tituloAcademico the tituloAcademico to set
	 */
	public void setTituloAcademico(String tituloAcademico) {
		this.tituloAcademico = tituloAcademico;
	}
	
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the instituicaoVinculada
	 */
	public String getInstituicaoVinculada() {
		return instituicaoVinculada;
	}

	/**
	 * @param instituicaoVinculada the instituicaoVinculada to set
	 */
	public void setInstituicaoVinculada(String instituicaoVinculada) {
		this.instituicaoVinculada = instituicaoVinculada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CPF, instituicaoVinculada, nascimento, nome, senha, tituloAcademico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(instituicaoVinculada, other.instituicaoVinculada)
				&& Objects.equals(nascimento, other.nascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(tituloAcademico, other.tituloAcademico);
	}
	
	
	
}
