package ma.fst.localisationsmartphone;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;
    private RequestQueue requestQueue;

    private String baseUrl = "http://10.0.2.2/localisation/createPosition.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tvInfo);
        requestQueue = Volley.newRequestQueue(this);

        LocationManager locationManager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1
            );
            return;
        }

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000,
                0,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        double altitude = location.getAltitude();
                        float precision = location.getAccuracy();

                        String msg = "Latitude : " + latitude
                                + "\nLongitude : " + longitude
                                + "\nAltitude : " + altitude
                                + "\nPrécision : " + precision + " m";

                        tvInfo.setText(msg);

                        envoyerPosition(latitude, longitude);
                    }
                }
        );
    }

    private void envoyerPosition(double latitude, double longitude) {

        try {
            String date = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss",
                    Locale.getDefault()
            ).format(new Date());

            String imei = "123456";

            String url = baseUrl
                    + "?latitude=" + URLEncoder.encode(String.valueOf(latitude), "UTF-8")
                    + "&longitude=" + URLEncoder.encode(String.valueOf(longitude), "UTF-8")
                    + "&date_position=" + URLEncoder.encode(date, "UTF-8")
                    + "&imei=" + URLEncoder.encode(imei, "UTF-8");

            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url,
                    response -> Toast.makeText(this, response, Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(this, "Erreur : " + error.toString(), Toast.LENGTH_LONG).show()
            );

            requestQueue.add(request);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}