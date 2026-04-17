package FrancescoAlves.U2W2D5.controller;

import FrancescoAlves.U2W2D5.entities.Viaggio;
import FrancescoAlves.U2W2D5.payloads.NewViaggioDTO;
import FrancescoAlves.U2W2D5.payloads.StatoViaggioDTO;
import FrancescoAlves.U2W2D5.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio save(@RequestBody NewViaggioDTO body) {
        return viaggioService.save(body);
    }

    @GetMapping
    public List<Viaggio> getAll() {
        return viaggioService.findAll();
    }

    @PatchMapping("/{id}/stato")
    public Viaggio updateStato(@PathVariable Long id, @RequestBody @Validated StatoViaggioDTO body) {
        System.out.println("stato viaggio " + id + " aggiornato");
        return viaggioService.updateStato(id, body);
    }

}