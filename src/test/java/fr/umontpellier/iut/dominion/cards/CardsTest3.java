package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.IOGame;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.base.*;
import fr.umontpellier.iut.dominion.cards.common.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static fr.umontpellier.iut.dominion.TestUtils.hasCards;
import static org.junit.jupiter.api.Assertions.*;


class CardsTest3 {
    private IOGame game;
    private Player p0, p1, p2;

    @BeforeEach
    void disableConsole() {

        System.setOut(new PrintStream(new OutputStream() {

            @Override
            public void write(int arg0) {

            }
        }));

    }

    @BeforeEach
    void setUp() {
        String[] playerNames = new String[]{"Toto", "Titi", "Tutu"};
        game = new IOGame(playerNames, new String[0]);
        p0 = game.getPlayer(0);
        p1 = game.getPlayer(1);
        p2 = game.getPlayer(2);
    }


    @Test
    void testMoatReactionWitch() {
        p0.getHand().add(new Moat());
        p1.getHand().add(new Witch());
        p2.getHand().add(new Moat());

        game.setInput("y", "n");
        p1.playCard("Witch");
        assertNull(p2.getDiscard().getCard("Curse"));
        assertNotNull(p0.getDiscard().getCard("Curse"));
    }

    @Test
    void testMoatReactionBandit() {
        p0.getHand().add(new Moat());
        p0.getDraw().add(0, new Silver());
        p1.getHand().add(new Bandit());
        p2.getHand().add(new Moat());
        p2.getDraw().add(0, new Silver());

        game.setInput("y", "n");
        p1.playCard("Bandit");
        assertNotNull(p2.getDraw().getCard("Silver"));
        assertNull(p0.getDraw().getCard("Silver"));
        assertNull(p0.getDiscard().getCard("Silver"));
    }

    @Test
    void testMoatReactionMilitia() {
        p0.getHand().clear();
        p2.getHand().clear();

        p0.getHand().add(new Moat());
        p0.getHand().add(new Silver());
        p0.getHand().add(new Gold());
        p0.getHand().add(new Witch());
        p0.getHand().add(new Bandit());

        p1.getHand().add(new Militia());

        p2.getHand().add(new Moat());
        p2.getHand().add(new Silver());
        p2.getHand().add(new Gold());
        p2.getHand().add(new Smithy());
        p2.getHand().add(new Mine());


        game.setInput("y", "n", "Silver", "Gold");
        p1.playCard("Militia");
        assertEquals(5, p2.getHand().size());
        assertEquals(3, p0.getHand().size());
    }

    @Test
    void testMoatReactionBureaucrat() {
        p0.getHand().clear();
        p0.getHand().add(new Estate());
        p0.getHand().add(new Duchy());
        p0.getHand().add(new Moat());

        p1.getHand().add(new Bureaucrat());

        p2.getHand().clear();
        p2.getHand().add(new Moat());
        p2.getHand().add(new Gold());
        p2.getHand().add(new Copper());
        p2.getHand().add(new Curse());

        game.setInput("n", "y");
        p1.playCard("Bureaucrat");

        assertNotNull(p0.getHand().getCard("Estate"));   // p0 a Estate en main
        assertNotNull(p0.getHand().getCard("Duchy"));       // p0 a Duchy en main
        assertNotEquals("Duchy", p0.getDraw().get(0).getName());    // le Duchy n'est pas sur la pioche de p0
        assertNotNull(p1.getDraw().getCard("Silver"));   // p1 a un Silver sur la pioche
        assertEquals(4, p2.getHand().size());            // p0 a toujours les mêmes cartes en main
    }

    @Test
    void testThroneRoom() {
        p1.getHand().add(new ThroneRoom());
        p1.getHand().add(new Village());

        Card c1 = p1.getDraw().get(0);
        Card c2 = p1.getDraw().get(1);

        game.setInput("Village");
        p1.playCard("Throne Room");

        assertEquals(4, p1.getNumberOfActions());
        assertTrue(p1.getHand().contains(c1));
        assertTrue(p1.getHand().contains(c2));
        assertEquals(7, p1.getHand().size());
    }

    @Test
    void testThroneRoomCanPass() {
        p1.getHand().add(new ThroneRoom());
        p1.getHand().add(new Village());

        Card c1 = p1.getDraw().get(0);
        Card c2 = p1.getDraw().get(1);

        game.setInput("");
        p1.playCard("Throne Room");

        assertEquals(0, p1.getNumberOfActions());
        assertFalse(p1.getHand().contains(c1));
        assertFalse(p1.getHand().contains(c2));
        assertEquals(6, p1.getHand().size());
    }

    @Test
    void testLibrary() {
        p1.getDraw().clear();
        p1.getHand().clear();
        p1.getHand().add(new Library());
        p1.getHand().add(new Duchy());
        p1.getHand().add(new Duchy());
        p1.getHand().add(new Duchy());
        p1.getHand().add(new Duchy());
        p1.getDraw().add(new Gold());
        p1.getDraw().add(new Village());
        p1.getDraw().add(new Festival());
        p1.getDraw().add(new Silver());
        p1.getDraw().add(new Silver());

        game.setInput("y", "n");    // le joueur défausse le Village et prend le Festival
        p1.playCard("Library");

        assertTrue(
                hasCards(p1.getHand(), "Duchy", "Duchy", "Duchy", "Duchy", "Festival", "Gold", "Silver"));
        assertTrue(hasCards(p1.getDiscard(), "Village"));
    }


    @Test
    void testBandit() {
        p1.getHand().add(new Bandit());
        Card silver1 = new Silver();
        Card silver2 = new Silver();
        Card gold = new Gold();
        Card copper = new Copper();
        p2.getDraw().add(0, silver1);
        p2.getDraw().add(0, copper);
        p0.getDraw().add(0, gold);
        p0.getDraw().add(0, silver2);

        game.setInput("Copper", "Silver");

        p1.playCard("Bandit");

        assertNotNull(p1.getDiscard().getCard("Gold")); // p1 a gagné un Gold
        assertFalse(p2.getDraw().contains(silver1));    // p2 a perdu le Silver (automatiquement)
        assertFalse(p2.getDiscard().contains(silver1));
        assertTrue(p2.getDiscard().contains(copper));   // p2 a défaussé le Copper
        assertFalse(p0.getDraw().contains(silver2));    // p0 a perdu le Silver (choix de l'utilisateur)
        assertFalse(p0.getDiscard().contains(silver2));
        assertTrue(p0.getDiscard().contains(gold));     // p0 a défaussé le Gold
    }

    @Test
    void testBanditOnlyOneAndNone() {
        p1.getHand().add(new Bandit());
        Card gold = new Gold();
        p2.getDraw().clear();
        p0.getDraw().clear();
        p2.getDiscard().clear();
        p0.getDiscard().clear();
        p0.getDraw().add(0, gold);

        game.setInput();

        p1.playCard("Bandit");

        assertNotNull(p1.getDiscard().getCard("Gold"));
        assertFalse(p0.getDiscard().contains(gold));
        assertEquals(0,p0.getDiscard().size());
        assertEquals(0,p2.getDiscard().size());
        assertEquals(0,p2.getDraw().size());
    }

    @Test
    void testHarbinger() {
        p1.getHand().add(new Harbinger());
        Card gold = new Gold();
        p1.getDiscard().add(gold);
        p1.getDiscard().add(new Copper());
        p1.getDiscard().add(new Copper());
        p1.getDiscard().add(new Copper());
        Card c0 = p1.getDraw().get(0);

        game.setInput("Silver", "Gold");

        p1.playCard("Harbinger");

        assertTrue(p1.getHand().contains(c0));
        assertEquals(1, p1.getNumberOfActions());
        assertEquals(gold, p1.getDraw().get(0));
        assertFalse(p1.getDiscard().contains(gold));
    }

    @Test
    void testMerchant() {
        p1.getHand().add(new Merchant());
        p1.getHand().add(new Silver());
        p1.getHand().add(new Silver());

        p1.playCard("Merchant");

        assertEquals(0, p1.getMoney());
        assertEquals(8, p1.getHand().size());
        assertEquals(1, p1.getNumberOfActions());
        p1.playCard("Silver");
        assertEquals(3, p1.getMoney());
        p1.playCard("Silver");
        assertEquals(5, p1.getMoney());
    }

    @Test
    void testMerchant2foisDansLeTour() {
        p1.getHand().add(new Merchant());
        p1.getHand().add(new Merchant());
        p1.getHand().add(new Silver());
        p1.getHand().add(new Silver());
        p1.getHand().add(new Silver());

        p1.playCard("Merchant");
        p1.playCard("Merchant");

        assertEquals(0, p1.getMoney());
        p1.playCard("Silver");
        assertEquals(4, p1.getMoney());
        p1.playCard("Silver");
        assertEquals(6, p1.getMoney());
    }

    @Test
    void testSentryTrash1Discard1() {
        p1.getHand().add(new Sentry());
        Card silver = new Silver();
        Card gold = new Gold();
        Card duchy = new Duchy();
        p1.getDraw().add(0, duchy);
        p1.getDraw().add(0, silver);
        p1.getDraw().add(0, gold);

        game.setInput("Duchy", "", "Silver"); // écarte Duchy, passe, défausse Silver

        p1.playCard("Sentry");

        assertEquals(1, p1.getNumberOfActions());
        assertTrue(p1.getHand().contains(gold));
        assertFalse(p1.getAllCards().contains(duchy));
        assertFalse(p1.getDraw().contains(silver));
        assertTrue(p1.getDiscard().contains(silver));
    }

    @Test
    void testSentryPassTwice() {
        p1.getHand().add(new Sentry());
        Card silver = new Silver();
        Card gold = new Gold();
        Card duchy = new Duchy();
        p1.getDraw().add(0, duchy);
        p1.getDraw().add(0, silver);
        p1.getDraw().add(0, gold);

        game.setInput("", "", "", "Silver"); // passe, passe, replace Silver puis Duchy (Duchy au dessus)

        p1.playCard("Sentry");

        assertEquals(1, p1.getNumberOfActions());
        assertTrue(p1.getHand().contains(gold));
        assertFalse(p1.getDiscard().contains(duchy));
        assertFalse(p1.getDiscard().contains(silver));
        assertEquals(duchy, p1.getDraw().get(0));
        assertEquals(silver, p1.getDraw().get(1));
    }
}
