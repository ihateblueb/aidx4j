package site.remlit.aidx4j;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;
import java.util.Random;

class Utils {
    private static long counter = 0;

    /**
     * Increments global counter for AID and AIDX generation
     *
     * @since 1.0.0
     * */
    static void incrementCounter() {
        counter++;
    }

    /**
     * Gets global counter for AID and AIDX ids
     *
     * @since 1.0.0
     * */
    static @NotNull Long getCounter() {
        return counter;
    }

    /**
     * Gets date object for 1 Jan, 2000
     *
     * @since 1.0.0
     * */
    static @NotNull Date time2000() {
        return new Date(946684800000L);
    }

    /**
     * Acceptable random strings for AIDX
     *
     * @since 1.0.0
     * */
    static @NotNull List<String> aidAlphabet() {
        return List.of(
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a",  "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        );
    }

    /**
     * Get a random acceptable strings for AIDX
     *
     * @since 1.0.0
     * */
    static @NotNull String aidAlphabetRandom() {
        List<String> aidAlphabet = aidAlphabet();
        int index = new Random().nextInt(aidAlphabet.size());
        return aidAlphabet.get(index);
    }

    // Modifying methods

    /**
     * Pads start of string if it does not fill enough space, otherwise return
     *
     * @param value String value
     * @param length Required minimum length
     * @param padChar Character to pad with
     *
     * @since 1.0.0
     *
     * @return Padded string
     * */
    static @NotNull String padStart(
            @NotNull String value,
            @NotNull Integer length,
            @NotNull Character padChar
    ) {
        if (value.length() >= length) {
            return value;
        }

        return String.valueOf(padChar).repeat(length) +
                value;
    }

    /**
     * Takes the last n characters of a string and returns them
     *
     * @param value String value
     * @param length n amount to take
     *
     * @since 1.0.0
     *
     * @return Last n characters
     * */
    static @NotNull String takeLast(
            @NotNull String value,
            @NotNull Integer length
    ) {
        char[] chars = value.toCharArray();
        StringBuilder last = new StringBuilder();

        for (int i = length; i >= 1; i--) {
            last.append(chars[chars.length - i]);
        }

        return last.toString();
    }
}
