package com.example.demo.user;

import com.example.demo.banque.Banque;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "banque_id", referencedColumnName = "id")
    private Banque banque;
    private String numCompte;
    private String name;
    private String firstName;
    private LocalDate datePret;
    private Long montant;
    private Long montantARembourser;
    private Boolean deleteMark;

    public User() {
    }

    public User(
            Long userId,
            String name,
            String firstName,
            String numCompte,
            LocalDate datePret,
            Long montant,
            Long montantARembourser,
            Boolean deleteMark
            ) {
        this.userId = userId;
        this.numCompte = numCompte;
        this.name = name;
        this.firstName = firstName;
        this.datePret = datePret;
        this.montant = montant;
        this.montantARembourser = montantARembourser;
        this.deleteMark = deleteMark;
    }

    public User(
            String name,
            String firstName,
            String numCompte,
            LocalDate datePret,
            Long montant,
            Long montantARembourser,
            Boolean deleteMark) {
        this.name = name;
        this.numCompte = numCompte;
        this.firstName = firstName;
        this.datePret = datePret;
        this.montant = montant;
        this.montantARembourser = montantARembourser;
        this.deleteMark = deleteMark;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Boolean deleteMark) {
        this.deleteMark = deleteMark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public LocalDate getDatePret() {
        return datePret;
    }

    public void setDatePret(LocalDate datePret) {
        this.datePret = datePret;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Long getMontantARembourser() {
        return montantARembourser;
    }

    public void setMontantARembourser(Long montantARembourser) {
        this.montantARembourser = montantARembourser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", banque=" + banque +
                ", numCompte='" + numCompte + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", datePret=" + datePret +
                ", montant=" + montant +
                ", montantARembourser=" + montantARembourser +
                ", deleteMark=" + deleteMark +
                '}';
    }
}
