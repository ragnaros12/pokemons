import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Mudbray extends Pokemon {
    public Mudbray(String name, int level){
        super(name, level);
        setStats(70, 100, 70, 45, 55, 45);
        setType(Type.GROUND);
        setMove(new RockSlide());
    }
}

class RockSlide extends PhysicalMove{
    public RockSlide(){
        super(Type.ROCK, 75, 0.9);
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(0.3 >= Math.random()){
            Effect.flinch(pokemon);
        }
    }
}
