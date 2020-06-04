/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsc.slo.tecinfo.estudante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ramao
 */
@Controller
public class SecurityController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/403")
    public String acessoNegado() {
        return "erro403";
    }
    
    @GetMapping("/")
    public String mostrar() {
        return "redirect:/estudantes/mostrar";
    }
    
}
