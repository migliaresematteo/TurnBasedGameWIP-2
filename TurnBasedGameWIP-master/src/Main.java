import java.util.Scanner;
public class Main {
    public static AllyCharacter Himeko = new AllyCharacter("Himeko", 40, 100,"Erudition",0.27,5);
    public static AllyCharacter Yanqing = new AllyCharacter("Yanqing", 35, 100, "The Hunt", 0.35,5);
    public static EnemyCharacter Enemy_1 = new EnemyCharacter("Enemy_1", 16, 250, 0.23);
    public static EnemyCharacter Enemy_2 = new EnemyCharacter("Enemy_2", 17, 250, 0.24);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventsHandler eventsHandler = new EventsHandler();
        //main process
        while((Himeko.getCharacterHP() > 0) || (Yanqing.getCharacterHP() > 0)) {
            eventsHandler.turnListener(scanner);
            eventsHandler.ally_turn(Enemy_1, Enemy_2);
            System.out.printf("%s's HP: %3f\n%s's HP: %3f\n%s's HP: %3f\n%s's HP: %3f\n", Himeko.getCharacterName(), Himeko.getCharacterHP(),Yanqing.getCharacterName(),Yanqing.getCharacterHP(), Enemy_1.getCharacterName(), Enemy_1.getCharacterHP(), Enemy_2.getCharacterName(), Enemy_2.getCharacterHP());
            eventsHandler.enemy_turn(Enemy_1, Enemy_2);
            System.out.printf("%s's HP: %3f\n%s's HP: %3f\n%s's HP: %3f\n%s's HP: %3f\n", Himeko.getCharacterName(), Himeko.getCharacterHP(),Yanqing.getCharacterName(),Yanqing.getCharacterHP(), Enemy_1.getCharacterName(), Enemy_1.getCharacterHP(), Enemy_2.getCharacterName(), Enemy_2.getCharacterHP());
        }
    }
}