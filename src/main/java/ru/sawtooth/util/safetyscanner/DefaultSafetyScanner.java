package ru.sawtooth.util.safetyscanner;

import ru.sawtooth.util.dateformatter.DateFormatter;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class DefaultSafetyScanner implements SafetyScanner {
    private final Scanner scanner;

    public DefaultSafetyScanner(InputStream source) {
        scanner = new Scanner(source);
    }

    @Override
    public String notEmptyString() throws IOException {
        String result = scanner.nextLine();

        if (!result.isEmpty())
            return result;
        throw new IOException("Incorrect input in safety scanner");
    }

    @Override
    public Date futureDate() throws IOException {
        String dateInput = notEmptyString();
        DateFormatter formatter = new DateFormatter();
        Date result;

        try {
            result = formatter.get().parse(dateInput);
            if (result.after(new Date()))
                return result;
            throw new IOException("Incorrect input in safety scanner");
        }
        catch (ParseException e) {
            throw new IOException("Incorrect input in safety scanner");
        }
    }

    @Override
    public int intInRange(int from, int to) throws IOException {
        String input = notEmptyString();
        int result;

        try {
            result = Integer.parseInt(input);
            if (result >= from && result <= to)
                return result;
            throw new IOException("Incorrect input in safety scanner");
        }
        catch (Exception e) {
            throw new IOException("Incorrect input in safety scanner");
        }
    }
}
