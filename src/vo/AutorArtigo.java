/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class AutorArtigo extends Especialista {

	public AutorArtigo(String cPF, String nome, String nascimento, String tituloAcademico, String senha,
			String areaEspecialidade) {
		super(cPF, nome, nascimento, tituloAcademico, senha, areaEspecialidade);
		// TODO Auto-generated constructor stub
	}
	
	public Artigo submeterArtigo() {
		Artigo artigo = new Artigo(1, "TITULO", "RESUMO", null, 0, areaEspecialidade);
		
		
		return artigo;
	
		
	}
	
}
