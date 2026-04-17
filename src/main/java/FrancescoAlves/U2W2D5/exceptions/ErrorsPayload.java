package FrancescoAlves.U2W2D5.exceptions;

import java.time.LocalDateTime;

public record ErrorsPayload(String message, LocalDateTime timestamp) {
}