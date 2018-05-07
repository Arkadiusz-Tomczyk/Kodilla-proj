package stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        Integer [] littList = {15, 59,789, 1589,1};

        //When
        double avg = ArrayOperations.getAverage(littList);

        //Then

        Assert.assertEquals(490, avg, 1);

    }
}
