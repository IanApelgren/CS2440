package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import solution.DoubleArraySeq;

/**
 * JUnit test class for DoubleArraySeq.
 * 
 * @author Mitch Parry
 * @version 2013-08-15
 * 
 */
public class DoubleArraySeqTest
{
    private static final double A = 1.1;
    private static final double B = 2.2;
    private static final double C = 3.3;
    private static final double D = 4.4;
    private static final double E = 5.5;
    private static final double F = 6.6;
    private static final double G = 7.7;
    private static final double H = 8.8;
    private static final double I = 9.9;
    private static final double A2 = 1.2;
    private static final double B3 = 2.3;

    /**
     * A helper method that increments the pass/fail counters and prints an
     * appropriate message based on the value of the specified condition.
     * 
     * @param condition
     *            A condition for which to test. If the condition is true, the
     *            test passed; otherwise, it fails.
     * @param message
     *            A message to print indicating the context for the test.
     */
    private void test(boolean condition, String message)
    {
        if (condition)
        {
            System.out.println("\nPASSED: " + message);
        }
        else
        {
            System.out.println("\nFAILED: " + message);
        }
        assertTrue(message, condition);
    }

    /**
     * Tests the no-args constructor.
     */
    @Test
    public void testNoArgsConstructor()
    {
        DoubleArraySeq s = new DoubleArraySeq();

        test(s.getCapacity() == 10,
                "Default parameter gives a capacity of 10: " + s.getCapacity());
        test(!s.isCurrent(),
                "isCurrent returns false: " + s.isCurrent());
        test(s.size() == 0,
                "size returns 0: " + s.size());
        test(s.toString().equals("<>"),
                "toString returns \"<>\": " + s.toString());
    }

    /**
     * Tests the one argument constructor.
     */
    @Test
    public void testOneArgConstructor()
    {
        final int INITIAL_CAPACITY = 27;
        DoubleArraySeq s2 = new DoubleArraySeq(INITIAL_CAPACITY);
        test(s2.getCapacity() == INITIAL_CAPACITY,
                "new DoubleArraySeq(27) gives a capacity of 27: "
                        + s2.getCapacity());
        test(!s2.isCurrent(),
                "isCurrent returns false: " + s2.isCurrent());
        test(s2.size() == 0,
                "size returns 0: " + s2.size());
        test(s2.toString().equals("<>"),
                "toString returns \"<>\": " + s2.toString());
    }

    /**
     * Tests trimToSize.
     */
    @Test
    public void testTrimToSize()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.trimToSize();
        assertEquals("After trimToSize(), capacity is 0: " + s.getCapacity(),
                0, s.getCapacity());
    }

    /**
     * Tests equals.
     */
    @Test
    public void testEquals()
    {
        final int INITIAL_CAPACITY = 27;
        DoubleArraySeq s2 = new DoubleArraySeq(INITIAL_CAPACITY);
        DoubleArraySeq s = new DoubleArraySeq();
        test(s.equals(s2),
                "Two empty sequences are equal: " + s.equals(s2));
        s.trimToSize();
        test(s.equals(s2),
                "Two empty sequences are still equal: " + s.equals(s2));
    }

    /**
     * Tests ensureCapacity.
     */
    @Test
    public void testEnsureCapacity()
    {
        final int INITIAL_CAPACITY = 27;
        final int ENSURE_CAPACITY = 128;
        DoubleArraySeq s = new DoubleArraySeq(INITIAL_CAPACITY);
        s.ensureCapacity(ENSURE_CAPACITY);
        test(s.getCapacity() == ENSURE_CAPACITY,
                "After ensureCapacity(128), capacity is 128: "
                        + s.getCapacity());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter1()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);

        test(s.toString().equals("<[1.1]>"),
                "After addAfter(1.1), toString returns <[1.1]>: "
                        + s.toString());
        test(s.getCurrent() == A,
                "Current is 1.1: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 1,
                "size is 1: " + s.size());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter2()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);

        test(s.toString().equals("<1.1, [2.2]>"),
                "After addAfter(2.2), toString returns <1.1, [2.2]>: "
                        + s.toString());
        test(s.getCurrent() == B,
                "Current is 2.2: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 2,
                "size is 2: " + s.size());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter3()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);

        test(s.toString().equals("<1.1, 2.2, [3.3]>"),
                "After addAfter(3.3), toString returns <1.1, 2.2, [3.3]>:\n"
                        + "        " + s.toString());
        test(s.getCurrent() == C,
                "Current is 3.3: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 3,
                "size is 3: " + s.size());
    }

    /**
     * Tests start.
     */
    @Test
    public void testStart1()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        test(s.toString().equals("<[1.1], 2.2, 3.3>"),
                "After start, toString returns <[1.1], 2.2, 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter4()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        test(s.toString().equals("<1.1, [4.4], 2.2, 3.3>"),
                "After addAfter(4.4), toString returns "
                        + "<1.1, [4.4], 2.2, 3.3>:\n        " + s.toString());
        test(s.getCurrent() == D,
                "Current is 4.4: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 4,
                "size is 4: " + s.size());
    }

    /**
     * Tests advance.
     */
    @Test
    public void testAdvance1()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();

        test(s.toString().equals("<1.1, 4.4, [2.2], 3.3>"),
                "After advance, toString returns <1.1, 4.4, [2.2], 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter5()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);

        test(s.toString().equals("<1.1, 4.4, 2.2, [5.5], 3.3>"),
                "After addAfter(5.5), toString returns "
                        + "<1.1, 4.4, 2.2, [5.5], 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests advance.
     */
    @Test
    public void testAdvance2()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3>"),
                "After 2x advance(), toString returns "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter6()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();
        s.addAfter(F);

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3, [6.6]>"),
                "After addAfter(6.6), toString returns "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3, [6.6]>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter7()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();
        s.addAfter(F);
        s.addAfter(G);
        s.addAfter(H);
        s.addAfter(I);
        s.addAfter(A2);

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, "
                + "8.8, 9.9, [1.2]>"),
                "After adding 4 more, toString returns\n        "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, 8.8,"
                        + " 9.9, [1.2]>:\n" + "        " + s.toString());
        test(s.getCapacity() == 10,
                "Capacity is 10: " + s.getCapacity());
        test(s.size() == 10,
                "size returns 10: " + s.size());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter8()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();
        s.addAfter(F);
        s.addAfter(G);
        s.addAfter(H);
        s.addAfter(I);
        s.addAfter(A2);
        s.addAfter(B3);

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, "
                + "8.8, 9.9, 1.2, [2.3]>"),
                "After adding 1 more, toString returns\n        "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, 8.8,"
                        + "9.9, 1.2, [2.3]>:\n        " + s.toString());
        test(s.getCapacity() > 11,
                "Capacity is > 11: " + s.getCapacity());
        test(s.size() == 11,
                "size returns 11: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore1()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);

        test(s.toString().equals("<[1.1]>"),
                "After addBefore(1.1), toString returns <[1.1]>: "
                        + s.toString());
        test(s.getCurrent() == A,
                "Current is 1.1: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 1,
                "size is 1: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore2()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);

        test(s.toString().equals("<[2.2], 1.1>"),
                "After addBefore(2.2), toString returns <[2.2], 1.1>: "
                        + s.toString());
        test(s.getCurrent() == B,
                "Current is 2.2: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 2,
                "size is 2: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore3()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);

        test(s.toString().equals("<[3.3], 2.2, 1.1>"),
                "After addBefore(3.3), toString returns <[3.3], 2.2, 1.1>:\n"
                        + "        " + s.toString());
        test(s.getCurrent() == C,
                "Current is 3.3: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 3,
                "size is 3: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAdvance3()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();

        test(s.toString().equals("<3.3, [2.2], 1.1>"),
                "After advance(), toString returns <3.3, [2.2], 1.1>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore4()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);

        test(s.toString().equals("<3.3, [4.4], 2.2, 1.1>"),
                "After addBefore(4.4), toString returns " + "<3.3, [4.4], 2.2,"
                        + "1.1>:\n" + "        " + s.toString());
        test(s.getCurrent() == D,
                "Current is 4.4: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 4,
                "size is 4: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAdvance4()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();

        test(s.toString().equals("<3.3, 4.4, 2.2, 1.1>"),
                "After 3x advance(), toString returns <3.3, 4.4, 2.2, 1.1>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore5()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();
        s.addBefore(E);

        test(s.toString().equals("<[5.5], 3.3, 4.4, 2.2, 1.1>"),
                "After addBefore(5.5), toString returns "
                        + "<[5.5], 3.3, 4.4, 2.2, 1.1>:\n        "
                        + s.toString());
        test(s.getCurrent() == E,
                "Current is 5.5: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 5,
                "size is 5: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore6()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();
        s.addBefore(E);
        s.addBefore(F);
        s.addBefore(G);
        s.addBefore(H);
        s.addBefore(I);
        s.addBefore(A2);

        test(s.getCurrent() == A2,
                "Current is 1.2: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() == 10,
                "capacity is still 10: " + s.getCapacity());
        test(s.size() == 10,
                "size is 10: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore7()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();
        s.addBefore(E);
        s.addBefore(F);
        s.addBefore(G);
        s.addBefore(H);
        s.addBefore(I);
        s.addBefore(A2);
        s.addBefore(B3);

        test(s.getCurrent() == B3,
                "Current is 2.3: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.getCapacity() > 11,
                "capacity is > 11: " + s.getCapacity());
        test(s.size() == 11,
                "size is 11: " + s.size());
    }

    /**
     * Tests addAll.
     */
    @Test
    public void testAddAll1()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        DoubleArraySeq s2 = new DoubleArraySeq();
        s1.addAfter(A);
        s1.addAfter(C);
        s1.addBefore(B);

        s2.addAfter(D);
        s2.addAfter(E);
        s2.addAfter(F);

        s1.addAll(s2);

        test(s1.toString().equals("<1.1, [2.2], 3.3, 4.4, 5.5, 6.6>"),
                "After addAll(s2), s1 is <1.1, [2.2], 3.3, 4.4, 5.5, 6.6>");
        test(s1.size() == 6,
                "s1's size is 6: " + s1.size());
        test(s1.getCapacity() == 10,
                "s1's capacity is 10: " + s1.getCapacity());
    }

    /**
     * Tests addAll.
     */
    @Test
    public void testAddAll2()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        DoubleArraySeq s2 = new DoubleArraySeq();
        s1.addAfter(A);
        s1.addAfter(C);
        s1.addBefore(B);

        s2.addAfter(D);
        s2.addAfter(E);
        s2.addAfter(F);

        s1.addAll(s2);

        test(s2.toString().equals("<4.4, 5.5, [6.6]>"),
                "After addAll(), s2 is <4.4, 5.5, [6.6]>");
        test(s2.size() == 3,
                "s2's size is 3: " + s2.size());
        test(s2.getCapacity() == 10,
                "s2's capacity is 10: " + s2.getCapacity());
    }

    /**
     * Tests addAll.
     */
    @Test
    public void testAddAll3()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        DoubleArraySeq s2 = new DoubleArraySeq();
        s1.addAfter(A);
        s1.addAfter(C);
        s1.addBefore(B);

        s2.addAfter(D);
        s2.addAfter(E);
        s2.addAfter(F);

        s1.addAll(s2);
        s1.addAll(s1);

        test(s1.toString().equals("<1.1, [2.2], 3.3, 4.4, 5.5, 6.6, 1.1, "
                + "2.2, 3.3, 4.4, 5.5, 6.6>"),
                "After addAll(s1), s1 is\n        <1.1, [2.2], 3.3, 4.4, 5.5, "
                        + "6.6, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6>:\n        "
                        + s1.toString());
        test(s1.size() == 12,
                "s1's size is 12: " + s1.size());
        test(s1.getCapacity() >= 12,
                "s1's capacity should be >= 12: " + s1.getCapacity());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone1()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleArraySeq s2 = s1.clone();

        test(s1.equals(s2),
                "The clone and the original are equal: " + s1.equals(s2));

        test(s1.toString().equals("<1.1, [2.2], 3.3>"),
                "s1 is <1.1, [2.2], 3.3>: " + s1.toString());
        test(s1.size() == 3,
                "The size of the original is 3: " + s1.size());
        test(s1.getCapacity() == 10,
                "The capacity of the original is 10: " + s1.getCapacity());
        test(s1.getCurrent() == B,
                "The current of the original is 2.2: " + s1.getCurrent());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone2()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleArraySeq s2 = s1.clone();

        test(s2.toString().equals("<1.1, [2.2], 3.3>"),
                "s2 is <1.1, [2.2], 3.3>: " + s2.toString());
        test(s2.size() == 3,
                "The size of the clone is 3: " + s2.size());
        test(s2.getCapacity() == 10,
                "The capacity of the clone is 10: " + s2.getCapacity());
        test(s2.getCurrent() == B,
                "The current of the clone is 2.2: " + s2.getCurrent());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone3()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleArraySeq s2 = s1.clone();
        s2.addAfter(D);

        test(s1.toString().equals("<1.1, [2.2], 3.3>"),
                "s1 is <1.1, [2.2], 3.3>: " + s1.toString());
        test(s1.size() == 3,
                "The size of the original is 3: " + s1.size());
        test(s1.getCapacity() == 10,
                "The capacity of the original is 10: " + s1.getCapacity());
        test(s1.getCurrent() == B,
                "The current of the original is 2.2: " + s1.getCurrent());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone4()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleArraySeq s2 = s1.clone();
        s2.addAfter(D);

        test(s2.toString().equals("<1.1, 2.2, [4.4], 3.3>"),
                "s2 is <1.1, 2.2, [4.4], 3.3>: " + s2.toString());
        test(s2.size() == 4,
                "The size of the clone is 4: " + s2.size());
        test(s2.getCapacity() == 10,
                "The capacity of the clone is 10: " + s2.getCapacity());
        test(s2.getCurrent() == D,
                "The current of the clone is 4.4: " + s2.getCurrent());
    }

    /**
     * Tests the concatenation method.
     */
    @Test
    public void testConcatenation1()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        s1.addAfter(A);
        s1.addAfter(B);

        DoubleArraySeq s2 = new DoubleArraySeq();
        s2.addBefore(B);
        s2.addBefore(A);

        DoubleArraySeq.concatenation(s1, s2);

        test(s1.toString().equals("<1.1, [2.2]>"),
                "s1 is still <1.1, [2.2]>: " + s1.toString());
        test(s2.toString().equals("<[1.1], 2.2>"),
                "s2 is still <[1.1], 2.2>: " + s2.toString());
    }

    /**
     * Tests the concatenation method.
     */
    @Test
    public void testConcatenation2()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        s1.addAfter(A);
        s1.addAfter(B);

        DoubleArraySeq s2 = new DoubleArraySeq();
        s2.addBefore(B);
        s2.addBefore(A);

        DoubleArraySeq s3 = DoubleArraySeq.concatenation(s1, s2);

        test(s3.toString().equals("<1.1, 2.2, 1.1, 2.2>"),
                "New seq is: <1.1, 2.2, 1.1, 2.2>: " + s3.toString());
        test(s3.size() == 4,
                "New seq's size is 4: " + s3.size());
        test(s3.getCapacity() >= 4,
                "New seq's capacity is >= 4: " + s3.getCapacity());
        test(!s3.isCurrent(),
                "New seq has a current (false): " + s3.isCurrent());
    }

    /**
     * Initialize sequence.
     * 
     * @param s
     *            the sequence
     */
    private void initialize(DoubleArraySeq s)
    {
        s.addAfter(1.0);
        s.addAfter(2.0);
        s.addAfter(3.0);
        s.addAfter(4.0);
        s.addAfter(5.0);
        s.addAfter(6.0);
        s.addAfter(7.0);
        s.addAfter(8.0);
        s.addAfter(9.0);
        s.addAfter(1.0);
        s.addAfter(A);
    }

    /**
     * Update sequence.
     * 
     * @param s
     *            the sequence
     */
    private void update(DoubleArraySeq s)
    {
        s.start();
        s.removeCurrent();
        s.advance();
        s.removeCurrent();
        s.advance();
        s.advance();
        s.removeCurrent();
    }

    /**
     * Tests the start method.
     */
    @Test
    public void testStart2()
    {
        DoubleArraySeq s = new DoubleArraySeq();
        initialize(s);

        // int oldCapacity = s.getCapacity();

        s.start();
        test(s.toString().equals("<[1.0], 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, "
                + "8.0, 9.0, 1.0, 1.1>"),
                "Seq is: <[1.0], 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, "
                        + "8.0, 9.0, 1.0, 1.1>:\n        " + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent1()
    {
        DoubleArraySeq s = new DoubleArraySeq();

        initialize(s);

        int oldCapacity = s.getCapacity();

        s.start();
        s.removeCurrent();

        test(s.size() == 10, "size is 10: " + s.size());
        test(s.getCapacity() == oldCapacity,
                "Capacity is " + oldCapacity + ": " + s.getCapacity());
        test(s.toString().equals("<[2.0], 3.0, 4.0, 5.0, 6.0, 7.0, "
                + "8.0, 9.0, 1.0, 1.1>"),
                "After removeCurrent: <[2.0], 3.0, 4.0, 5.0, 6.0, 7.0, "
                        + "8.0, 9.0, 1.0, 1.1>:\n        " + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent2()
    {
        DoubleArraySeq s = new DoubleArraySeq();

        initialize(s);

        int oldCapacity = s.getCapacity();

        s.start();
        s.removeCurrent();
        s.advance();
        s.removeCurrent();

        test(s.size() == 9, "size is 9: " + s.size());
        test(s.getCapacity() == oldCapacity,
                "Capacity is " + oldCapacity + ": " + s.getCapacity());
        test(s.toString().equals("<2.0, [4.0], 5.0, 6.0, 7.0, "
                + "8.0, 9.0, 1.0, 1.1>"),
                "After advance/removeCurrent:\n        <2.0, [4.0], 5.0, 6.0, "
                        + "7.0, 8.0, 9.0, 1.0, 1.1>:\n        " + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent3()
    {
        DoubleArraySeq s = new DoubleArraySeq();

        initialize(s);

        int oldCapacity = s.getCapacity();

        update(s);

        test(s.size() == 8, "size is 8: " + s.size());
        test(s.getCapacity() == oldCapacity,
                "Capacity is " + oldCapacity + ": " + s.getCapacity());
        test(s.toString().equals("<2.0, 4.0, 5.0, [7.0], "
                + "8.0, 9.0, 1.0, 1.1>"),
                "After advance/advance/removeCurrent:\n        <2.0, 4.0, 5.0, "
                        + "[7.0], 8.0, 9.0, 1.0, 1.1>:\n        "
                        + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent4()
    {
        DoubleArraySeq s = new DoubleArraySeq();

        initialize(s);

        int oldCapacity = s.getCapacity();

        update(s);

        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.removeCurrent();

        test(s.size() == 7, "size is 7: " + s.size());
        test(s.getCapacity() == oldCapacity,
                "Capacity is " + oldCapacity + ": " + s.getCapacity());
        test(s.toString().equals("<2.0, 4.0, 5.0, 7.0, "
                + "8.0, 9.0, 1.0>"),
                "After 4x advance/removeCurrent:  <2.0, 4.0, 5.0, "
                        + "7.0, 8.0, 9.0, 1.0>:\n        " + s.toString());
        test(!s.isCurrent(),
                "Is there a current: (false): " + s.isCurrent());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent5()
    {
        DoubleArraySeq s = new DoubleArraySeq();

        initialize(s);

        int oldCapacity = s.getCapacity();

        update(s);

        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.removeCurrent();
        s.start();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();

        test(s.size() == 0, "size is 0: " + s.size());
        test(s.getCapacity() == oldCapacity,
                "Capacity is " + oldCapacity + ": " + s.getCapacity());
        test(s.toString().equals("<>"), "After removing everything: <>: "
                + s.toString());
        test(!s.isCurrent(),
                "Is there a current: (false): " + s.isCurrent());
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals1()
    {
        DoubleArraySeq s1 = new DoubleArraySeq();
        DoubleArraySeq s2 = new DoubleArraySeq();
        DoubleArraySeq s3 = new DoubleArraySeq();
        DoubleArraySeq s4 = new DoubleArraySeq();
        DoubleArraySeq s5 = new DoubleArraySeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s5.addAfter(A);
        s5.addAfter(B);

        test(s1.equals(s1),
                "An empty sequence is equal to itself: " + s1.equals(s1));
        test(s1.equals(s2),
                "An empty sequence is equal to an empty sequence : "
                        + s1.equals(s2));
        test(!s1.equals(s3),
                "An empty sequence is not equal to a non-empty one: (false): "
                        + s1.equals(s3));
        test(s3.equals(s4),
                "Two non-empty equal sequences are equal: " + s3.equals(s4));
        test(!s3.equals(s5),
                "Two non-empty, non-equal sequences are equal (false): "
                        + s3.equals(s5));
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals2()
    {
        final int CORRECT_CAPACITY = 27;
        DoubleArraySeq s3 = new DoubleArraySeq();
        DoubleArraySeq s4 = new DoubleArraySeq();
        DoubleArraySeq s5 = new DoubleArraySeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s5.addAfter(A);
        s5.addAfter(B);
        s3.ensureCapacity(CORRECT_CAPACITY);

        test(s3.equals(s4),
                "Two non-empty equal sequences (w/ different capacities) "
                        + "are equal:\n        " + s3.equals(s4));
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals3()
    {
        final int CORRECT_CAPACITY = 27;
        DoubleArraySeq s3 = new DoubleArraySeq();
        DoubleArraySeq s4 = new DoubleArraySeq();
        DoubleArraySeq s5 = new DoubleArraySeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s5.addAfter(A);
        s5.addAfter(B);
        s3.ensureCapacity(CORRECT_CAPACITY);
        s3.addAfter(B);
        s4.addAfter(B);
        s3.start();

        test(!s3.equals(s4),
                "Two sequence w/ same element but different current "
                        + "are equal (false):\n        " + s3.equals(s4));
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals4()
    {
        final int CORRECT_CAPACITY = 27;
        DoubleArraySeq s3 = new DoubleArraySeq();
        DoubleArraySeq s4 = new DoubleArraySeq();
        DoubleArraySeq s5 = new DoubleArraySeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s5.addAfter(A);
        s5.addAfter(B);
        s3.ensureCapacity(CORRECT_CAPACITY);
        s3.addAfter(B);
        s4.addAfter(B);
        s3.start();
        s4.advance();

        test(!s3.equals(s4),
                "Two sequence w/ same element but different current "
                        + "are equal (false):\n        " + s3.equals(s4));
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions1()
    {
        try
        {
            DoubleArraySeq s = new DoubleArraySeq();
            s.addAll(null);
            test(false, "addAll(null) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "addAll(null) should throw a NPE: " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "addAll(null) should throw a NPE, got: "
                    + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions2()
    {
        try
        {
            DoubleArraySeq s = new DoubleArraySeq();
            s.advance();
            test(false, "advance() with no current should throw a ISE");
        }
        catch (IllegalStateException ex)
        {
            test(true, "advance() with no current should throw a ISE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "advance() with no current should throw a ISE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions3()
    {
        try
        {
            DoubleArraySeq.concatenation(null, null);
            test(false, "concatenation(null, null) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "concatenation(null, null) should throw a NPE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "concatenation(null, null) should throw a NPE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions4()
    {
        try
        {
            DoubleArraySeq s = new DoubleArraySeq();
            DoubleArraySeq.concatenation(null, s);
            test(false, "concatenation(null, s) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "concatenation(null, s) should throw a NPE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "concatenation(null, s) should throw a NPE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions5()
    {
        try
        {
            DoubleArraySeq s = new DoubleArraySeq();
            DoubleArraySeq.concatenation(s, null);
            test(false, "concatenation(s, null) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "concatenation(s, null) should throw a NPE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "concatenation(s, null) should throw a NPE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions6()
    {
        try
        {
            DoubleArraySeq s = new DoubleArraySeq();
            s.getCurrent();
            test(false, "getCurrent() w/ no current should throw a ISE");
        }
        catch (IllegalStateException ex)
        {
            test(true, "getCurrent() w/ no current should throw a ISE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "getCurrent() w/ no current should throw a ISE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions7()
    {
        try
        {
            DoubleArraySeq s = new DoubleArraySeq();
            s.removeCurrent();
            test(false, "removeCurrent() w/ no current should throw a ISE");
        }
        catch (IllegalStateException ex)
        {
            test(true, "removeCurrent() w/ no current should throw a ISE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "removeCurrent() w/ no current should throw a ISE,\n"
                    + "        got: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
