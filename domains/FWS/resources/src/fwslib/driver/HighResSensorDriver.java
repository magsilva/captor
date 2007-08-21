package fwslib.driver;

import fwslib.SensorReading;

/**
 * @author Kicho
 *
 */
public class HighResSensorDriver {

    public static SensorReading get(int sensorId) {
        return new SensorReading(sensorId, SensorReading.HighRes, WindReader.read());
    }

}