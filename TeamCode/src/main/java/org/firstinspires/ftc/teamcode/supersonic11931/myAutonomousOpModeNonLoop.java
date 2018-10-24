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


        //When play is pressed, run motor to lower robot to ground
        //Robot.land.lowerFromLander();
        //sleep(3000);

        /*myRobot.drive.driveManual(0.5f, 0.0f, 0.0f);
        sleep(2000);

        myRobot.drive.driveManual(0.0f, 0.4f, 0.4f);
        sleep(1000);

        myRobot.drive.driveManual(0.5f, 0.0f, 0.0f);
        sleep(4000);
        */

        // Robot Drops from lander *Todo

         myRobot.drive.driveManual(0.25f, 0.0f, 0.0f);
        sleep(1500);


        // Start tracking and spinning
        while (!myRobot.nav.isTargetVisible())
        {
            myRobot.nav.trackTargets();
            myRobot.drive.driveManual(0.0f, 0.0f, -0.25f);
        }

        // Stop spinning
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        // Drive forward to move away from lander for 4 seconds
        myRobot.drive.driveManual(0.5f, 0.0f, 0.0f);
        sleep(2000);

        myRobot.drive.driveManual(0.0f,0.0f,0.0f);



/*STEP 1: Determine robot location/basic program
            The camera should start at a 50 degree angle in relation to the front of the robot
            so that when it is rotated it will sense a target in the shortest amount of time
            Begin rotating camera
            Use an if statement to inform the robot of when a target is recognized
            Once recognized, stop rotation
            Read image using vuforia
            Use pre-programmed vuforia code to determine location
            */

            /*STEP 2: Get to depot
            Using location info from previous step, input xyz cordinates into an array
            Use equations to determine appropriate course to depot (ex. x=16, drive=x-4, distance to drive is 12 units)
            Input distance variables and run drive code for robot
            Robot should be appropriate distance depot to place team marker
             */

            /*STEP 3: Place team marker and go to crater
            Run motor to extend land
            Release team marker
            Adding distance variables to origin
             */

            /* STEP 4: Go to crater
            Using equations, you should be able to identify your current location without finding another location target
            Turn robot toward crater
            Drive forward toward crater
             */

        //Identify gold mineral using color sensor
        //Push gold mineral off area

        //Drive partially into crater



        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        myRobot.shutDown();
        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }


}
