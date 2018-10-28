package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;


public class LanderArm {

    //public LanderClaw claw = null;
    private DcMotor spinnyBoy = null;



    // Constructor method
    public LanderArm(DcMotor a){

        spinnyBoy = a;
        //claw = new LanderClaw(c);


    }


    // For TeleOp mode
    public void runArm(float button1)
    {


    }


    public void lowerFromLander()
    {
        // TODO: lander & claw code... to automatically lower robot from lander

    }


    public void raiseToLander()
    {
        // TODO: land & claw code... to automatically raise robot up onto lander
        // NOTE: NEED CODE TO ENSURE IT STOPS MOTOR BEFORE POSSIBLE DAMAGE TO ROBOT!!!

    }


    public void shutDown()
    {
        // Stop land
        spinnyBoy.setPower(0);
    }


}
