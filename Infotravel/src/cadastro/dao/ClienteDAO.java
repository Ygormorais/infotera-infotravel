package cadastro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cadastro.model.Cliente;

public class ClienteDAO {
	
	private Cliente cliente = new Cliente();

	public ClienteDAO() {}
	
	public static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Cliente.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}
	
	public Cliente create(Cliente cliente) {
		Session session = ClienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();
		return cliente;
	}
	
	public Cliente readById(Long id) {
		Session session = ClienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		Cliente c = session.find(Cliente.class, id);
		session.getTransaction().commit();
		return c;
	}
	
	public Cliente readByCPF(String cpf) {
		Session session = ClienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		cliente = (Cliente) session.createQuery("SELECT p FROM Cliente p WHERE p.cpf = '"+cpf+"'").getSingleResult();
		System.out.println("CPF de: "+cliente.getNome()+"= "+cliente.getCpf()+".");
		session.getTransaction().commit();
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> readAll() {
		Session session = ClienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		List<Cliente> listaClientes = session.createQuery("SELECT p FROM Cliente p ORDER BY p.id ASC").getResultList();
		session.getTransaction().commit();
		return listaClientes;
	}
	
	public Cliente updateById(Long id, Cliente pac) {
		
		Session session = ClienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		this.cliente = session.find(Cliente.class, id);
		this.cliente.setCpf(pac.getCpf());
		this.cliente.setDataDeAtendimento(pac.getDataDeAtendimento());
		this.cliente.setEmail(pac.getEmail());
		this.cliente.setEndereco(pac.getEndereco());
		this.cliente.setBairro(pac.getBairro());
		this.cliente.setComplemento(pac.getComplemento());
		this.cliente.setNome(pac.getNome());
		this.cliente.setCidade(pac.getCidade());
		session.merge(this.cliente);
		session.getTransaction().commit();
		return this.cliente;
	}
	
	public Cliente removeById(Long id) {
		Session session = ClienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		this.cliente = session.find(Cliente.class, id);
		session.delete(this.cliente);
		session.getTransaction().commit();
		return this.cliente;
	}

}
