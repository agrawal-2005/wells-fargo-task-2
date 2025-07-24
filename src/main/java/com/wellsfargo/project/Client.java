package com.wellsfargo.training.pms.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class represents a Client entity in the database.
 * Each client has their own contact details and is linked to a FinancialAdvisor.
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;

    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    // Many-to-One relationship with FinancialAdvisor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor financialAdvisor;

    // One-to-One relationship with Portfolio
    // The 'mappedBy' attribute indicates that the 'client' field in the Portfolio entity owns the relationship.
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Portfolio portfolio;

    /**
     * Default constructor for JPA.
     */
    public Client() {
    }

    /**
     * Constructor to initialize a Client object.
     * @param firstName The first name of the client.
     * @param lastName The last name of the client.
     * @param address The address of the client.
     * @param phone The phone number of the client.
     * @param email The email of the client.
     * @param financialAdvisor The advisor for this client.
     */
    public Client(String firstName, String lastName, String address, String phone, String email, FinancialAdvisor financialAdvisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.financialAdvisor = financialAdvisor;
    }

    // --- Getters and Setters ---

    public Long getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FinancialAdvisor getFinancialAdvisor() {
        return financialAdvisor;
    }

    public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) {
        this.financialAdvisor = financialAdvisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
