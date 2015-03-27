package co.com.udem.alquilerMaquinas.Controller;

import java.util.List;

import org.codehaus.jackson.impl.JsonReadContext;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.udem.alquilerMaquinas.Bussines.AlquilerMaquinasService;
import co.com.udem.alquilerMaquinas.DTO.Estado;
import co.com.udem.alquilerMaquinas.domain.maquina;

@Controller
@RequestMapping("/maquinas")
public class AlquilerMaquinasController {
	@Autowired
	public AlquilerMaquinasService alquilermaquinasservice;
	
	//CRUD	
	//Create
	@RequestMapping("/insertarMaquina")
	public @ResponseBody Estado insertarMaquina(@RequestParam(value="nombre",required=true)String nombre, @RequestParam(value="precio",required=true)String precio, @RequestParam(value="descuento",required=true)String descuento,@RequestParam(value="descripcion",required=true)String descripcion,@RequestParam(value="disponible",required=true)String disponible,@RequestParam(value="imagen",required=true)String imagen){
		maquina m = new maquina(nombre, Float.parseFloat(precio), Integer.parseInt(descuento), descripcion, Boolean.parseBoolean(disponible), imagen);
		Estado estado = alquilermaquinasservice.insertarMaquina(m);
		System.out.println(estado);			
		return estado;
	}
	//Read-List
	@RequestMapping("/maquinas-listAPI")
	public @ResponseBody List<maquina> MoviesListAPI(@RequestParam(value = "name", required = false, defaultValue = "Santiago") String name){
		System.out.println(name);
		List<maquina> maquina = alquilermaquinasservice.obtenerListaMaquinas();
		return maquina;
	}
	//Read
	@RequestMapping("/obtenerMaquina")
	public @ResponseBody List<maquina> obtenerMaquina(@RequestParam(value="idMaquina",required=true)String idMaquina){				
		List<maquina> maquina = alquilermaquinasservice.obtenerMaquina(Long.parseLong(idMaquina)); 		
		return maquina;
	}
	//Update
	@RequestMapping("/actualizarMaquina")
	public @ResponseBody Estado actualizarMaquina(@RequestParam(value="id",required=true)String id, @RequestParam(value="nombre",required=true)String nombre, @RequestParam(value="precio",required=true)String precio, @RequestParam(value="descuento",required=true)String descuento,@RequestParam(value="descripcion",required=true)String descripcion,@RequestParam(value="disponible",required=true)String disponible,@RequestParam(value="imagen",required=true)String imagen){						
		Estado estado;
		maquina m = alquilermaquinasservice.getMaquina(Long.parseLong(id));
		if (m==null) {			
			return new Estado("Error");
		}
		m.setNombre(nombre);
		m.setPrecio(Float.parseFloat(precio));
		m.setDescripcion(descripcion);
		m.setDescuento(Integer.parseInt(descuento));
		m.setImagen(imagen);
		m.setDisponible(Boolean.parseBoolean(disponible));
		estado = alquilermaquinasservice.actualizarMaquina(m);
		System.out.println(estado);		
		return estado;
	}
	//Delete
	@RequestMapping("/eliminarMaquina")
	public @ResponseBody Estado eliminarMaquina(@RequestParam(value="idMaquina",required=true)String idMaquina){
		Estado estado = alquilermaquinasservice.eliminarMaquina(Long.parseLong(idMaquina));
		System.out.println(estado);
		return estado;
	}
	//------------------------------------------------------------------------------
	//Vistas
	@RequestMapping("/listaMaquinas")
	public ModelAndView listaMaquinas(){
		List<maquina> maquina = alquilermaquinasservice.obtenerListaMaquinas();
		ModelAndView mv = new ModelAndView();
		mv.addObject("maquina", maquina);		
		return mv;
	}
}
