package com.meterial.demo.LottieAnim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.lottie_activity_main);

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.content_1, ListFragment.newInstance())
          .commit();
    }
  }
}
