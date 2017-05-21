import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/19/17.
 */
public class MySetTest
{
    MySet <String> mySet;
    ArrayList<String> myList;

    @Before
    public void initialize()
    {
        mySet = new MySet<String>();
        myList = new ArrayList<String>();
        myList.add("Chris");
        myList.add("Stephen");
        myList.add("Chris");
        myList.add("Greg");
        myList.add("Blue");
    }

    @Test
    public void addTest()
    {
        //given
        int expected = 1;

        //when
       boolean result = mySet.add("Paco");
       int actual = mySet.size();

       //then
        Assert.assertEquals("size", expected, actual);
        Assert.assertTrue("The resutl", result);
    }

    @Test
    public void addTestDuplicate()
    {
        //given
        int expectd = 1;

        //when
        mySet.add("Paco");
        boolean result = mySet.add("Paco");
        int actual = mySet.size();

        //then
        Assert.assertEquals("size", expectd, actual);
        Assert.assertFalse("The resutl", result);
    }

    @Test
    public void clearTest()
    {
        //given
        int expectd = 0;

        //when
        mySet.add("Paco");
        mySet.clear();
        int actual = mySet.size();

        //then
        Assert.assertEquals("size", expectd, actual);
        Assert.assertTrue("Should be empty", mySet.isEmpty());
    }

    @Test
    public void addAllTest()
    {
        //given
        int expected = 4;

        //when
       boolean result =  mySet.addAll(myList);
        int actual = mySet.size();

        //then
        Assert.assertEquals("Test to add 2 new", expected, actual);
        Assert.assertTrue("should add something new", result);

    }

    @Test
    public void removeTestSuccess(){
        //given
        mySet.add("Delaware");
        mySet.add("New Jersey");
        int expected = 1;

        //when
        boolean result = mySet.remove("New Jersey");
        int actual = mySet.size();

        //
        Assert.assertEquals("shoud be 1 left", expected, actual);
    }

    @Test
    public void hashCodeTest()
    {
        String paco = "Paco";
        String stephen = "Stephen";
        int expected = paco.hashCode() + stephen.hashCode();
        mySet.add(paco);
        mySet.add(stephen);

        int actual = mySet.hashCode();

        Assert.assertEquals("Should equal", expected, actual);
    }

    @Test
    public void toArrayTest()
    {
        //given
        mySet.add("Monday");
        mySet.add("Tuesday");
        mySet.add("Wednesday");
        String expected = "Monday";

        //when
        Object [] week = mySet.toArray();
        String actual = week[0].toString();

        //then
        Assert.assertEquals("check object of array", expected, actual);
    }

    @Test
    public void testRemoveAll()
    {
        //given
        mySet.add("Ford");
        mySet.add("Honda");
        mySet.add("Stephen");
        int expected = 2;

        //when
        mySet.removeAll(myList);
        int actual = mySet.size();

        //then
        Assert.assertEquals("test", expected, actual);

    }

    @Test
    public void testRetainAll()
    {
        //given
        mySet.add("Chris");
        mySet.add("Paco");
        mySet.add("Greg");
        mySet.add("Stephen");
        mySet.add("Anna");
        int expected = 3;

        //when
        mySet.retainAll(myList);
        int actual = mySet.size();

        //then
        Assert.assertEquals("Should be only one duplicate", expected, actual);

    }

}
