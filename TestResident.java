package Project1;

import org.junit.Assert;
import org.junit.Test;

public class TestResident {

    @Test
    public void ControlNumberTestTrue(){
        Resident resident = new Resident("Poznan", "Stefan", "Czarniecki", "99100354533");
        Assert.assertEquals(resident.getCity(), "Poznan");
        Assert.assertEquals(resident.getForename(), "Stefan");
        Assert.assertEquals(resident.getSurname(), "Czarniecki");
        Assert.assertEquals(resident.getPesel(), "99100354533");
    }

    @Test
    public void ControlNumberTestFalse(){
        Resident resident = new Resident("Poznan", "Stefan", "Czarniecki", "99100354533");
        Assert.assertNotEquals(resident.getCity(), "Krakow");
        Assert.assertNotEquals(resident.getForename(), "Aleksander");
        Assert.assertNotEquals(resident.getSurname(), "Kowalski");
        Assert.assertNotEquals(resident.getPesel(), "77010793699");
    }
}
