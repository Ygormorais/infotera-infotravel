package cadastro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Classe de persistência para tabela cliente do banco de dados.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT p FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=20)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="data_de_atendimento", nullable=false)
	private Date dataDeAtendimento;

	@Column(nullable=false, length=40)
	private String email;

	@Column(nullable=false, length=40)
	private String endereco;

	@Column(nullable=false, length=20)
	private String nome;
	
	@Column(nullable=false, length=40)
	private String bairro;
	
	@Column(nullable=false, length=40)
	private String complemento;
	
	@Column(nullable=false, length=40)
	private String cidade;

	public Cliente() {}

	public Cliente(String cpf, Date dataDeAtendimento, String email, String endereco, String bairro, String complemento, String cidade, String nome) {
		this.cpf = cpf;
		this.dataDeAtendimento = dataDeAtendimento;
		this.email = email;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeAtendimento() {
		return this.dataDeAtendimento;
	}

	public void setDataDeAtendimento(Date dataDeAtendimento) {
		this.dataDeAtendimento = dataDeAtendimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}