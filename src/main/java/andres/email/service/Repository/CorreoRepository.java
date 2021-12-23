package andres.email.service.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andres.email.service.Entity.Correo;

@Repository("correoRepository")
public interface CorreoRepository extends JpaRepository<Correo, Serializable>{

}
