package uea.pagamentos_api.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uea.pagamentos_api.models.enums.Tipo;

@Entity
public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerar id automático
	private Long codigo;
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	@NotNull(message = "Data de vencimento é obrigatório")
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	@NotNull(message = "Valor é obrigatório")
	private BigDecimal valor;
	private String observacao;
	@NotNull(message = "Tipo é obrigatório")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	@NotNull(message = "Categoria é obrigatório")
	private Categoria categoria;
	@JsonIgnoreProperties({"endereco", "ativo"})
	@ManyToOne
	@JoinColumn(name="codigo_pessoa")
	@NotNull(message = "Pessoa é obrigatório")
	private Pessoa pessoa;

	public Lancamento() {
	}

	public Lancamento(Long codigo, String descricao, LocalDate dataVencimento, LocalDate dataPagamento,
			BigDecimal valor, String observacao, Tipo tipo, Categoria categoria, Pessoa pessoa) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.observacao = observacao;
		this.tipo = tipo;
		this.categoria = categoria;
		this.pessoa = pessoa;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Tipo getTipoLancamento() {
		return tipo;
	}

	public void setTipoLancamento(Tipo tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Lancamento(Long codigo) {
		super();
		this.codigo = codigo;
	}

}
