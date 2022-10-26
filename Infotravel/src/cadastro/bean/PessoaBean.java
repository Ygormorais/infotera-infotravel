package cadastro.bean;

import java.util.Date;

public class PessoaBean {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String cep;
	private String complemento;
	private String bairro;
	private String cidade;
	
	@SuppressWarnings("deprecation")
	private Date atendimento = new Date(new Date().getYear(), 0, 1);
	
	private String consultarPorCPF;
	
	public PessoaBean() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Date atendimento) {
		this.atendimento = atendimento;
	}
	
	public String getConsultarPorCPF() {
		return consultarPorCPF;
	}
	
	public void setConsultarPorCPF(String consultarPorCPF) {
		this.consultarPorCPF = consultarPorCPF;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
