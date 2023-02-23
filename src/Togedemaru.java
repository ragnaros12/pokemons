import ru.ifmo.se.pokemon.*;

public class Togedemaru extends Pokemon {
    public Togedemaru(String name, int level) {
        super(name, level);
        setStats(65, 98, 63, 40, 73, 96);
        setType(Type.ELECTRIC, Type.STEEL);
        setMove(new Rest(), new DoubleTeam(), new Bite(), new Crunch());
    }
}
class DoubleTeam extends StatusMove {
    public DoubleTeam(){
        super(Type.NORMAL, 0, 1);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ACCURACY, (int)pokemon.getStat(Stat.ACCURACY) + 1);
    }
}

class Bite extends PhysicalMove{
    public Bite(){
        super(Type.DARK, 60, 1);
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(0.3 >= Math.random()){
            Effect.flinch(pokemon);
        }
    }
}

class Crunch extends PhysicalMove{
    public Crunch(){
        super(Type.DARK, 80, 1);
    }
}

class Rest extends StatusMove{
    public Rest(){
        super(Type.PSYCHIC, 0, 1);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.HP, (int) pokemon.getStat(Stat.HP));
        pokemon.setCondition(new Effect().condition(Status.SLEEP).turns(2));
    }
}