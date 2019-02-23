/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henry
 */
public class RolDePago {
    
    ArrayList<Empleado> listaEmpleados;

    public RolDePago(String archivo){
        listaEmpleados=new ArrayList<Empleado>();
        FileReader f = null;
        try {
            String cadena;
            f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                String[] parts = cadena.split("=");
                this.listaEmpleados.add(new Empleado(parts[0], parts[1]));
                
            }   b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RolDePago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RolDePago.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(RolDePago.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimirSueldos(){
        for(Empleado empleado:listaEmpleados){
            System.out.println("The amount to pay "+empleado.getNombre()+" is: "+empleado.calcularSueldo()+" USD");
        }
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    
    
}
