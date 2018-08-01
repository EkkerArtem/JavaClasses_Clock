import com.google.common.base.Preconditions;

import static java.lang.Math.abs;

public class AngleCalculating implements iAngleCalculating {
    private static final int DEGREES_IN_CIRCLE = 360;
    private static final int DEGREES_IN_HOUR = 30;
    private static final int DEGREES_IN_MINUTE = 6;

    /** Method for calculating angle between hours hand and minutes hand on regular analog clock.
     * @param hours hours part of time passed.
     * @param minutes minutes part of time passed.
     * @return result of calculating angle between hours hand and minutes hand.
     */
    @Override
    public double calculating(int hours, int minutes) {
        double differenceInDegrees;
        checkData(hours,minutes);
        if (hours > 12 && hours < 24){
            hours -= 12;
        }
        float hour = hours;
        float minute = minutes;
        float additionalTimeToHours = (1-(DEGREES_IN_CIRCLE - minute * DEGREES_IN_MINUTE) / DEGREES_IN_CIRCLE) ;
        differenceInDegrees = Math.round(abs(((hour + additionalTimeToHours) * DEGREES_IN_HOUR - minute * DEGREES_IN_MINUTE)));
        return differenceInDegrees <= 180 ? differenceInDegrees : 360 - differenceInDegrees;
    }

    /** Method for checking input data before calculating angle {@link #calculating(int,int)}
     * @param hours
     * @param minutes
     */
    private static void checkData(int hours, int minutes) {
        Preconditions.checkArgument(hours > 0, "Hours cant be negative");
        Preconditions.checkArgument(hours <= 23, "Hours cant be above 23");
        Preconditions.checkArgument(minutes >= 0, "Minutes cant be negative");
        Preconditions.checkArgument(minutes < 60, "Minutes cant be above 60");
    }

}