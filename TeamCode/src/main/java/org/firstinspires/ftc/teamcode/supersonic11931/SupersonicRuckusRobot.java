package org.firstinspires.ftc.teamcode.supersonic11931;



import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.CollectorArm;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.LanderArm;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.Navigation;
import org.firstinspires.ftc.teamcode.supersonic11931.subsystems.Sweeper;
import com.qualcomm.hardware.bosch.BNO055IMU;

import com.qualcomm.robotcore.hardware.DistanceSensor;

/**
 * This is NOT an opmode.
 * THIS IS THE MAIN ROBOT CLASS FOR TEAM SUPERSONIC
 * This class defines all the specific hardware for our Rover Ruckus bot.
 *
 **/
public class SupersonicRuckusRobot {

    public boolean isLanded = false;

    public Navigation nav;
    public Drivetrain drive;
    public LanderArm land;
    public ColorDistanceSensor color;
    public CollectorArm collect;


    // Constructor method
    SupersonicRuckusRobot(HardwareMap hw) {

        // Initialize robot components
        // Init Nav (navigation target tracker)
        nav = new Navigation(hw.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hw.appContext.getPackageName()));

        // Init color / distance sensor
        color = new ColorDistanceSensor(hw.get(com.qualcomm.robotcore.hardware.ColorSensor.class, "sensor_color_distance"), hw.get(DistanceSensor.class, "sensor_color_distance"));

        // Init drivetrain
        drive = new Drivetrain(
                hw.get(DcMotor.class, "leftFront"),
                hw.get(DcMotor.class, "rightFront"),
                hw.get(DcMotor.class, "leftRear"),
                hw.get(DcMotor.class, "rightRear"),
                hw.get(BNO055IMU.class, "imu")
        );

        // Init lander
        land = new LanderArm(hw.get(DcMotor.class, "lander_arm_drive"));

        // Init collector
        // collect = new CollectorArm(hw.get(DcMotor.class, "collector_arm_drive"), hw.get(DcMotor.class, "sweeper_drive"));
    }


    public void shutDown(){

        // Shut down all robot components
       drive.shutDown();
        nav.shutDown();
        color.shutDown();
        land.shutDown();
        //collect.shutDown();

    }


}
