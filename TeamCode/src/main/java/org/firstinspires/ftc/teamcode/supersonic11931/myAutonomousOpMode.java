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
@Autonomous(name="Supersonic Autonomous Mode", group ="Supersonic")
// @Disabled
public class myAutonomousOpMode extends LinearOpMode {

    private SupersonicRuckusRobot myRobot;
    private ElapsedTime runtime = new ElapsedTime(); // timer
    private final int AUTONOMOUS_DURATION = 30;
    public enum STATE {
        LANDING,
        DRIVING_TO_DEPOT,
        CLAIMING,
        SAMPLING,
        DRIVING_TO_CRATER,
        PARKING,
        COMPLETE
    }

    @Override public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Ruckus Robot starting...");
        telemetry.update();

        myRobot = new SupersonicRuckusRobot(this.hardwareMap); // instantiate robot object
        telemetry.addData("Status", "Ruckus Robot successfully INITIALIZED; waiting for start");
        telemetry.update();

        STATE state = STATE.LANDING; // set initial state (landing)
        this.waitForStart(); // Wait for driver to press PLAY from driver station
        runtime.reset(); // start the timer
        telemetry.addData("Status", "Ruckus Robot RUNNING in Autonomous Mode");
        telemetry.update();

        while (runtime.time() < AUTONOMOUS_DURATION && state != STATE.COMPLETE) {

            //This is a basic outline of programming objectives, pseudo code

            //When play is pressed, run motor to lower robot to ground

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

            // Use State Machine
            switch (state) {
                case LANDING:
                    myRobot.land.lowerFromLander();
                    if (this.myRobot.isLanded) {state = STATE.DRIVING_TO_DEPOT;}
                    break;

                case DRIVING_TO_DEPOT:
                    myRobot.nav.trackTargets();
                    // ...
                    break;

                case CLAIMING:
                    // ...
                    break;

                case SAMPLING:
                    // ...
                    break;

                case DRIVING_TO_CRATER:
                    // ...
                    break;

                case PARKING:
                    // ...
                    break;

                default:
                    // ...

                    state = STATE.COMPLETE;
                    break;
            }


        }

        myRobot.shutDown();
        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }


}
