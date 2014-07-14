package br.com.wofsolutions.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wof_sub_categoria")
public class SubCategoriaCid10 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "subcat")
	private String subCat;
	/**
	 * indica se a situação da categoria em relação à classificação
	 * cruz/asterisco: em branco: não tem dupla classificação; +: classificação
	 * por etiologia; e *: classificação por manifestação.
	 */
	private String classif;

	/**
	 * indica se a subcategoria só pode ser usada para homens ou mulheres: em
	 * branco: pode ser utilizada em qualquer situação; F: só deve ser utilizada
	 * para o sexo feminino; e M: só deve ser utilizada para o sexo masculino.
	 */
	private String restrsexo;

	/**
	 * indica se a subcategoria pode causar óbito:
	 * 
	 * em branco: não há restrição; e N: a subcategoria tem pouca probabilidade
	 * de causar óbito.
	 * 
	 * Observação: além disto, deve-se atentar para o fato de que as
	 * subcategorias da classificação asterisco não devem ser utilizadas na
	 * classificação de causas de óbitos, assim como as subcategorias do
	 * capítulo XIX e do capítulo XXI.
	 */
	@Column(name = "causa_obto")
	private String causaObto;

	/**
	 * descrição (nome) da categoria;
	 */

	@Column(length=1000)
	private String descricao;

	/**
	 * descrição (nome) abreviado da categoria, com até 50 caracteres (inclui o
	 * código da categoria);
	 */
	@Column(name = "descricao_abreviada")
	private String descAbrev;

	/**
	 * contém, quando a categoria tiver dupla classificação, o código da
	 * categoria segundo a outra classificação (nem todos os casos de dupla
	 * classificação contém este campo); e
	 */
	private String refer;

	/**
	 * contém o(s) código(s) de categorias excluídas que agora fazem parte desta
	 * categoria.
	 */
	private String excluidos;
	
	@ManyToOne
	@JoinColumn(name = "cat", referencedColumnName = "cat")
	private CategoriaCid10 categoria = new CategoriaCid10();
	
	
	

	public SubCategoriaCid10() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubCategoriaCid10(String subCat, String classif, String restrsexo,
			String causaObto, String descricao, String descAbrev, String refer,
			String excluidos, CategoriaCid10 categoria) {
		super();
		this.subCat = subCat;
		this.classif = classif;
		this.restrsexo = restrsexo;
		this.causaObto = causaObto;
		this.descricao = descricao;
		this.descAbrev = descAbrev;
		this.refer = refer;
		this.excluidos = excluidos;
		this.categoria = categoria;
	}

	public String getSubCat() {
		return subCat;
	}

	public void setSubCat(String subCat) {
		this.subCat = subCat;
	}

	public String getClassif() {
		return classif;
	}

	public void setClassif(String classif) {
		this.classif = classif;
	}

	public String getRestrsexo() {
		return restrsexo;
	}

	public void setRestrsexo(String restrsexo) {
		this.restrsexo = restrsexo;
	}

	public String getCausaObto() {
		return causaObto;
	}

	public void setCausaObto(String causaObto) {
		this.causaObto = causaObto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescAbrev() {
		return descAbrev;
	}

	public void setDescAbrev(String descAbrev) {
		this.descAbrev = descAbrev;
	}

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public String getExcluidos() {
		return excluidos;
	}

	public void setExcluidos(String excluidos) {
		this.excluidos = excluidos;
	}

	public CategoriaCid10 getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaCid10 categoria) {
		this.categoria = categoria;
	}


	

}
