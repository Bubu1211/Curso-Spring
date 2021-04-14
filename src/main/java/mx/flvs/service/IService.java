package mx.flvs.service;

import java.util.List;
import mx.flvs.domain.Cliente;

public interface IService {
    
    public List<Cliente> listarClientes();
    public void guardar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public Cliente findById(Cliente cliente);
}
