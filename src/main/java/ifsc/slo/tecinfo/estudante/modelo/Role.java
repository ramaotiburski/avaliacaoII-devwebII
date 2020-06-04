/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ramao
 */
@Entity
public class Role implements GrantedAuthority{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codRole;
    private String nomeRole;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Role(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public Role() {
    }

    public int getCodRole() {
        return codRole;
    }

    public void setCodRole(int codRole) {
        this.codRole = codRole;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
    
    
    
    
}
