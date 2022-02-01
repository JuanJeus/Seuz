/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author freet
 */
public class Util {

    private final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public static Date convertirFecha(String fecha) {
        try {
            return SDF.parse(fecha);
        } catch (Exception e) {
            System.out.println("ErrroComplueaños!!!!");
            return null;
        }
    }

    public static double calcularEdad(Date fechainicio) {
        try {
            Calendar calfin = Calendar.getInstance();
//            
            Calendar calinicio = Calendar.getInstance();
            calinicio.setTime(fechainicio);
//
            int anios = calfin.get(Calendar.YEAR) - calinicio.get(Calendar.YEAR);
            int mes = calfin.get(Calendar.MONTH) - calinicio.get(Calendar.MONTH);
            int dia = calfin.get(Calendar.DATE) - calinicio.get(Calendar.DATE);
            if (mes < 0 || (mes == 0 && dia < 0)) {
                anios--;
            }
            System.out.println("Edad: " + anios);
            return anios;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
