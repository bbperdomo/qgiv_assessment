package com.example.androidtechnical;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtechnical.Adapter.GiftAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private GiftAdapter mAdapter;
    private DividerItemDecoration mDividerItemDecoration;
    private ProgressBar mProgressBar;
    private Button mGiveNowButton;
    private ImageView mCompanyIconView;
    private double mAmountRaised = 0.00;
    private double mAmountGoal = 1000.00;
    private static final int PICK_IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(TAG, "onCreate: Launched");

        mRecyclerView = findViewById(R.id.recyclerView);
        mProgressBar = findViewById(R.id.progressIndicator);
        mGiveNowButton = findViewById(R.id.giveNowButton);
        mCompanyIconView = findViewById(R.id.companyIcon);
        mAdapter = new GiftAdapter(new ArrayList<>());


        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(mDividerItemDecoration);


        initialize();


    }

    private void initialize() {

        mGiveNowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Gift newGift = new Gift(100.00,"Just Now");
                mAdapter.addGift(newGift);
                mAmountRaised += newGift.getAmount();
                updateProgress(mAmountRaised);
            }
        });

        mCompanyIconView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                openImageBrowser();
                return true;
            }
        });

    }

    private void updateProgress(Double newAmount) {

        TextView amountRaisedTextView = findViewById(R.id.amountRaised);
        amountRaisedTextView.setText( String.format(Locale.US, "$%.2f raised", newAmount));

        int progressAmount = (int) Math.round(100.00 * (newAmount / mAmountGoal));
        mProgressBar.setProgress(progressAmount);

        if(newAmount >= mAmountGoal){
            mGiveNowButton.setEnabled(false);
        }
    }


    private void openImageBrowser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            Picasso.get().load(imageUri).into(mCompanyIconView);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}