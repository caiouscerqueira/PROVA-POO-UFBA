/**
 * 
 */
package vo;

import java.util.List;

/**
 * @author CaiS2Lai
 *
 */
public class ProgramChairs extends Organizador {
	
	
	
	
	public ProgramChairs(String tipo, String subTipo) {
		super(tipo);
		this.setSubTipo("P");
	}
	
	

	public ProgramChairs(String cpf, String senha, String tipo, String subTipo) {
		super(cpf, senha, tipo);
		this.setSubTipo("P");
	}



	public List<Artigo>  aceitarArtigo(List<Artigo> artigos) {
		
		for(int x= 0; x< artigos.size(); x++){
			if(Integer.valueOf(artigos.get(x).getQtdPaginas()) > 30) {
				artigos.get(x).setArpovacao(true);
			}
		}
		
		return artigos;
	}

	public void visualiarAvaliacao(List<Artigo> artigos) {
		for(Artigo artigo : artigos) {
			artigo.getRevisores();
		}
		
	}



	public List<Artigo> rejeitarArtigo(List<Artigo> artigos) {
		for(int x= 0; x< artigos.size(); x++){
			if(Integer.valueOf(artigos.get(x).getQtdPaginas()) > 30) {
				artigos.get(x).setArpovacao(false);
			}
		}
		
		return artigos;
		
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
		if (!(obj instanceof ProgramChairs)) {
			return false;
		}
		return true;
	}
	
	
}
