package co.com.udem.alquilerMaquinas.DAO;

import java.util.List;

import co.com.udem.alquilerMaquinas.DTO.Estado;
import co.com.udem.alquilerMaquinas.domain.maquina;

public interface AlquilerMaquinasDAO {
	//Read-List
	public List<maquina> obtenerListaMaquinas();
	//Create
	public Estado insertarMaquina(maquina maquina);
	//Delete
	public Estado eliminarMaquina(Long idmaquina);
	//Read
	public List<maquina> obtenerMaquina(Long idmaquina);
	//Update
	public Estado actualizarMaquina(maquina m);
	
	public maquina getMaquina(Long id);
}
