package com.inditex.pricing.infrastructure.rest.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.inditex.pricing.infrastructure.rest.exception.DateFomatException;

public class DateUtils {
	
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");

    public static LocalDateTime getFormatDate(String dateStr) {
        try {
            return LocalDateTime.parse(dateStr, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new DateFomatException(dateStr + " invalid date");
        }
    }

}
