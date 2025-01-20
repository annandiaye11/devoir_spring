package sn.api.devoirspring.web.DTO.response;

public class ClientResponseDTO {
    private String nomComplet;
    private String telephone;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(String nomComplet, String telephone) {
        this.nomComplet = nomComplet;
        this.telephone = telephone;
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
