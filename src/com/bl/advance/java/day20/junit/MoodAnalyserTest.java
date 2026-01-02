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

    @Test // tc 1.1
    public void givenMeassage_ISIAmSadMood_ShouldReturnSad() {
        MoodAnalyser1 moodAnalyser1 = new MoodAnalyser1("This is a SAD message");
        String mood = moodAnalyser1.analyseMood();
        Assert.assertEquals(mood, "SAD");
    }

    @Test // tc 1.2
    public void givenMessage_IAmInAnyMood_ShouldReturnHappy() {
        MoodAnalyser1 moodAnalyser1 = new MoodAnalyser1("I am in any mood");
        String mood = moodAnalyser1.analyseMood();
        Assert.assertEquals(mood, "HAPPY");
    }

    @Test // tc 2.1
    public void givenNull_Mood_ShouldReturnHappy() {
        MoodAnalyser1 moodAnalyser1 = new MoodAnalyser1(null);
        String mood = moodAnalyser1.analyseMood();
        Assert.assertEquals(mood, "HAPPY");
    }
}
