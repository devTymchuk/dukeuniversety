package duke.arraylist;

public class MainDukeArray {

	public static void main(String[] args) {
		System.out.println("It's Duke Array, ... ");

		CharacterDemo cd = new CharacterDemo();
		System.out.println("CharacterDemo  digitTest:  ");
		cd.digitTest();

		System.out.println("CharacterDemo  conversionTest");
		cd.conversionTest();

		CaesarCipher cc = new CaesarCipher(7);

		System.out.println("CaesarCipher encryptAnySimbols"
				+ "  Tanya AND RUSLAN key= 7 :  "
				+ cc.encryptAnySimbols("Tanya AND RUSLAN", 7));
		cc.decrypt("errr");

		DiceRolling dice = new DiceRolling();
		dice.simpleSimulate(12);

		// Counting with Arrays
		System.out
				.println("CommonWords cmw = new CommonWords();    cmw.countShakespeare()");
		CommonWords cmw = new CommonWords();
		cmw.countShakespeare(); // шукає слова і рахує у файлі

		// CountWords cw = new CountWords();
		// cw.tester();
	}
}
