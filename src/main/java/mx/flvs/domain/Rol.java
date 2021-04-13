package mx.flvs.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable{
    
    private static Long serialVersionUID = 1L
}
