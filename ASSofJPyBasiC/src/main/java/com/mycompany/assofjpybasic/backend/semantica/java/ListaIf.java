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
public class ListaIf extends StatementJava{
    
    private boolean ret;
    private final List<IfOperacion> ifs = new ArrayList<>();
    
    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public List<IfOperacion> getIfs() {
        return ifs;
    }
    
    /**
     * Verificar retornabilidad del listado de If, si tiene el else
     */
    public void verRetornabilidad(){
        ret = ifs.stream().allMatch((ifOperacion) -> (ifOperacion.isRet()));
    }
    
}
