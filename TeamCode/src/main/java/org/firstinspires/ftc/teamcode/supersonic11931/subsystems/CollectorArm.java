package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class CollectorArm {

    private DcMotor armDrive1 = null;
    private DcMotor armDrive2 = null;
    private DcMotor elbowDrive = null;
    //public Sweeper sweeper;

    // Constructor method
    public CollectorArm(DcMotor a1, DcMotor a2, DcMotor b){

        armDrive1 = a1;
        armDrive2 = a2;
        elbowDrive = b;

    }


    // For TeleOp mode
    public void runArm(float JoyStick)
    {
        armDrive1.setPower(JoyStick);
        armDrive2.setPower(-JoyStick);
    }


    public void runElbow(float ToggleStick)
    {
        elbowDrive.setPower(ToggleStick/2);
    }

    public void shutDown()
    {
        // Stop land
        armDrive1.setPower(0);
        armDrive2.setPower(0);
        elbowDrive.setPower(0);
    }

}