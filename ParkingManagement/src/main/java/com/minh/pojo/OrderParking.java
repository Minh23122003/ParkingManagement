/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "order_parking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderParking.findAll", query = "SELECT o FROM OrderParking o"),
    @NamedQuery(name = "OrderParking.findById", query = "SELECT o FROM OrderParking o WHERE o.id = :id"),
    @NamedQuery(name = "OrderParking.findByVehicleName", query = "SELECT o FROM OrderParking o WHERE o.vehicleName = :vehicleName"),
    @NamedQuery(name = "OrderParking.findByLicensePlates", query = "SELECT o FROM OrderParking o WHERE o.licensePlates = :licensePlates"),
    @NamedQuery(name = "OrderParking.findByCreatedDate", query = "SELECT o FROM OrderParking o WHERE o.createdDate = :createdDate"),
    @NamedQuery(name = "OrderParking.findByStatus", query = "SELECT o FROM OrderParking o WHERE o.status = :status"),
    @NamedQuery(name = "OrderParking.findByStartTime", query = "SELECT o FROM OrderParking o WHERE o.startTime = :startTime"),
    @NamedQuery(name = "OrderParking.findByEndTime", query = "SELECT o FROM OrderParking o WHERE o.endTime = :endTime")})
public class OrderParking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "vehicle_name")
    private String vehicleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "license_plates")
    private String licensePlates;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    @JsonIgnore
    private Set<OrderCancel> orderCancelSet;
    @JoinColumn(name = "parking_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parking parkingId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;

    public OrderParking() {
    }

    public OrderParking(Integer id) {
        this.id = id;
    }

    public OrderParking(Integer id, String vehicleName, String licensePlates, Date createdDate, String status) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.licensePlates = licensePlates;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public Set<OrderCancel> getOrderCancelSet() {
        return orderCancelSet;
    }

    public void setOrderCancelSet(Set<OrderCancel> orderCancelSet) {
        this.orderCancelSet = orderCancelSet;
    }

    public Parking getParkingId() {
        return parkingId;
    }

    public void setParkingId(Parking parkingId) {
        this.parkingId = parkingId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
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
        if (!(object instanceof OrderParking)) {
            return false;
        }
        OrderParking other = (OrderParking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minh.pojo.OrderParking[ id=" + id + " ]";
    }
    
}
