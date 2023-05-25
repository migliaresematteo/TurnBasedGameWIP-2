import java.util.Scanner;
import java.util.Random;
public class EventsHandler {
    public Random random = new Random();
    public int decided = 0;
    public AllyCharacter[] Chars;
    private String action;
    private String selection;
    public AllyCharacter Himeko;
    public AllyCharacter Yanqing;
    public EnemyCharacter Enemy_1;
    public EnemyCharacter Enemy_2;
    public EventsHandler() {
        Himeko = new AllyCharacter(Main.Himeko.getCharacterName(), Main.Himeko.getCharacterLevel(), Main.Himeko.getCharacterHP(), Main.Himeko.getPath(), Main.Himeko.getMultiplier(), Main.Himeko.getEnergies());
        Yanqing = new AllyCharacter(Main.Yanqing.getCharacterName(), Main.Yanqing.getCharacterLevel(), Main.Yanqing.getCharacterHP(), Main.Yanqing.getPath(), Main.Yanqing.getMultiplier(), Main.Yanqing.getEnergies());
        Enemy_1 = new EnemyCharacter(Main.Enemy_1.getCharacterName(), Main.Enemy_1.getCharacterLevel(), Main.Enemy_1.getCharacterHP(),Main.Enemy_1.getMultiplier());
        Enemy_2 = new EnemyCharacter(Main.Enemy_2.getCharacterName(), Main.Enemy_2.getCharacterLevel(), Main.Enemy_2.getCharacterHP(),Main.Enemy_2.getMultiplier());
        Chars = new AllyCharacter[]{Himeko, Yanqing};
    }
    public void turnListener(Scanner scanner) {
        AllyCharacter[] Chars = {Himeko, Yanqing};
        System.out.printf(">> Choose an action to performorm with %s: ",Chars[decided].getCharacterName());
        this.action = scanner.nextLine();
        System.out.printf(">> Choose an enemy to attack with %s: ",Chars[decided].getCharacterName());
        this.selection = scanner.nextLine();
    }
    public void ally_turn(EnemyCharacter Enemy_1, EnemyCharacter Enemy_2) {
        if(action.equals("Normal")) {
            if(selection.equals("Enemy_1")) Chars[decided].dealDamage(Enemy_1);
            else Chars[decided].dealDamage(Enemy_2);
        } else if (action.equals("Ability")) {
            if(selection.equals("Enemy_1")) Chars[decided].dealAbility(Enemy_1);
            else Chars[decided].dealAbility(Enemy_2);
        }
        if (decided == 0) decided = 1;
        else decided = 0;
    }
    public void enemy_turn(EnemyCharacter Enemy_1, EnemyCharacter Enemy_2) {
        EnemyCharacter[] EChars = {Enemy_1, Enemy_2};
        int decided_target = shuffle();
        System.out.printf(">> %s will attack: %s\n", EChars[decided].getCharacterName(), Chars[decided_target].getCharacterName());
        if (decided_target == 0) EChars[decided].dealDamage(Chars[0]);
        else EChars[decided].dealDamage(Chars[1]);
    }
    public int shuffle() { return random.nextInt(2); }
}
