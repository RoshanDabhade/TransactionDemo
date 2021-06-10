/*

@NamedQueries({
	@NamedQuery(name = "AccountDetails.getBalance",query = "SELECT new com.example.transactionDemo.entity.AccountDetails(a.availableBalance)  FROM AccountDetails a where a.accountNo =:sAccountNo"),
	@NamedQuery(name = "AccountDetails.updateFundToAccounts",query = "UPDATE AccountDetails a SET a.availableBalance= :newBalance where a.accountNo= :accountNo"),
	@NamedQuery(name = "AccountDetails.findByAccountNo",query = "Select new com.example.transactionDemo.entity.AccountDetails(a.accountNo,a.availableBalance) from AccountDetails a where a.accountNo=:accountNo")
})
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.transactionDemo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Deepika
 */
@Entity
@Table(name = "account_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDetails.findAll", query = "SELECT a FROM AccountDetails a"),
    @NamedQuery(name = "AccountDetails.updateFundToAccounts",query = "UPDATE AccountDetails a SET a.availableBalance= :newBalance where a.accountNo= :accountNo"),
    @NamedQuery(name = "AccountDetails.findByAccountNo", query = "SELECT a FROM AccountDetails a WHERE a.accountNo = :accountNo"),
    @NamedQuery(name = "AccountDetails.findByAvailableBalance", query = "SELECT a FROM AccountDetails a WHERE a.availableBalance = :availableBalance")})
public class AccountDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @JsonIgnore
    @Column(name = "account_no")
    private Long accountNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "available_balance")
    private Double availableBalance;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountDetails")
    private Set<TransactionDetails> transactionDetails = new HashSet<TransactionDetails>(0);


	public AccountDetails() {
    }

    public AccountDetails(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }
    
    public Set<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(Set<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	@Override
    public String toString() {
        return "com.exinformatics.eximatrimonyweb.models.AccountDetails[ accountNo=" + accountNo + " ]";
    }
    
}
