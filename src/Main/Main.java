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

	private void exibirMenu() {
		System.out.println("\n\n\n");
		System.out.println("+-------------------------------------------+");
		System.out.println("|              Menu de Opções               |");
		System.out.println("+-------------------------------------------+");
		System.out.println("| 01 - Fazer Login                          |");
		System.out.println("| 02 - Inscrever Participante               |");
		System.out.println("| 03 - Validar inscrição de participantes   |");
		System.out.println("| 04 - Invalidar inscrição de participantes |");
		System.out.println("| 05 - Emitir certificado para participante |");
		System.out.println("| 06 - Submeter artigo                      |");
		System.out.println("| 07 - Enviar avaliação de artigo           |");
		System.out.println("| 08 - Ver avaliações de um artigo          |");
		System.out.println("| 09 - Aceitar artigo                       |");
		System.out.println("| 10 - Rejeitar artigo                      |");
		System.out.println("| 11 - Listar artigos aceitos	            |");
		System.out.println("| 12 - Listar artigos negados               |");
		System.out.println("| 13 - Ver dados de um artigo               |");
		System.out.println("| 14 - Listar participantes                 |");
		System.out.println("| 15 - Sair                                 |");
		System.out.println("+-------------------------------------------+");
		System.out.println("\n\n\n");
	}

	private static boolean valida_usuario(Usuario usuario) {
		if (usuario.getTipo().isEmpty()) {
			System.out.print("O tipo não pode ser vazio.\n");
			return false;
		} else if (!usuario.getTipo().equalsIgnoreCase("P") && !usuario.getTipo().equalsIgnoreCase("O")
				&& !usuario.getTipo().equalsIgnoreCase("E")) {
			System.out.print("Digite apenas uma das opções disponíveis.\n");
			return false;
		} else if (usuario.getTipo().length() != 1) {
			System.out.print("Digite apenas uma das opções disponíveis.\n");
			return false;
		}
		return true;
	}

	private static boolean valida_organizador(Organizador organizador) {
		if (organizador.getSubTipo().isEmpty()) {
			System.out.print("A função não pode ser vazia.\n");
			return false;
		} else if (!organizador.getSubTipo().equalsIgnoreCase("P") && !organizador.getSubTipo().equalsIgnoreCase("G")) {
			System.out.print("Digite apenas uma das opções disponíveis.\n");
			return false;
		} else if (organizador.getSubTipo().length() != 1) {
			System.out.print("Digite apenas uma das opções disponíveis.\n");
			return false;
		}
		return true;
	}

	private static boolean valida_especialista(Especialista especialista) {
		if (especialista.getSubTipo().isEmpty()) {
			System.out.print("A função não pode ser vazia.\n");
			return false;
		} else if (!especialista.getSubTipo().equalsIgnoreCase("A")
				&& !especialista.getSubTipo().equalsIgnoreCase("R")) {
			System.out.print("Digite apenas uma das opções disponíveis.\n");
			return false;
		} else if (especialista.getSubTipo().length() != 1) {
			System.out.print("Digite apenas uma das opções disponíveis.\n");
			return false;
		}
		return true;
	}

	private static boolean validaUsuario(Usuario usuario, List<Usuario> usuarios) {
		if (!usuarios.contains(usuario)) {
			System.out.print("Realize login para depois emitir certificados. ");
			new Exception("Login não realizado");
			return false;
		}

		return true;
	}

	private void fazerLogin(Usuario usuario) {
		Scanner scanner = new Scanner(System.in);
		boolean validador = false;
		try {
			do {
				System.out.print(
						"Digite o tipo de Usuario. Digite 'P' para participante, 'E' para especialista ou 'O' para organizador  : ");
				usuario.setTipo(scanner.next().toUpperCase());
				validador = valida_usuario(usuario);
			} while (!validador);

			if (usuario.getTipo().equalsIgnoreCase("P")) {
				Participante participante = new Participante(usuario.getTipo());
				participante.setCPF(usuario.getCPF());
				participante.setSenha(usuario.getSenha());
				participantesPendentes.add(participante);

			} else if (usuario.getTipo().equalsIgnoreCase("O")) {
				Organizador usuarioOrganizador = new Organizador(usuario.getTipo());
				usuarioOrganizador.setCPF(usuario.getCPF());
				usuarioOrganizador.setSenha(usuario.getSenha());
				organizadores.add(usuarioOrganizador);
				Organizador organizador = new Organizador(usuarioOrganizador.getCPF(), usuarioOrganizador.getSenha(),
						usuarioOrganizador.getTipo());
				do {
					System.out.print("Digite sua função. Digite 'P' para program chairs, ou 'G' para general chairs: ");

					organizador.setSubTipo(scanner.next().toUpperCase());
					validador = valida_organizador(organizador);
				} while (!validador);

				if (organizador.getSubTipo().equalsIgnoreCase("P")) {
					ProgramChairs programchairs = new ProgramChairs(usuario.getTipo(), organizador.getSubTipo());
					programchairs.setCPF(organizador.getCPF());
					programchairs.setSenha(organizador.getSenha());
					organizadoresProgramChairs.add(programchairs);

				} else if (organizador.getSubTipo().equalsIgnoreCase("G")) {
					GeneralChairs generalchairs = new GeneralChairs(usuario.getTipo(), organizador.getSubTipo());
					generalchairs.setCPF(organizador.getCPF());
					generalchairs.setSenha(organizador.getSenha());
					organizadoresGeneralChairs.add(generalchairs);

				} else {
					new Exception("Organizador sem função cadastrada ou com função inválida");
					return;
				}

			} else if (usuario.getTipo().equalsIgnoreCase("E")) {
				Especialista usuarioespecialista = new Especialista(usuario.getTipo());
				usuarioespecialista.setCPF(usuario.getCPF());
				usuarioespecialista.setSenha(usuario.getSenha());
				especialistas.add(usuarioespecialista);
				Especialista especialista = new Especialista(usuarioespecialista.getCPF(),
						usuarioespecialista.getSenha(), usuarioespecialista.getTipo());
				do {
					System.out.print(
							"Digite sua função. Digite 'A' para autor de artigo, ou 'R' para revisor de artigo: ");
					especialista.setSubTipo(scanner.next().toUpperCase());
					validador = valida_especialista(especialista);
				} while (!validador);

				if (especialista.getSubTipo().equalsIgnoreCase("A")) {
					AutorArtigo autorArtgo = new AutorArtigo(usuario.getTipo(), especialista.getSubTipo());
					autorArtgo.setCPF(especialista.getCPF());
					autorArtgo.setSenha(especialista.getSenha());
					especialistasAutorArtigo.add(autorArtgo);

				} else if (especialista.getSubTipo().equalsIgnoreCase("R")) {
					RevisorArtigo revisorArtgo = new RevisorArtigo(usuario.getTipo(), especialista.getSubTipo());
					revisorArtgo.setCPF(especialista.getCPF());
					revisorArtgo.setSenha(especialista.getSenha());
					especialistasRevisorArtigo.add(revisorArtgo);

				} else {
					new Exception("Especialista sem função cadastrada ou com função inválida");
					return;
				}

			}

			usuarios.add(usuario);
			System.out.print("\nLogin efetuado com sucesso");

		} catch (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}

	}

	private void inscreverParticipante(Usuario usuarioParticipante) {
		try {

			if (!usuarios.contains(usuarioParticipante)) {
				System.out.print("Realize login para depois inscrever participante. ");
				new Exception("Login não realizado");
				return;
			}

			Scanner scanner = new Scanner(System.in);

			System.out.print("Nome do participante: ");
			usuarioParticipante.setNome(scanner.next().toUpperCase());

			System.out.print("Titulo Acadêmico do participante: ");
			usuarioParticipante.setTituloAcademico(scanner.next().toUpperCase());

			System.out.print("Data de nascimento do participante: ");
			usuarioParticipante.setNascimento(scanner.next().toUpperCase());

			System.out.print("Instituição de vínculo do participante: ");
			scanner.nextLine();
			usuarioParticipante.setInstituicaoVinculada(scanner.nextLine());

			usuariosPendentes.add(usuarioParticipante);
			System.out.print("Inscrição pendente de aprovação. ");
		} catch (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}
	}

	private void validarInscricao(Usuario usuarioGeneralChaiirs) {
		if (!usuarios.contains(usuarioGeneralChaiirs)) {
			System.out.print("Realize login para depois validar inscrições. ");
			new Exception("Login não realizado");
			return;
		}

		Organizador organizador = new Organizador(usuarioGeneralChaiirs.getCPF(), usuarioGeneralChaiirs.getSenha(),
				usuarioGeneralChaiirs.getTipo());

		if (!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("G");

		GeneralChairs generalChairs = new GeneralChairs(organizador.getCPF(), organizador.getSenha(),
				organizador.getTipo(), organizador.getSubTipo());

		if (!organizadoresGeneralChairs.contains(generalChairs)) {
			System.out.print("O Organizador não pode validar a inscrição, pois não é General Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}

		boolean validar = true;
		participantes.addAll(generalChairs.validarInscricao(usuariosPendentes, validar));
		for (Participante participanteInscrito : participantes) {

			System.out.println("\nO participante : " + participanteInscrito.getNome() + " do CPF :"
					+ participanteInscrito.getCPF() + " teve sua inscrição validada com sucesso.");

			System.out.println("\n");

		}
	}

	private void invalidarInscricao(Usuario usuarioGeneralChaiirs) {
		if (!usuarios.contains(usuarioGeneralChaiirs)) {
			System.out.print("Realize login para depois invalidar inscrições. ");
			new Exception("Login não realizado");
			return;
		}

		Organizador organizador = new Organizador(usuarioGeneralChaiirs.getCPF(), usuarioGeneralChaiirs.getSenha(),
				usuarioGeneralChaiirs.getTipo());

		if (!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("G");

		GeneralChairs generalChairs = new GeneralChairs(organizador.getCPF(), organizador.getSenha(),
				organizador.getTipo(), organizador.getSubTipo());

		if (!organizadoresGeneralChairs.contains(generalChairs)) {
			System.out.print("O Organizador não pode validar a inscrição, pois não é General Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}

		boolean validar = false;
		List<Participante> participantesInvalidadosList = generalChairs.validarInscricao(usuariosPendentes, validar);
		if (participantesInvalidadosList != null && participantesInvalidadosList.size() > 0
				&& !participantesInvalidadosList.isEmpty()) {
			System.out.print("Participantes com inscrições invalidadas: ");
			System.out.println("\n");
			for (int k = 0; k < participantesInvalidadosList.size(); k++) {

				System.out.print("Nome: " + participantesInvalidadosList.get(k).getNome() + "CPF: "
						+ participantesInvalidadosList.get(k).getCPF());
				System.out.println("\n");
			}

		}
	}

	private void emitirCertificado(Usuario usuarioGeneralChaiirs) {
		if (!usuarios.contains(usuarioGeneralChaiirs)) {
			System.out.print("Realize login para depois emitir certificados. ");
			new Exception("Login não realizado");
			return;
		}

		Organizador organizador = new Organizador(usuarioGeneralChaiirs.getCPF(), usuarioGeneralChaiirs.getSenha(),
				usuarioGeneralChaiirs.getTipo());

		if (!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode validar a inscrição, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("G");

		GeneralChairs generalChairs = new GeneralChairs(organizador.getCPF(), organizador.getSenha(),
				organizador.getTipo(), organizador.getSubTipo());

		if (!organizadoresGeneralChairs.contains(generalChairs)) {
			System.out.print("O Organizador não pode validar a inscrição, pois não é General Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}

		if (participantes.isEmpty() || participantes.size() < 1 || participantes == null) {
			System.out.print("Não existem participantes para emissão de certificado. ");
		}

		for (Participante participante : participantes) {
			if (participante.isAssistiuPalestra()) {
				String certificado = generalChairs.emitirCertificado(participante);
				System.out.println(certificado + " para o participante " + participante.getNome() + " de CPF "
						+ participante.getCPF() + ".");
			} else {
				System.out.println("O participante " + participante.getNome() + " de CPF " + participante.getCPF()
						+ " não teve o seu certificado emitido pois não atendeu os critérios mínimos necessários.");
			}
		}
	}

	private void submeterArtigo(Usuario usuarioEspecialista) {
		try {
			if (!usuarios.contains(usuarioEspecialista)) {
				System.out.print("Realize login para depois submeter um artigo. ");
				new Exception("Login não realizado");
				return;
			}

			Especialista especialista = new Especialista(usuarioEspecialista.getCPF(), usuarioEspecialista.getSenha(),
					usuarioEspecialista.getTipo());

			if (!especialistas.contains(especialista)) {
				System.out.print("O usuário não pode submeter artigo, pois não é Especialista. ");
				new Exception("Acesso não permitido");
				return;
			}
			especialista.setSubTipo("A");

			AutorArtigo autorArtigo = new AutorArtigo(especialista.getCPF(), especialista.getSenha(),
					especialista.getTipo(), especialista.getSubTipo());

			if (!especialistasAutorArtigo.contains(autorArtigo)) {
				System.out.print("O Especialista não pode submeter artigo, pois não é  Autor. ");
				new Exception("Acesso não permitido");
				return;
			}

			Artigo artigo = autorArtigo.submeterArtigo(autorArtigo);
			artigos.add(artigo);

		} catch (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}
	}

	private void enviarAvaliacao(Usuario usuarioEspecialista) {
		if (!usuarios.contains(usuarioEspecialista)) {
			System.out.print("Realize login para depois submeter um artigo. ");
			new Exception("Login não realizado");
			return;
		}

		Especialista especialista = new Especialista(usuarioEspecialista.getCPF(), usuarioEspecialista.getSenha(),
				usuarioEspecialista.getTipo());

		if (!especialistas.contains(especialista)) {
			System.out.print("O usuário não pode enviar avalição do  artigo, pois não é Especialista. ");
			new Exception("Acesso não permitido");
			return;
		}
		especialista.setSubTipo("A");

		RevisorArtigo revisorArtigo = new RevisorArtigo(especialista.getCPF(), especialista.getSenha(),
				especialista.getTipo(), especialista.getSubTipo());

		if (!especialistasAutorArtigo.contains(revisorArtigo)) {
			System.out.print("O Especialista não pode enviar avalição do artigo, pois não é  Revisor. ");
			new Exception("Acesso não permitido");
			return;
		}

		revisorArtigo.revisarArtigo(artigos, revisorArtigo);

	}

	private void visualizarAvaliacoes(Usuario usuario) {
		if (!usuarios.contains(usuario)) {
			System.out.print("Realize login para depois visualizar avaliações. ");
			new Exception("Login não realizado");
			return;
		}
		if (usuario.getTipo().equalsIgnoreCase("O")) {
			Organizador organizador = new Organizador(usuario.getCPF(), usuario.getSenha(), usuario.getTipo());

			if (!organizadores.contains(organizador)) {
				System.out.print("O usuário não pode visualizar avaliações, pois não é Organizador. ");
				new Exception("Acesso não permitido");
				return;
			}
			organizador.setSubTipo("P");

			ProgramChairs programChairs = new ProgramChairs(organizador.getCPF(), organizador.getSenha(),
					organizador.getTipo(), organizador.getSubTipo());

			if (!organizadoresProgramChairs.contains(programChairs)) {
				System.out.print("O Organizador não pode visualizar avaliações, pois não é Program Chairs. ");
				new Exception("Acesso não permitido");
				return;
			}

			programChairs.visualiarAvaliacao(artigos);

			for (Artigo artigo : artigos) {
				System.out.println("\nArtigo: " + artigo.getId());
				for (RevisorArtigo revisor : artigo.getRevisores()) {
					System.out.println("\nRevisores: " + revisor.getNome());
				}

				System.out.println("\n\n");
			}

		} else if (usuario.getTipo().equalsIgnoreCase("E")) {
			Especialista especialista = new Especialista(usuario.getCPF(), usuario.getSenha(), usuario.getTipo());

			if (!especialistas.contains(especialista)) {
				System.out.print("O usuário não pode visualizar avaliações, pois não é Especialista. ");
				new Exception("Acesso não permitido");
				return;
			}

			for (RevisorArtigo revisorartigo : especialistasRevisorArtigo) {
				if (revisorartigo.getCPF().equalsIgnoreCase(especialista.getCPF())) {
					RevisorArtigo revisor = new RevisorArtigo(especialista.getCPF(), especialista.getSenha(),
							especialista.getTipo(), especialista.getSubTipo());

					for (Artigo artigo : artigos) {
						if (artigo.getRevisores().contains(revisor)) {
							revisor.visualiarAvaliacao(artigo);
							System.out.println("\nArtigo: " + artigo.getId());
							System.out.println("\nRevisor: " + revisor.getNome());
						}
						System.out.println("\n\n");
					}
				} else {
					for (AutorArtigo autorartigo : especialistasAutorArtigo) {
						if (autorartigo.getCPF().equalsIgnoreCase(especialista.getCPF())) {

							AutorArtigo autor = new AutorArtigo(especialista.getCPF(), especialista.getSenha(),
									especialista.getTipo(), especialista.getSubTipo());

							for (Artigo artigo : artigos) {
								if (artigo.getAutores().contains(autor)) {
									autor.visualiarAvaliacao(artigo);
									System.out.println("\nArtigo: " + artigo.getId());
									for (RevisorArtigo revisor : artigo.getRevisores()) {
										System.out.println("\nRevisores: " + revisor.getNome());
									}

									System.out.println("\n\n");
								}
							}
						}
					}
				}
			}
		}
	}

	private void aceitarArtigo(Usuario usuarioProgramChaiirs) {
		if (!usuarios.contains(usuarioProgramChaiirs)) {
			System.out.print("Realize login para depois emitir certificados. ");
			new Exception("Login não realizado");
			return;
		}

		Organizador organizador = new Organizador(usuarioProgramChaiirs.getCPF(), usuarioProgramChaiirs.getSenha(),
				usuarioProgramChaiirs.getTipo());

		if (!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode aceitar artigo, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("P");

		ProgramChairs programChairs = new ProgramChairs(organizador.getCPF(), organizador.getSenha(),
				organizador.getTipo(), organizador.getSubTipo());

		if (!organizadoresProgramChairs.contains(programChairs)) {
			System.out.print("O Organizador não pode aceitar artigos, pois não é Program Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}

		artigos = programChairs.aceitarArtigo(artigos);
		for (Artigo artigo : artigos) {
			if (artigo.isArpovacao()) {

				System.out.println(" O " + artigo.getTitulo() + " de id " + artigo.getId() + ". Foi aceito.");
			}
		}
	}

	private void rejeitarArtigo(Usuario usuarioProgramChaiirs) {
		if (!usuarios.contains(usuarioProgramChaiirs)) {
			System.out.print("Realize login para depois emitir certificados. ");
			new Exception("Login não realizado");
			return;
		}

		Organizador organizador = new Organizador(usuarioProgramChaiirs.getCPF(), usuarioProgramChaiirs.getSenha(),
				usuarioProgramChaiirs.getTipo());

		if (!organizadores.contains(organizador)) {
			System.out.print("O usuário não pode aceitar artigo, pois não é Organizador. ");
			new Exception("Acesso não permitido");
			return;
		}
		organizador.setSubTipo("P");

		ProgramChairs programChairs = new ProgramChairs(organizador.getCPF(), organizador.getSenha(),
				organizador.getTipo(), organizador.getSubTipo());

		if (!organizadoresProgramChairs.contains(programChairs)) {
			System.out.print("O Organizador não pode aceitar artigos, pois não é Program Chairs. ");
			new Exception("Acesso não permitido");
			return;
		}

		artigos = programChairs.rejeitarArtigo(artigos);
		for (Artigo artigo : artigos) {
			if (!artigo.isArpovacao()) {

				System.out.println(" O " + artigo.getTitulo() + " de id " + artigo.getId() + ". Foi rejeitado.");
			}
		}
	}

	private void listarArtigosAceitos() {
		Collections.sort(artigos);
		if (artigos.isEmpty() || artigos.size() < 1 || artigos == null) {
			System.out.println("\nNão existem artigos aceitos\n");
		} else {
			for (Artigo artigo : artigos) {
				if (artigo.isArpovacao()) {
					System.out.println("\nArtigo : " + artigo.getTitulo());
					System.out.println("\n\n");
				}
			}
		}
	}

	private void listarArtigosNegados() {
		Collections.sort(artigos);
		if (artigos.isEmpty() || artigos.size() < 1 || artigos == null) {
			System.out.println("\nNão existem artigos negados\n");
		} else {
			for (Artigo artigo : artigos) {
				if (!artigo.isArpovacao()) {
					System.out.println("\nArtigo : " + artigo.getTitulo());
					System.out.println("\n\n");
				}
			}
		}
	}

	private void visualizarDadosArtigo(Usuario usuario) {
		if (artigos.isEmpty() || artigos.size() < 1 || artigos == null) {
			System.out.println("\nNão existem artigos\n");
		} else {
			for (Artigo artigo : artigos) {
				if (!artigo.isArpovacao()) {
					System.out.println("\nTitulo : " + artigo.getTitulo());
					System.out.println("\nResumo : " + artigo.getResumo());
					System.out.println("\nAQuantidade de páginas : " + artigo.getQtdPaginas());
					System.out.println("\nPalavras chvaes : " + artigo.getPalavaChave().toString());
					System.out.println("\nData de Submissão: " + artigo.getDataSubmissao());
					System.out.println("\nAutores : " + artigo.getAutores().toString());
					System.out.println("\n\n");
				}
			}
		}
	}

	private void listarParticipantes() {
		Collections.sort(participantes);
		if (participantes.isEmpty() || participantes.size() < 1 || participantes == null) {
			System.out.println("\nNão existem participantes inscritos\n");
		} else {
			for (Participante participante : participantes) {
				System.out.println("\nCPF: " + participante.getCPF());
				System.out.println("Nome: " + participante.getNome());
				System.out.println("Data de Nascimento: " + participante.getNascimento());
				System.out.println("\nTitulo Acadêmico: " + participante.getTituloAcademico());
				System.out.println("\nInstituição de vínculo: " + participante.getInstituicaoVinculada());
				System.out.println("\n\n");
			}
		}
	}

	public static void main(String[] args) {
		short opcao = 50;
		Scanner scanner = new Scanner(System.in);
		Main principal = new Main();
		Usuario usuario = new Usuario();
		do {
			principal.exibirMenu();

			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextShort();

			switch (opcao) {
			case 1:

				usuario = usuario.fazerLogin();
				principal.fazerLogin(usuario);

				break;
			case 2:

				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("P")) {
						principal.inscreverParticipante(usuario);
					} else {
						System.out.println("Apenas participantes podem realizar inscrições ");
					}

				}
				break;
			case 3:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("O")) {
						principal.validarInscricao(usuario);
					} else {
						System.out.println("Apenas Organizadores podem validar inscrições ");
					}
				}
				break;
			case 4:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("O")) {
						principal.invalidarInscricao(usuario);
					} else {
						System.out.println("Apenas Organizadores podem invalidar inscrições ");
					}
				}
				break;
			case 5:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("O")) {
						principal.emitirCertificado(usuario);
					} else {
						System.out.println("Apenas Organizadores podem validar inscrições ");
					}
				}
				break;
			case 6:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("E")) {
						principal.submeterArtigo(usuario);
					} else {
						System.out.println("Apenas especialistas podem submeter artigos ");
					}
				}

				break;
			case 7:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("E")) {
						principal.enviarAvaliacao(usuario);
					} else {
						System.out.println("Apenas especialistas podem enviar avalições de  artigos ");
					}
				}

				break;
			case 8:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("E") || usuario.getTipo().equalsIgnoreCase("O")) {
						principal.visualizarAvaliacoes(usuario);
					} else {
						System.out.println(
								"Apenas especialistas e organizadores podem visualizar avalições de  artigos ");
					}
				}

				break;
			case 9:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("O")) {
						principal.aceitarArtigo(usuario);
					} else {
						System.out.println("Apenas Organizadores podem aceitar artigos ");
					}
				}

				break;
			case 10:
				if (usuario.getCPF() == null || usuario.getCPF().isEmpty()) {
					System.out.println("Realize o login antes de acessar as demais opções ");
				} else {
					if (usuario.getTipo().equalsIgnoreCase("O")) {
						principal.rejeitarArtigo(usuario);
					} else {
						System.out.println("Apenas Organizadores podem aceitar artigos ");
					}
				}

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
			case 15:
				System.out.println("Programa encerrado.");
				break;

			default:
				principal.exibirMenu();
			}
		} while (opcao != 15);
	}
}
