package com.bl.advance.java.day20.junit;


import com.bl.advance.java.day19.regex.MoodAnalyser;
import com.bl.advance.java.day21.exception.MoodAnalyser1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodAnalyserTest {
    @Test
    public void testMoodAnalysis() throws Exception {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a SAD message");
        Assert.assertEquals(mood, "SAD");
    }

    @Test
    public void givenMeassage_ISIAmSadMood_ShouldReturnSad() {
        MoodAnalyser1 moodAnalyser1 = new MoodAnalyser1();
        String mood = moodAnalyser1.analyseMood("This is a SAD message");
        Assert.assertEquals(mood, "SAD");
    }

    @Test
    public void givenMessage_IAmInAnyMood_ShouldReturnHappy(){
        MoodAnalyser1 moodAnalyser1 = new MoodAnalyser1();
        String mood = moodAnalyser1.analyseMood("I am in any mood");
        Assert.assertEquals(mood, "HAPPY");
    }
}
