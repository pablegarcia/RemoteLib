package es.bq.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AppActivity extends Activity {

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}

	/**
	 * Called when the activity is becoming visible to the user.
	 */
	@Override
	public void onStart() {
		super.onStart();

		// Get the login button usind the ID
		Button loginButton = (Button) findViewById(R.id.loginButton);

		// Listening to the login button
		loginButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Log.e("Login", "Login to dropbox");
			}
		});
	}
}
