package day30.CabInvoiceGeneratorTest;

import com.bl.day30.invoicegenerator.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    @Test
    public void givenMultipleRides_ShouldReturnEnhancedInvoiceSummary() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(RideType.NORMAL,2.0, 5),
                new Ride(RideType.NORMAL,3.0, 10),
                new Ride(RideType.NORMAL,1.0, 3)
        };
        InvoiceSummary summary = generator.calculateInvoice(rides);
        Assertions.assertEquals(3, summary.totalRides);
        Assertions.assertEquals(78.0, summary.totalFare, 0.0);
        Assertions.assertEquals(26.0, summary.averageFare, 0.0);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {

        RideRepository repository = new RideRepository();
        Ride[] rides = {
                new Ride(RideType.NORMAL,2.0, 5),
                new Ride(RideType.NORMAL,3.0, 10)
        };
        repository.addRides("user1", rides);

        InvoiceService service = new InvoiceService(repository);
        InvoiceSummary summary = service.getInvoice("user1");

        Assertions.assertEquals(2, summary.totalRides);
        Assertions.assertEquals(65.0, summary.totalFare, 0.0);
        Assertions.assertEquals(32.5, summary.averageFare, 0.0);
    }
    @Test
    public void givenNormalAndPremiumRides_ShouldReturnCorrectInvoice() {

        InvoiceGenerator generator = new InvoiceGenerator();

        Ride[] rides = {
                new Ride(RideType.NORMAL, 2.0, 5),     // 25
                new Ride(RideType.PREMIUM, 1.0, 5)     // 25
        };

        InvoiceSummary summary = generator.calculateInvoice(rides);

        Assertions.assertEquals(2, summary.totalRides);
        Assertions.assertEquals(50.0, summary.totalFare, 0.0);
        Assertions.assertEquals(25.0, summary.averageFare, 0.0);
    }
}
