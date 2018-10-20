package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class LifterSupersonic {

    public ClawSupersonic claw = null;
    private DcMotor armDrive = null;



    // Constructor method
    public LifterSupersonic(DcMotor a, Servo c){

        armDrive = a;
        claw = new ClawSupersonic(c);

    }


    // For TeleOp mode
    public void runArm(boolean button1, boolean button2)
    {
        // TODO: lift code

    }


    public void lowerFromLander()
    {
        // TODO: lift & claw code

    }

    public void shutDown()
    {
        // Stop lift
        armDrive.setPower(0);
    }


}
