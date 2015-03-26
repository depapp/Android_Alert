package com.example.prak_alert;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void _addDialog(View view) {
		AlertDialog.Builder alertdialog = new AlertDialog.Builder(
				MainActivity.this);
		alertdialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		alertdialog.setTitle("Pilih Warna?");
		alertdialog
				.setMessage("Jika anda ingin keluar aplikasi maka tutup dialog ini");
		alertdialog.setPositiveButton("YA", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Berhasil di tutup",
						Toast.LENGTH_LONG).show();
				dialog.dismiss();
			}
		});
		alertdialog.setNegativeButton("TIDAK", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		AlertDialog dialog = alertdialog.create();
		dialog.show();
	}

	public void _addListDialog(View view) {
		AlertDialog.Builder alertdialog = new AlertDialog.Builder(
				MainActivity.this);
		alertdialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		alertdialog.setTitle("Pilih Warna?");
		final String arr[] = { "merah", "biru", "kuning" };
		alertdialog.setItems(arr, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Anda memilih " + arr[which],
						Toast.LENGTH_LONG).show();
				dialog.dismiss();
			}
		});
		AlertDialog dialog = alertdialog.create();
		dialog.show();
	}

	public void _addMultiChoiceItems(View view) {
		AlertDialog.Builder alertdialog = new AlertDialog.Builder(
				MainActivity.this);
		alertdialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		alertdialog.setTitle("Pilih Warna?");
		final String arr[] = { "merah", "biru", "kuning" };
		final StringBuffer buffer = new StringBuffer();
		alertdialog.setMultiChoiceItems(arr, null,
				new OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						if (isChecked) {
							buffer.append(arr[which]);
							buffer.append(",");
						}
					}
				});
		alertdialog.setPositiveButton("OK", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this,
						"Anda memilih " + buffer.toString(), Toast.LENGTH_LONG)
						.show();
			}
		});
		AlertDialog dialog = alertdialog.create();
		dialog.show();
	}

	public void _addCustomLayout(View view) {
		AlertDialog.Builder alertdialog = new AlertDialog.Builder(
				MainActivity.this);
		alertdialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		LayoutInflater inflater = getLayoutInflater();
		View v = inflater.inflate(R.layout.dialog_custom, null);
		alertdialog.setView(v);
		final EditText username = (EditText) v.findViewById(R.id.username);
		final EditText password = (EditText) v.findViewById(R.id.password);

		alertdialog.setPositiveButton("OK", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (username.getText().toString().equals("admin")
						&& password.getText().toString().equals("1234")) {
					Toast.makeText(MainActivity.this, "Anda Berhasil Login",
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(MainActivity.this, "Anda Gagal Login ",
							Toast.LENGTH_LONG).show();
				}

			}
		});
		alertdialog.setNegativeButton("CANCEL", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Anda Tidak Login ",
						Toast.LENGTH_LONG).show();
			}
		});
		AlertDialog dialog = alertdialog.create();
		dialog.show();
	}
}