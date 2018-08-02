public interface iAngleCalculating {
    /** Method to Method for calculating angle between hours hand and minutes hand on regular analog clock.
     * @param hours hours part of time passed.
     * @param minutes minutes part of time passed.
     * @return result of calculating angle between hours hand and minutes hand.
     * If the ancle greater then 180 it will be counted as 360 - current value.
     * If the ancle negative it will take module of current value.
     *
     */
    public double calculating(int hours, int minutes);
}
