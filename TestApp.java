package Project1;

import org.junit.Assert;
import org.junit.Test;

public class TestApp {
    @Test
    public void ControlNumberTestTrue(){
        Resident resident = new Resident("Poznan", "Stefan", "Czarniecki", "99100354533");
        Assert.assertTrue(App.RepetedPesel(resident,"99100354533", "Aleksander", "Kowalski"));
    }

    @Test
    public void ControlNumberTestFalse(){
        Resident resident = new Resident("Poznan", "Stefan", "Czarniecki", "99100354533");
        Assert.assertFalse(App.RepetedPesel(resident,"77010793699", "Stefan", "Czarniecki"));
    }

}
