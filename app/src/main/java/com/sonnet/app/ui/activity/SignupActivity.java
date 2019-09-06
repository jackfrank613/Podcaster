package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.utils.PreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class SignupActivity extends AppCompatActivity {

    //google and facebook signin code
    private ImageView btn_facebook,btn_google;
    public CallbackManager callbackManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        FacebookSdk.sdkInitialize(getApplicationContext());
        btn_facebook=(ImageView)findViewById(R.id.f_button);
        btn_google=(ImageView)findViewById(R.id.g_button);
        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, CategoryActivity.class));
                finish();
            }
        });

        //callback manager creation
        callbackManager = CallbackManager.Factory.create();
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(SignupActivity.this, Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        getFacebookData(loginResult);
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.i("error",error.toString());
                    }
                });
                LoginManager.getInstance().logOut();
            }
        });

    }


    private void getFacebookData(final LoginResult loginResult)
    {
        GraphRequest request=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                if (response.getError() != null) {
                    // handle error
                } else {
                    String id = object.optString("id");
                    String email=object.optString("email");
                    String name= object.optString("name");
                    try {
                        JSONObject picture=object.getJSONObject("picture");
                        JSONObject data=picture.getJSONObject("data");
                        Log.i("debug",String.valueOf(data));
                        String mImageUrl = data.getString("url");
                        int height=data.getInt("height");
                        Log.i("height:",mImageUrl);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // facebookSignup(name,id);
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,name,gender,birthday,picture.type(small)");
        request.setParameters(parameters);
        request.executeAsync();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
