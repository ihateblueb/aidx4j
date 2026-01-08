package site.remlit.aidx4j;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import static site.remlit.aidx4j.Utils.*;

/**
 * Utility for generating AIDX
 *
 * @since 1.0.0
 * */
public class AidxUtil {
    /**
     * Generate an AIDX
     *
     * @since 1.0.0
     *
     * @return Generated AIDX
     * */
    public static @NotNull String generateAidx() {
        StringBuilder id = new StringBuilder();

        Date now = new Date();
        Date time2000 = time2000();

        long time = (now.getTime() - time2000.getTime());
        if (time < 0) time = 0;

        incrementCounter();

        id.append(padStart(Long.toString(time, 36), 8, '0'));

        id.append(aidAlphabetRandom());
        id.append(aidAlphabetRandom());
        id.append(aidAlphabetRandom());
        id.append(aidAlphabetRandom());

        id.append(takeLast(padStart(Long.toString(getCounter(), 36), 4, '0'), 4));

        return id.toString();
    }
}

