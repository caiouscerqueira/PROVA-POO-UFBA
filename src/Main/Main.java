package Main;
import java.util.List;
import java.util.Scanner;

import vo.Artigo;
import vo.Participante;

import java.util.ArrayList;

public class Main {
	
	List<Participante> participantes = new ArrayList<>();
	List<Artigo> produtos = new ArrayList<>();
	
	private void exibirMenu(){
		System.out.println("\n\n");
		System.out.println("+-------------------------------------------+");
		System.out.println("|        Menu de Opções                     |");
		System.out.println("+-------------------------------------------+");
		System.out.println("| 01 - Cadastrar Participante                    |");
		System.out.println("| 02 - Cadastrar Produto                    |");
		System.out.println("| 03 - Imprimir relatório de participantes       |");
		System.out.println("| 04 - Imprimir relatório de produtos       |");
		System.out.println("| 50 - Exibir o menu de opções              |");
		System.out.println("| 99 - Sair                                 |");
		System.out.println("+-------------------------------------------+");
	}
	
	private void cadastrarParticipante(){
		Scanner leitor = new Scanner(System.in);
		Participante participante = new Participante(null, null, null, null, null);
		
		System.out.print("Nome do participante: ");
		participante.setNome(leitor.next());
		
		System.out.print("Titulo Acadêmico do participante: ");
		participante.setTituloAcademico(leitor.next());
		
		System.out.print("Data de nascimento do participante: ");
		participante.setNascimento(leitor.next());
		
		System.out.print("CPF do participante: ");
		leitor.nextLine();// limpa o scanner
		participante.setCPF(leitor.nextLine());
		
		participantes.add(participante);
		
		
		//leitor.close();
	}
	
	private void imprimirParticipante(){
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
		Scanner leitor = new Scanner(System.in);
		Main teste = new Main();

		do{
			teste.exibirMenu();
		
			System.out.print("Opção escolhida: ");
			opcao = leitor.nextShort();
			
			switch(opcao){
				case 1:
					teste.cadastrarParticipante();
					break;
				case 3:
					teste.imprimirParticipante();
					break;
				case 50:
					teste.exibirMenu();
					break;
				default:
					teste.exibirMenu();
			}
		}while(opcao != 99);
	}
}
