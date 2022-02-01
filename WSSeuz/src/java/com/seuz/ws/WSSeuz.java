/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.ws;

import com.seuz.dao.ProcesoDAO;
import com.seuz.to.EmployeeTO;
import com.seuz.util.Util;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author freet
 */
@WebService(serviceName = "WSSeuz", targetNamespace = "ws.com.seuz")
@Stateless
public class WSSeuz {

    @EJB(beanName = "controladorEmployee")
    private ProcesoDAO controladorEmployee;

    @WebMethod(operationName = "crearEmployee")
    public String crearEmployee(@WebParam(name = "name") String name, @WebParam(name = "lastaname") String lastname, @WebParam(name = "birthdate") String birthdate) {
        if (name == null || name.equals("")) {
            return "Name Requerido*";
        }
        if (lastname == null || lastname.equals("")) {
            return "Lastname Requerido*";
        }
        if (birthdate == null || birthdate.equals("")) {
            return "birthdate Requerido*";
        }
        Date fechacumple = Util.convertirFecha(birthdate);
        if (fechacumple == null) {
            return "Formato Inválido de Fecha (dd/mm/yyyy)";
        }
        double edad = Util.calcularEdad(fechacumple);
        if (edad < 18) {
            return "Empleado menor de edad";
        }
        if (controladorEmployee.find(name, lastname) != null) {
            return "El Empleado ya existe!";
        }
        return controladorEmployee.create(
                new EmployeeTO(name, lastname, fechacumple)
        ) ? "success" : "error";
    }
}
