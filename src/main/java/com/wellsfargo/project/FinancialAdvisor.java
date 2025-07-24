package com.wellsfargo.training.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a FinancialAdvisor entity in the database.
 * It's an update based on the detailed ERD.
 */
@Entity
public class FinancialAdvisor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String address;

    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    // One-to-Many relationship with Client
    // A financial advisor can have many clients.
    // CascadeType.ALL means operations (persist, remove, etc.) on advisor will cascade to clients.
    @OneToMany(mappedBy = "financialAdvisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Client> clients = new HashSet<>();

    /**
     * Default constructor for JPA.
     */
    public FinancialAdvisor() {
    }

    /**
     * Constructor to initialize a FinancialAdvisor object.
     * @param firstName The first name of the advisor.
     * @param lastName The last name of the advisor.
     * @param address The address of the advisor.
     * @param phone The phone number of the advisor.
     * @param email The email of the advisor.
     */
    public FinancialAdvisor(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // --- Getters and Setters ---

    public Long getAdvisorId() {
        return advisorId;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
