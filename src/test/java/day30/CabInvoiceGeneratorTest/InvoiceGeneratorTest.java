package day30.CabInvoiceGeneratorTest;

import com.bl.day30.invoicegenerator.InvoiceGenerator;
import com.bl.day30.invoicegenerator.InvoiceSummary;
import com.bl.day30.invoicegenerator.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    @Test
    public void givenMultipleRides_ShouldReturnEnhancedInvoiceSummary() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(3.0, 10),
                new Ride(1.0, 3)
        };
        InvoiceSummary summary = generator.calculateInvoice(rides);
        Assertions.assertEquals(3, summary.totalRides);
        Assertions.assertEquals(78.0, summary.totalFare, 0.0);
        Assertions.assertEquals(26.0, summary.averageFare, 0.0);
    }
}
