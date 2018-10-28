package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * This is NOT an opmode.
 * THIS IS THE DRIVETRAIN CLASS FOR TEAM SUPERSONIC'S ROBOT
 * This class defines all the logic for the drivetrain.
 *
 * MECANUM drive
 *
 **/
public class Drivetrain {

    public boolean arcadeMode = false;
    private DcMotor frontLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor rearLeftMotor = null;
    private DcMotor rearRightMotor = null;
    private double frontLeftPower;
    private double frontRightPower;
    private double rearLeftPower;
    private double rearRightPower;
    private final float SLOW_MOTION = 0.2f;
    private BNO055IMU imu = null;
    private Orientation angles;
    private Acceleration gravity;
    private double headingOffset = 0.0;


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
    public Drivetrain(DcMotor lfm, DcMotor rfm, DcMotor lrm, DcMotor rrm, BNO055IMU gyro) {

        frontLeftMotor = lfm;
        frontRightMotor = rfm;
        rearLeftMotor = lrm;
        rearRightMotor = rrm;
        imu = gyro;

        initGyro();
    }


    public void driveManual(float d, float s, float t, boolean slow)
    {
        // Mecanum drive is controlled with three axes: drive (front-and-back),
        // strafe (left-and-right), and twist (rotating the whole chassis).
        double speed = Math.hypot(-s, d);
        double direction = Math.atan2(d, -s) - Math.PI / 4;
        double rotation = t;

        if (slow)
        {
            speed *= SLOW_MOTION;
            rotation *= SLOW_MOTION;
        }

        frontLeftPower = -(speed * Math.cos(direction) + rotation);
        frontRightPower = speed * Math.sin(direction) - rotation;
        rearLeftPower = -(speed * Math.sin(direction) + rotation);
        rearRightPower = speed * Math.cos(direction) - rotation;

        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        rearLeftMotor.setPower(rearLeftPower);
        rearRightMotor.setPower(rearRightPower);

    }


    public void driveManual(float d, float s, float t)
    {
        this.driveManual(d, s, t, false);
    }


    public void driveManualArcade(float d, float s, float t, boolean slow)
    {
        double x = Math.pow(s, 3.0);
        double y = Math.pow(d, 3.0);

        double rotation = Math.pow(t, 3.0);
        double direction = Math.atan2(x, y) + (arcadeMode ? getHeading() : 0.0);
        double speed = Math.min(1.0, Math.sqrt(x * x + y * y));

        if (slow)
        {
            speed *= SLOW_MOTION;
            rotation *= SLOW_MOTION;
        }

        frontLeftPower = speed * Math.sin(direction + Math.PI / 4.0) + rotation;
        frontRightPower = speed * Math.cos(direction + Math.PI / 4.0) - rotation;
        rearLeftPower = speed * Math.cos(direction + Math.PI / 4.0) + rotation;
        rearRightPower = speed * Math.sin(direction + Math.PI / 4.0) - rotation;

        final double scale = maxAbs(1.0, frontLeftPower, rearLeftPower, frontRightPower, rearRightPower);

        frontLeftMotor.setPower(frontLeftPower / scale);
        frontRightMotor.setPower(frontRightPower / scale);
        rearLeftMotor.setPower(rearLeftPower / scale);
        rearRightMotor.setPower(rearRightPower / scale);


    }


    /***
     * use target position to determine the best way to approach it.
     * Set the Axial, Lateral and Yaw axis motion values to get us there.
     *
     * @return true if we are close to target
     */
    /*
    public boolean driveCruiseControl() {

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


    // Cruise control code *** IN PROGRESS ***
    public void setAxial(double axial)      {driveAxial = Range.clip(axial, -1, 1);}
    public void setLateral(double lateral)  {driveLateral = Range.clip(lateral, -1, 1); }
    public void setYaw(double yaw)          {driveYaw = Range.clip(yaw, -1, 1); }
    */


    private void initGyro()
    {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu.initialize(parameters);

        runUsingEncoders();
    }


    private void setMotorMode(DcMotor.RunMode mode, DcMotor... motors) {
        for (DcMotor motor : motors) {
            motor.setMode(mode);
        }
    }


    public void runUsingEncoders() {
        setMotorMode(DcMotor.RunMode.RUN_USING_ENCODER, frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }


    public void runWithoutEncoders() {
        setMotorMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER, frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }


    public boolean isGyroCalibrated() {
        return imu.isGyroCalibrated();
    }


    public void refreshGyro() {
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS);
        gravity = imu.getGravity();
    }


    public double getRawHeading() {
    //private double getRawHeading() {
        return angles.firstAngle;
    }


    public double getHeading() {
        return (getRawHeading() - headingOffset) % (2.0 * Math.PI); // @return the robot's current heading in radians
    }


    public double getHeadingDegrees() {
        return Math.toDegrees(getHeading()); // @return the robot's current heading in degrees
    }


    public void resetHeading() {
        headingOffset = getRawHeading(); // Set the current heading to zero.
    }


    private static double maxAbs(double... xs) {
        double ret = Double.MIN_VALUE;
        for (double x : xs) {
            if (Math.abs(x) > ret) {
                ret = Math.abs(x);
            }
        }
        return ret;
    }


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
