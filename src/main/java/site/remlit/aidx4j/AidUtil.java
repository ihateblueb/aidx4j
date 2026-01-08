package site.remlit.aidx4j;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import static site.remlit.aidx4j.Utils.*;

/**
 * Utility for generating AID
 *
 * @since 1.0.0
 * */
public class AidUtil {
    /**
     * Generate an AID
     *
     * @deprecated The AID format is likely to produce duplicates. Please use AIDX instead.
     * @since 1.0.0
     *
     * @return Generated AID
     * */
    @Deprecated(since = "1.0.0")
    public static @NotNull String generateAid() {
        String id = "";

        Date now = new Date();
        Date time2000 = time2000();

        long time = (now.getTime() - time2000.getTime());
        if (time < 0) time = 0;

        incrementCounter();

        id += padStart(Long.toString(time, 36), 8, '0');
        id += takeLast(padStart(Long.toString(getCounter(), 36), 2, '0'), 2);

        return id;
    }
}
