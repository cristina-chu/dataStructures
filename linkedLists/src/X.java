public class X {
	private char letter;

	public X() {
		this('a');
	}

	public X(char letter) {
		this.letter = letter;
	}

	public char getChar() {
		return letter;
	}

	public boolean equals(Object o) {
		return letter == ((X)o).getChar();
	}

	public String toString() {
		return letter + "";
	}
}