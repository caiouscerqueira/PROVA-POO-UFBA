/**
 * 
 */
package vo;

import java.util.Objects;

/**
 * @author CaiS2Lai
 *
 */
public class Participante extends Usuario implements Comparable<Participante> {

	private boolean assistiuPalestra;
	
	/**
	 * @param tipo
	 */
	public Participante(String tipo) {
		this.setTipo("P");
		
	}

	/**
	 * @param cpf
	 * @param nome
	 * @param nascimento
	 * @param tituloAcademico
	 * @param senha
	 * @param instituicaoVinculada
	 * @param tipo
	 * @param assistiuPalestra
	 */
	public Participante(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada, String tipo, boolean assistiuPalestra) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada, tipo);
		this.assistiuPalestra = assistiuPalestra;
	}

	public Participante(String cpf, String senha) {
		super(cpf,senha);
		
		// TODO Auto-generated constructor stub
	}
	
	public Participante(String cpf, String nome, String nascimento,  String tituloAcademico,  String senha, String instituicaoVinculada,
			String tipo) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada);
		this.setTipo("P");
	}

	public int compareTo(Participante p1, Participante p2) {
		// TODO Auto-generated method stub
		 return p1.getNome().compareTo(p2.getNome());
	}

	@Override
	public int compareTo(Participante o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void assistirPalestra() {
		this.assistiuPalestra = true;
	}

	/**
	 * @return the assistiuPalestra
	 */
	public boolean isAssistiuPalestra() {
		return assistiuPalestra;
	}

	/**
	 * @param assistiuPalestra the assistiuPalestra to set
	 */
	public void setAssistiuPalestra(boolean assistiuPalestra) {
		this.assistiuPalestra = assistiuPalestra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(assistiuPalestra);
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
		if (!(obj instanceof Participante)) {
			return false;
		}
		Participante other = (Participante) obj;
		return assistiuPalestra == other.assistiuPalestra;
	}
	
	
}
