package fi.msp.exercisedialogmenusnotifications;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Options-menu listeners
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_video:
                Toast.makeText(getBaseContext(), "Video", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_music:
                //Toast.makeText(getBaseContext(), "Music", Toast.LENGTH_SHORT).show();
                SecretDialogFragment secretDialogFragment = new SecretDialogFragment();
                secretDialogFragment.show(getFragmentManager(), "Jee");

                return true;
            case R.id.action_quit:
                // Create secret button
                Button secretButton = new Button(this);
                secretButton.setText("You no touch button!");
                secretButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "You touch button!", Toast.LENGTH_SHORT).show();
                    }
                });

                // Create LinearLayout
                LinearLayout ll = (LinearLayout)findViewById(R.id.buttonLayout);
                LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                ll.addView(secretButton, lp);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void secretButtonClicked(View view) {
        String secretString = "You touch the button!";

        // toast message to screen
        Toast.makeText(getApplicationContext(), secretString,
                Toast.LENGTH_SHORT).show();
    }
}