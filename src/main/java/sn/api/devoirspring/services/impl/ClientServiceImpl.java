package sn.api.devoirspring.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import sn.api.devoirspring.data.entities.Client;
import sn.api.devoirspring.data.entities.Commande;
import sn.api.devoirspring.data.repositories.ClientRepository;
import sn.api.devoirspring.data.repositories.CommandeRepository;
import sn.api.devoirspring.services.ClientService;
import sn.api.devoirspring.web.DTO.mappers.ClientMapper;
import sn.api.devoirspring.web.DTO.request.ClientRequestDTO;
import sn.api.devoirspring.web.DTO.response.CommandeResponseDTO;

import java.awt.print.Pageable;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;
    private ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, CommandeRepository commandeRepository) {
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Client createClientWithCommandes(ClientRequestDTO clientDTO) {
        // Validation du téléphone unique
        if (clientRepository.existsByTelephone(clientDTO.getTelephone())) {
            throw new RuntimeException("Le téléphone existe déjà");
        }

        Client client = clientMapper.toEntity(clientDTO);

        // Validation d'au moins une commande
        if (client.getCommandes() == null || client.getCommandes().isEmpty()) {
            throw new RuntimeException("Le client doit avoir au moins une commande");
        }

        // Association client-commandes
        client.getCommandes().forEach(commande -> commande.setClient(client));

        return clientRepository.save(client);
    }

    @Override
    public Page<CommandeResponseDTO> getClientCommandes(Long clientId, Pageable pageable) {
        Page<Commande> commandesPage = commandeRepository.findByClientId(clientId, pageable);
        return commandesPage.map(clientMapper::toResponseDTO);
    }
}
