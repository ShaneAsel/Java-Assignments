package blackjack;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Random;

public class Blackjack {

    // Start of Card class and declare variables
    public static class Card {
    
    public final int suit;
    public final int number;
    public final String type;
    public final int points;
    
    //Card constructor. Since aces can equal either 1 or 11 they will be handled by getScore
    public Card(int s, int n) {
    this.suit = s;
    this.number = n;
        switch (this.number) {
        case 1:
        this.type = "ace";
        this.points = 11;
        break;
        case 11:
        this.type = "jack";
        this.points = 10;
        break;
        case 12:
        this.type = "queen";
        this.points = 10;
        break;
        case 13:
        this.type = "king";
        this.points = 10;
        break;
        default:
        this.type = Integer.toString(number);
        this.points = number;
        break;
        }
    }
    }

    // Define player class and declare variables
    public static class Player {
  
    public String name;
    public int cash = 200;
    public int bet = 0;
    public boolean stay = false;
    public boolean bust = false;
    public boolean bankrupt = false;
    public ArrayList<Card> hand = new ArrayList<>();
    
    // How the score is returned
    public int getScore() {
        int score = 0;
	int aces = 0;
	
        // This loop counts the number of aces in one's hand
	for (Card card : this.hand) {
            score += card.points;
	if (card.type.equals("ace")) aces++;
	}
	// Subtract 10 pts from the player's score for each ace in their hand while their score is above 21
	while (aces > 0) {
	if (score <= 21) break;
	else {
            score -= 10;
            aces--;
	}
	}
	return score;
		}
    
    // Logic to return the cards in a players hand
    public String getHand() {
    String handList = "";
    for (Card card : this.hand) {
        if (!this.hand.get(this.hand.size() - 1).equals(card)) handList += card.type + ", ";
        else handList += card.type;
    }
    return handList;
    }
    }

	// Method to actually deal a card to a player.
	public static void deal(Player player, ArrayList<Card> deck) {
		Random generator = new Random();
		boolean goodCard = false;
                // Random generator generates a suit & number. Provided that the generated combination the card will be dealt to the player.
                // If the card has been used then a new one is generated.
		while (!goodCard) {
			int ranNum = generator.nextInt(13) + 1;
			int ranSuit = generator.nextInt(4) + 1;
			for (Card card : deck) {
				if (card.suit ==  ranSuit && card.number == ranNum) {
					goodCard = true;
					Card ranCard = new Card(ranSuit,ranNum);
					player.hand.add(ranCard);
					deck.remove(ranCard);
				}
			}
		}
	}
	
	public static ArrayList<Card> setDeck() {
		ArrayList<Card> deck = new ArrayList<>();
		for (int s = 1; s < 5; s++) {
			for (int n = 1; n < 14; n++) deck.add(new Blackjack.Card(s,n));
		}
		return deck;
	}

        // Assigning players logic
	public static ArrayList<Player> setPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		String playerNum = null;
		Object[] playerSelector = {"1","2","3","4"};
		do {
			playerNum = (String) JOptionPane.showInputDialog(
				null,
				"How many players will be testing their luck at the table? (1-4)",
				"Asel Casino - Blackjack",
				JOptionPane.QUESTION_MESSAGE,
				null,
				playerSelector,
				null
			);
			if (playerNum == null) Blackjack.quitConfirm();
		}
                // Screen/logic to prompt player for name
		while (playerNum == null || (playerNum != null && (!playerNum.matches("[1-4]"))));
		int intPlayers = Integer.parseInt(playerNum);
		for (int i = 0; i < intPlayers; i++) {
			players.add(new Player());
			players.get(i).name = JOptionPane.showInputDialog(
				null,
				"Player " + (i+1) + ", enter your name:",
				"Asel Casino - Blackjack",
				JOptionPane.QUESTION_MESSAGE
			);
		}
		return players;
	}

        // If user choses to quit
	public static int quitConfirm() {
		int quitConfirm = JOptionPane.showConfirmDialog(
			null,
			"Are you sure you're ready to cash out?",
			"Asel Casino - Blackjack",
			JOptionPane.YES_NO_OPTION
		);
		if (quitConfirm == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(
				null,
				"Better luck next time!",
				"Asel Casino - Blackjack",
				JOptionPane.INFORMATION_MESSAGE
			);
			System.exit(0);
			return quitConfirm;
		}
		else return quitConfirm;
	}

	public static void playRound(ArrayList<Player> players, ArrayList<Card> deck) {
		// Following the rules of blackjack, two cards are dealt to each player at the start of the game.
                // The user is also prompted to place their bet(s).
		for (Player curPlayer : players) {
                    if (!curPlayer.bankrupt) {
                	Blackjack.deal(curPlayer,deck);
			Blackjack.deal(curPlayer,deck);
			int bet = 0;
			boolean validBet = false;
			do {
    			String betStr = JOptionPane.showInputDialog(
			null, curPlayer.name + ", you have $" + curPlayer.cash + ".\n" + "Enter a positive amount of money for your bet (e.g. $100):", "Asel Casino - Blackjack",
			JOptionPane.QUESTION_MESSAGE);
                    try {
			bet = Integer.parseInt(betStr);
                        if (bet > curPlayer.cash) {
			JOptionPane.showMessageDialog(null,"You tried to bet $" + bet + " but you only have $" + curPlayer.cash + ".", "Asel Casino - Blackjack",
			JOptionPane.ERROR_MESSAGE);
			}
                    else {	
                        curPlayer.bet = bet;
                        validBet = true;
                    }      
                        }
                    catch (NumberFormatException e) {
                    if (betStr == null) Blackjack.quitConfirm();
                    else{
                    JOptionPane.showMessageDialog(
                    null, "Please enter a valid bet!", "Asel Casino - Blackjack",
                    JOptionPane.ERROR_MESSAGE);
                    // Is there a better way to format the next three lines? It looks cluttered to me but they all have a purpose
                    }
                    }
                    }
                    while (!validBet);
                    }

		}

		// While the players haven't quit and this part of the game hasn't concluded
		boolean roundEnd = false;
		while (!roundEnd) {
			int endPlayers = 0;
			// Check each player thru the loop
			for (int i = 0; i < players.size(); i++) {
                            Player curPlayer = players.get(i);
                            // As long as the current player hasn't busted or stayed and isn't bankrupt then alert them it's their turn
                            if (!curPlayer.bust && !curPlayer.stay && !curPlayer.bankrupt) {
                            JOptionPane.showMessageDialog(null, curPlayer.name + ", it's your turn!", "Asel Casino - Blackjack",
                            JOptionPane.INFORMATION_MESSAGE);
                            Object[] options = {"Hit","Stay"};
                            int decision = -1;
                            int quitConfirm = JOptionPane.NO_OPTION;
                            do {
                                decision = JOptionPane.showOptionDialog(null,
				"Your current hand is: " + curPlayer.getHand() + ".\n" +
				"Your score is " + curPlayer.getScore(),"Asel Casino - Blackjack",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);
                                    switch (decision) {
					case 0:
                                            Blackjack.deal(curPlayer,deck);
                                            break;
					case 1:
                                            curPlayer.stay = true;
                                            break;
                                            default:
                                     quitConfirm = Blackjack.quitConfirm();
                                    }
                            }
                            while (quitConfirm == JOptionPane.NO_OPTION && decision == -1);
                                if (curPlayer.getScore() > 21) {
                                    curPlayer.bust = true;
                                    JOptionPane.showMessageDialog(null,"You busted! Your final score is " + curPlayer.getScore() + ".","Bust!",
                                    JOptionPane.ERROR_MESSAGE);
				}
				}
                            else endPlayers++;
			}
			if (endPlayers == players.size()) roundEnd = true;
		}
	}

        // Calculate cash in each player's bank
	public static void setCash(ArrayList<Player> players, Player dealer) {
		for (Player curPlayer : players) {
			if (!curPlayer.bankrupt) {
				if (curPlayer.getScore() <= 21 && curPlayer.hand.size() >= 5) curPlayer.cash += curPlayer.bet;
				else if (curPlayer.getScore() > 21 || (curPlayer.getScore() <= dealer.getScore() && dealer.getScore() <= 21)) curPlayer.cash -= curPlayer.bet;
				else if (curPlayer.getScore() == 21 && curPlayer.hand.size() == 2) curPlayer.cash += 2 * curPlayer.bet;
				else curPlayer.cash += curPlayer.bet;

				if (curPlayer.cash == 0) {
					curPlayer.bankrupt = true;
					JOptionPane.showMessageDialog(null,curPlayer.name + ", you lost all of your money! Thank you for playing with us.",
						"Asel Casino - Blackjack",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public static void reset(ArrayList<Player> players, ArrayList<Card> deck) {
		for (Player player : players) {
			player.hand = new ArrayList<>();
			player.bust = false;
			player.stay = false;
			player.bet = 0;
		}
		deck = Blackjack.setDeck();
	}
        
        // Display the final scores
	public static void displayScores(ArrayList<Player> players) {
		int[] finalScores = new int[players.size()];
		String scores = "<html>--- Final Scores ---<br /><table>";
		for (int i = 0; i < players.size(); i++) {
			finalScores[i] = players.get(i).getScore();
			scores += "<tr><td>" + players.get(i).name + ":</td><td>$" + players.get(i).cash + "</td></tr>";
		}
		scores += "</table></html>";
		JLabel display = new JLabel(scores);
		JOptionPane.showMessageDialog(null,display,"Asel Casino - Blackjack",
			JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {	
		ArrayList<Player> players = Blackjack.setPlayers();
		// Genrate list of players
		ArrayList<Card> deck = Blackjack.setDeck();
		// Generate the deck
                int repeat = JOptionPane.YES_OPTION;
		while (repeat == JOptionPane.YES_OPTION) {
			// Generate dealer 
			Player dealer = new Player();
			dealer.name = "Dealer";
			Blackjack.deal(dealer,deck);
			Blackjack.deal(dealer,deck);
			while (dealer.getScore() < 17) Blackjack.deal(dealer,deck);

			
			Blackjack.playRound(players,deck);
                        // Start a round
			
			String roundScores = "<html>|--- Round Scores ---|<table><tr><td>Dealer:</td><td>" + dealer.getScore() + "</td></tr>";
			// Display scores
                        int bankruptPlayers = 0;
			for (Player curPlayer : players) roundScores += "<tr><td>" + curPlayer.name + ":</td><td>" + curPlayer.getScore() + "</td></tr>";
			roundScores += "</table></html>";
			JLabel roundDisplay = new JLabel(roundScores);
			JOptionPane.showMessageDialog(null,roundDisplay, "Asel Casino - Blackjack",
                        JOptionPane.INFORMATION_MESSAGE);
                        
			Blackjack.setCash(players, dealer);
			for (Player curPlayer : players) if (curPlayer.bankrupt) bankruptPlayers++;
			if (bankruptPlayers < players.size()) {
				repeat = JOptionPane.showConfirmDialog(null,"Would you like to try your luck at another round?", "Asel Casino - Blackjack",
				JOptionPane.YES_NO_OPTION);
			}
			else repeat = JOptionPane.NO_OPTION;
			if (repeat == JOptionPane.NO_OPTION) {
				break;
			}
			else {
				Blackjack.reset(players,deck);
			}
		}
		Blackjack.displayScores(players);
	}
}
