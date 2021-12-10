package com.monika.smartreaders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.SilentAuthenticationCallback;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalServiceException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.monika.smartreaders.MainUI.Dashboard;

import org.json.JSONObject;

public class MsAuthPage extends AppCompatActivity {
    private static final String TAG = MsAuthPage.class.getSimpleName();

    /* UI & Debugging Variables */
    Button signInButton;
   // Button signOutButton;

    /* Azure AD Variables */
    private ISingleAccountPublicClientApplication mSingleAccountApp;
    private IAccount mAccount;
    private String defaultGraphResourceUrl;
    private String signoutinfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);// Creates a PublicClientApplication object with res/raw/auth_config_single_account.json

        signoutinfo="hahaha";
        signoutinfo = getIntent().getStringExtra("signoutinfo");

        signInButton =findViewById(R.id.btn_signIn);
        defaultGraphResourceUrl = MSGraphRequestWrapper.MS_GRAPH_ROOT_ENDPOINT + "v1.0/me";

        PublicClientApplication.createSingleAccountPublicClientApplication(this,
                R.raw.auth_config_single_account,
                new IPublicClientApplication.ISingleAccountApplicationCreatedListener() {
                    @Override
                    public void onCreated(ISingleAccountPublicClientApplication application) {

                        mSingleAccountApp = application;
                        Log.d(TAG, "onCreated: "+"account detected!!"+mSingleAccountApp);
                        loadAccount();
                        if(signoutinfo!=null && signoutinfo.equals("signoutasap")){
                            Log.d(TAG, "onCreate: "+"yes"+mSingleAccountApp);

                            if (mSingleAccountApp == null) {
                                Log.d(TAG, "onCreate: yes here");
                                return;
                            }
                            mSingleAccountApp.signOut(new ISingleAccountPublicClientApplication.SignOutCallback() {
                                @Override
                                public void onSignOut() {
                                    Log.d(TAG, "onSignOut: "+"yes here finally");
                                    showToastOnSignOut();
                                    signInButton.setEnabled(true);
                                }

                                @Override
                                public void onError(@NonNull MsalException exception) {
                                    displayError(exception);
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(MsalException exception) {
                        displayError(exception);
                    }
                });





        signInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mSingleAccountApp == null) {
                    return;
                }

                mSingleAccountApp.signIn(MsAuthPage.this, null, getScopes(), getAuthInteractiveCallback());
            }
        });

    }


    public void signout(){

        mSingleAccountApp.signOut(new ISingleAccountPublicClientApplication.SignOutCallback() {
            @Override
            public void onSignOut() {
                showToastOnSignOut();
            }

            @Override
            public void onError(@NonNull MsalException exception) {
                displayError(exception);
            }
        });

    }



    @Override
    public void onResume() {
        super.onResume();
        loadAccount();
    }

    private String[] getScopes() {
        String blah="user.read";
        return blah.toLowerCase().split(" ");
    }

    private void loadAccount() {
        if (mSingleAccountApp == null) {
            return;
        }

        mSingleAccountApp.getCurrentAccountAsync(new ISingleAccountPublicClientApplication.CurrentAccountCallback() {
            @Override
            public void onAccountLoaded(@Nullable IAccount activeAccount) {
                // You can use the account data to update your UI or your app database.
                mAccount = activeAccount;
                Log.d(TAG, "onAccountLoaded: "+activeAccount+ "  "+mAccount+signoutinfo);
                if(mAccount!=null &&( signoutinfo==null )){
                    Intent i= new Intent(MsAuthPage.this,Dashboard.class);
                    Log.d(TAG, "onAccountLoaded: "+mAccount.getUsername());
                   i.putExtra("name",mAccount.getUsername());

                    startActivity(i);
                    finish();
                }

                //updateUI();
            }

            @Override
            public void onAccountChanged(@Nullable IAccount priorAccount, @Nullable IAccount currentAccount) {
                if (currentAccount == null) {
                    // Perform a cleanup task as the signed-in account changed.
                    showToastOnSignOut();
                }
            }

            @Override
            public void onError(@NonNull MsalException exception) {
                displayError(exception);
            }
        });
    }

    /**
     * Callback used in for silent acquireToken calls.
     */
    private SilentAuthenticationCallback getAuthSilentCallback() {
        return new SilentAuthenticationCallback() {

            @Override
            public void onSuccess(IAuthenticationResult authenticationResult) {
                Log.d(TAG, "Successfully authenticated");

                /* Successfully got a token, use it to call a protected resource - MSGraph */
                callGraphAPI(authenticationResult);
            }

            @Override
            public void onError(MsalException exception) {
                /* Failed to acquireToken */
                Log.d(TAG, "Authentication failed: " + exception.toString());
                displayError(exception);

                if (exception instanceof MsalClientException) {
                    /* Exception inside MSAL, more info inside MsalError.java */
                } else if (exception instanceof MsalServiceException) {
                    /* Exception when communicating with the STS, likely config issue */
                } else if (exception instanceof MsalUiRequiredException) {
                    /* Tokens expired or no session, retry with interactive */
                }
            }
        };
    }

    private AuthenticationCallback getAuthInteractiveCallback() {
        return new AuthenticationCallback() {

            @Override
            public void onSuccess(IAuthenticationResult authenticationResult) {
                /* Successfully got a token, use it to call a protected resource - MSGraph */
                Log.d(TAG, "Successfully authenticated");
                Log.d(TAG, "ID Token: " + authenticationResult.getAccount().getClaims().get("id_token"));

                /* Update account */
                mAccount = authenticationResult.getAccount();
                //updateUI();

                /* call graph */
                callGraphAPI(authenticationResult);
            }

            @Override
            public void onError(MsalException exception) {
                /* Failed to acquireToken */
                Log.d(TAG, "Authentication failed: " + exception.toString());
                displayError(exception);

                if (exception instanceof MsalClientException) {
                    /* Exception inside MSAL, more info inside MsalError.java */
                } else if (exception instanceof MsalServiceException) {
                    /* Exception when communicating with the STS, likely config issue */
                }
            }

            @Override
            public void onCancel() {
                /* User canceled the authentication */
                Log.d(TAG, "User cancelled login.");
            }
        };
    }

    private void callGraphAPI(final IAuthenticationResult authenticationResult) {
        MSGraphRequestWrapper.callGraphAPIUsingVolley(
                this,
                defaultGraphResourceUrl,
                authenticationResult.getAccessToken(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        /* Successfully called graph, process data and send to UI */
                        Log.d(TAG, "Response: " + response.toString());
                        displayGraphResult(response);
                        Intent i = new Intent(MsAuthPage.this, Dashboard.class);
                        startActivity(i);
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error: " + error.toString());
                        displayError(error);
                    }
                });
    }
    private void displayGraphResult(@NonNull final JSONObject graphResponse) {
       // logTextView.setText(graphResponse.toString());
    }

    private void displayError(@NonNull final Exception exception) {
       // logTextView.setText(exception.toString());
    }
    private void showToastOnSignOut() {
        final String signOutText = "Signed Out.";
      //  currentUserTextView.setText("");
        Toast.makeText(this, signOutText, Toast.LENGTH_SHORT)
                .show();
    }
}
