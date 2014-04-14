package com.androidhuman.example.mapsv2example;

import android.location.Location;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.model.*;

import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.LocationListener;


public class MainActivity extends Activity implements OnMyLocationChangeListener {
	LocationManager locationManager;
	String locationProvider;
	Location location;
	GoogleMap map;
	int latitude, longitude;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		// Some buildings have indoor maps. Center the camera over
		// the building, and a floor picker will automatically appear.
		map.setMyLocationEnabled(true);// 현재 위치 탐색 버튼 생성
		LatLng loc = new LatLng(37.57778,126.979187);
		CameraPosition cp = new CameraPosition.Builder().target((loc)).zoom(7).build();
		map.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
		map.setOnMyLocationChangeListener(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onMyLocationChange(Location Current_location) {
		// TODO Auto-generated method stub
		LatLng temp = new LatLng(Current_location.getLatitude(),
				Current_location.getLongitude());

		CameraPosition cp = new CameraPosition.Builder().target((temp)).zoom(18).build();
		map.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
	}

}
