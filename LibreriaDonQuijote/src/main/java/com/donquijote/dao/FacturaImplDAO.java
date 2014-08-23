/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.dao;

import com.donquijote.daointerface.FacturaInterfaceDAO;
import com.donquijote.persistence.Cliente;
import com.donquijote.persistence.DetalleFactura;
import com.donquijote.persistence.Factura;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author José Luis
 */
public class FacturaImplDAO extends HibernateDaoSupport implements FacturaInterfaceDAO {

    @Override
    public Cliente findClientByCedula(String cedula) {
        List<Cliente> listClientes = (List<Cliente>) getHibernateTemplate().find("from Cliente cli where cli.estadoborrado=false and cli.cedulaRuc='" + cedula+"'");

        if (!listClientes.isEmpty()) {
            return listClientes.get(0);
        }

        return null;
    }

    @Override
    public void saveFactura(Factura obj) {
        getHibernateTemplate().save(obj);
    }

    @Override
    public Factura obtainLastFactura() {
        List<Factura> listFacturas = (List<Factura>) getHibernateTemplate().find("from Factura f where f.estadoborrado=false");

        if (!listFacturas.isEmpty()) {
            return listFacturas.get(listFacturas.size()-1);
        }

        return null;
    }

    @Override
    public void saveDetalleFactura(DetalleFactura obj) {
        getHibernateTemplate().save(obj);
    }

}
