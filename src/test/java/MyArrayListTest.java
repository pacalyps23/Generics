/**
 * Created by luisgarcia on 5/18/17.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MyArrayListTest<E>
{
    MyArrayList myList;
    String name1;
    String name2;
    String name3;

    @Before
    public void initialize()
    {
        myList = new MyArrayList();
        name1 = "Paco";
        name2 = "Alla";
        name3 = "Celia";

    }

    @Test
    public void addTest()
    {
        //given
        myList.add(name1);
        myList.add(name2);
        String expected = name2;

        //when
        String actual = (String) myList.get(0);
        System.out.println("Size:" + myList.getSize());

        //then
        Assert.assertEquals("Shoudl return Alla", expected, actual);
    }

}
