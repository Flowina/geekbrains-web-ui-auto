package hw4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTests {
    @Test
    public void positiveTriangleSquareCalculate() {

        Assert.assertEquals(TriangleHelper.square(3, 4, 5), 6);
    }

    @Test
    public void negativeTriangleSquareCalculate() {

        Assert.expectThrows(IllegalArgumentException.class, () -> TriangleHelper.square(0, 4, 5));
    }
}
