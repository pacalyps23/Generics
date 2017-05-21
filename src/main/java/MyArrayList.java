
import java.util.Arrays;

/**
 * Created by luisgarcia on 5/18/17.
 */
public class MyArrayList<E>
{
    private Object[] myArray;
    private int count;

    public MyArrayList()
    {
        count = 0;
        myArray = new Object[count];

    }

    public void add(E element)
    {
        if(myArray.length == count)
            myArray = Arrays.copyOf(myArray, myArray.length+1);

        myArray [count++] = element;
    }

    public Object get(int index)
    {

        return myArray[index];
    }

    public boolean isEmpty()
    {
        if(getSize() <= 0)
            return true;
        else
            return false;
    }

    public void remove(int index)
    {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        else
        {
            boolean result = false;
           shiftLeft(index);
        }
    }

    public int getSize()
    {
        return count;
    }

    private void shiftLeft(int index)
    {
        for(int j = index; j < getSize()-1; j++)
        {
            myArray[j] = myArray[j+1];
        }
        count--;
    }

    public Object [] toArray()
    {
        Object [] result = new Object[getSize()];
        for(int i = 0; i < getSize(); i++)
        {
            result[i] = myArray[i];
        }
        return result;
    }


}
