package FrancescoAlves.U2W2D5.payloads;

import java.time.LocalDate;

public record NewPrenotazioneDTO(Long dipendenteId, Long viaggioId, String note, LocalDate dataRichiesta) {
}
