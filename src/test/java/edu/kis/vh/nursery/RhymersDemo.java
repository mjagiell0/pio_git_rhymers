package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

/**
 * The RhymersDemo class demonstrates the use of the rhymers from the factory.
 */
class RhymersDemo {

    /**
     * The main method which serves as the entry point of the program.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    /**
     * Tests the rhymers created by the given factory.
     *
     * @param factory The factory to create rhymers
     */
    private static void testRhymers(Rhymersfactory factory) {
        DefaultCountingOutRhymer[] rhymers = {
                factory.GetStandardRhymer(),
                factory.GetFalseRhymer(),
                factory.GetFIFORhymer(),
                factory.GetHanoiRhymer()
        };
        /**
         * Tests the rhymers created by the given factory.
         */
        for (int i = 1; i < 15; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);

        /**
         *  Populate the HanoiRhymer with random values
         */
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++)
            rhymers[3].countIn(rn.nextInt(20));

        /**
         *  Print the contents of each rhymer
         */
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        /**
         *  Print the total number of rejected values for the HanoiRhymer
         */
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
    }

}
