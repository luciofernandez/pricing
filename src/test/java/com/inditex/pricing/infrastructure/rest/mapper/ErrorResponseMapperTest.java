package com.inditex.pricing.infrastructure.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import org.assertj.core.data.TemporalUnitOffset;
import org.junit.jupiter.api.Test;

import com.inditex.pricing.model.ErrorResponse;

public class ErrorResponseMapperTest {
	
    @Test
    void convertToErrorResponse_shouldMapFieldsCorrectly() {
        // Arrange
        String error = "400 BAD_REQUEST";
        String message = "2020-06-10:00:00 invalid date";

        // Act
        ErrorResponse response = ErrorResponseMapper.convertToErrorResponse(error, message);

        // Assert
        assertThat(response.getError()).isEqualTo(error);
        assertThat(response.getMessage()).isEqualTo(message);

        // Comprobamos que timestamp no es nulo y es cercano al ahora
        assertThat(response.getTimestamp()).isNotNull();

        OffsetDateTime now = OffsetDateTime.now();
        // El timestamp debe estar dentro de un margen razonable de 5 segundos respecto al tiempo actual
        assertThat(response.getTimestamp()).isCloseTo(now, within(5, ChronoUnit.SECONDS));
    }

    private static TemporalUnitOffset within(long amount, ChronoUnit unit) {
        return org.assertj.core.api.Assertions.within(amount, unit);
    }
}
