package com.meterial.demo.commonActivity.TextSpan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.meterial.demo.R;

/**
 *
 * @author zenghao
 * @since 2017/4/25 下午2:32
 */
public class TestTextSpanActivity extends AppCompatActivity {

    // region Member Variables
    private Typeface regularFont;
    private Typeface italicFont;
    private Typeface boldItalicFont;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span);

        italicFont = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Italic.ttf");
        regularFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        boldItalicFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-BoldItalic.ttf");

        setUpTextView1();
        setUpTextView2();
        setUpTextView3();
        setUpTextView4();
        setUpTextView5();
        setUpTextView6();
        setUpTextView7();
        setUpTextView8();
        setUpTextView9();
        setUpTextView10();
        setUpTextView11();
        setUpTextView12();
        setUpTextView13();

    }


    private void setUpTextView1(){
        // Setup single span
        TextView tv1 = (TextView) findViewById(R.id.tv1);

        CharSequence formattedText1 = Trestle.getFormattedText(
                new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                        .foregroundColor(ContextCompat.getColor(this, R.color.purple_100)) // Pass resolved color instead of resource id
                        .backgroundColor(ContextCompat.getColor(this, R.color.green_500)) // Pass resolved color instead of resource id
                        .typeface(italicFont)
                        .build());

        tv1.setText(formattedText1);
    }

    private void setUpTextView2(){
        // Setup multiple spans
        TextView tv2 = (TextView) findViewById(R.id.tv2);

        List<Span> spans1 = new ArrayList<>();
        spans1.add(new Span.Builder("ForegroundSpan")
                .foregroundColor(ContextCompat.getColor(this, R.color.red_500)) // Pass resolved color instead of resource id
                .build());
        spans1.add(new Span.Builder("BackgroundSpan")
                .backgroundColor(ContextCompat.getColor(this, R.color.yellow_500)) // Pass resolved color instead of resource id
                .build());
        spans1.add(new Span.Builder("ForegroundSpan and BackgroundSpan")
                .foregroundColor(ContextCompat.getColor(this, R.color.brown_500)) // Pass resolved color instead of resource id
                .backgroundColor(ContextCompat.getColor(this, R.color.blue_300)) // Pass resolved color instead of resource id
                .build());
        spans1.add(new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                .foregroundColor(ContextCompat.getColor(this, R.color.green_700)) // Pass resolved color instead of resource id
                .backgroundColor(ContextCompat.getColor(this, R.color.indigo_200)) // Pass resolved color instead of resource id
                .typeface(regularFont)
                .build());

        CharSequence formattedText2 = Trestle.getFormattedText(spans1);

        tv2.setText(formattedText2);
    }

    private void setUpTextView3(){
        // Setup single span
        TextView tv3 = (TextView) findViewById(R.id.tv3);

        CharSequence formattedText3 = Trestle.getFormattedText(
                new Span.Builder("RelativeSizeSpan")
                        .relativeSize(2.0f)
                        .build());

        tv3.setText(formattedText3);
    }

    private void setUpTextView4(){
        // Setup single span
        TextView tv4 = (TextView) findViewById(R.id.tv4);

        CharSequence formattedText4 = Trestle.getFormattedText(
                new Span.Builder("AbsoluteSizeSpan")
                        .absoluteSize(20)
                        .build());

        tv4.setText(formattedText4);
    }

    private void setUpTextView5(){
        // Setup single span
        TextView tv5 = (TextView) findViewById(R.id.tv5);

        CharSequence formattedText5 = Trestle.getFormattedText(
                new Span.Builder("URLSpan")
                        .isUrl(true)
                        .build());

        tv5.setText(formattedText5);
    }

    private void setUpTextView6(){
        // Setup single span
        TextView tv6 = (TextView) findViewById(R.id.tv6);

        CharSequence formattedText6 = Trestle.getFormattedText(
                new Span.Builder("UnderlineSpan")
                        .isUnderline(true)
                        .build());

        tv6.setText(formattedText6);
    }

    private void setUpTextView7(){
        // Setup single span
        TextView tv7 = (TextView) findViewById(R.id.tv7);

        CharSequence formattedText7 = Trestle.getFormattedText(
                new Span.Builder("StrikethroughSpan")
                        .isStrikethru(true)
                        .build());

        tv7.setText(formattedText7);
    }

    private void setUpTextView8(){
        // Setup single span
        TextView tv8 = (TextView) findViewById(R.id.tv8);

        CharSequence formattedText8 = Trestle.getFormattedText(
                new Span.Builder("QuoteSpan")
                        .quoteColor(ContextCompat.getColor(this, R.color.green_500)) // Pass resolved color instead of resource id
                        .build());

        tv8.setText(formattedText8);
    }

    private void setUpTextView9(){
        // Setup single span
        TextView tv9 = (TextView) findViewById(R.id.tv9);

        List<Span> spans2 = new ArrayList<>();
        spans2.add(new Span.Builder("No Span ")
                .build());
        spans2.add(new Span.Builder("SubscriptSpan ")
                .subscript(true)
                .build());
        spans2.add(new Span.Builder("No Span ")
                .build());
        spans2.add(new Span.Builder("SuperscriptSpan ")
                .superscript(true)
                .build());

        CharSequence formattedText9 = Trestle.getFormattedText(spans2);
        tv9.setText(formattedText9);
    }

    private void setUpTextView10(){
        // Setup single span
        TextView tv10 = (TextView) findViewById(R.id.tv10);

        CharSequence formattedText10 = Trestle.getFormattedText(
                new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan (case sensitive)")
                        .regex(new Regex("c", Regex.CASE_SENSITIVE))
                        .foregroundColor(ContextCompat.getColor(this, R.color.green_500)) // Pass resolved color instead of resource id
                        .backgroundColor(ContextCompat.getColor(this, R.color.red_200)) // Pass resolved color instead of resource id
                        .typeface(boldItalicFont)
                        .build());

        tv10.setText(formattedText10);
    }

    private void setUpTextView11(){
        // Setup single span
        TextView tv11 = (TextView) findViewById(R.id.tv11);

        CharSequence formattedText11 = Trestle.getFormattedText(
                new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan (case insensitive)")
                        .regex(new Regex("(", Regex.CASE_INSENSITIVE))
                        .foregroundColor(ContextCompat.getColor(this, R.color.green_500)) // Pass resolved color instead of resource id
                        .backgroundColor(ContextCompat.getColor(this, R.color.red_200)) // Pass resolved color instead of resource id
                        .typeface(boldItalicFont)
                        .build());

        tv11.setText(formattedText11);
    }

    private void setUpTextView12(){
        // Setup single span
        TextView tv12 = (TextView) findViewById(R.id.tv12);

        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "You clicked on the ClickableSpan", Toast.LENGTH_SHORT).show();
            }

        };

        CharSequence formattedText12 = Trestle.getFormattedText(
                new Span.Builder("ClickableSpan")
                        .clickableSpan(clickableSpan)
                        .build());

        tv12.setMovementMethod(LinkMovementMethod.getInstance());
        tv12.setText(formattedText12);
    }

    private void setUpTextView13(){
        // Setup single span
        TextView tv13 = (TextView) findViewById(R.id.tv13);

        CharSequence formattedText13 = Trestle.getFormattedText(
                new Span.Builder("ScaleX")
                        .scaleX(2.5f)
                        .build());

        tv13.setText(formattedText13);
    }
    // endregion
}
