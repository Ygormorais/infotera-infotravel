package cadastro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import cadastro.dao.ClienteDAO;
import cadastro.model.Cliente;

public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1840286588260281394L;
	private Cliente cliente;
	private Cliente clienteConsulta;
	private Cliente clienteCPF = new Cliente();
	private Cliente clienteAtualizado;
	private List<Cliente> clientes;
	private List<Cliente> listaPacAtual;
	private PessoaBean pessoaBean;
	private AtualizaBean atualizaBean;
	private ClienteDAO clienteDao;

	private Long deletePorId;

	@PostConstruct
	public void construirObjetos() {
		cliente = new Cliente();
		clientes = new ArrayList<>();
		listaPacAtual = new ArrayList<>();
		pessoaBean = new PessoaBean();
		atualizaBean = new AtualizaBean();
		clienteDao = new ClienteDAO();
		clienteAtualizado = new Cliente();
		clienteConsulta = new Cliente();
	}

	public CadastroBean() {
	}

	// -------------------------------------------------------------------------- ||
	// ---------------------------------------------------------------------------------------

	public Cliente salvar() {
		Cliente c = new Cliente(pessoaBean.getCpf(), pessoaBean.getAtendimento(), pessoaBean.getEmail(),
				pessoaBean.getEndereco(), pessoaBean.getNome(), pessoaBean.getBairro(), pessoaBean.getCidade(), pessoaBean.getComplemento());
		clientes.add(c);
		clienteDao.create(c);
		return c;
	}

	public Cliente obterClientePorId(Long id) {
		this.clienteConsulta = clienteDao.readById(id);
		return this.clienteConsulta;
	}

	public Cliente obterClientePorCPF(String cpf) {
		this.clienteCPF = clienteDao.readByCPF(cpf);
		this.listaPacAtual.clear();
		this.listaPacAtual.add(this.clienteCPF);
		return this.clienteCPF;
	}

	public List<Cliente> obterTodosClientes() {
		clientes.clear();
		clientes.addAll(clienteDao.readAll());
		return clientes;
	}

	public Cliente atualizarClientelPorId(Long id) {
		Cliente c = new Cliente(atualizaBean.getCpf(), atualizaBean.getAtendimento(), atualizaBean.getEmail(),
				atualizaBean.getEndereco(), atualizaBean.getNome(), atualizaBean.getBairro(), atualizaBean.getCidade(), atualizaBean.getComplemento());
		
		this.clienteAtualizado = clienteDao.updateById(id, c);
		this.obterTodosClientes();
		return this.clienteAtualizado;
	}

	public Cliente deletarClientePorId(Long id) {
		this.cliente = clienteDao.removeById(id);
		this.obterTodosClientes();
		return this.cliente;
	}

	// -------------------------------------------------------------------------- ||
	// ---------------------------------------------------------------------------------------

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public cadastro.dao.ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(cadastro.dao.ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}

	public cadastro.bean.PessoaBean getPessoaBean() {
		return pessoaBean;
	}

	public void setPessoaBean(cadastro.bean.PessoaBean pessoaBean) {
		this.pessoaBean = pessoaBean;
	}

	public Cliente getClienteConsulta() {
		return clienteConsulta;
	}

	public void setClienteConsulta(Cliente clienteConsulta) {
		this.clienteConsulta = clienteConsulta;
	}

	public Cliente getClienteAtualizado() {
		return clienteAtualizado;
	}

	public Cliente getClienteCPF() {
		return clienteCPF;
	}

	public void setClienteCPF(Cliente clienteCPF) {
		this.clienteCPF = clienteCPF;
	}

	public List<Cliente> getListaPacAtual() {
		return listaPacAtual;
	}

	public void setListaPacAtual(List<Cliente> listaPacAtual) {
		this.listaPacAtual = listaPacAtual;
	}


	public void setClienteAtualizado(Cliente clienteAtualizado) {
		this.clienteAtualizado = clienteAtualizado;
	}

	public Long getDeletePorId() {
		return deletePorId;
	}

	public void setDeletePorId(Long deletePorId) {
		this.deletePorId = deletePorId;
	}

	public AtualizaBean getAtualizaBean() {
		return atualizaBean;
	}

	public void setAtualizaBean(AtualizaBean atualizaBean) {
		this.atualizaBean = atualizaBean;
	}

}
