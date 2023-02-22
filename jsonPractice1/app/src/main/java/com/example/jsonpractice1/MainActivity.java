package com.example.jsonpractice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject usGovernment = new JSONObject();

        JSONObject executiveBranch = new JSONObject();
        JSONObject executiveBranchPositions = new JSONObject();
        JSONObject legislativeBranch = new JSONObject();
        JSONObject judicialBranch = new JSONObject();
        JSONObject stateGovernment = new JSONObject();
        JSONObject localGovernment = new JSONObject();
        JSONArray justices = new JSONArray();
        JSONObject justice1 = new JSONObject();
        JSONObject justice2 = new JSONObject();
        JSONObject justice3 = new JSONObject();
        JSONObject legislativeInfo = new JSONObject();
    try {
        usGovernment.put("Executive Branch", executiveBranch);
        usGovernment.put("Legislative Branch", legislativeBranch);
        usGovernment.put("Judicial Branch", judicialBranch);
        usGovernment.put("State Government", stateGovernment);
        usGovernment.put("Local Government", localGovernment);

        executiveBranch.put("President", "Joe Biden");
        executiveBranch.put("Vice President", "Kamala Harris");
        executiveBranch.put("Secretary of State", "Antony J. Blinken");

        legislativeBranch.put("Speaker of the House", "Kevin McCarthy");
        legislativeBranch.put("Senate Majority Leader", "Chuck Schumer");
        legislativeBranch.put("Senate Minorty Leader", "Mitch McConnell");
        legislativeInfo.put("House Democrats", 212);
        legislativeInfo.put("House Republicans", 222);
        legislativeInfo.put("Senate Democrats", 47);
        legislativeInfo.put("Senate Republicans", 50);
        legislativeBranch.put("Party Statistics", legislativeInfo);

        judicialBranch.put("Chief Justice", "John Roberts");
        judicialBranch.put("US District Courts", 94);
        judicialBranch.put("US Court of Appeals", 13);
        justice1.put("name","Clarence Thomas");
        justice1.put("ideology", "conservative");
        justice2.put("name", "Sonia Sotomayor");
        justice2.put("ideology", "liberal");
        justice3.put("name", "Brett Kavanaugh");
        justice3.put("ideology", "moderate");
        justices.put(justice1);
        justices.put(justice2);
        justices.put(justice3);
        judicialBranch.put("Supreme Court Justices", justices);

        stateGovernment.put("State", "New Jersey");
        stateGovernment.put("Governor", "Phil Murphy");
        stateGovernment.put("NJ Senate Leader", "Craig Coughlin");

        localGovernment.put("Township", "South Brunswick");
        localGovernment.put("Mayor", "Charles Carley");
        localGovernment.put("BOE Superintendent", "Scott Feder");
        Log.d("US Government", usGovernment.toString());
    }catch(JSONException e){e.printStackTrace();}
    }


}