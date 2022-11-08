/**
 * 
 */
package vo;

/**
 * @author CaiS2Lai
 *
 */
public class Participante extends Pessoa implements Comparable<Participante> {
			
	public Participante(String cPF, String nome, String nascimento, String tituloAcademico, String senha) {
		super(cPF, nome, nascimento, tituloAcademico, senha);
		// TODO Auto-generated constructor stub
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

	

}
