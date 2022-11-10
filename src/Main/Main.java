package Main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import vo.Artigo;
import vo.AutorArtigo;
import vo.Especialista;
import vo.GeneralChairs;
import vo.Organizador;
import vo.Participante;
import vo.ProgramChairs;
import vo.RevisorArtigo;
import vo.Usuario;

public class Main {
	
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	List<Participante> participantes = new ArrayList<>();
	List<GeneralChairs> organizadoresGeneralChairs = new ArrayList<>();
	List<ProgramChairs> organizadoresProgramChairs = new ArrayList<>();
	List<Organizador> organizadores = new ArrayList<>();
	List<Especialista> especialistas = new ArrayList<>();
	List<AutorArtigo> especialistasAutorArtigo = new ArrayList<>();
	List<RevisorArtigo> especialistasRevisorArtigo = new ArrayList<>();
	List<Participante> participantesPendentes = new ArrayList<>();
	List<Usuario> usuariosPendentes = new ArrayList<>();
	List<Artigo> artigos = new ArrayList<>();
	List<Usuario> usuarios = new ArrayList<>();
	private void exibirMenu(){
		System.out.println("\n\n");
		System.out.println("+-------------------------------------------+");
		System.out.println("|              Menu de Opções               |");
		System.out.println("+-------------------------------------------+");
		System.out.println("| 01 - Fazer Login                    		|");
		System.out.println("| 02 - Inscrever Participante               |");
		System.out.println("| 03 - Validar inscrição de participantes	|");
		System.out.println("| 04 - Invalidar inscrição de participantes |");
		System.out.println("| 05 - Emitir certificado para participante |");
		System.out.println("| 06 - Submeter artigo						|");
		System.out.println("| 07 - Enviar avaliação de artigo			|");
		System.out.println("| 08 - Ver avaliações de um artigo			|");
		System.out.println("| 09 - Aceitar artigo						|");
		System.out.println("| 10 - Rejeitar artigo						|");
		System.out.println("| 11 - Listar artigos aceitos	            |");
		System.out.println("| 12 - Listar artigos negados               |");
		System.out.println("| 13 - Ver dados de um artigo			    |");
		System.out.println("| 14 - Listar participantes        		    |");
		System.out.println("| 15 - Sair                                 |");
		System.out.println("+-------------------------------------------+");
	}
	
	 private static boolean valida_usuario(Usuario usuario){
		 if(usuario.getTipo().isEmpty()){
				System.out.print("O tipo não pode ser vazio.\n");
				return false;
			}else if(!usuario.getTipo().equalsIgnoreCase("P") && !usuario.getTipo().equalsIgnoreCase("O") && !usuario.getTipo().equalsIgnoreCase("E")){
				System.out.print("Digite apenas uma das opções disponíveis.\n");
				return false;
			}else if(usuario.getTipo().length() != 1) {
				System.out.print("Digite apenas uma das opções disponíveis.\n");
				return false;
			}   
		 return true;
	}
	 
	 
	 private static boolean valida_organizador(Organizador organizador){
		 if(organizador.getSubTipo().isEmpty()){
				System.out.print("A função não pode ser vazia.\n");
				return false;
			}else if(!organizador.getSubTipo().equalsIgnoreCase("P") && !organizador.getSubTipo().equalsIgnoreCase("G")){
				System.out.print("Digite apenas uma das opções disponíveis.\n");
				return false;
			}else if(organizador.getSubTipo().length() != 1) {
				System.out.print("Digite apenas uma das opções disponíveis.\n");
				return false;
			}   
		 return true;
	}
	
	 private static boolean valida_especialista(Especialista especialista){
		 if(especialista.getSubTipo().isEmpty()){
				System.out.print("A função não pode ser vazia.\n");
				return false;
			}else if(!especialista.getSubTipo().equalsIgnoreCase("A") && !especialista.getSubTipo().equalsIgnoreCase("R")){
				System.out.print("Digite apenas uma das opções disponíveis.\n");
				return false;
			}else if(especialista.getSubTipo().length() != 1) {
				System.out.print("Digite apenas uma das opções disponíveis.\n");
				return false;
			}   
		 return true;
	} 
	/*
	 * private static boolean valida_senha(Usuario usuario) {
	 * if(usuario.getSenha().isEmpty()){
	 * System.out.print("A senha não pode ser vazia.\n"); return false; }else
	 * if(usuario.getSenha().length() <6 || usuario.getSenha().length()>8) {
	 * System.out.print("Senha inválida.\n"); return false; } return true; }
	 */
	private void fazerLogin(Usuario usuario){
		Scanner scanner = new Scanner(System.in);
		boolean validador = false; 
		try{ 
			do {
				System.out.print("Digite o tipo de Usuario. Digite 'P' para participante, 'E' para especialista ou 'O' para organizador  : ");
				usuario.setTipo(scanner.next()); 
				validador = valida_usuario(usuario); 
			}while  (!validador);
			
			if(usuario.getTipo().equalsIgnoreCase("P")) {
				Participante participante = new Participante(usuario.getTipo()); 
				participante.setCPF(usuario.getCPF());
				participante.setSenha(usuario.getSenha());
				participantesPendentes.add(participante);
				
			}else if(usuario.getTipo().equalsIgnoreCase("O")) {
				Organizador organizador = new Organizador(usuario.getTipo()); 
				organizador.setCPF(usuario.getCPF());
				organizador.setSenha(usuario.getSenha());
				
				do {
					System.out.print("Digite sua função. Digite 'P' para program chairs, ou 'G' para general chairs: ");
					usuario.setTipo(scanner.next()); 
					validador = valida_organizador(organizador); 
				}while  (!validador);
				
				if(organizador.getSubTipo().equalsIgnoreCase("P")){
					ProgramChairs programchairs = new ProgramChairs(usuario.getTipo(), organizador.getSubTipo());
					programchairs.setCPF(organizador.getCPF());
					programchairs.setSenha(organizador.getSenha());
					organizadoresProgramChairs.add(programchairs);
				
				}else if(organizador.getSubTipo().equalsIgnoreCase("G")){
					GeneralChairs generalchairs = new GeneralChairs(usuario.getTipo(), organizador.getSubTipo());
					generalchairs.setCPF(organizador.getCPF());
					generalchairs.setSenha(organizador.getSenha());
					organizadoresGeneralChairs.add(generalchairs);
				
				}else {
					new Exception("Organizador sem função cadastrada ou com função inválida");
					return;
				}	
				
				organizadores.add(organizador);
			
			}else if(usuario.getTipo().equalsIgnoreCase("E")) {
				Especialista especialista = new Especialista(usuario.getTipo()); 
				especialista.setCPF(usuario.getCPF());
				especialista.setSenha(usuario.getSenha());
				
				do {
					System.out.print("Digite sua função. Digite 'A' para autor de artigo, ou 'R' para revisor de artigo: ");
					usuario.setTipo(scanner.next()); 
					validador = valida_especialista(especialista); 
				}while  (!validador);
				
				if(especialista.getSubTipo().equalsIgnoreCase("A")){
					AutorArtigo autorArtgo = new AutorArtigo(usuario.getTipo(), especialista.getSubTipo());
					autorArtgo.setCPF(especialista.getCPF());
					autorArtgo.setSenha(especialista.getSenha());
					especialistasAutorArtigo.add(autorArtgo);
				
				}else if(especialista.getSubTipo().equalsIgnoreCase("R")){
					RevisorArtigo revisorArtgo = new RevisorArtigo(usuario.getTipo(), especialista.getSubTipo());
					revisorArtgo.setCPF(especialista.getCPF());
					revisorArtgo.setSenha(especialista.getSenha());
					especialistasRevisorArtigo.add(revisorArtgo);
				
				}else {
					new Exception("Especialista sem função cadastrada ou com função inválida");
					return;
				}	
				
				especialistas.add(especialista);
			}
			
		usuarios.add(usuario);
		System.out.print("\nLogin efetuado com sucesso");
		
		}catch (Exception e) { System.out.print("Erro: " + e.getMessage()); }
		
		
	}
	
	private void inscreverParticipante(Usuario usuarioParticipante){
		try {
		
			if(!usuarios.contains(usuarioParticipante)) {
				System.out.print("Realize login para acessar as demais opções. ");
				new Exception("Login não realizado");
				return;
			}
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Nome do participante: ");
			usuarioParticipante.setNome(scanner.next());
			
			System.out.print("Titulo Acadêmico do participante: ");
			usuarioParticipante.setTituloAcademico(scanner.next());
			
			System.out.print("Data de nascimento do participante: ");
			usuarioParticipante.setNascimento(scanner.next());
			
			System.out.print("Instituição de vínculo do participante: ");
			scanner.nextLine(); 
			usuarioParticipante.setInstituicaoVinculada(scanner.nextLine());
			
			usuariosPendentes.add(usuarioParticipante);
			
		}catch (Exception e) { System.out.print("Erro: " + e.getMessage()); }	
	}
	
	private void validarInscricao(Usuario usuarioGeneralChaiirs){
		if(!usuarios.contains(usuarioGeneralChaiirs)) {
			System.out.print("Realize login para acessar as demais opções. ");
			new Exception("Login não realizado");
			return;
		}
			
		Organizador organizador = new Organizador(usuarioGeneralChaiirs.getCPF(),usuarioGeneralChaiirs.getSenha(),usuarioGeneralChaiirs.getTipo());
		
		if(!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("G");
		
		GeneralChairs generalChairs = new GeneralChairs(organizador.getCPF(), organizador.getSenha(), organizador.getTipo(), organizador.getSubTipo());
		
		if(!organizadoresGeneralChairs.contains(usuarioGeneralChaiirs)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é General Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}
		
		boolean validar = true;
		generalChairs.validarInscricao(usuariosPendentes, validar);
		
	}
	
	private void invalidarInscricao(Usuario usuarioGeneralChaiirs){
		if(!usuarios.contains(usuarioGeneralChaiirs)) {
			System.out.print("Realize login para acessar as demais opções. ");
			new Exception("Login não realizado");
			return;
		}
			
		Organizador organizador = new Organizador(usuarioGeneralChaiirs.getCPF(),usuarioGeneralChaiirs.getSenha(),usuarioGeneralChaiirs.getTipo());
		
		if(!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("G");
		
		GeneralChairs generalChairs = new GeneralChairs(organizador.getCPF(), organizador.getSenha(), organizador.getTipo(), organizador.getSubTipo());
		
		if(!organizadoresGeneralChairs.contains(usuarioGeneralChaiirs)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é General Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}
		
		boolean validar = false;
		generalChairs.validarInscricao(usuariosPendentes, validar);
		
	}
	
	private void emitirCertificado(Usuario usuarioGeneralChaiirs){
		if(!usuarios.contains(usuarioGeneralChaiirs)) {
			System.out.print("Realize login para acessar as demais opções. ");
			new Exception("Login não realizado");
			return;
		}
			
		Organizador organizador = new Organizador(usuarioGeneralChaiirs.getCPF(),usuarioGeneralChaiirs.getSenha(),usuarioGeneralChaiirs.getTipo());
		
		if(!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("G");
		
		GeneralChairs generalChairs = new GeneralChairs(organizador.getCPF(), organizador.getSenha(), organizador.getTipo(), organizador.getSubTipo());
		
		if(!organizadoresGeneralChairs.contains(usuarioGeneralChaiirs)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é General Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}
		for(Participante participante : participantes){
			if(participante.isAssistiuPalestra()) {
				String certificado =	generalChairs.emitirCertificado(participante);
				System.out.println(certificado +" para o participante "+participante.getNome()+" de CPF "+participante.getCPF()+".");
			}
		}
	}
	
	private void submeterArtigo(Usuario usuario) {
		
	}
	
	private void enviarAvaliacao(Usuario usuario) {
		
	}
	
	private void visualizarAvaliacoes(Usuario usuario) {
		
	}
	
	private void aceitarArtigo(Usuario usuario) {
		
	}
	
	private void rejeitarArtigo(Usuario usuario) {
		
	}
	
	private void listarArtigosAceitos() {
		
	}
	
	private void listarArtigosNegados() {
		
	}
	
	private void visualizarDadosArtigo(Usuario usuario) {
		
	}
	private void listarParticipantes(){
		Collections.sort(participantes);
		if(participantes.isEmpty() || participantes.size() < 1 || participantes == null) {
			System.out.println("\nNão existem participantes inscritos\n");
		}else {
			for(Participante participante : participantes){
				System.out.println("\nCPF: " + participante.getCPF());
				System.out.println("Nome: " + participante.getNome());
				System.out.println("Data de Nascimento: " + participante.getNascimento());
				System.out.println("\nTitulo Acadêmico: " + participante.getTituloAcademico());
				System.out.println("\nInstituição de vínculo: " + participante.getInstituicaoVinculada());
				System.out.println("\n\n");
			}
		}	
	}
	
	public static void main(String[] args){
		short opcao = 50;
		Scanner scanner = new Scanner(System.in);
		Main principal = new Main();
		Usuario usuario = new Usuario();
		do{
			principal.exibirMenu();
			
			System.out.print("Opção escolhida: ");
			opcao = scanner.nextShort();
			
			switch(opcao){
				case 1:
					
					usuario = usuario.fazerLogin();
					principal.fazerLogin(usuario);
					
					break;
				case 2:
					
					if(usuario.getCPF() == null || usuario.getCPF().isEmpty() ) {
						System.out.println("Realize o login antes de acessar as demais opções ");
					}else {
						if(usuario.getTipo().equalsIgnoreCase("P")) {
							principal.inscreverParticipante(usuario);
						}else {
							System.out.println("Apenas participantes podem realizar inscrições ");
						}
						
					}
					break;
				case 3:
					if(usuario.getCPF() == null || usuario.getCPF().isEmpty() ) {
						System.out.println("Realize o login antes de acessar as demais opções ");
					}else {
						if(usuario.getTipo().equalsIgnoreCase("O")) {
							principal.validarInscricao(usuario);
						}else {
							System.out.println("Apenas Organizadores podem validar inscrições ");
						}
					}
					break;	
				case 4:
					principal.invalidarInscricao(usuario);
					break;	
				case 5:
					principal.emitirCertificado(usuario);
					break;	
				case 6:
					principal.submeterArtigo(usuario);
					break;	
				case 7:
					principal.enviarAvaliacao(usuario);
					break;	
				case 8:
					principal.visualizarAvaliacoes(usuario);
					break;	
				case 9:
					principal.aceitarArtigo(usuario);
					break;	
				case 10:
					principal.rejeitarArtigo(usuario);
					break;	
				case 11:
					principal.listarArtigosAceitos();
					break;
				case 12:
					principal.listarArtigosNegados();
					break;	
				case 13:
					principal.visualizarDadosArtigo(usuario);
					break;	
				case 14:
					principal.listarParticipantes();
					break;
				/*
				 * case 15: principal.exibirMenu(); break;
				 */
				default:
					principal.exibirMenu();
			}
		}while(opcao != 15);
	}
}
