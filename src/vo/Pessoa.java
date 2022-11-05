/**
 * 
 */
package vo;

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
	
	
	/**
	 * @param cPF
	 * @param nome
	 * @param nascimento
	 * @param tituloAcademico
	 * @param login
	 * @param senha
	 */
	public Pessoa(String cpf, String nome, String nascimento, String tituloAcademico, String senha) {
		CPF = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.tituloAcademico = tituloAcademico;
		this.senha = senha;
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
	
	
	
}
