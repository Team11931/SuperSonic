package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;


public class LanderArm {

    //public LanderClaw claw = null;
    public DcMotor spinnyBoy = null;



    // Constructor method
    public LanderArm(DcMotor a){

        spinnyBoy = a;
        //claw = new LanderClaw(c);



    }


    // For TeleOp mode
    public void runArm(float joyStick)
    {
        spinnyBoy.setPower(joyStick);

    }



    public void lowerFromLander()
    {
        spinnyBoy.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spinnyBoy.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spinnyBoy.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        spinnyBoy.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //spinnyBoy.setTargetPosition();
        spinnyBoy.setPower(0.25f);

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
