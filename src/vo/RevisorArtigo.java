/**
 * 
 */
package vo;

import java.util.List;

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

	public RevisorArtigo(String cpf, String senha, String tipo, String subTipo) {
		super(cpf, senha, tipo);
		this.setSubTipo("R");
	}

		
	public void revisarArtigo(List<Artigo> artigos, RevisorArtigo revisor) {
		
		for(int i =0; i < artigos.size(); i++) {
			artigos.get(i).getRevisores().add(revisor);
				
		}
	
		
	}

	public void visualiarAvaliacao(Artigo artigo) {
		artigo.getRevisores();
		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof RevisorArtigo)) {
			return false;
		}
		return true;
	}
	
	
}
