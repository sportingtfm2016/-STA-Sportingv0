package com.sporting.cristianpr.sportingv0;

import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class MyLocationListener implements LocationListener {
    MapsActivity MapsActivity;

    public MapsActivity getMainActivity() {
        return MapsActivity;
    }

    public void setMainActivity(MapsActivity mainActivity) {
        this.MapsActivity = mainActivity;
    }

    @Override
    public void onLocationChanged(Location loc) {
        // Este mŽtodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
        // debido a la detecci—n de un cambio de ubicacion
        loc.getLatitude();
        loc.getLongitude();

        LatLng current =  new LatLng(loc.getLatitude(), loc.getLongitude());
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(current, 16);
        this.MapsActivity.mMap.animateCamera(update);
        this.MapsActivity.mMap.addPolyline((new PolylineOptions())
                .add(this.MapsActivity.prev, current).width(6).color(Color.BLUE)
                .visible(true));
        this.MapsActivity.prev=current;
        current = null;

        //String Text = "Mi ubicaciin actual es: " + "\n Lat = "
        //        + loc.getLatitude() + "\n Long = " + loc.getLongitude();
        //this.MapsActivity.setLocation(Text);
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Este mŽtodo se ejecuta cada vez que se detecta un cambio en el
        // status del proveedor de localizaci—n (GPS)
        // Los diferentes Status son:
        // OUT_OF_SERVICE -> Si el proveedor esta fuera de servicio
        // TEMPORARILY_UNAVAILABLE -> Temp˜ralmente no disponible pero se
        // espera que este disponible en breve
        // AVAILABLE -> Disponible
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}