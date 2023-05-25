public class EnemyCharacter extends Enemies {
    private final String characterName;
    private final int characterLevel;
    private float characterHP;
    private final double multiplier;

    public EnemyCharacter(String characterName, int characterLevel, float characterHP, double multiplier) {
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.characterHP = characterHP;
        this.multiplier = multiplier;
    }
    public void getDamage(AllyCharacter ally) {
        int AllyLevel = ally.getCharacterLevel();
        double randomMultiplier = (Math.random() * 10);
        this.characterHP -= ally.getMultiplier() * AllyLevel + randomMultiplier;
    }
    public void getAbilityDamage(AllyCharacter ally) {
        int AllyLevel = ally.getCharacterLevel();
        double randomMultiplier = (Math.random() * 15);
        this.characterHP -= ally.getMultiplier() * AllyLevel + 2.5 + randomMultiplier;
    }
    public void dealDamage(AllyCharacter ally) {
        ally.getDamage(this);
    }
    public String getCharacterName() { return this.characterName; }
    public int getCharacterLevel() { return this.characterLevel; }
    public float getCharacterHP() { return this.characterHP; }
    public double getMultiplier() { return this.multiplier; }
}