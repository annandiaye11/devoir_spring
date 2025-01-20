package sn.api.devoirspring.data.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nomComplet;

    public Client(Long id, String nomComplet, String telephone) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.telephone = telephone;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Column(unique = true, nullable = false)
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes = new ArrayList<>();
}
