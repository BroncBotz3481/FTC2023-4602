package org.firstinspires.ftc.teamcode.BaseCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.BaseCode.New.Team4602HWMap;

@TeleOp(name = "Team4602TeleOp2023", group = "4602")
public class Team4602TeleOp2023 extends LinearOpMode {
    Team4602HWMap robot = new Team4602HWMap();

    Position position = Position.DOWN;

    @Override
    public void runOpMode()
    {
        robot.Map(hardwareMap);
        telemetry.addData("Say", "TeleOp Starting");
        telemetry.update();
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //robot.Lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_PARTY_PALETTE);
        waitForStart();

        while (opModeIsActive()) {
            boolean speedslow = gamepad1.right_bumper;
            double mag = speedslow ? 1.0 : 1.0;

            boolean speedslow1 = gamepad1.left_bumper;
            double mag1 = speedslow1 ? 0.75 : 1.0;  //makes speed high

            double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;


            if (robot.Touch.isPressed()) {
                telemetry.addData("Touch", robot.Touch.isPressed());
                telemetry.update();
            }

            if(hwMap.ButtonX.GetButtonBurstDown()){
                if (ElevatorMotor==0)
                    ElevatorMotor==1;
                else:
                    ElevatorMotor==0;
            }
            if(hwMap.ButtonY.GetButtonBurstDown()){
                if (ElevatorMotor==0)
                    ElevatorMotor==-1;
                else:
                ElevatorMotor==0;
            }

            // hello
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            telemetry.addData("RightFront", robot.DriveRightFront.getCurrentPosition());
            telemetry.addData("RightBack", robot.DriveRightBack.getCurrentPosition());
            telemetry.addData("LeftFront", robot.DriveLeftFront.getCurrentPosition());
            telemetry.addData("LeftBack", robot.DriveLeftBack.getCurrentPosition());
            telemetry.update();

            robot.DriveLeftFront.setPower(frontLeftPower * mag * mag1*0.5);
            robot.DriveLeftBack.setPower(backLeftPower * mag * mag1*0.5);
            robot.DriveRightFront.setPower(frontRightPower * mag * mag1*0.5);
            robot.DriveRightBack.setPower(backRightPower * mag * mag1*0.5);

        }
    }
}