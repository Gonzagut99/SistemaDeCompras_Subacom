package pe.com.subacomcompras.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.service.seguridad.EmpleadoService;

@Controller
public class InicioController {
    @Autowired
    private EmpleadoService servicio; 
    
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
            @RequestParam String password, RedirectAttributes redirectAttributes){
        List<EmpleadoEntity> empleados = servicio.findByDni(dni);

        if (!empleados.isEmpty()) {
            EmpleadoEntity empleado = empleados.get(0); // Asumiendo que DNI es único
            if (empleado.getUsuario().getUser_password().equals(password)) {
                // Si la contraseña es correcta, redireccionamos hacia el menú principal
                return "redirect:/home?id_employee="+empleado.getId_employee();
            } else {
                // Si la contraseña es incorrecta, agregamos un mensaje de error
                redirectAttributes.addFlashAttribute("error", "Contraseña incorrecta. Intente nuevamente.");
            }
        } else {
            // Si el DNI no existe, agregamos un mensaje de error
            redirectAttributes.addFlashAttribute("error", "DNI no encontrado. Intente nuevamente.");
        }

        // Redireccionamos al login
        return "redirect:/";
    }

    @GetMapping("/home")
    public String MostrarMenu(@RequestParam(required = false) Long id_employee, Model modelo) {
        modelo.addAttribute("employee",
                servicio.findById(id_employee).get());
        return "Home/home";
    }
}
