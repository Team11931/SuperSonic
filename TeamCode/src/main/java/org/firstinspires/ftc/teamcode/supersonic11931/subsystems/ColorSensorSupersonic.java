package org.firstinspires.ftc.teamcode.supersonic11931.subsystems;

import android.graphics.Color;
import android.view.View;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import java.util.Locale;


public class ColorSensorSupersonic {

    /**
     * Note that the REV Robotics Color-Distance incorporates two sensors into one device.
     * It has a light/distance (range) sensor.  It also has an RGB color sensor.
     * The light/distance sensor saturates at around 2" (5cm).  This means that targets that are 2"
     * or closer will display the same value for distance/light detected.
     *
     * Although you configure a single REV Robotics Color-Distance sensor in your configuration file,
     * you can treat the sensor as two separate sensors that share the same name in your op mode.
     *
     * In this example, we represent the detected color by a hue, saturation, and value color
     * model (see https://en.wikipedia.org/wiki/HSL_and_HSV).  We change the background
     * color of the screen to match the detected color.
     *
     * In this example, we  also use the distance sensor to display the distance
     * to the target object.  Note that the distance sensor saturates at around 2" (5 cm).
     *
     */
    public ColorSensor sensorColor;
    public DistanceSensor sensorDistance;

    private float hsvValues[] = {0F, 0F, 0F}; // hsvValues is an array that will hold the hue, saturation, and value information.
    private final double SCALE_FACTOR = 255; // sometimes it helps to multiply the raw RGB values with a scale factor to amplify/attentuate the measured values.

    //constructor
    public ColorSensorSupersonic(ColorSensor c, DistanceSensor d) {

        // get a reference to the color sensor.
        sensorColor = c;

        // get a reference to the distance sensor that shares the same name.
        sensorDistance = d;

    }


    public void trackColors()
    {
        // convert the RGB values to HSV values.
        // multiply by the SCALE_FACTOR, then cast it back to int (SCALE_FACTOR is a double)
        Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                (int) (sensorColor.green() * SCALE_FACTOR),
                (int) (sensorColor.blue() * SCALE_FACTOR),
                hsvValues);

        // send the info back to driver station using telemetry function.
        //opMode.telemetry.addData("RGB", sensorColor.red() + ", " + sensorColor.green() + ", " + sensorColor.blue());
        //opMode.telemetry.addData("Distance (cm)", String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
        //opMode.telemetry.addData("Alpha", sensorColor.alpha());
        //opMode.telemetry.addData("Hue", hsvValues[0]);

    }


    public void shutDown(){

    }



}
