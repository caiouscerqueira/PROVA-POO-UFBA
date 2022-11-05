/**
 * 
 */
package vo;

import java.util.ArrayList;

/**
 * @author CaiS2Lai
 *
 */
public class Artigo {
	
	private int id;
	private String titulo;
	private String resumo;
	private ArrayList<String> palavaChave;
	private int qtdPaginas;
	private String dataSubmissao;
	
	/**
	 * @param id
	 * @param titulo
	 * @param resumo
	 * @param palavaChave
	 * @param qtdPaginas
	 * @param dataSubmissao
	 */
	public Artigo(int id, String titulo, String resumo, ArrayList<String> palavaChave, int qtdPaginas,
			String dataSubmissao) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.palavaChave = palavaChave;
		this.qtdPaginas = qtdPaginas;
		this.dataSubmissao = dataSubmissao;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * @param resumo the resumo to set
	 */
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	/**
	 * @return the palavaChave
	 */
	public ArrayList<String> getPalavaChave() {
		return palavaChave;
	}

	/**
	 * @param palavaChave the palavaChave to set
	 */
	public void setPalavaChave(ArrayList<String> palavaChave) {
		this.palavaChave = palavaChave;
	}

	/**
	 * @return the qtdPaginas
	 */
	public int getQtdPaginas() {
		return qtdPaginas;
	}

	/**
	 * @param qtdPaginas the qtdPaginas to set
	 */
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	/**
	 * @return the dataSubmissao
	 */
	public String getDataSubmissao() {
		return dataSubmissao;
	}

	/**
	 * @param dataSubmissao the dataSubmissao to set
	 */
	public void setDataSubmissao(String dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}
	
	
	

}
