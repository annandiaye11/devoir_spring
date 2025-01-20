package sn.api.devoirspring.web.Controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.api.devoirspring.data.entities.Client;
import sn.api.devoirspring.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/{id}/commandes")
    public ResponseEntity<Client> createClientWithCommandes(@Validated @RequestBody ClientRequestDTO clientDTO) {
        return new ResponseEntity<>(clientService.createClientWithCommandes(clientDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/commandes")
    public ResponseEntity<Page<ClientCommandeResponseDTO>> getClientCommandes(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(clientService.getClientCommandes(id, (java.awt.print.Pageable) pageable));
    }

}
