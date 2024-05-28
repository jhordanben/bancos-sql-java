package sql_java_teste_bancos.java;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import dao.UserPosDAO;
import model.Midnights;


public class TesteBancoJdbc {

	
 	@Test
	public void initBanco() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Midnights midnights = new Midnights();
		
		midnights.setId(11);
		midnights.setNome("guilty as sin");
		midnights.setEmail("the tortured poets departament@gmail.com");
		
						
		userPosDAO.salvar(midnights);
	}
	
	@Test
	public void initAtualizar() {
		try {
			
			UserPosDAO dao = new UserPosDAO();
			
			Midnights objetoBanco = dao.buscar(3);
			
			objetoBanco.setNome("NOME ALTERADO");
			
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	@Test
	public void initDeletar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(6);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
