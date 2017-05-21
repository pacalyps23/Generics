import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Created by luisgarcia on 5/19/17.
 */
public class MySet<E>
{
    private Object [] myArray;
    private int sizeOfArray;

    public MySet()
    {
        myArray = (E[]) new Object[0];
        sizeOfArray = 0;
    }

    public boolean add(E element)
    {
        if(contains(element))
        {
            return false;
        }
        if(myArray.length == size())
            myArray = Arrays.copyOf(myArray, myArray.length+1);

        myArray [sizeOfArray++] = element;
        return true;
    }

    public void clear()
    {
        myArray = (E[]) new Object[0];
        sizeOfArray = 0;
    }

    public boolean contains(Object obj)
    {
        for(int i =0; i < sizeOfArray; i++)
        {
            if (myArray[i].equals(obj))
                return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> collection)
    {
        boolean result = false;
        for(E element : collection)
        {
            if(add(element))
            {
                result = true;
            }
        }
        return result;
    }

    public boolean equals(Object obj)
    {
        return false;
    }

    public boolean isEmpty()
    {
        if(size()==0)
            return true;
        else
            return false;
    }

    public boolean remove(Object obj)
    {
        boolean result = false;
        for(int i = 0; i < size(); i++)
        {
            if(myArray[i].equals(obj))
            {
                shiftLeft(i);
                result = true;
            }
        }
        return result;
    }

    private void shiftLeft(int index)
    {
        for(int j = index; j < size()-1; j++)
        {
            myArray[j] = myArray[j+1];
        }
        myArray = Arrays.copyOf(myArray, myArray.length-1);
        sizeOfArray--;
    }

    public int size()
    {
        return sizeOfArray;
    }

    public int hashCode()
    {
        int result = 0;
        for(Object element: myArray)
        {
           result += element.hashCode();
        }
        return result;
    }

    public Object [] toArray()
    {
        Object [] result = new Object[size()];
        for(int i = 0; i < size(); i++)
        {
            result[i] = myArray[i];
        }
        return result;
    }

    public boolean removeAll(Collection<?> collection)
    {
        boolean result = false;
        for(Object element : collection)
        {
            boolean myResult = remove(element);
            if(myResult)
            {
                result = true;
            }

        }
        return result;
    }

    public boolean retainAll(Collection<?> collection)
    {
        boolean result = false;
                for(int i = 0; i < size(); i++)
                {
                    if(!collection.contains(myArray[i]))
                    {
                        remove(myArray[i]);
                        result = true;
                        i--;
                    }

                }

        return result;
    }



}
