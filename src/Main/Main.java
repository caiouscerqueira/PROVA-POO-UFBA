package Main;
import java.util.List;
import java.util.Scanner;

import vo.Artigo;
import vo.GeneralChairs;
import vo.Participante;
import vo.Usuario;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	List<Participante> participantes = new ArrayList<>();
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
	private static boolean valida_senha(Usuario usuario) {
		if(usuario.getSenha().isEmpty()){
			System.out.print("A senha não pode ser vazia.\n");
			return false;
		}else if(usuario.getSenha().length() <6 || usuario.getSenha().length()>8) {
			System.out.print("Senha inválida.\n");
			return false;
		}
		return true;
	}
	private void fazerLogin(Usuario usuario){
		Scanner scanner = new Scanner(System.in);
		boolean validador = false; 
		try{ 
			do {
				System.out.print("Digite o tipo de Usuario. Digite 'P' para participante, 'E' para especialisa ou 'O' para organizador  : ");
				usuario.setTipo(scanner.next()); 
				validador = valida_usuario(usuario); 
			}while  (!validador);
		 
		usuarios.add(usuario);
		System.out.print("\nLogin efetuado com sucesso"); 
		}catch (Exception e) { System.out.print("Erro: " + e.getMessage()); }
		
	}
	
	private void inscreverParticipante(Usuario participante){
		Scanner scanner = new Scanner(System.in);
				
		System.out.print("Nome do participante: ");
		participante.setNome(scanner.next());
		
		System.out.print("Titulo Acadêmico do participante: ");
		participante.setTituloAcademico(scanner.next());
		
		System.out.print("Data de nascimento do participante: ");
		participante.setNascimento(scanner.next());
		
		System.out.print("CPF do participante: ");
		scanner.nextLine(); 
		participante.setCPF(scanner.nextLine());
		
		usuariosPendentes.add(participante);
		
				
	}
	
	private void validarInscricao(Usuario usuario){
		boolean validar = true;
		if(usuario.getTipo().equalsIgnoreCase("O")) {
			GeneralChairs generalchair = new GeneralChairs(null, null, null, null, null);
			generalchair.validarInscricao(usuariosPendentes, validar);
		}
	}
	
	private void invalidarInscricao(Usuario usuario){
		boolean validar = false;
		if(usuario.getTipo().equalsIgnoreCase("O")) {
			GeneralChairs generalchair = new GeneralChairs(null, null, null, null, null);
			generalchair.validarInscricao(usuariosPendentes, validar);
		}
	}
	
	private void emitirCertificado(Usuario usuario){
		if(usuario.getTipo().equalsIgnoreCase("O")) {
			GeneralChairs generalchair = new GeneralChairs(null, null, null, null, null);
			for(Participante participante : participantes){
				String certificado =	generalchair.emitirCertificado(participante);
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
		for(Participante participante : participantes){
			System.out.println("\nCPF: " + participante.getCPF());
			System.out.println("Nome: " + participante.getNome());
			System.out.println("\nTitulo Acadêmico: " + participante.getTituloAcademico());
			System.out.println("Data de Nascimento: " + participante.getNascimento());
			System.out.println("\n\n");
		}
	}
	
	public static void main(String[] args){
		short opcao = 50;
		Scanner scanner = new Scanner(System.in);
		Main teste = new Main();
		Usuario usuario = new Usuario(null, null);
		do{
			teste.exibirMenu();
			
			System.out.print("Opção escolhida: ");
			opcao = scanner.nextShort();
			
			switch(opcao){
				case 1:
					
					usuario.fazerLogin();
					teste.fazerLogin(usuario);
					break;
				case 2:
					if(usuario.getTipo().equalsIgnoreCase("p")) {
						teste.inscreverParticipante(usuario);
					}
					break;
				case 3:
					teste.validarInscricao(usuario);
					break;	
				case 4:
					teste.invalidarInscricao(usuario);
					break;	
				case 5:
					teste.emitirCertificado(usuario);
					break;	
				case 6:
					teste.submeterArtigo(usuario);
					break;	
				case 7:
					teste.enviarAvaliacao(usuario);
					break;	
				case 8:
					teste.visualizarAvaliacoes(usuario);
					break;	
				case 9:
					teste.aceitarArtigo(usuario);
					break;	
				case 10:
					teste.rejeitarArtigo(usuario);
					break;	
				case 11:
					teste.listarArtigosAceitos();
					break;
				case 12:
					teste.listarArtigosNegados();
					break;	
				case 13:
					teste.visualizarDadosArtigo(usuario);
					break;	
				case 14:
					teste.listarParticipantes();
					break;
				/*
				 * case 15: teste.exibirMenu(); break;
				 */
				default:
					teste.exibirMenu();
			}
		}while(opcao != 15);
	}
}
