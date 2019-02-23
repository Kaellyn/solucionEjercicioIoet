/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Henry
 */
public class Empleado {
    
    String nombre;
    ArrayList <Horario> horarios;

    public Empleado(String nombre, ArrayList<Horario> horarios) {
        this.nombre = nombre;
        this.horarios = horarios;
    }
    
    public Empleado(String nombre,String horarios){
        this.nombre = nombre;
        this.horarios=new ArrayList<Horario>();
        StringTokenizer tokens=new StringTokenizer(horarios,",");
        while(tokens.hasMoreTokens()){
            String datos=tokens.nextToken();
            this.horarios.add(new Horario(datos.substring(0, 2), datos.substring(2, 7), datos.substring(8, 13)));
        }
    }
    
    public double calcularSueldo(){
        double total=0;
        for(Horario horario : horarios){
            total+=horario.valorHorarioDos();
        }
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }
    
    
    
    
    
}
