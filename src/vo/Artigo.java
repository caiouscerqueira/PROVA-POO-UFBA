/**
 * 
 */
package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author CaiS2Lai
 *
 */
public class Artigo implements Comparable<Artigo> {
	
	private static int id = 0;
	private String titulo;
	private String resumo;
	private ArrayList<String> palavaChave;
	private String qtdPaginas;
	private Date dataSubmissao;
	private boolean aprovacao;
	private List<AutorArtigo> autores;
	private List<RevisorArtigo> revisores;
	private static final int QTD_MAX_AUTORES = 5;
	private static final int QTD_MIN_AUTORES = 1;
	
	/**
	 * @param id
	 * @param titulo
	 * @param resumo
	 * @param palavaChave
	 * @param qtdPaginas
	 * @param dataSubmissao
	 */
	public Artigo(int id, String titulo, String resumo, ArrayList<String> palavaChave, String qtdPaginas,
			Date dataSubmissao) {
		this.id = id ++;
		this.titulo = titulo;
		this.resumo = resumo;
		this.palavaChave = palavaChave;
		this.qtdPaginas = qtdPaginas;
		this.dataSubmissao = dataSubmissao;
	}
	
		/**
	 * @param id
	 * @param titulo
	 * @param resumo
	 * @param palavaChave
	 * @param qtdPaginas
	 * @param dataSubmissao
	 * @param autores
	 */
	public Artigo(int id, String titulo, String resumo, ArrayList<String> palavaChave, String qtdPaginas,
			Date dataSubmissao, List<AutorArtigo> autores) {
		this.id = id++;
		this.titulo = titulo;
		this.resumo = resumo;
		this.palavaChave = palavaChave;
		this.qtdPaginas = qtdPaginas;
		this.dataSubmissao = dataSubmissao;
		this.autores = autores;
	}
	
	

	/**
		 * 
		 */
		public Artigo() {
			this.id = id++;
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
	public String getQtdPaginas() {
		return qtdPaginas;
	}

	/**
	 * @param qtdPaginas the qtdPaginas to set
	 */
	public void setQtdPaginas(String qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	/**
	 * @return the dataSubmissao
	 */
	public Date getDataSubmissao() {
		return dataSubmissao;
	}

	/**
	 * @param dataSubmissao the dataSubmissao to set
	 */
	public void setDataSubmissao(Date dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}

	/**
	 * @return the autores
	 */
	public List<AutorArtigo> getAutores() {
		return autores;
	}

	/**
	 * @param autores the autores to set
	 */
	public void setAutores(List<AutorArtigo> autores) {
		this.autores = autores;
	}
	
	
	/**
	 * @return the revisores
	 */
	public List<RevisorArtigo> getRevisores() {
		return revisores;
	}

	/**
	 * @param revisores the revisores to set
	 */
	public void setRevisores(List<RevisorArtigo> revisores) {
		this.revisores = revisores;
	}

	/**
	 * @return the qtdMaxAutores
	 */
	public static int getQtdMaxAutores() {
		return QTD_MAX_AUTORES;
	}

	/**
	 * @return the qtdMinAutores
	 */
	public static int getQtdMinAutores() {
		return QTD_MIN_AUTORES;
	}

	/**
	 * @return the arpovacao
	 */
	public boolean isArpovacao() {
		return aprovacao;
	}

	/**
	 * @param arpovacao the arpovacao to set
	 */
	public void setArpovacao(boolean aprovacao) {
		this.aprovacao = aprovacao;
	}

	public int compareTo(Artigo a1, Artigo a2) {
		// TODO Auto-generated method stub
		 return a1.getTitulo().compareTo(a2.getTitulo());
	}

	@Override
	public int compareTo(Artigo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aprovacao, autores, dataSubmissao, palavaChave, qtdPaginas, resumo, revisores, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Artigo)) {
			return false;
		}
		Artigo other = (Artigo) obj;
		return aprovacao == other.aprovacao && Objects.equals(autores, other.autores)
				&& Objects.equals(dataSubmissao, other.dataSubmissao) && Objects.equals(palavaChave, other.palavaChave)
				&& qtdPaginas == other.qtdPaginas && Objects.equals(resumo, other.resumo)
				&& Objects.equals(revisores, other.revisores) && Objects.equals(titulo, other.titulo);
	}

	/**
	 * @return the avaliacao
	 */
	
}
