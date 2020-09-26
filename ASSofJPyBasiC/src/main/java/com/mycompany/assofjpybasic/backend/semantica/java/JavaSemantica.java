/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mari2bar
 */
public class JavaSemantica {
    
    private final List<TablaJava> tabla;
    
    public JavaSemantica(){
        tabla = new ArrayList<>();
    }

    public List<TablaJava> getTabla() {
        return tabla;
    }
    
}
