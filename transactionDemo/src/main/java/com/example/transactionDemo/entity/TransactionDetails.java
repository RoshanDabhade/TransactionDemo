/*

@NamedQueries({
	@NamedQuery(name = "TransactionDetails.getTransactionDetails",query = "SELECT new com.example.transactionDemo.entity.TransactionDetails(t.transactionAmount,t.referenceNumber,t.transactionFlag)  FROM TransactionDetails t where t.objAccountDetails.accountNo =:sAccountNoInLong"),
})
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.transactionDemo.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Deepika
 */
@Entity
@Table(name = "transaction_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t"),
    @NamedQuery(name = "TransactionDetails.findByAccountNo", query = "SELECT t FROM TransactionDetails t WHERE t.accountDetails.accountNo = :accountNo"),
    @NamedQuery(name = "TransactionDetails.findByTransactionFlag", query = "SELECT t FROM TransactionDetails t WHERE t.transactionFlag = :transactionFlag"),
    @NamedQuery(name = "TransactionDetails.findByTransactionAmount", query = "SELECT t FROM TransactionDetails t WHERE t.transactionAmount = :transactionAmount"),
    @NamedQuery(name = "TransactionDetails.findByReferenceNumber", query = "SELECT t FROM TransactionDetails t WHERE t.referenceNumber = :referenceNumber")})
public class TransactionDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    //@Size(max = 1)
    @Column(name = "transaction_flag")
    private String transactionFlag;
    
    @Column(name = "transaction_amount")
    private Double transactionAmount;
    
    @Column(name = "reference_number")
    private BigInteger referenceNumber;
    
    @JsonIgnore
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    @ManyToOne(optional = false)
    private AccountDetails accountDetails;

    public TransactionDetails() {
    }

    public String getTransactionFlag() {
        return transactionFlag;
    }

    public void setTransactionFlag(String transactionFlag) {
        this.transactionFlag = transactionFlag;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigInteger getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(BigInteger referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

   

    public TransactionDetails(int id, String transactionFlag, Double transactionAmount,
			BigInteger referenceNumber, AccountDetails accountDetails) {
		
    	this.id=id;
		this.transactionFlag = transactionFlag;
		this.transactionAmount = transactionAmount;
		this.referenceNumber = referenceNumber;
		this.accountDetails = accountDetails;
	}

	

	
    
}

