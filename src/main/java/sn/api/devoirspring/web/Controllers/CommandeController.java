package sn.api.devoirspring.web.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.api.devoirspring.data.entities.Commande;
import sn.api.devoirspring.services.CommandeService;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<CommandeDTO>> getCommandesByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(commandeService.getCommandesByClientId(clientId));
    }

    @PostMapping("/client/{clientId}")
    public ResponseEntity<Commande> addCommande(
            @PathVariable Long clientId,
            @Validated @RequestBody CommandeDTO commandeDTO) {
        return new ResponseEntity<>(commandeService.addCommande(clientId, commandeDTO), HttpStatus.CREATED);
    }
}
