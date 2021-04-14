package mx.flvs.dao;

import mx.flvs.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long>{
    
}
