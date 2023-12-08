package pe.com.subacomcompras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {
    //definiendo la pagina que cargara cuando se ejecute
    //la aplicacion
    @GetMapping()
    public String MostrarInicio() {
        return "index";
    }
    
     //metodo validar que recibe los valores desde el formulario que se encuentra
    //en el index
    @PostMapping("/validar")
    //para almacenar los valores que vienen del index --> cajas de texto
    //utilizamos la anotacion @RequestParam, que deben de tener el mismo nombre
    //de las cajas de texto del formulario
    public String ValidarUsuario(@RequestParam String dni,
            @RequestParam String password){
        System.out.println("dni"+dni + ", contraseña: "+password);
        //comparamos los valores recibidos desde el formulario
        if(dni.equals("74060336")&& password.equals("123456")){
            //redireccionamos hacia el menu principal
            return "redirect:/home";
        }else{
            //redireccionamos al login --> index
            return "redirect:/";
        }
        
    }

    @GetMapping("/home")
    public String MostrarMenu() {
        return "Home/home";
    }
}
