package servlet;

import influxdb.InfluxClient;
import org.influxdb.dto.Point;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = {"/*"}, loadOnStartup = 1)
public class HelloWorldServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        String userAgent = request.getHeader("User-Agent");

        try {
            Integer rating = Integer.parseInt(request.getParameter("rating"));

            if(rating > 10 || rating < 0) throw new NumberFormatException();

            InfluxClient.write(
                Point.measurement("ratings")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("userAgent", userAgent)
                    .addField("rating", rating)
                    .build()
            );

            System.out.println("Got a " + rating + "/10 rating from " + userAgent);

            response.getOutputStream().print("Thank you for your rating!");
        } catch (NumberFormatException e) {
            InfluxClient.write(
                Point.measurement("exceptions")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("userAgent", userAgent)
                    .addField("Exception", e.toString())
                    .addField("Class", e.getStackTrace()[0].getClassName())
                    .addField("Line Number", e.getStackTrace()[0].getLineNumber())
                    .build()
            );

            response.getOutputStream().print("ERROR: Please provide a valid rating!");
        }
    }

}