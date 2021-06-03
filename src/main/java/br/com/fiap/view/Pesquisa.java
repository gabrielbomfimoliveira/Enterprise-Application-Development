package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisa {
	
	public static void main(String[] args) {
		
		//Obter o EntityManager
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar a CidadeDao
		CidadeDAO cidadeDAO = new CidadeDAOImpl(em);
		
		//Pesquisar as cidades
		List<Cidade> cidades = cidadeDAO.listar();
		//Exibir todas as cidades
		
		System.out.println("Listar as cidades: ");
		for(Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Pesquisar as cidades por ddd
		//Cidade = cidadeDAO.buscarPorDdd(11);
		cidades = cidadeDAO.buscarPorDdd(11);
		System.out.println("Buscar cidades por DDD");
		for(Cidade cidade: cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getDdd());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
		
		
	}

}
