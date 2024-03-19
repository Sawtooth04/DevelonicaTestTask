package ru.sawtooth.util.dateformatter;

import java.text.SimpleDateFormat;

public final class DateFormatter {
    public SimpleDateFormat get() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
}
