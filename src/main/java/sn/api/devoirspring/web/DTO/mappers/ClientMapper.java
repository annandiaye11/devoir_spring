package sn.api.devoirspring.web.DTO.mappers;

import sn.api.devoirspring.data.entities.Client;
import sn.api.devoirspring.data.entities.Commande;
import sn.api.devoirspring.web.DTO.request.ClientRequestDTO;
import sn.api.devoirspring.web.DTO.response.ClientResponseDTO;
import sn.api.devoirspring.web.DTO.response.CommandeResponseDTO;

public interface ClientMapper {
    Client toEntity(ClientRequestDTO dto);
    ClientResponseDTO toDTO(Client client);
    CommandeResponseDTO toResponseDTO(Commande commande);
}
