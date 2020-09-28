/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assofjpybasic.backend.semantica.java;

import java.util.ArrayList;

/**
 *
 * @author mari2bar
 */
public class StatementsJava extends ArrayList<StatementJava>{
    
    private boolean ret = false;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }
    
}
