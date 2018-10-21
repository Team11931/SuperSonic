package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class LanderArm {

    public LanderClaw claw = null;
    private DcMotor armDrive = null;



    // Constructor method
    public LanderArm(DcMotor a, Servo c){

        armDrive = a;
        claw = new LanderClaw(c);

    }


    // For TeleOp mode
    public void runArm(boolean button1, boolean button2)
    {
        // TODO: land code

    }


    public void lowerFromLander()
    {
        // TODO: land & claw code

    }

    public void shutDown()
    {
        // Stop land
        armDrive.setPower(0);
    }


}
