/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdEmp", query = "SELECT e FROM Empleados e WHERE e.idEmp = :idEmp")
    , @NamedQuery(name = "Empleados.findByNombreEmp", query = "SELECT e FROM Empleados e WHERE e.nombreEmp = :nombreEmp")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emp")
    private Integer idEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_emp")
    private String nombreEmp;
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    @ManyToOne(optional = false)
    private Departamento idDep;

    public Empleados() {
    }

    public Empleados(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Empleados(Integer idEmp, String nombreEmp) {
        this.idEmp = idEmp;
        this.nombreEmp = nombreEmp;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public Departamento getIdDep() {
        return idDep;
    }

    public void setIdDep(Departamento idDep) {
        this.idDep = idDep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmp != null ? idEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Empleados[ idEmp=" + idEmp + " ]";
    }
    
}
