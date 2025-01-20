package sn.api.devoirspring.web.DTO.request;


public class ClientRequestDTO {
    private String nomComplet;
    private String telephone;
    private List<CommandeDTO> commandes;

    public List<CommandeDTO> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandeDTO> commandes) {
        this.commandes = commandes;
    }

    public ClientRequestDTO(String nomComplet, String telephone, List<CommandeDTO> commandes) {
        this.nomComplet = nomComplet;
        this.telephone = telephone;
        this.commandes = commandes;
    }

    public ClientRequestDTO() {
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
}
