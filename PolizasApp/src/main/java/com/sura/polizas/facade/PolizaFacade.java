package com.sura.polizas.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sura.polizas.bean.Asegurado;
import com.sura.polizas.bean.RespuestaValidaBean;
import com.sura.polizas.datos.PolizasRepository;
import com.sura.polizas.entidades.Poliza;
import com.sura.polizas.entidades.TipoPoliza;

@Component
public class PolizaFacade implements IPolizaFacade{

	@Autowired
	PolizasRepository polizasRepository;
	
	@Autowired
	AseguradoFacade aseguradoFacade;
	
	@Autowired
	VehiculoFacade vehiculoFacade;
	
	public Poliza findById(long id) {
		return polizasRepository.findById(id).orElse(new Poliza());
	}
	
	public RespuestaValidaBean validaPedido(long id, String tipoDocumento, String numeroDocumento, String placa) {
		Poliza poliza = findById(id);
		if(poliza==null) return RespuestaValidaBean.buildNoFinanciado("No existe la poliza con el id "+id) ;

		if(poliza.getTipoPoliza()==TipoPoliza.COLECTIVO.codigo) {
			Asegurado asegurado = new Asegurado(tipoDocumento, numeroDocumento, new Long(id).toString());
			RespuestaValidaBean respuesta = aseguradoFacade.valida(asegurado);
			if(!respuesta.isAsegurable()) return RespuestaValidaBean.buildNoFinanciado("El duenio del vehiculo no es empleado de la empresa") ;
			
		}else if(poliza.getTipoPoliza()==TipoPoliza.INDIVIDUAL.codigo) {
			String respuesta = vehiculoFacade.obtenerZona(placa);
			if(respuesta==null || !respuesta.equals(poliza.getZona()) ) return RespuestaValidaBean.buildNoFinanciado("La zona del vehiculo no aplica para la poliza") ;
			
		}else {
			return RespuestaValidaBean.buildNoFinanciado("La poliza es de un tipo no conocido") ;
			
		}
		
		return RespuestaValidaBean.buildFinanciado() ;
	}
	
}
