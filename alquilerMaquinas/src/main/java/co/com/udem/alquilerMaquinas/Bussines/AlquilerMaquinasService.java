package co.com.udem.alquilerMaquinas.Bussines;

import java.util.List;

import co.com.udem.alquilerMaquinas.DTO.Estado;
import co.com.udem.alquilerMaquinas.domain.maquina;

public interface AlquilerMaquinasService {
	public List<maquina> obtenerListaMaquinas();
	public Estado insertarMaquina(maquina maquina);
	public Estado eliminarMaquina(Long idmaquina);
	public List<maquina> obtenerMaquina(Long idmaquina);
	public Estado actualizarMaquina(maquina m);
	
	public maquina getMaquina(Long id);
}
