package ir.maziardev.simkhan.activity;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.maziardev.simkhan.R;
import ir.maziardev.simkhan.enums.Extras;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_detail_number)
    TextView tv_detail_number;
    @BindView(R.id.tv_detail_agahi)
    TextView tv_detail_agahi;
    @BindView(R.id.tv_detail_operator)
    TextView tv_detail_operator;
    @BindView(R.id.tv_detail_karkard)
    TextView tv_detail_karkard;
    @BindView(R.id.tv_detail_type)
    TextView tv_detail_type;
    @BindView(R.id.tv_detail_price)
    TextView tv_detail_price;
    @BindView(R.id.tv_detail_type_round)
    TextView tv_detail_type_round;
    @BindView(R.id.tv_detail_state)
    TextView tv_detail_state;
    @BindView(R.id.tv_detail_date)
    TextView tv_detail_date;
    @BindView(R.id.tv_detail_type_price)
    TextView tv_detail_type_price;
    @BindView(R.id.tv_detail_seen)
    TextView tv_detail_seen;
    @BindView(R.id.tv_detail_desc)
    TextView tv_detail_desc;
    @BindView(R.id.tv_detail_phone)
    TextView tv_detail_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        Bundle ex = getIntent().getExtras();
        if (ex != null) {

            tv_detail_number.setText(ex.getString(Extras.NUMBER.toString(), ""));
            tv_detail_agahi.setText(ex.getString(Extras.OWNERID.toString(), ""));
            tv_detail_operator.setText(ex.getString(Extras.OPERATORID.toString(), ""));
            tv_detail_karkard.setText(ex.getString(Extras.STATUS.toString(), ""));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
