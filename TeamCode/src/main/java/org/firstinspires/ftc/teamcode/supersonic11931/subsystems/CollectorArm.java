package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class CollectorArm {

    public DcMotor armDrive1 = null;
    public DcMotor armDrive2 = null;
    private DcMotor elbowDrive = null;
    public Servo holdArmDrive = null;
    //public Sweeper sweeper;

    // Constructor method
    public CollectorArm(DcMotor a1, DcMotor a2, DcMotor b/*,  Servo c*/){

        armDrive1 = a1;
        armDrive2 = a2;
        elbowDrive = b;
        // holdArmDrive = c;
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

    public void runHold(boolean a, boolean b)
    {
        if(a) {
            holdArmDrive.setPosition(20);
        }

        else if(b)
        {
            holdArmDrive.setPosition(-20);
        }
    }

    public void shutDown()
    {
        // Stop land
        armDrive1.setPower(0);
        armDrive2.setPower(0);
        elbowDrive.setPower(0);

    }

    //public int getEncoderPosition(boolean x) {
    //   return armDrive1.getCurrentPosition();
    //}

    public void setEncoderTarget(int position) {
        armDrive1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armDrive1.setTargetPosition(position);
        armDrive2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armDrive2.setTargetPosition(-position);
    }
}