package day30.CabInvoiceGeneratorTest;

import com.bl.day30.invoicegenerator.CabInvoiceGenerator;
import com.bl.day30.invoicegenerator.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double fare = generator.calculateFare(2.0, 5);
        Assertions.assertEquals(25.0, fare);
    }

    @Test
    public void givenVeryShortRide_ShouldReturnMinimumFare(){
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double fare = generator.calculateFare(0.1,1);
        Assertions.assertEquals(5.0, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double totalFare = generator.calculateFare(rides);
        Assertions.assertEquals(30.0, totalFare);
    }
}
