package sn.api.devoirspring.web.DTO.mappers;

import sn.api.devoirspring.data.entities.Commande;
import sn.api.devoirspring.web.DTO.response.CommandeResponseDTO;

public interface CommmandeMapper {
    Commande toEntity(CommandeResponseDTO dto);
    CommandeResponseDTO toDTO(Commande commande);
}
