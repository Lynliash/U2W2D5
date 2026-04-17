package FrancescoAlves.U2W2D5.entities;


import FrancescoAlves.U2W2D5.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "viaggi")
@Data
@NoArgsConstructor
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String destinazione;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    public Viaggio(StatoViaggio stato, LocalDate data, String destinazione) {
        this.stato = stato;
        this.data = data;
        this.destinazione = destinazione;
    }

    public Long getId() {
        return id;
    }


    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public StatoViaggio getStato() {
        return stato;
    }

    public void setStato(StatoViaggio stato) {
        this.stato = stato;
    }
}