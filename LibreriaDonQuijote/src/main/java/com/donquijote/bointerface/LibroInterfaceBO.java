/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donquijote.bointerface;

import com.donquijote.bean.BeanLibro;
import java.util.List;

/**
 *
 * @author José Luis
 */
public interface LibroInterfaceBO {
   boolean insert(BeanLibro obj);
    void delete(BeanLibro obj);
    boolean update(BeanLibro obj);
    List<BeanLibro> getAll();
    
}
