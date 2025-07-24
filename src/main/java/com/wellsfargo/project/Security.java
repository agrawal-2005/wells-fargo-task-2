package com.wellsfargo.training.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * This class represents a Security entity in the database.
 * Each security belongs to a single Portfolio. This model matches the ERD.
 */
@Entity
public class Security implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date purchaseDate;

    @Column(nullable = false)
    private Double purchasePrice;

    @Column(nullable = false)
    private Integer quantity;

    // Many-to-One relationship with Portfolio
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    /**
     * Default constructor for JPA.
     */
    public Security() {
    }

    /**
     * Constructor to initialize a Security object.
     * @param name The name of the security.
     * @param category The category of the security.
     * @param purchaseDate The date the security was purchased.
     * @param purchasePrice The price at which the security was purchased.
     * @param quantity The quantity of the security.
     * @param portfolio The portfolio this security belongs to.
     */
    public Security(String name, String category, Date purchaseDate, Double purchasePrice, Integer quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    // --- Getters and Setters ---

    public Long getSecurityId() {
        return securityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
