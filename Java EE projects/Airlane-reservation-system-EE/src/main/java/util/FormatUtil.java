package util;

import model.enums.ExceptionEnums;
import model.exceptions.NullObjectException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtil {
    public static String formatDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            throw new NullObjectException(ExceptionEnums.NULL_OBJECT_EXCEPTION);
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
        return localDateTime.format(dtf);
    }

    public static String decimalFormat(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            throw new NullObjectException(ExceptionEnums.NULL_OBJECT_EXCEPTION);
        }
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return decimalFormat.format(bigDecimal);
    }
}
