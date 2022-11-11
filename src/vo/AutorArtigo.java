/**
 * 
 */
package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Main.Util;

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

	public AutorArtigo(String cpf, String senha, String tipo, String subTipo) {
		super(cpf, senha, tipo);
		this.setSubTipo("A");
	}

	

	public Artigo submeterArtigo(AutorArtigo autorArtigo) {
		
		Scanner scanner = new Scanner(System.in);
		Artigo artigo = new Artigo();
		List<AutorArtigo> listaAutores = new ArrayList<AutorArtigo>();
		ArrayList<String> palavrasChaves = new ArrayList<String>(); 
		int qtd_autores = 0;
		try {
			do {
				System.out.print("Digite o título do artigo: ");
				artigo.setTitulo(scanner.next());
				
				System.out.print("Digite o resumo do artigo: ");
				artigo.setResumo(scanner.next());
				
				System.out.print("Digite a(s) palvra(s) chave(s) do artigo separadas por ',': ");
				String[] palavras_chaves = scanner.next().split(",");
				for(int i=0; i < palavras_chaves.length; i++  ) {
					palavrasChaves.add(palavras_chaves[i]);	
				}
				artigo.setPalavaChave(palavrasChaves);
				
				do {
					System.out.print("Digite a quantidade de paginas do artigo: ");
					if(!scanner.next().matches("[0-9]+")) {
						System.out.print("Digite apenas números.\n");
					}
				}while (!scanner.next().matches("[0-9]+"));
				int qtd_paginas = Integer.parseInt(scanner.next());
				artigo.setQtdPaginas(qtd_paginas);
				artigo.setDataSubmissao(new Date());
				do {
					System.out.print("Digite quantos autores o artigo possui (Artigos devem possuir de 1 a 5 autores): ");
					if(!scanner.next().matches("[0-9]+")) {
						System.out.print("Digite apenas números.\n");
					}
					if(!scanner.next().matches("[1-5]+")) {
						System.out.print("Artigos devem possuir de 1 a 5 autores.\n");
					}
					
					qtd_autores = Integer.parseInt(scanner.nextLine());
					if(qtd_autores > Artigo.getQtdMaxAutores() || qtd_autores < Artigo.getQtdMinAutores()) {
						System.out.print("Artigos devem possuir de 1 a 5 autores.\n");
					}
					}while (!scanner.next().matches("[1-5]+"));
					
					for(int j =0; j< qtd_autores -1; j++) {
						AutorArtigo autoresArtigo = new AutorArtigo("E", "A");
						
						System.out.print("CPF do autor: ");
						
						if(!Util.valida_cpf(scanner.next())) {
							System.out.print("CPF do autor é invalido. Digite apenas os números.\n");
						}
						
						autoresArtigo.setCPF(scanner.next());
						
						System.out.print("Nome do autor: ");
						autoresArtigo.setNome(scanner.next());
						
						System.out.print("Titulo Acadêmico do autor: ");
						autoresArtigo.setTituloAcademico(scanner.next());
						
						System.out.print("Data de nascimento do autor: ");
						autoresArtigo.setNascimento(scanner.next());
						
						System.out.print("Instituição de vínculo do autor: ");
						scanner.nextLine(); 
						autoresArtigo.setInstituicaoVinculada(scanner.nextLine());
						
					}
					listaAutores.add(autorArtigo);
					
					if(listaAutores.size() == qtd_autores) {
						artigo.setAutores(listaAutores);
					}else {
						System.out.print("A quantidade de autores não corresponde a informada");
						new Exception("Quantidade de auotres inválida");
					}
				
			}while (artigo.getAutores().isEmpty() || artigo.getAutores().size() < 1);		
			
		}catch  (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}
		return artigo;
		
	}

	public void visualiarAvaliacao(Artigo artigo) {
		artigo.getRevisores();
		
	}
	
}
