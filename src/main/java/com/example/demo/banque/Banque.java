package com.example.demo.banque;

import com.example.demo.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Banque{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomBanque;
    private Long taux;
    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    public Banque() {
    }

    public Banque(String nomBanque, Long taux) {
        this.nomBanque = nomBanque;
        this.taux = taux;
    }

    public Banque(Long id, String nomBanque, Long taux) {
        this.id = id;
        this.nomBanque = nomBanque;
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public Long getTaux() {
        return taux;
    }

    public void setTaux(Long taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nomBanque='" + nomBanque + '\'' +
                ", taux=" + taux +
                '}';
    }
}
