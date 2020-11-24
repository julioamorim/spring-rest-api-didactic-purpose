package io.github.julioamorim.apirest.controller;

import io.github.julioamorim.apirest.model.Client;
import io.github.julioamorim.apirest.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // endpoint to get clients
    @GetMapping
    public List finAllClients() {
        return clientRepository.findAll();
    }

    // endpoint to get clients by id
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> findClientsById(@PathVariable Integer clientId) {
        return clientRepository.findById(clientId).map(clientRecord ->  ResponseEntity.ok().body(clientRecord)).orElse(ResponseEntity.notFound().build());
    }

    //endpoint to create a new client
    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientRepository.save(client);
    }

    //endpoint to update a client
    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer clientId, @RequestBody Client client) {
        return clientRepository.findById(clientId).map(

                clientData -> {
                    clientData.setClientName(client.getClientName());
                    Client clientUpdated = clientRepository.save(clientData);
                    return ResponseEntity.ok().body(clientUpdated);
                }

        ).orElse(ResponseEntity.notFound().build());
    }

    //endpoint to delete a client
    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable("clientId") Integer clientId){
        return clientRepository.findById(clientId).map(
                clientData ->
                {
                    clientRepository.deleteById(clientId);
                    return ResponseEntity.ok().build();
                }
        ).orElse(ResponseEntity.notFound().build());
    }
}