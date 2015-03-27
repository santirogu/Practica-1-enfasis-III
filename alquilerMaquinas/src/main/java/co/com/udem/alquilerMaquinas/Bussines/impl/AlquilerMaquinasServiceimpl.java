package co.com.udem.alquilerMaquinas.Bussines.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.udem.alquilerMaquinas.Bussines.AlquilerMaquinasService;
import co.com.udem.alquilerMaquinas.DAO.AlquilerMaquinasDAO;
import co.com.udem.alquilerMaquinas.DTO.Estado;
import co.com.udem.alquilerMaquinas.domain.maquina;

@Service
public class AlquilerMaquinasServiceimpl implements AlquilerMaquinasService {

	@Autowired
	private AlquilerMaquinasDAO alquilermaquinasDAO;
	
	@Transactional
	public List<maquina> obtenerListaMaquinas() {
		List<maquina> maquina = alquilermaquinasDAO.obtenerListaMaquinas();				
		//float precioDes = 0;		
		for (maquina maquina2 : maquina) {	
			double dscto = (maquina2.getDescuento())/(double)100;
			float precioDes = (float) (maquina2.getPrecio() - (maquina2.getPrecio()*(dscto)));
			//System.out.println(dscto);
			maquina2.setPreciodescuento(precioDes);			
		}
		return maquina;
	}

	@Transactional
	public Estado insertarMaquina(maquina maquina) {
		return alquilermaquinasDAO.insertarMaquina(maquina);
	}

	@Transactional
	public Estado eliminarMaquina(Long idmaquina) {
		return alquilermaquinasDAO.eliminarMaquina(idmaquina);
	}

	@Transactional
	public List<maquina> obtenerMaquina(Long idmaquina) {
		return alquilermaquinasDAO.obtenerMaquina(idmaquina);
	}

	@Transactional
	public Estado actualizarMaquina(maquina m) {
		return alquilermaquinasDAO.actualizarMaquina(m);
	}

	@Transactional
	public maquina getMaquina(Long id) {
		return alquilermaquinasDAO.getMaquina(id);
	}

}
