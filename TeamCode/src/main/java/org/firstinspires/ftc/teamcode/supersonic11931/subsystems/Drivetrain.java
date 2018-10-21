package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


/**
 * This is NOT an opmode.
 * THIS IS THE DRIVETRAIN CLASS FOR TEAM SUPERSONIC'S ROBOT
 * This class defines all the logic for the drivetrain.
 *
 * MECANUM drive
 *
 **/
public class Drivetrain {

    private DcMotor frontLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor rearLeftMotor = null;
    private DcMotor rearRightMotor = null;
    private double frontLeftPower;
    private double frontRightPower;
    private double rearLeftPower;
    private double rearRightPower;
    private final float SLOW_MOTION = 0.4f;


    /*
    // Cruise control variables *** IN PROGRESS ***
    private final double TARGET_DISTANCE =  400.0;  // Hold robot's center 400 mm from target in Cruise Control mode
    private static final double ON_AXIS = 10;           // Within 1.0 cm of target center-line
    private static final double CLOSE_ENOUGH = 20;      // Within 2.0 cm of final target standoff
    public  static final double YAW_GAIN = 0.018;       // Rate at which we respond to heading error
    public  static final double LATERAL_GAIN = 0.0027;  // Rate at which we respond to off-axis error
    public  static final double AXIAL_GAIN = 0.0017;    // Rate at which we respond to target distance errors
    private double robotBearing = 0;                    // Robot's rotation around the Z axis (CCW is positive)
    private double targetRange = 0;                     // Range from robot's center to target in mm
    private double targetBearing = 0;                   // Heading of the target , relative to the robot's unrotated center
    private double relativeBearing = 0;                 // Heading to the target from the robot's current bearing.
    private double robotX = 0;                          // X displacement from target center
    private double robotY = 0;                          // Y displacement from target center
    private double driveAxial = 0 ;                     // Positive is forward
    private double driveLateral = 0 ;                   // Positive is right
    private double driveYaw = 0 ;                       // Positive is CCW
    */


    // Constructor method
    public Drivetrain(DcMotor lfm, DcMotor rfm, DcMotor lrm, DcMotor rrm) {

        frontLeftMotor = lfm;
        frontRightMotor = rfm;
        rearLeftMotor = lrm;
        rearRightMotor = rrm;

    }


    /*
    public void driveManual(float d, float s, float t){

        // Mecanum drive is controlled with three axes: drive (front-and-back),
        // strafe (left-and-right), and twist (rotating the whole chassis).
        double drive  = d;
        double strafe = s;
        double twist  = t;

        //frontLeftPower = Range.clip(drive + strafe + twist, -1.0, 1.0) ;
        frontLeftPower = Range.clip(drive - strafe + twist, -1.0, 1.0);
        frontRightPower = Range.clip(drive - strafe - twist, -1.0, 1.0);
        //rearLeftPower = Range.clip(drive - strafe + twist, -1.0, 1.0) ;
        rearLeftPower = Range.clip(drive + strafe + twist, -1.0, 1.0);
        rearRightPower = Range.clip(drive + strafe - twist, -1.0, 1.0);

        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        rearLeftMotor.setPower(rearLeftPower);
        rearRightMotor.setPower(rearRightPower);

    }
    */


    public void driveManual(float d, float s, float t, boolean slow)
    {
        // Mecanum drive is controlled with three axes: drive (front-and-back),
        // strafe (left-and-right), and twist (rotating the whole chassis).
        double velocity = Math.hypot(-s, d);
        double course = Math.atan2(d, -s) - Math.PI / 4;
        double rotation = t;

        if (slow)
        {
            velocity *= SLOW_MOTION;
        }

        frontLeftPower = -(velocity * Math.cos(course) + rotation);
        frontRightPower = velocity * Math.sin(course) - rotation;
        rearLeftPower = -(velocity * Math.sin(course) + rotation);
        rearRightPower = velocity * Math.cos(course) - rotation;

        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        rearLeftMotor.setPower(rearLeftPower);
        rearRightMotor.setPower(rearRightPower);
    }


    public void driveManual(float d, float s, float t)
    {
        this.driveManual(d, s, t, false);
    }


    /***
     * use target position to determine the best way to approach it.
     * Set the Axial, Lateral and Yaw axis motion values to get us there.
     *
     * @return true if we are close to target
     */
    /*
    public boolean driveCruiseControl() {

        // Cruise control code *** IN PROGRESS ***
        boolean closeEnough = false;

        // Priority #1 Rotate to always be pointing at the target (for best target retention).
        double Y  = (relativeBearing * YAW_GAIN);

        // Priority #2  Drive laterally based on distance from X axis (same as y value)
        double L  =(robotY * LATERAL_GAIN);

        // Priority #3 Drive forward based on the desiredHeading target standoff distance
        double A  = (-(robotX + TARGET_DISTANCE) * AXIAL_GAIN);

        // Send the desired axis motions to the robot hardware.
        setYaw(Y);
        setAxial(A);
        setLateral(L);

        // Determine if we are close enough to the target for action.
        closeEnough = ( (Math.abs(robotX + TARGET_DISTANCE) < CLOSE_ENOUGH) &&
                (Math.abs(robotY) < ON_AXIS));

        return (closeEnough);
    }
    */

    /*
    // Cruise control code *** IN PROGRESS ***
    public void setAxial(double axial)      {driveAxial = Range.clip(axial, -1, 1);}
    public void setLateral(double lateral)  {driveLateral = Range.clip(lateral, -1, 1); }
    public void setYaw(double yaw)          {driveYaw = Range.clip(yaw, -1, 1); }
    */

    public void shutDown(){

        frontLeftPower = 0;
        frontRightPower = 0;
        rearLeftPower = 0;
        rearRightPower = 0;

        frontLeftMotor.setPower(frontLeftPower);
        rearLeftMotor.setPower(frontRightPower);
        frontRightMotor.setPower(rearLeftPower);
        rearRightMotor.setPower(rearRightPower);
    }



}
