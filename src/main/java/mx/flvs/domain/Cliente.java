package mx.flvs.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name= "clientes")
public class Cliente implements Serializable{
    
    private static Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @NotNull
    @Email
    private String email;
    
    private String telefono;
    
    @NotNull
    private float saldo;
    
    public long getIdCliente(){
        return this.idCliente;
    }
    
    public void setIdCliente(long idCliente){
        this.idCliente = idCliente;
    }
}
