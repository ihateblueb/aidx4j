package site.remlit.aidx4j.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static site.remlit.aidx4j.AidUtil.generateAid;

public class GenerateAidTest {
    @Test
    public void test() {
        ArrayList<String> aidList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String aid = generateAid();
            assertEquals(10, aid.length());
            aidList.add(aid);
        }

        assert aidList.size() == Arrays.stream(aidList.toArray()).distinct().count();
    }

    @Test
    public void test1mil() {
        ArrayList<String> aidList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            String aid = generateAid();
            assertEquals(10, aid.length());
            aidList.add(aid);
        }

        System.out.println("Out of " + aidList.size() + " generated AID, " +
                Arrays.stream(aidList.toArray()).distinct().count() + " are distinct");
    }
}
