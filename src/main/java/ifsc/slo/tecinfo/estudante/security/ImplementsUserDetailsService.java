/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.security;

import ifsc.slo.tecinfo.estudante.modelo.Role;
import ifsc.slo.tecinfo.estudante.modelo.Usuario;
import ifsc.slo.tecinfo.estudante.repositorio.UsuarioRepository;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramao
 */
@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository ur;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = ur.findByLogin(login);
        
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario nao encontrado!"); 
        }
        return new User(usuario.getLogin(), usuario.getSenha(), true,true,true,true,usuario.getAuthorities());
    }
    
    //salva o usuario no banco de dados
    public Usuario save(Usuario user) {
        Usuario usuario = new Usuario();
        usuario.setNome(user.getNome());
        usuario.setLogin(user.getLogin());
        usuario.setTipo(user.getTipo());
        usuario.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
        String vetor[] = user.getTipo().split(",");
        List<Role> roles = new ArrayList<>();
        if(vetor.length>1){
            for (String role : vetor) {
                roles.add(new Role(role));
            }
            usuario.setRoles(roles);
        }else{
            roles.add(new Role(user.getTipo()));
            usuario.setRoles(roles);
        }
        return ur.save(usuario);
    }
    
}
