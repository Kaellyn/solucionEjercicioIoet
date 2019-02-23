/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Henry
 */
public class Horario {
    String dia;
    String horaInicio;
    String horaFin;
            
    public Horario(String dia, String horaInicio, String horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public double valorHorario(){
        
        String[] diasSemana=new String[]{"MO","TU","WE","TH","FR","SA","SU"};
        int categoriaDia=0;
        double valorHora=0;
        categoriaDia=this.dia.equals(diasSemana[5]) || this.dia.equals(diasSemana[6])?1:categoriaDia;
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime tiempoInicio = LocalTime.parse(this.horaInicio, dateTimeFormatter);
        LocalTime tiempoFin = LocalTime.parse(this.horaFin, dateTimeFormatter);
        
        if(tiempoInicio.isAfter(LocalTime.parse("18:00")))
            valorHora=categoriaDia==0?20:25;
        else {
            if(tiempoInicio.isAfter(LocalTime.parse("09:00")))
                valorHora=categoriaDia==0?15:20;
            else
                valorHora=categoriaDia==0?25:30;
        }
        double diffHoras = Duration.between(tiempoInicio, tiempoFin).getSeconds();
        
        return (diffHoras/3600) * valorHora;
    }
    public double valorHorarioDos(){
        
        String[] diasSemana=new String[]{"MO","TU","WE","TH","FR","SA","SU"};
        int categoriaDia=0;
        double valorHora=0;
        categoriaDia=this.dia.equals(diasSemana[5]) || this.dia.equals(diasSemana[6])?1:categoriaDia;
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime tiempoInicio = LocalTime.parse(this.horaInicio, dateTimeFormatter);
        LocalTime tiempoFin = LocalTime.parse(this.horaFin, dateTimeFormatter);
        double valor=0;
        
        if(tiempoInicio.isBefore(LocalTime.parse("09:01")) && tiempoFin.isAfter(LocalTime.parse("00:00"))){
            LocalTime tiempoInicioTemp=tiempoInicio;
            LocalTime tiempoFinTemp=tiempoFin;
            valorHora=categoriaDia==0?25:30;
            if(tiempoInicio.isBefore(LocalTime.parse("00:01")))
                tiempoInicioTemp=LocalTime.parse("00:00", dateTimeFormatter);
            if(tiempoFin.isAfter(LocalTime.parse("09:00")))
                tiempoFinTemp=LocalTime.parse("09:01", dateTimeFormatter);
            valor+=(Duration.between(tiempoInicioTemp, tiempoFinTemp).getSeconds()/3600)*valorHora;
        }
        if(tiempoInicio.isBefore(LocalTime.parse("18:01")) && tiempoFin.isAfter(LocalTime.parse("09:00"))){
            LocalTime tiempoInicioTemp=tiempoInicio;
            LocalTime tiempoFinTemp=tiempoFin;
            valorHora=categoriaDia==0?15:20;
            if(tiempoInicio.isBefore(LocalTime.parse("09:01")))
                tiempoInicioTemp=LocalTime.parse("09:00", dateTimeFormatter);
            if(tiempoFin.isAfter(LocalTime.parse("18:00")))
                tiempoFinTemp=LocalTime.parse("18:01", dateTimeFormatter);
            valor+=(Duration.between(tiempoInicioTemp, tiempoFinTemp).getSeconds()/3600)*valorHora;
        }
        if(tiempoInicio.isBefore(LocalTime.parse("23:59")) && tiempoFin.isAfter(LocalTime.parse("18:00"))){
            LocalTime tiempoInicioTemp=tiempoInicio;
            LocalTime tiempoFinTemp=tiempoFin;
            valorHora=categoriaDia==0?20:25;
            if(tiempoInicio.isBefore(LocalTime.parse("18:01")))
                tiempoInicioTemp=LocalTime.parse("18:00", dateTimeFormatter);
            if(tiempoFin.isAfter(LocalTime.parse("23:59")))
                tiempoFinTemp=LocalTime.parse("23:59", dateTimeFormatter);
            valor+=(Duration.between(tiempoInicioTemp, tiempoFinTemp).getSeconds()/3600)*valorHora; 
        }
        return valor;
    }
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
    
    
    
}
