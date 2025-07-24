package com.wellsfargo.training.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Portfolio entity in the database.
 * It now includes a creationDate as per the ERD.
 */
@Entity
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creationDate;

    // One-to-One relationship with Client
    // Each portfolio is uniquely owned by one client.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    // One-to-Many relationship with Security
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Security> securities = new HashSet<>();

    /**
     * Default constructor for JPA.
     */
    public Portfolio() {
    }

    /**
     * Constructor to initialize a Portfolio object.
     * @param creationDate The date the portfolio was created.
     * @param client The client who owns this portfolio.
     */
    public Portfolio(Date creationDate, Client client) {
        this.creationDate = creationDate;
        this.client = client;
    }

    // --- Getters and Setters ---

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }
}
