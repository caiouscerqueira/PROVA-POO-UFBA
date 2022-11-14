/**
 * 
 */
package vo;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author CaiS2Lai
 *
 */
public class Usuario extends Pessoa {

	private String tipo;
	public Usuario(String cpf, String nome, String nascimento, String tituloAcademico, String senha, String instituicaoVinculada,String tipo) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada);
		// TODO Auto-generated constructor stub
		this.tipo = tipo; 
	}

	/**
	 * @param cPF
	 * @param senha
	 * @param tipo
	 */
	
	public Usuario(String cPF, String senha, String tipo) { 
		super(cPF, senha);
		this.tipo = tipo; 
	}
		 
	public Usuario(String cpf, String senha) { 
		super(cpf,senha);
	 
	// TODO Auto-generated constructor stub 
	}
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param tipo
	 */
	public Usuario(String tipo) {
		this.tipo = tipo;
	}

	public Usuario(String cpf, String nome, String nascimento, String tituloAcademico, String senha,
			String instituicaoVinculada) {
		super(cpf, nome, nascimento, tituloAcademico, senha, instituicaoVinculada);
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	private static boolean valida_cpf(Usuario usuario){
		 if(usuario.getCPF().isEmpty()){
				System.out.print("O CPF não pode ser vazio.\n");
				return false;
			}else if(!usuario.getCPF().matches("[0-9]+")) {
				System.out.print("Digite apenas os números do CPF.\n");
				return false;
			}else if(usuario.getCPF().length() != 11) {
				System.out.print("Digite todos os números do CPF.\n");
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
	public Usuario fazerLogin(){
		Scanner scanner = new Scanner(System.in);
		
		Usuario usuario = new Usuario();
		
		boolean validador = false;
		try {
			do {
				System.out.print("Digite o CPF para realizar o login: ");
				usuario.setCPF(scanner.next());
				validador = valida_cpf(usuario);
			}while (!validador);	
			
			do {
				System.out.print("Digite sua senha, ela dever conter entre 6 e 8 caracteres: ");
				scanner.nextLine();
				usuario.setSenha(scanner.next());
				validador = valida_senha(usuario);
			}while (!validador);		
			
		}catch  (Exception e) {
			System.out.print("Erro: " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tipo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		return Objects.equals(tipo, other.tipo);
	}
	
	
	
	
}
