package com.bl.advance.java.junit;


import com.bl.advance.java.regex.MoodAnalyser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodAnalyserTest {
    @Test
    public void testMoodAnalysis() throws Exception {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a SAD message");
        Assert.assertEquals(mood, "SAD");
    }
}
