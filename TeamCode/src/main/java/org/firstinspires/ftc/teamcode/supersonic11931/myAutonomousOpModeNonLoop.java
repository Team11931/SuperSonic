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
        // TODO
        sleep(2000);

        // Then, drive to crater
        myRobot.drive.driveManual(0.0f, 0.0f, 0.5f); // turn 180 degrees
        sleep(1500);
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f);
        sleep(5000);

        // When crater is reached, stop the robot
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);







        // Start tracking and spinning
        /*while (!myRobot.nav.isTargetVisible())
        {
            myRobot.nav.trackTargets();
            myRobot.drive.driveManual(0.0f, 0.0f, -0.25f);
        }

        // Stop spinning
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        // Drive forward to move away from lander for 4 seconds
        myRobot.drive.driveManual(-0.5f, 0.0f, 0.0f);
        sleep(2000);

        //Stop driving
        myRobot.drive.driveManual(0.0f,0.0f,0.0f);

        myRobot.drive.driveManual(0.0f, 0.0f, -0.25f);
        sleep(1500);

        myRobot.drive.driveManual(-0.5f, 0.0f, 0.0f);
        sleep(2500);



        //Spin
        //myRobot.drive.driveManual(0.0f, 0.0f, -0.3f);

*/

        myRobot.shutDown();
        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }


}
