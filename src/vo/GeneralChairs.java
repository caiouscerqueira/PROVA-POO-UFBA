/**
 * 
 */
package vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CaiS2Lai
 *
 */
public class GeneralChairs extends Organizador {

	public GeneralChairs(String cPF, String nome, String nascimento, String tituloAcademico, String senha) {
		super(cPF, nome, nascimento, tituloAcademico, senha);
		// TODO Auto-generated constructor stub
	}
	
	public List<Participante> validarInscricao(List<Usuario> usuariosPendentes, boolean validar) {
		List<Participante> participantesInscritos = new ArrayList<>();
		List<Participante> participantesNegados = new ArrayList<>();
		Participante participante = new Participante(null, null, null, null, null);
		for(Usuario usuario : usuariosPendentes){
			if(usuario.getTipo().equals("P")) {
				participante.setCPF(usuario.getCPF());
				participante.setNascimento(usuario.getNascimento());
				participante.setNome(usuario.getNome());
				participante.setTituloAcademico(usuario.getTituloAcademico());
				participantesInscritos.add(participante);
			}else {
				participante.setCPF(usuario.getCPF());
				participante.setNascimento(usuario.getNascimento());
				participante.setNome(usuario.getNome());
				participante.setTituloAcademico(usuario.getTituloAcademico());
				participantesNegados.add(participante);
			}
		}
		if(validar) {
			return participantesInscritos;
		}else {
			return participantesNegados;
		}
				
		
		
	}
	
	
	
	public String emitirCertificado(Participante participante) {
		
		return "CERTIFICADO EMITIDO";
		
	}
}
