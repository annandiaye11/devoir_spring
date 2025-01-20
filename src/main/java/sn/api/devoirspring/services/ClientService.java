package sn.api.devoirspring.services;

import org.springframework.data.domain.Page;
import sn.api.devoirspring.data.entities.Client;
import sn.api.devoirspring.web.DTO.request.ClientRequestDTO;
import sn.api.devoirspring.web.DTO.response.CommandeResponseDTO;

import java.awt.print.Pageable;

public interface ClientService {
    Client createClientWithCommandes(ClientRequestDTO clientDTO);

//    Client createClientWithCommandes(ClientRequestDTO clientDTO);

    Page<CommandeResponseDTO> getClientCommandes(Long clientId, Pageable pageable);
}
