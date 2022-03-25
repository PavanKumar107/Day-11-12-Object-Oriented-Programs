package deckofcards;

public class Deckofcards {
	private String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int n = suits.length * ranks.length;
	String[] deckInitialize() {
		String[] deck = new String[this.n];
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = ranks[i] + " of " + suits[j];
			}
		}
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		return deck;
	}
	int[] nineCardsIndex() {
		int[] cardIndex = { 52, 52, 52, 52, 52, 52, 52, 52, 52 }; /// Initialize array with numbers
		int i = 0;
		int min = 0;
		int max = 51;
		while (i < 9) {
			int condition = 0;
			int randomIndex = (int) Math.floor(Math.random() * (max - min) + min);
			for (int j = 0; j < cardIndex.length; j++) {
				if (randomIndex == cardIndex[j]) {
					condition = 1;
					break;
				}
			}
			if (condition == 0) {
				cardIndex[i] = randomIndex;
				i += 1;
			}
		}
		return cardIndex;
	}
	void distribution() {
		String[] deck = deckInitialize();
		int[] cardIndex = nineCardsIndex();
		for(int i=1; i < 5; i++) {
			System.out.println("Player " + i + " Cards :");
			for(int j=i-1; j < cardIndex.length; j=j+4) {
				System.out.printf("%s \t", deck[j]);
				System.out.printf("|| %s    ", deck[j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Deckofcards cards = new Deckofcards();
		cards.distribution();
	}
}