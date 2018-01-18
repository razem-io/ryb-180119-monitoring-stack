package influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

public class InfluxClient {
    private static InfluxDB influxDB = InfluxDBFactory.connect("http://127.0.0.1:8086", "java", "java");

    static {
        influxDB.setDatabase("ryb_java");
        influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);
    }

    public static void write(Point point) {
        influxDB.write("ryb_java", "seven_days", point);
    }

    public static void close() {
        influxDB.close();
    }
}
