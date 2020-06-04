/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.controller;

import ifsc.slo.tecinfo.estudante.modelo.Usuario;
import ifsc.slo.tecinfo.estudante.security.ImplementsUserDetailsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ramao
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private ImplementsUserDetailsService usuarioService;
    
    //solicitação para registro do usuario
    @GetMapping("/cadastro")
    public String showRegistrationForm(Model model, Usuario usuario) {
        model.addAttribute(usuario);
        return "registration";
    }
    
    //registro do usuario
    @PostMapping("/cadastro")
    public String registerUserAccount(@Valid Usuario usuario, BindingResult result) {

        usuarioService.save(usuario);
        return "redirect:/estudantes/mostrar";
    }
    
}
