package ru.sawtooth.util.safetyscanner;

import java.io.IOException;
import java.util.Date;

public interface SafetyScanner {
    public int intInRange(int from, int to) throws IOException;

    public String notEmptyString() throws IOException;

    public Date futureDate() throws IOException;
}
