package ru.yunost;

public class BonusService {
    final static int BONUS= 5000;

    public long calculate (long amount, boolean registered) {

        long bonus;

        if(registered) {
            bonus = (int) (0.10 * amount);
        } else {
            bonus = (int) (0.04 * amount);
        }

        if(bonus > BONUS) {
            bonus = BONUS;
        }
        return bonus;
    }
}
