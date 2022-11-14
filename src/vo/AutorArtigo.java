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

	private static boolean valida_paginas(String paginas){
		 if(paginas.isEmpty()){
				System.out.print("A quantidade de paginas não pode ser vazia.\n");
				return false;
			}else if(!paginas.matches("[0-9]+")) {
				System.out.print("Digite apenas números.\n");
				return false;
			}
		 return true;
	}
	
	private static boolean valida_autores(String paginas){
		 if(paginas.isEmpty()){
				System.out.print("A quantidade de autores não pode ser vazia.\n");
				return false;
			}else if(!paginas.matches("[1-5]+")) {
				System.out.print("São permitidos apenas de 1 a 5 autores por artigo.\n");
				return false;
			}
		 return true;
	}


	public Artigo submeterArtigo(AutorArtigo autorArtigo) {
		
		Scanner scanner = new Scanner(System.in);
		Artigo artigo = new Artigo();
		List<AutorArtigo> listaAutores = new ArrayList<AutorArtigo>();
		ArrayList<String> palavrasChaves = new ArrayList<String>(); 
		String qtd_autores = "";
		
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
					artigo.setQtdPaginas(scanner.next());
						
					if(!valida_paginas(artigo.getQtdPaginas())) {
						
						System.out.print("Quantidade de paginas inválida ");
					}
					artigo.setDataSubmissao(new Date());
				}while (!artigo.getQtdPaginas().matches("[0-9]+"));
				do {
					System.out.print("Digite quantos autores o artigo possui (Artigos devem possuir de 1 a 5 autores): ");
					qtd_autores= scanner.next();
					if(!valida_autores(qtd_autores)) {
						System.out.print("Quantidade de autores inválida ");
					}
					if(Integer.valueOf(qtd_autores) > Artigo.getQtdMaxAutores() || Integer.valueOf(qtd_autores) < Artigo.getQtdMinAutores()) {
						System.out.print("Artigos devem possuir de 1 a 5 autores.\n");
					}
					}while (!qtd_autores.matches("[1-5]+"));
					
					for(int j =0; j< Integer.valueOf(qtd_autores) -1; j++) {
						AutorArtigo autoresArtigo = new AutorArtigo("E", "A");
						
						System.out.print("CPF do autor: ");
						autoresArtigo.setCPF(scanner.next());
						if(!Util.valida_cpf(autoresArtigo.getCPF())) {
							System.out.print("CPF do autor é invalido. Digite apenas os números.\n");
						}
						
						
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
					
					if(listaAutores.size() == Integer.valueOf(qtd_autores)) {
						artigo.setAutores(listaAutores);
						System.out.print("Artigo submetido com sucesso!");
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
		if (!(obj instanceof AutorArtigo)) {
			return false;
		}
		return true;
	}
	
	
	
}
