/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.to;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author freet
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTO.findNameLastname", query = "SELECT u FROM EmployeeTO u where u.name = :name and u.lastname = :lastname")
})
public class EmployeeTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "GENERED_ID")
    private int idgenred;
    @Column(name = "JOB_ID")
    private int jobid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name = "BIRTHDATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthdate;

    public EmployeeTO() {
    }

    public EmployeeTO(String name, String lastname, Date birthdate) {
        this.name = name.trim().toUpperCase();
        this.lastname = lastname.trim().toUpperCase();
        this.birthdate = birthdate;
        this.jobid = 1;
        this.idgenred = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdgenred() {
        return idgenred;
    }

    public void setIdgenred(int idgenred) {
        this.idgenred = idgenred;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTO)) {
            return false;
        }
        EmployeeTO other = (EmployeeTO) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seuz.to.EmployeeTO[ id=" + id + " ]";
    }

}
