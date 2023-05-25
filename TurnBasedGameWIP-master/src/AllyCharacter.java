public class AllyCharacter extends Allies {
    private final String characterName;
    private final int characterLevel;
    private float characterHP;
    private final String path;
    private final double multiplier;
    private int energies;

    public AllyCharacter(String characterName, int characterLevel, float characterHP, String path, double multiplier, int energies) {
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.characterHP = characterHP;
        this.path = path;
        this.multiplier = multiplier;
        this.energies = energies;
    }
    public void getDamage(EnemyCharacter enemy) {
        int EnemyLevel = enemy.getCharacterLevel();
        double randomMultiplier = (Math.random() * 10);
        this.characterHP -= enemy.getMultiplier() * EnemyLevel + randomMultiplier;
    }
    public void dealDamage(EnemyCharacter enemy) {
        enemy.getDamage(this);
        if (this.energies < 5) this.energies++;
    }
    public void dealAbility(EnemyCharacter enemy) {
        if (this.energies > 0) {
            enemy.getAbilityDamage(this);
            this.energies--;
        }
        else System.out.println("No more energies left!");
    }
    public String getCharacterName() { return this.characterName; }
    public int getCharacterLevel() { return this.characterLevel; }
    public float getCharacterHP() { return this.characterHP; }
    public String getPath() { return this.path; }
    public double getMultiplier() { return this.multiplier; }
    public int getEnergies() { return this.energies; }
}