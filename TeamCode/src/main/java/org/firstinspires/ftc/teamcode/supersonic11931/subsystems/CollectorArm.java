package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class CollectorArm {

    private DcMotor armDrive = null;
    public Sweeper sweeper;

    // Constructor method
    public CollectorArm(DcMotor a, DcMotor s){

        armDrive = a;

        // Init sweeper
        sweeper = new Sweeper(s);


    }


    // For TeleOp mode
    public void runArm(boolean button1, boolean button2)
    {
        // TODO: land code


    }


    public void shutDown()
    {
        // Stop land
        armDrive.setPower(0);
    }

}
