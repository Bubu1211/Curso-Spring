package mx.flvs.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable{
    
    private static Long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_rol")
    private int idRol;
    
    @NotNull
    private String nombre;
}
