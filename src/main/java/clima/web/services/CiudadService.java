package clima.web.services;

import java.util.ArrayList;
import java.util.List;

import clima.web.model.Ciudad;
import clima.web.model.Pais;

public class CiudadService {

	private List<Ciudad> ciudades;
	
	public CiudadService() {
		List<Pais> paises = getPaises();
		ciudades = new ArrayList<>();
		ciudades = new ArrayList<>();
		Ciudad ciudad = null;
		
		for (int i=0; i<15;i++) {
			ciudad = new  Ciudad();
			ciudad.setId(i);
			ciudad.setNombre("Ciudad-" + i * 3);
			ciudad.setPais(paises.get(i % 3));
			
			this.ciudades.add(ciudad);
		}
		
	}
	
	public Pais getPais(Integer id) {
		
		Pais pais = null;
		
		for (Pais paiss : getPaises()) {
			if(paiss.getId()==id) {
				pais = paiss;
				break;
			}
		}
		
		return pais;
		
	}
	
	public List<Ciudad> getCiudades(Integer idPais){
		
		List<Ciudad> ciudadesByPais = new ArrayList<>();
		
		/*	
			List<Ciudad) result = ciudades.stream()
			.filter(ciudad -> idPais.equals(ciudad.getPais().getId()))
			.collect(Collectors.toList());
		*/
		
		for (Ciudad ciudad : ciudades) {
			if(ciudad.getPais().getId() == idPais) {
				ciudadesByPais.add(ciudad);
			}
		}
		
		return ciudadesByPais;
	}
	
	public List<Pais> getPaises(){
		List<Pais> listaPaises = new ArrayList<>();
		
		Pais arg = new Pais();
		arg.setId(54);
		arg.setName("Argentina");
		
		Pais uru = new Pais();
		uru.setId(598);
		uru.setName("Uruguay");
		
		Pais bra = new Pais();
		bra.setId(55);
		bra.setName("Brasil");
		
		Pais chi = new Pais();
		chi.setId(56);
		chi.setName("Chile");
		
		Pais par = new Pais();
		par.setId(595);
		par.setName("Paraguay");
		
		listaPaises.add(arg);
		listaPaises.add(uru);
		listaPaises.add(bra);
		listaPaises.add(chi);
		listaPaises.add(par);
		
		return listaPaises;
	}
}
