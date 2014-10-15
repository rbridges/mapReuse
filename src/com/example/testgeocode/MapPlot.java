package com.example.testgeocode;

import java.util.List;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.testgeocode.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;




public class MapPlot extends FragmentActivity
        implements GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener{

    GoogleMap mapView;
    com.google.android.gms.maps.Projection projection;
    SupportMapFragment smf;
    double lat,lng;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.map_page);
//	        FragmentTransaction mTransaction = getSupportFragmentManager()
//	                .beginTransaction();
//	        SupportMapFragment mFRaFragment = new SupportMapFragment();
//	        mTransaction.add(R.id.map, mFRaFragment);
//	        mTransaction.commit();
	        
	        try {
	            MapsInitializer.initialize(this);
	        } catch (Exception e) {//GooglePlayServicesNotAvailableException
	            e.printStackTrace();
	        }
	        
	       //Log.d("savedInstanceState", savedInstanceState.toString());
	       // lat = savedInstanceState.getDouble("latitude");
	       // lng = savedInstanceState.getDouble("longitude");
	       Bundle bund;
	       bund = this.getIntent().getExtras();
	       lat = bund.getDouble("latitude");
	       lng = bund.getDouble("longitude");
	       
	       

	}
	public void onStart()
	{
		super.onStart();
		FragmentManager fm = getSupportFragmentManager();
		int i = 0;
		List<Fragment> fragments = fm.getFragments();
		for(Fragment f:fragments) {
			System.out.println(f.getId());
		}
		SupportMapFragment mid = (SupportMapFragment) fm.findFragmentById(R.id.map);
		mapView = mid.getMap(); 
        mapView.moveCamera(CameraUpdateFactory.newCameraPosition(
                new CameraPosition.Builder().target(new LatLng(lat, lng))
             .zoom(15.5f)
             .bearing(0)
             .tilt(25)
             .build()
     ));
		
	}
	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	} 
	
	

}