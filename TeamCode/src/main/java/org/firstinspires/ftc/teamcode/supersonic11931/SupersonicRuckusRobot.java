package org.firstinspires.ftc.teamcode.supersonic11931;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.ArmSupersonic;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.ColorSensorSupersonic;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.DrivetrainSupersonic;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.NavigationSupersonic;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.SweeperSupersonic;

/**
 * This is NOT an opmode.
 * THIS IS THE MAIN ROBOT CLASS FOR TEAM SUPERSONIC
 * This class defines all the specific hardware for our Rover Ruckus bot.
 *
 **/
public class SupersonicRuckusRobot {

    public boolean isLanded = false;

    public NavigationSupersonic nav;
    public DrivetrainSupersonic drive;
    public ArmSupersonic arm;
    public ColorSensorSupersonic color;
    public SweeperSupersonic sweeper;


    // Constructor method
    SupersonicRuckusRobot(HardwareMap hw){

        // Initialize robot components
        // Init Nav (navigation target tracker)
        //nav = new NavigationSupersonic(hw.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hw.appContext.getPackageName()));

        // Init color / distance sensor
        //color = new ColorSensorSupersonic(hw.get(ColorSensor.class, "sensor_color_distance"), hw.get(DistanceSensor.class, "sensor_color_distance"));

        // Init drivetrain
        drive = new DrivetrainSupersonic(
            hw.get(DcMotor.class, "leftFront"),
            hw.get(DcMotor.class, "rightFront"),
            hw.get(DcMotor.class, "leftRear"),
            hw.get(DcMotor.class, "rightRear")
        );

        // Init arm
        //arm = new ArmSupersonic(hw.get(DcMotor.class, "arm_drive"), hw.get(Servo.class, "claw_drive"));

        // Init sweeper
        //sweeper = new SweeperSupersonic(hw.get(DcMotor.class, "sweeper_drive"));

    }


    public void shutDown(){

        // Shut down all robot components
        drive.shutDown();
        //nav.shutDown();
        //color.shutDown();
        //sweeper.shutDown();

    }


}
