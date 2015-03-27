package co.com.udem.alquilerMaquinas.DAO.impl;

import java.util.List;












import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.com.udem.alquilerMaquinas.DAO.AlquilerMaquinasDAO;
import co.com.udem.alquilerMaquinas.DTO.Estado;
import co.com.udem.alquilerMaquinas.domain.maquina;

@Repository
public class AlquilerMaquinasDAOimpl implements AlquilerMaquinasDAO {

	@Autowired
	private SessionFactory sessionfactory;		
	
	public List<maquina> obtenerListaMaquinas() {
		Session session = sessionfactory.getCurrentSession();
		Query query = session.createQuery("FROM maquina");		
		@SuppressWarnings("unchecked")
		List<maquina> listaMaquinas = (List<maquina>)query.list();
		return listaMaquinas;
	}

	public Estado insertarMaquina(maquina maquina) {
		Session session = sessionfactory.getCurrentSession();
		Estado estado;		
		try {					
			session.clear();
			session.saveOrUpdate(maquina);
			session.flush();
			estado = new Estado("Exito");
		} catch (Exception e2) {
			estado = new Estado(e2.getMessage().toString());
		}		
		return estado;		
	}

	public Estado eliminarMaquina(Long idmaquina) {
		Session session = sessionfactory.getCurrentSession();	
		Estado estado;		
		try {	
			maquina maquina = (maquina)session.load(maquina.class, idmaquina);
			session.clear();
			session.delete(maquina);	
			estado = new Estado("Exito");
		} catch (Exception e2) {
			estado = new Estado(e2.getMessage().toString());			
		}
		return estado;
	}

	public List<maquina> obtenerMaquina(Long idmaquina) {
		Session session = sessionfactory.getCurrentSession();
		session.clear();
		Query query = session.createQuery("FROM maquina WHERE idMaquina = :idm");
		query.setParameter("idm", idmaquina);		
		@SuppressWarnings("unchecked")
		List<maquina> listmaquina= (List<maquina>)query.list();
		return listmaquina;
	}

	public Estado actualizarMaquina(maquina m) {
		Session session = sessionfactory.getCurrentSession();		
		Estado estado;		
		try {
			session.update(m);
			estado = new Estado("Exito");
		} catch (Exception e) {
			estado = new Estado(e.getMessage().toString());
		}		
		return estado;
	}

	public maquina getMaquina(Long id) {	
		maquina mq =(maquina)sessionfactory.getCurrentSession().get(maquina.class, id);		
		return mq;
	}

}
