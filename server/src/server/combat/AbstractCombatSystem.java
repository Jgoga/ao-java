package server.combat;

import com.artemis.E;
import server.core.Server;
import server.database.model.modifiers.Modifiers;
import shared.interfaces.CharClass;

import java.util.Optional;

import static com.artemis.E.E;

public abstract class AbstractCombatSystem implements CombatSystem {

    private final Server server;

    public AbstractCombatSystem(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    @Override
    public int shieldEvasionPower(int userId) {
        E e = E(userId);
        float shieldModifier = Modifiers.SHIELD.of(CharClass.get(e));
        return (int) (100 * shieldModifier / 2);
    }

    @Override
    public int evasionPower(int userId) {
        E e = E(userId);
        float temp = 100 + 100 / 33 * e.getAgility().getValue() * Modifiers.EVASION.of(CharClass.get(e));
        return (int) (temp + 2.5f * Math.max(e.getLevel().level - 12, 0));
    }

    @Override
    public int weaponAttackPower(int userId) {
        E e = E(userId);
        int power = (int) (100 + 3 * e.getAgility().getValue() * Modifiers.WEAPON.of(CharClass.get(e)));
        return power;
    }

    @Override
    public int projectileAttackPower(int userId) {
        return 0;
    }

    @Override
    public int wrestlingAttackPower(int userId) {
        return 0;
    }

    @Override
    public void userAttack(int userId, Optional<Integer> targetId) {
        Optional<Integer> realTargetId = targetId.isPresent() ? targetId : getTarget(userId);
        if (canAttack(userId, realTargetId)) {
            hit(userId, realTargetId.get());
        } else {
            failed(userId, realTargetId);
        }
    }

    protected abstract void failed(int entityId, Optional<Integer> targetId);

    @Override
    public void hit(int userId, int entityId) {
        int damage = damageCalculation(userId, entityId);
        doHit(userId, entityId, damage);
    }

    @Override
    public abstract boolean canAttack(int userId, Optional<Integer> targetId);

    @Override
    public abstract int damageCalculation(int userId, int entityId);

    abstract Optional<Integer> getTarget(int userId);

    abstract void doHit(int userId, int entityId, int damage);

    abstract boolean isAttackable(int entityId);

}
