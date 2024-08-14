/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "parking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parking.findAll", query = "SELECT p FROM Parking p"),
    @NamedQuery(name = "Parking.findById", query = "SELECT p FROM Parking p WHERE p.id = :id"),
    @NamedQuery(name = "Parking.findByAddress", query = "SELECT p FROM Parking p WHERE p.address = :address"),
    @NamedQuery(name = "Parking.findByQuantity", query = "SELECT p FROM Parking p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Parking.findByDailyPrice", query = "SELECT p FROM Parking p WHERE p.dailyPrice = :dailyPrice"),
    @NamedQuery(name = "Parking.findByNightPrice", query = "SELECT p FROM Parking p WHERE p.nightPrice = :nightPrice"),
    @NamedQuery(name = "Parking.findByNote", query = "SELECT p FROM Parking p WHERE p.note = :note")})
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100, message = "{parking.address.errMsg}")
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Min(value = 1, message = "{parking.quantity.errMsg}")
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Min(value = 3000, message = "{parking.dailyPrice.errMsg}")
    @Column(name = "daily_price")
    private int dailyPrice;
    @Basic(optional = false)
    @NotNull
    @Min(value = 6000, message = "{parking.nightPrice.errMsg}")
    @Column(name = "night_price")
    private int nightPrice;
    @Size(max = 255, message = "{parking.note.errMsg}")
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Status statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parkingId")
    @JsonIgnore
    private Set<Rating> ratingSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parkingId")
    @JsonIgnore
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parkingId")
    @JsonIgnore
    private Set<OrderParking> orderParkingSet;

    public Parking() {
    }

    public Parking(Integer id) {
        this.id = id;
    }

    public Parking(Integer id, String address, int quantity, int dailyPrice, int nightPrice) {
        this.id = id;
        this.address = address;
        this.quantity = quantity;
        this.dailyPrice = dailyPrice;
        this.nightPrice = nightPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(int nightPrice) {
        this.nightPrice = nightPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @XmlTransient
    public Set<OrderParking> getOrderParkingSet() {
        return orderParkingSet;
    }

    public void setOrderParkingSet(Set<OrderParking> orderParkingSet) {
        this.orderParkingSet = orderParkingSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parking)) {
            return false;
        }
        Parking other = (Parking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minh.pojo.Parking[ id=" + id + " ]";
    }
    
}
