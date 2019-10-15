package edu.cscc;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the methods used by Rock Paper Scissors Lizard Spock to verify they function properly.
 * @author Zach Hertel
 */
public class RPSLSpockTest {
    /**
     * Test if the isValidPick() method is correctly returning True only for the String values used by the game.
     */
    @Test
    public void testIsValidPick() {
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.ROCK));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.PAPER));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.SCISSORS));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.LIZARD));
        Assert.assertTrue(RPSLSpock.isValidPick(RPSLSpock.SPOCK));
        Assert.assertFalse(RPSLSpock.isValidPick("invalid"));
    }

    /**
     * Test if the generatePick() method always selects a String that is not null and is a valid choice in the game.
     */
    @Test
    public void testGeneratePick() {
        for (int i = 0; i < 1000000; i++) {
            String c_pick = RPSLSpock.generatePick();
            Assert.assertTrue(c_pick != null && !"".equals(c_pick));
            Assert.assertTrue(RPSLSpock.isValidPick(c_pick));
        }
    }

    /**
     * Test if the isComputerWin() method is correctly returning True only for instances where the computers action beats the user's action in the game.
     */
    @Test
    public void testIsComputerWin() {
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.ROCK, RPSLSpock.SCISSORS));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.ROCK, RPSLSpock.LIZARD));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.PAPER, RPSLSpock.ROCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.PAPER, RPSLSpock.SPOCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SCISSORS, RPSLSpock.PAPER));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SCISSORS, RPSLSpock.LIZARD));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.LIZARD, RPSLSpock.PAPER));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.LIZARD, RPSLSpock.SPOCK));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SPOCK, RPSLSpock.SCISSORS));
        Assert.assertTrue(RPSLSpock.isComputerWin(RPSLSpock.SPOCK, RPSLSpock.ROCK));
        Assert.assertFalse(RPSLSpock.isComputerWin(RPSLSpock.ROCK, RPSLSpock.ROCK));
    }
}