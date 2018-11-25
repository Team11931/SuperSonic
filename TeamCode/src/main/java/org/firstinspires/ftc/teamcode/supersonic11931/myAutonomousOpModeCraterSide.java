package org.firstinspires.ftc.teamcode.supersonic11931;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This IS an opmode.
 * THIS IS THE MAIN CLASS FOR TEAM SUPERSONIC'S AUTONOMOUS MODE
 *
 **/
@Autonomous(name="Supersonic Autonomous (Crater Side)", group ="Supersonic")
// @Disabled
public class myAutonomousOpModeCraterSide extends LinearOpMode {

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
        //myRobot.collect.armDrive1.setPower(-1.0f);
        //myRobot.collect.armDrive2.setPower(1.0f);
        //sleep(1000);
        //myRobot.collect.armDrive1.setPower(0.0f);
        //myRobot.collect.armDrive2.setPower(0.0f);
        boolean doLander = false;
        if (doLander) {
            myRobot.collect.runArm(-1.0f);
            sleep(1000);
            myRobot.collect.runArm(0.0f);
        }



        /*

        // Then, sample


        // Then, drive to crater
        myRobot.drive.driveManual(0.0f, -0.2f, 0.0f);
        sleep(300);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        myRobot.drive.driveManual(0.5f, 0.0f, 0.0f);
        sleep(500);
        myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);

        //Start sensing colors


        //If center mineral is silver
        /*if(myRobot.color.sensorColor.green() >= 18 ){

            //Drive sideways to the left mineral
            myRobot.drive.driveManual(0.5f, 0.4f, 0.0f);
            sleep(200);
            myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);



            //If left mineral is silver/ if the right mineral is gold
            if(myRobot.color.sensorColor.green() >= 18) {

                //drive to far right mineral
                myRobot.drive.driveManual(0.0f, -0.4f, 0.0f);
                sleep(400);

                //drive to crater
                myRobot.drive.driveManual(0.4f,0.0f,0.0f);
                sleep(500);
                myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
            }

            //If left mineral is gold
            else {
                //Drive to crater
                myRobot.drive.driveManual(0.4f,0.0f,0.0f);
                sleep(500);
                myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
            }
        }

        //If center mineral is gold
        if (myRobot.color.sensorColor.green() < 18){
            //drive to crater
            myRobot.drive.driveManual(0.4f,0.0f,0.0f);
            sleep(300);
            myRobot.drive.driveManual(0.0f, 0.0f, 0.0f);
        }
*/
        myRobot.shutDown();
        telemetry.addData("Status", "Ruckus Robot successfully SHUT DOWN");
        telemetry.update();
    }


}