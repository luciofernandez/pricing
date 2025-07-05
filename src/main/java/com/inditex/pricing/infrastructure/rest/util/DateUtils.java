package com.inditex.pricing.infrastructure.rest.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.inditex.pricing.infrastructure.rest.exception.DateFomatException;

public class DateUtils {
	
    public static final DateTimeFormatter ISO_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static LocalDateTime getFormatDate(String dateStr) {
        try {
            return LocalDateTime.parse(dateStr, ISO_FORMAT);
        } catch (DateTimeParseException e) {
            throw new DateFomatException(dateStr + " invalid date");
        }
    }

}
