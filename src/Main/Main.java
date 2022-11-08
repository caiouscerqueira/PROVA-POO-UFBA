package Main;
import java.util.List;
import java.util.Scanner;

import vo.Artigo;
import vo.GeneralChairs;
import vo.Participante;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	List<Participante> participantes = new ArrayList<>();
	List<Artigo> produtos = new ArrayList<>();
	
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
	
	 private static boolean valida_cpf(Participante participante){
		 if(participante.getCPF().isEmpty()){
				System.out.print("O CPF não pode ser vazio.\n");
				return false;
			}else if(!participante.getCPF().matches("[0-9]+")) {
				System.out.print("Digite apenas os números do CPF.\n");
				return false;
			}else if(participante.getCPF().length() != 11) {
				System.out.print("Digite todos os números do CPF.\n");
				return false;
			}   
		 return true;
	}
	private static boolean valida_senha(Participante participante) {
		if(participante.getSenha().isEmpty()){
			System.out.print("A senha não pode ser vazia.\n");
			return false;
		}else if(participante.getSenha().length() <6 || participante.getSenha().length()>8) {
			System.out.print("Senha inválida.\n");
			return false;
		}
		return true;
	}
	private void fazerLogin(){
		Scanner scanner = new Scanner(System.in);
		Participante participante = new Participante(null, null, null, null, null);
		boolean validador = false;
		try {
			do {
				System.out.print("Digite o CPF para realizar o login: ");
				participante.setCPF(scanner.next());
				validador = valida_cpf(participante);
			}while (!validador);	
			
			do {
				System.out.print("Digite sua senha, ela dever conter entre 6 e 8 caracteres: ");
				scanner.nextLine();
				participante.setSenha(scanner.next());
				validador = valida_senha(participante);
			}while (!validador);		
				
			System.out.print("\nLogin efetuado com sucesso");
			
		}catch  (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}
		//scanner.close();
	}
	
	private void inscreverParticipante(){
		Scanner scanner = new Scanner(System.in);
		Participante participante = new Participante(null, null, null, null, null);
		
		System.out.print("Nome do participante: ");
		participante.setNome(scanner.next());
		
		System.out.print("Titulo Acadêmico do participante: ");
		participante.setTituloAcademico(scanner.next());
		
		System.out.print("Data de nascimento do participante: ");
		participante.setNascimento(scanner.next());
		
		System.out.print("CPF do participante: ");
		scanner.nextLine(); 
		participante.setCPF(scanner.nextLine());
		
		participantes.add(participante);
		
				
	}
	
	private void validarInscricao(){
		GeneralChairs generalchair = new GeneralChairs(null, null, null, null, null);
		generalchair.validarInscricao(true);
		
	}
	
	private void invalidarInscricao(){
		GeneralChairs generalchair = new GeneralChairs(null, null, null, null, null);
		generalchair.validarInscricao(false);
		
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

		do{
			teste.exibirMenu();
		
			System.out.print("Opção escolhida: ");
			opcao = scanner.nextShort();
			
			switch(opcao){
				case 1:
					teste.fazerLogin();
					break;
				case 2:
					teste.inscreverParticipante();
					break;
				case 3:
					teste.validarInscricao();
					break;	
				case 4:
					teste.invalidarInscricao();
					break;	
				case 5:
					teste.inscreverParticipante();
					break;	
				case 6:
					teste.inscreverParticipante();
					break;	
				case 7:
					teste.inscreverParticipante();
					break;	
				case 8:
					teste.inscreverParticipante();
					break;	
				case 9:
					teste.inscreverParticipante();
					break;	
				case 10:
					teste.inscreverParticipante();
					break;	
				case 11:
					teste.inscreverParticipante();
					break;
				case 12:
					teste.inscreverParticipante();
					break;	
				case 13:
					teste.inscreverParticipante();
					break;	
				case 14:
					teste.listarParticipantes();
					break;
				case 15:
					teste.exibirMenu();
					break;
				default:
					teste.exibirMenu();
			}
		}while(opcao != 99);
	}
}
