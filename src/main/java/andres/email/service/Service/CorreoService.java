package andres.email.service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import andres.email.service.Entity.Correo;
import andres.email.service.Repository.CorreoRepository;

@RestController
@RequestMapping("/correos")
@CrossOrigin
public class CorreoService {

	@Autowired
	CorreoRepository correoRepository;
	
	@GetMapping(path = "/ver-correos")
	public List<Correo> buscar(){
		return correoRepository.findAll();
	}
	
	@PostMapping(path = "/guardar-correo")
	public Correo guardar(@RequestBody Correo correo) {
		return correoRepository.save(correo);
	}
	
	@DeleteMapping(path = "/eliminar/{idcorreo}")
	public void eliminar(@PathVariable ("idcorreo") Integer idCorreo) {
		Optional<Correo> correo = correoRepository.findById(idCorreo);
		if(correo.isPresent()) {
			correoRepository.delete(correo.get());
		}
	}
}
