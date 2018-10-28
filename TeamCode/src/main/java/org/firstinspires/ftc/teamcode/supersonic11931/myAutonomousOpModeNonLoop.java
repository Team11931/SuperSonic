package org.firstinspires.ftc.teamcode.supersonic11931;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.InterruptedException;


/**
 * This IS an opmode.
 * THIS IS THE MAIN CLASS FOR TEAM SUPERSONIC'S AUTONOMOUS MODE
 *
 **/
@Autonomous(name="Supersonic Autonomous Mode (Non-Loop)", group ="Supersonic")
// @Disabled
public class myAutonomousOpModeNonLoop extends LinearOpMode {

    private SupersonicRuckusRobot myRobot;
    private ElapsedTime runtime = new ElapsedTime(); // timer
    private final int AUTONOMOUS_DURATION = 30;

    @Override public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Ruckus Robot starting...");
        telemetry.update();

        myRobot = new SupersonicRuckusRobot(this.hardwareMap); // instantiate robot object
        telemetry.addData("Status", "Ruckus Robot successfully INITIALIZED; waiting for start");
        telemetry.update();

        this.waitForStart(); // Wait for driver to press PLAY from driver station
        runtime.reset(); // start the timer
        telemetry.addData("Status", "Ruckus Robot RUNNING in Autonomous Mode");
        telemetry.update();


        //When play is pressed, lower robot to ground
        //Robot.land.lowerFromLander();
        //sleep(3000);


         /*
        // Code to Start tracking navigation targets  (start spinning to find one)
        // Navigation target used as starting point for moving around in autonomous mode
        // TODO: GET THIS VUFORIA CODE WORKING SO ROBOT CAN FIND NAVIGATION TARGET WHEN SPINNING
        while (!myRobot.nav.isTargetVisible())
        {
            myRobot.nav.trackTargets();
            myRobot.drive.driveManual(0.0f, 0.0f, -0.25f);
        }

        // Target found; stop spinning
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        sleep(2000);

        */


        // After robot is on ground, drive to depot
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f);
        sleep(1500);
        //myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        myRobot.drive.driveManual(0.0f, 0.0f, -0.25f);
        sleep(1500);
        //myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        myRobot.drive.driveManual(-0.3f, 0.0f, 0.0f);
        sleep(2000);
        //myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        myRobot.drive.driveManual(0.0f, 0.0f, -0.25f);
        sleep(1500);
        //myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f);
        sleep(2000);
        //myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.25f);
        sleep(1500);
        //myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        myRobot.drive.driveManual(-0.5f, 0.0f, 0.0f);
        sleep(4000);

        // When depot is reached, stop the robot
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);


        // Place team marker in depot
        // TODO: WRITE CODE TO PLACE TEAM MARKER IN DEPOT
        // WAITING FOR COLLECTOR ARM TO BE COMPLETE MECHANICALLY
        sleep(2000);


        // Then, drive to crater
        myRobot.drive.driveManual(0.0f, 0.0f, 0.5f); // turn 180 degrees
        sleep(1000);
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f);
        sleep(3000);

         /*
        // Code to use gyro (imu) to turn robot to a certain angle (degrees)
        // TODO: GET THIS IMU/GYRO CODE WORKING SO ROBOT CAN BE MORE ACCURATE TURNING
        // EVENTUALLY, THIS CAN REPLACE THE FEW LINES IMMEDIATLY ABOVE
        myRobot.drive.refreshGyro();
        while(myRobot.drive.getRawHeading() >= -90) // turn 180 degrees
        //while(myRobot.drive.getHeadingDegrees() >= -180) // turn 180 degrees
        {
            myRobot.drive.driveManual(0.0f, 0.0f, 0.2f);
            //sleep(100);
            myRobot.drive.refreshGyro();

        }
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f); // Stop turning
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f); // drive to crater
        sleep(3000);
        */


        // When crater is reached, stop the robot
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);



        myRobot.shutDown();
        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }


}
