package org.firstinspires.ftc.teamcode.supersonic11931;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;


/**
 * This IS an opmode.
 * THIS IS THE MAIN CLASS FOR TEAM SUPERSONIC'S TELEOP MODE
 *
 **/
@TeleOp(name = "Supersonic TeleOp Mode", group ="Supersonic")
// @Disabled
public class myTeleopOpMode extends LinearOpMode {

    private SupersonicRuckusRobot myRobot; // Main robot class

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Ruckus Robot starting...");
        telemetry.update();

        myRobot = new SupersonicRuckusRobot(this.hardwareMap); // instantiate robot object
        while (!myRobot.drive.isGyroCalibrated())
        {
            sleep(1000);
        }
        telemetry.addData("Status", "Ruckus Robot successfully INITIALIZED; waiting for start");
        telemetry.update();

        this.waitForStart(); // Wait for driver to press PLAY from driver station
        telemetry.addData("Status", "Ruckus Robot RUNNING in Teleop Mode");
        telemetry.update();

        // Loop until driver presses STOP from driver station
        while (opModeIsActive()) {

            // Navigation target  ...
            myRobot.nav.trackTargets();
            telemetry.addData("Visible Target", myRobot.nav.getVisibleTarget());

            // Color & distance sensor...
            myRobot.color.trackColors();
            telemetry.addData("RGB", myRobot.color.sensorColor.red() + ", " + myRobot.color.sensorColor.green() + ", " + myRobot.color.sensorColor.blue());
            telemetry.addData("Distance (cm)", String.format(Locale.US, "%.02f", myRobot.color.sensorDistance.getDistance(DistanceUnit.CM)));


            /*
            // Drivetrain... auto drive (CRUISE CONTROL) or manual drive? Regular or arcade mode?
            // In auto drive, the robot will approach any target it can see and then press against it
            // In manual drive the robot responds to the Joystick.
             if (myRobot.nav.isTargetVisible() && gamepad1.left_bumper) {
                myRobot.drive.driveCruiseControl(); // calculate automatic target approach

            } else {
                // Drive the robot using the joysticks
                // NOTE: ARCADE MODE CURRENTLY HARDCODED TO FALSE IN DRIVETRAIN, AS ARCADE MODE METHOD NOT WORKING AS INTENDED
                if (myRobot.drive.arcadeMode)
                {
                    myRobot.drive.driveManualArcade(this.gamepad1.left_stick_y, this.gamepad1.left_stick_x, this.gamepad1.right_stick_x, this.gamepad1.right_bumper);
                }
                else
                {
                    myRobot.drive.driveManual(this.gamepad1.left_stick_y, this.gamepad1.left_stick_x, this.gamepad1.right_stick_x, this.gamepad1.right_bumper);
                }
            }
            */


            myRobot.drive.refreshGyro();
            telemetry.addData("IMU Angle", myRobot.drive.getHeadingDegrees());
            myRobot.drive.driveManual(this.gamepad1.left_stick_y, this.gamepad1.left_stick_x, this.gamepad1.right_stick_x, this.gamepad1.right_bumper);


            // Lander Arm...
            myRobot.land.runArm(this.gamepad2.left_stick_y);

            // LanderClaw...
            //myRobot.land.claw.runClaw(this.gamepad1.dpad_left, this.gamepad1.dpad_right);

            // Collector Arm...
            //myRobot.collect.runArm(this.gamepad1.a, this.gamepad1.b);

            // Sweeper...
            // myRobot.collect.sweeper.runSweeper(this.gamepad1.a, this.gamepad1.b);

            telemetry.update();
        }

        myRobot.shutDown();
        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }


}