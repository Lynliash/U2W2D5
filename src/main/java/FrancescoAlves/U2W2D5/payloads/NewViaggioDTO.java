package FrancescoAlves.U2W2D5.payloads;

import FrancescoAlves.U2W2D5.enums.StatoViaggio;

import java.time.LocalDate;

public record NewViaggioDTO(String destinazione, LocalDate data, StatoViaggio stato) {
}
