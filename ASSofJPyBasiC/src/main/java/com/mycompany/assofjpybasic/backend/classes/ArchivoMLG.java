/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.classes;

/**
 *
 * @author mari2bar
 */
public class ArchivoMLG {
    
    private final String visual;
    private final String java;
    private final String python;
    private final String programa;
    
    /**
     * Iniciar archivo MLG, con los textos correspondientes
     * @param visual     
     * @param java     
     * @param python     
     * @param programa     
     */
    public ArchivoMLG(String visual, String java, String python, String programa){
        this.visual = visual;
        this.java = java;
        this.python = python;
        this.programa = programa;
        
    }

    public String getVisual() {
        return visual;
    }

    public String getJava() {
        return java;
    }

    public String getPython() {
        return python;
    }

    public String getPrograma() {
        return programa;
    }
    
}
