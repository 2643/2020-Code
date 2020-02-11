/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Parity;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SerialPort.StopBits;

public class TFMini extends SubsystemBase {
  byte[] setExtTrigger = hexStringToByteArray("4257020000000040");
  byte[] extTrigger = hexStringToByteArray("4257020000000041");
  byte[] setInternalTrigger = hexStringToByteArray("4257020000000140");
  byte[] reset = hexStringToByteArray("4257020000000140");

  SerialPort port = new SerialPort(115200, Port.kOnboard, 8, Parity.kNone, StopBits.kOne);

  /**
   * Creates a new TFMini.
   */
  public TFMini() {
    port.setReadBufferSize(32);
  }

  public int getDistance() {
    Boolean frameOne = false;
    Boolean frameTwo = false;
    List<String> bytes = new ArrayList<String>();
    // Add frame headers now.
    bytes.add("59");
    bytes.add("59");

    String outputFrame = port.readString();
    for (int index = 0; index < 32; index++) {
      if (frameOne && frameTwo) {
        for (int indexTwo = 0; index < 7; index++) {
          bytes.add(charToHexString(outputFrame.charAt(index + indexTwo)));
        }
        break;
      }
      if (frameOne) {
        if (charToHexString(outputFrame.charAt(index)) == "59") {
          frameTwo = true;
        } else {
          frameOne = false;
        }
      }
      if (charToHexString(outputFrame.charAt(index)) == "59") {
        frameOne = true;
      }
    }

    int accumulator = 0;
    for (int index = 0; index < 8; index++){
      accumulator += Integer.parseInt(bytes.get(index), 16);
    }

    int checksum = accumulator & Integer.parseInt("ffffffff", 16);
    if (Integer.toHexString(checksum) == bytes.get(8)){
      String distanceString = bytes.get(4) + bytes.get(5);
      int distance = Integer.parseInt(distanceString, 16);
      return distance;
    }
    else {
      return -1;
    }
  }

  public void setExternalTrigger() {
    port.write(setExtTrigger, 16);
  }

  public void setInternalTrigger() {
    port.write(setInternalTrigger, 16);
  }

  public void reset() {
    port.write(reset, 16);
  }

  public void trigger() {
    port.write(extTrigger, 16);
  }

  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
    }
    return data;
  }

  public String charToHexString(char ch) {
    return String.format("%02x", (int) ch);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
