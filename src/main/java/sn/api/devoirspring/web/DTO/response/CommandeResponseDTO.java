package sn.api.devoirspring.web.DTO.response;

import java.time.LocalDate;

public class CommandeResponseDTO {
    private LocalDate date;
    private Double montant;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public CommandeResponseDTO() {
    }

    public CommandeResponseDTO(LocalDate date, Double montant) {
        this.date = date;
        this.montant = montant;
    }
}
