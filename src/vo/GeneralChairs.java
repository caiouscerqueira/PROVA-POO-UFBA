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

	
	public GeneralChairs(String tipo, String subTipo) {
		super(tipo);
		this.setSubTipo("G");
	}



	public GeneralChairs(String cpf, String senha, String tipo, String subTipo) {
		super(cpf, senha, tipo);
		this.setSubTipo("G");
	}



	public List<Participante> validarInscricao(List<Usuario> usuariosPendentes, boolean validar) {
		List<Participante> participantesInscritos = new ArrayList<>();
		List<Participante> participantesNegados = new ArrayList<>();
		
		for(Usuario usuario : usuariosPendentes){
			Participante participante = new Participante(usuario.getCPF(), usuario.getNome(), usuario.getNascimento(), usuario.getTituloAcademico(), usuario.getSenha(),usuario.getInstituicaoVinculada(), usuario.getTipo());
			if(usuario.getTipo().equals("P") && validar) {
				participantesInscritos.add(participante);
			}else {
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
		if (!(obj instanceof GeneralChairs)) {
			return false;
		}
		return true;
	}
	
	
}
