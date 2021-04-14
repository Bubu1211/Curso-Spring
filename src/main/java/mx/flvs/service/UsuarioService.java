package mx.flvs.service;

import java.util.ArrayList;
import mx.flvs.dao.UsuarioDao;
import mx.flvs.domain.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var usuario = usuarioDao.findByUsername(username);
        
        if(usuario == null) throw new UsernameNotFoundException(username);
        
        var roles = new ArrayList<GrantedAuthority>();
        
        for(Rol rol: usuario.getRoles())
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
            
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
