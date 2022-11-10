/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class AutorArtigo extends Especialista {

	
	public AutorArtigo(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada, String tipo, String subTipo, String areaEspecialidade) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada, tipo, "A", areaEspecialidade);
		// TODO Auto-generated constructor stub
	}

	public AutorArtigo(String tipo, String subTipo) {
		super(tipo);
		this.setSubTipo("A");
	}

	public Artigo submeterArtigo() {
		Artigo artigo = new Artigo(1, "TITULO", "RESUMO", null, 0, areaEspecialidade);
		
		
		return artigo;
	
		
	}
	
}
