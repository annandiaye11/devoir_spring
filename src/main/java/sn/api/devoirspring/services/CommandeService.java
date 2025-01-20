package sn.api.devoirspring.services;

import sn.api.devoirspring.data.entities.Commande;
import sn.api.devoirspring.web.DTO.response.CommandeResponseDTO;

import java.util.List;

public interface CommandeService {
    List<CommandeResponseDTO> getCommandesByClientId(Long clientId);
    Commande addCommande(Long clientId, CommandeResponseDTO commandeDTO);
}
