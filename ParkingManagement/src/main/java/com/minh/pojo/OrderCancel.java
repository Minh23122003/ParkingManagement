/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "order_cancel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderCancel.findAll", query = "SELECT o FROM OrderCancel o"),
    @NamedQuery(name = "OrderCancel.findById", query = "SELECT o FROM OrderCancel o WHERE o.id = :id"),
    @NamedQuery(name = "OrderCancel.findByReason", query = "SELECT o FROM OrderCancel o WHERE o.reason = :reason"),
    @NamedQuery(name = "OrderCancel.findByDate", query = "SELECT o FROM OrderCancel o WHERE o.date = :date")})
public class OrderCancel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reason")
    private String reason;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "account_number")
    private String accountNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bank_name")
    private String bankName;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderParking orderId;
    
    @Transient
    private String dateTransient;

    public OrderCancel() {
    }

    public OrderCancel(Integer id) {
        this.id = id;
    }

    public OrderCancel(Integer id, String reason, Date date, String status, String accountNumber, String bankName, OrderParking orderId) {
        this.id = id;
        this.reason = reason;
        this.date = date;
        this.status = status;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderParking getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderParking orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof OrderCancel)) {
            return false;
        }
        OrderCancel other = (OrderCancel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minh.pojo.OrderCancel[ id=" + id + " ]";
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the dateTransient
     */
    public String getDateTransient() {
        return dateTransient;
    }

    /**
     * @param dateTransient the dateTransient to set
     */
    public void setDateTransient(String dateTransient) {
        this.dateTransient = dateTransient;
    }
    
}
