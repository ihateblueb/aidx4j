package site.remlit.aidx4j.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static site.remlit.aidx4j.AidxUtil.generateAidx;

public class GenerateAidxTest {
    @Test
    public void test() {
        ArrayList<String> aidxList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String aidx = generateAidx();
            assertEquals(16, aidx.length());
            aidxList.add(aidx);
        }

        assert aidxList.size() == Arrays.stream(aidxList.toArray()).distinct().count();
    }

    @Test
    public void test1mil() {
        ArrayList<String> aidxList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            String aidx = generateAidx();
            assertEquals(16, aidx.length());
            aidxList.add(aidx);
        }

        System.out.println("Out of " + aidxList.size() + " generated AIDX, " +
                Arrays.stream(aidxList.toArray()).distinct().count() + " are distinct");
    }
}
