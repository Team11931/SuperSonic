package org.firstinspires.ftc.teamcode.supersonic11931;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * This IS an opmode.
 * THIS IS THE MAIN CLASS FOR TEAM SUPERSONIC'S AUTONOMOUS MODE
 *
 **/
@Autonomous(name="Supersonic Autonomous (Depot Side)", group ="Supersonic")
// @Disabled
public class myAutonomousOpModeDepotSide extends LinearOpMode {

    private SupersonicRuckusRobot myRobot;
    private ElapsedTime runtime = new ElapsedTime(); // timer
    private final int AUTONOMOUS_DURATION = 30;

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Ruckus Robot starting...");
        telemetry.update();

        myRobot = new SupersonicRuckusRobot(this.hardwareMap); // instantiate robot object
        telemetry.addData("Status", "Ruckus Robot successfully INITIALIZED; waiting for start");
        telemetry.update();

        // this.waitForStart(); // Wait for driver to press PLAY from driver station
        while(!opModeIsActive() && !isStopRequested())
        {
            telemetry.addData("Status", "Waiting for start command");
        }
        runtime.reset(); // start the timer
        telemetry.addData("Status", "Ruckus Robot RUNNING in Autonomous Mode");
        telemetry.update();


        //When play is pressed, lower robot to ground
        boolean doLander = true;
        if (doLander) {
            myRobot.collect.runArm(0.5f);
            sleep(300);
            myRobot.collect.runArm(0.0f);

            myRobot.collect.holdArmDrive.setPosition(20);
            sleep(1000);

            myRobot.collect.runArm(-1.0f);
            sleep(500);
            myRobot.collect.runArm(0.0f);

            myRobot.collect.holdArmDrive.setPosition(0.625);
            sleep(1000);
        }
        //Turn
        myRobot.drive.driveManual(0.0f, 0.0f, -0.1f);
        sleep(715);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        sleep(500);

        //Drive forward
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f);
        sleep(900);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        sleep(500);

        //Turn
        myRobot.drive.driveManual(0.0f, 0.0f, -0.125f);
        sleep(850);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        sleep(500);

        //Drive forward
        myRobot.drive.driveManual(-0.25f, 0.0f, 0.0f);
        sleep(750);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        // When crater is reached, stop the robot
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        myRobot.shutDown();

        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }
}
