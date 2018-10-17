package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class ArmSupersonic {

    public ClawSupersonic claw = null;
    private DcMotor armDrive = null;



    // Constructor method
    public ArmSupersonic(DcMotor a, Servo c){

        armDrive = a;
        claw = new ClawSupersonic(c);

    }


    // For TeleOp mode
    public void runArm(boolean button1, boolean button2)
    {
        // TODO: arm code

    }


    public void lowerFromLander()
    {
        // TODO: arm & claw code

    }

    public void shutDown()
    {
        // Stop arm
        armDrive.setPower(0);
    }


}
