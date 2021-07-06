package Project1;

import org.junit.Assert;
import org.junit.Test;

public class TestPESEL {

    @Test
    public void ControlNumberTestTrue(){
        Assert.assertTrue(PESEL.ControlNumber("99100354533"));
    }

    @Test
    public void ControlNumberTestFalse(){
        Assert.assertFalse(PESEL.ControlNumber("88121354530"));
    }

    @Test
    public void PeselGenderCheckTestTrue(){
        Assert.assertTrue(PESEL.PeselGenderCheck("99100354533", "Marek"));
    }

    @Test
    public void PeselGenderCheckTestFalse(){
        Assert.assertFalse(PESEL.PeselGenderCheck("99100354533", "Aleksandra"));
    }
}