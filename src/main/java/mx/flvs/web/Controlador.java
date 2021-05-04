package mx.flvs.web;

import javax.validation.Valid;
import mx.flvs.domain.Cliente;
import mx.flvs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {
    
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Cliente cliente){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        clienteService.guardar(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/editar")
    public String editar(@ModelAttribute Cliente cliente, Model model){
        cliente = clienteService.findById(cliente);
        model.addAttribute("cliente", cliente);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Cliente cliente){
        clienteService.eliminar(cliente);
        return "redirect:/";
    }
    
}
