/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.service.seguridad;

import java.util.List;
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.service.generico.GenericoService;

public interface EmpleadoService extends GenericoService<EmpleadoEntity>{
    List<EmpleadoEntity> findByDni(String employee_dni);
}
