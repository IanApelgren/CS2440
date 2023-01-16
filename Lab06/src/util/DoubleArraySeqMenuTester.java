package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import solution.DoubleArraySeq;

/**
 * The class <code>TestDoubleArraySeq.java</code> tests the constructors and
 * public methods of class <code>DoubleArraySeq</code> using a console menu.
 * When the program pauses, the user should enter one of the following with one
 * that is appropriate dependent on the context:
 * <p>
 * <ul>
 * <li>a single integer menu choice</li>
 * <li>a single double value</li>
 * <li>several double values separated by blanks</li>
 * </ul>
 * Exceptions <code>IllegalArgumentException</code> and
 * <code>IllegalStateException</code> are caught by the <code>main</code>
 * method. No other exceptions are caught.
 * <p>
 * The <code>DoubleArraySeq</code> methods <code>clone</code>, <code>size</code>
 * , and <code>getCapacity</code> are implicitly tested by the
 * <code>display</code> method.
 * <p>
 * The original version of this file was downloaded from:
 * http://ctas.east.asu.edu/millard/CET230/proj/proj2/TestDoubleArraySeq.java
 * 
 * @author Dr. Mark A. Holliday
 * @author Bob Houston
 * @version 25 February 2011 (was 23 January 2000)
 */
public class DoubleArraySeqMenuTester
{
    private BufferedReader stdin = new BufferedReader(
            new InputStreamReader(System.in));

    /**
     * The first set of choices.
     * 
     * @param choice
     *            The choice.
     * @param seq
     *            The sequence.
     * @return The new sequence.
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private DoubleArraySeq switch1(int choice, DoubleArraySeq seq)
        throws IOException
    {
        switch (choice)
        {
            case 1:
                seq = newDASeq();
                break;
            case 2:
                testAddAfter(seq);
                break;
            case 3:
                testAddBefore(seq);
                break;
            case 4:
                seq.removeCurrent();
                break;
            case 5:
                testIsCurrent(seq);
                break;
            case 6:
                testGetCurrent(seq);
                break;
            case 7:
                seq.start();
                break;
            default:
        }
        return seq;
    }

    /**
     * The second set of choices.
     * 
     * @param choice
     *            The choice.
     * @param seq
     *            The sequence.
     * @return The new sequence.
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private DoubleArraySeq switch2(int choice, DoubleArraySeq seq)
        throws IOException
    {
        switch (choice)
        {
            case 8:
                seq.advance();
                break;
            case 9:
                seq.trimToSize();
                break;
            case 10:
                testEnsureCapacity(seq);
                break;
            case 11:
                testAddAll(seq);
                break;
            case 12:
                testConcatenation(seq);
                break;
            case 13:
                testToString(seq);
                break;
            case 14:
                testEquals(seq);
                break;
            default:
        }
        return seq;
    }

    /**
     * Runs the main loop.
     * 
     * @throws IOException
     *             if out of memory.
     */
    public void runTests() throws IOException
    {
        DoubleArraySeq seq = new DoubleArraySeq();
        boolean done = false;

        display("seq", seq);

        while (!done)
        {
            try
            {
                int choice = getMenuChoice();
                if (choice == 0)
                {
                    break;
                }
                seq = switch1(choice, seq);
                seq = switch2(choice, seq);
            }
            catch (IllegalArgumentException e1)
            {
                System.out.print("\nCAUGHT: IllegalArgumentException: ");
                System.out.println(e1.getMessage());
            }
            catch (IllegalStateException e2)
            {
                System.out.print("\nCAUGHT: IllegalStateException: ");
                System.out.println(e2.getMessage());
            }

            display("seq", seq);
        }
    }

    /**
     * Displays the current sequence.
     * 
     * @param label
     *            The label of the sequence.
     * @param seq
     *            The sequence.
     */
    private void display(String label, DoubleArraySeq seq)
    {
        DoubleArraySeq temp = seq.clone();
        int currPos = posOfCurrent(seq.clone());
        String outElement;

        System.out.println();
        System.out.print(label + ": {");

        temp.start();
        for (int i = 0; i < temp.size(); i++)
        {
            outElement = Double.toString(temp.getCurrent());

            if (i == currPos)
            {
                System.out.print("[" + outElement + "]");
            }
            else
            {
                System.out.print("<" + outElement + ">");
            }

            temp.advance();
        }

        for (int i = temp.size(); i < temp.getCapacity(); i++)
        {
            System.out.print("<>");
        }

        System.out.println("}");
    }

    /**
     * Gets the current position independent of the 'getCurrent' method.
     * 
     * @param seq
     *            The sequence
     * @return The current position
     */
    private int posOfCurrent(DoubleArraySeq seq)
    {
        int count = 0;

        while (seq.isCurrent())
        {
            seq.advance();
            count++;
        }

        return seq.size() - count;
    }

    /**
     * Prints the menu and reads the user input.
     * 
     * @return The option selected
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private int getMenuChoice() throws IOException
    {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("------------------------------------------------");
        System.out.println("1 Constructor   6 getCurrent     11 addAll    ");
        System.out.println("2 addAfter      7 start          12 concatenation");
        System.out.println("3 addBefore     8 advance        13 toString");
        System.out.println("4 removeCurrent 9 trimToSize     14 equals ");
        System.out.println("5 isCurrent    10 ensureCapacity");
        System.out.println("------------------------------------------------");
        System.out.print("Number of method to test (0 to quit): ");

        return Integer.parseInt(stdin.readLine());
    }

    /**
     * Creates and returns a new sequence.
     * 
     * @return The new sequence
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private DoubleArraySeq newDASeq() throws IOException
    {
        System.out.println();
        System.out.print("Enter initial capacity: ");

        return new DoubleArraySeq(Integer.parseInt(stdin.readLine()));
    }

    /**
     * Adds a value after the current element.
     * 
     * @param seq
     *            The sequence.
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private void testAddAfter(DoubleArraySeq seq) throws IOException
    {
        System.out.println();
        System.out.print("Enter double value to be added: ");
        seq.addAfter(Double.parseDouble(stdin.readLine()));
    }

    /**
     * Adds an element before the current.
     * 
     * @param seq
     *            The sequence.
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private void testAddBefore(DoubleArraySeq seq) throws IOException
    {
        System.out.println();
        System.out.print("Enter double value to be added: ");
        seq.addBefore(Double.parseDouble(stdin.readLine()));
    }

    /**
     * Prints whether or not a current element exists.
     * 
     * @param seq
     *            The sequence.
     */
    private void testIsCurrent(DoubleArraySeq seq)
    {
        System.out.println();
        if (seq.isCurrent())
        {
            System.out.println("A current element exists.");
        }
        else
        {
            System.out.println("No current element exists.");
        }
    }

    /**
     * Prints the current sequence using getCurrent.
     * 
     * @param seq
     *            The sequence.
     */
    private void testGetCurrent(DoubleArraySeq seq)
    {
        System.out.println();
        System.out.println("Current element: "
                + Double.toString(seq.getCurrent()));
    }

    /**
     * Calls the ensureCapacity method on the sequence.
     * 
     * @param seq
     *            The sequence
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private void testEnsureCapacity(DoubleArraySeq seq) throws IOException
    {
        System.out.println();
        System.out.print("Enter minimum capacity: ");
        seq.ensureCapacity(Integer.parseInt(stdin.readLine()));
    }

    /**
     * Tests the addAll method.
     * 
     * @param seq
     *            The sequence
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private void testAddAll(DoubleArraySeq seq) throws IOException
    {
        DoubleArraySeq addend = new DoubleArraySeq();

        System.out.println();
        System.out.print("Enter 0 or more double values for addend: ");
        StringTokenizer st = new StringTokenizer(stdin.readLine(), " ,");

        while (st.hasMoreTokens())
        {
            addend.addAfter(Double.parseDouble(st.nextToken()));
        }
        display("addend", addend);

        seq.addAll(addend);
    }

    /**
     * Tests the concatenation method.
     * 
     * @param s1
     *            The sequence.
     * @throws IOException
     *             if it can not read from the input stream.
     */
    private void testConcatenation(DoubleArraySeq s1) throws IOException
    {
        StringTokenizer st;
        DoubleArraySeq s2 = new DoubleArraySeq();

        display("s1", s1);
        System.out.println();
        System.out.print("Enter 0 or more double values for s2: ");
        st = new StringTokenizer(stdin.readLine(), " ,");

        while (st.hasMoreTokens())
        {
            s2.addAfter(Double.parseDouble(st.nextToken()));
        }
        display("s2", s2);

        display("result", DoubleArraySeq.concatenation(s1, s2));
    }

    /**
     * Tests the toString method.
     * 
     * @param seq
     *            The sequence.
     */
    private void testToString(DoubleArraySeq seq)
    {
        System.out.println();
        System.out.println(seq.toString());
    }

    /**
     * Tests the equals method.
     * 
     * @param seq
     *            The sequence.
     */
    private void testEquals(DoubleArraySeq seq)
    {
        final double A = 2.5;
        final double B = 4.0;
        System.out.println();
        DoubleArraySeq s1 = seq;

        System.out.println(seq.equals(s1) + " " + s1.equals(seq));

        s1 = new DoubleArraySeq();
        s1.addAfter(A);
        s1.addAfter(B);
        System.out.println(seq.equals(s1) + " " + s1.equals(seq));

        DoubleArraySeq s2 = new DoubleArraySeq();
        s2.addAfter(B);
        s2.addAfter(A);

        System.out.println(s2.equals(s1) + " " + s1.equals(s2));
    }

    /**
     * The main program.
     * 
     * @param args
     *            Not used.
     * @throws IOException
     *             if it can not read from the input stream.
     */
    public static void main(String[] args) throws IOException
    {
        DoubleArraySeqMenuTester tester = new DoubleArraySeqMenuTester();
        tester.runTests();
    }
}
