package FrancescoAlves.U2W2D5.controller;

import FrancescoAlves.U2W2D5.entities.Dipendente;
import FrancescoAlves.U2W2D5.payloads.NewDipendenteDTO;
import FrancescoAlves.U2W2D5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    //    GET --> prendo tutti i dipendenti
    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.findAll();
    }

    //    POST --> salvo un dipendente nuovo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveDipendente(@RequestBody NewDipendenteDTO body) {
        return dipendenteService.save(body);
    }

    //    GET --> prendo un dipendetne specifico con id
    @GetMapping("/{id}")
    public Dipendente findById(@PathVariable Long id) {
        return dipendenteService.findById(id);
    }

    //    PUT --> modifico un dipendente
    @PutMapping("/{id}")
    public Dipendente findByIdAndUpdate(@PathVariable Long id, @RequestBody NewDipendenteDTO body) {
        return dipendenteService.findByIdAndUpdate(id, body);
    }


    //    DELETE --> cancello un dipendente
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long id) {
        dipendenteService.findByIdAndDelete(id);
    }
}