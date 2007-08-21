package fwslib.driver;

import fwslib.SensorReading;

/**
 * @author Kicho
 *
 */
public class LowResSensorDriver {

    public static SensorReading get(int sensorId) {
        return new SensorReading(sensorId, SensorReading.LowRes, WindReader.read());
    }

}
