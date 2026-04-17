package FrancescoAlves.U2W2D5.controller;

import FrancescoAlves.U2W2D5.entities.Prenotazione;
import FrancescoAlves.U2W2D5.payloads.NewPrenotazioneDTO;
import FrancescoAlves.U2W2D5.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione save(@RequestBody NewPrenotazioneDTO body) {
        return prenotazioneService.save(body);
    }
}