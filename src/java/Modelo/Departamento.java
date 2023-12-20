/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findByIdDep", query = "SELECT d FROM Departamento d WHERE d.idDep = :idDep")
    , @NamedQuery(name = "Departamento.findByNombreDep", query = "SELECT d FROM Departamento d WHERE d.nombreDep = :nombreDep")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dep")
    private Integer idDep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_dep")
    private String nombreDep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDep")
    private Collection<Empleados> empleadosCollection;

    public Departamento() {
    }

    public Departamento(Integer idDep) {
        this.idDep = idDep;
    }

    public Departamento(Integer idDep, String nombreDep) {
        this.idDep = idDep;
        this.nombreDep = nombreDep;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDep != null ? idDep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDep == null && other.idDep != null) || (this.idDep != null && !this.idDep.equals(other.idDep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Departamento[ idDep=" + idDep + " ]";
    }
    
}
