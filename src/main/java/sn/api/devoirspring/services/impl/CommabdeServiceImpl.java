package sn.api.devoirspring.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sn.api.devoirspring.data.entities.Client;
import sn.api.devoirspring.data.entities.Commande;
import sn.api.devoirspring.data.repositories.ClientRepository;
import sn.api.devoirspring.data.repositories.CommandeRepository;
import sn.api.devoirspring.services.CommandeService;
import sn.api.devoirspring.web.DTO.mappers.CommmandeMapper;
import sn.api.devoirspring.web.DTO.response.CommandeResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommabdeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;

    public CommabdeServiceImpl(CommandeRepository commandeRepository, ClientRepository clientRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
    }

    private final ClientRepository clientRepository;

    private CommmandeMapper commandeMapper;
    @Override
    public List<CommandeResponseDTO> getCommandesByClientId(Long clientId) {
        return commandeRepository.findById(clientId)
                .stream()
                .map(commandeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Commande addCommande(Long clientId, CommandeResponseDTO commandeDTO) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        Commande commande = commandeMapper.toEntity(commandeDTO);
        commande.setClient(client);

        return commandeRepository.save(commande);
    }
}
