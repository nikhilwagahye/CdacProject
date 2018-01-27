package com.cdac.projectdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.Constabts;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {

    private static final String TAG = PaymentActivity.class.getSimpleName();
    private static final int REQUEST_CODE_PAYMENT = 1;
    // PayPal configuration
    private static PayPalConfiguration paypalConfig = new PayPalConfiguration()
            .environment(Constabts.PAYPAL_ENVIRONMENT)
            .clientId(Constabts.PAYPAL_CLIENT_ID);


    private RadioGroup checkout_payment_radio_group;
    private RadioButton checkout_payment_paypal_radio;
    private RadioButton checkout_payment_cod_radio;

    int paymentIDSelected;
    private Button buttonProceed;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        checkout_payment_radio_group = (RadioGroup) findViewById(R.id.checkout_payment_radio_group);
        checkout_payment_paypal_radio = (RadioButton) findViewById(R.id.checkout_payment_paypal_radio);
        checkout_payment_cod_radio = (RadioButton) findViewById(R.id.checkout_payment_cod_radio);
        buttonProceed = (Button) findViewById(R.id.buttonProceed);
        initRadioButtons();
        //start paypal service
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        startService(intent);

        buttonProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlePayment();
            }
        });

        imageViewBack = (ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCheckout();
            }
        });

    }

    private void handlePayment() {

        if(paymentIDSelected == 1) {
            PayPalPayment thingsToBuy = getStuffToBuy(PayPalPayment.PAYMENT_INTENT_SALE);

            Intent intent = new Intent(PaymentActivity.this, com.paypal.android.sdk.payments.PaymentActivity.class);
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
            intent.putExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_PAYMENT, thingsToBuy);

            startActivityForResult(intent, REQUEST_CODE_PAYMENT);
        } else {
            navigateToSuccess();
        }
    }
    private PayPalPayment getStuffToBuy(String paymentIntent) {
       // List<Cart> cartItems = mCheckoutDetails.getCartIItems();
        PayPalItem[] items = new PayPalItem[4];

        for (int i = 0; i < 4; i++) {
            PayPalItem payPalItem = new PayPalItem("Item " + i, 1,
                    new BigDecimal(1), "USD","1234");
            items[i] = payPalItem;
        }

        BigDecimal amount = new BigDecimal("" + 2);
        PayPalPayment payment = new PayPalPayment(amount, "USD", "Total Amount", paymentIntent);

        return payment;
    }
    private void initRadioButtons() {
        checkout_payment_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == R.id.checkout_payment_paypal_radio) {
                    paymentIDSelected = 1;
                    checkout_payment_paypal_radio.setButtonDrawable(R.drawable.form_checkbox_enabled);
                    checkout_payment_cod_radio.setButtonDrawable(R.drawable.form_checkbox_radio_disabled);

                } else if (id == R.id.checkout_payment_cod_radio) {
                    paymentIDSelected = 2;
                    checkout_payment_paypal_radio.setButtonDrawable(R.drawable.form_checkbox_radio_disabled);
                    checkout_payment_cod_radio.setButtonDrawable(R.drawable.form_checkbox_enabled);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirm =
                        data.getParcelableExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {
                        Log.i(TAG, confirm.toJSONObject().toString(4));
                        Log.i(TAG, "--------------------------------");
                        Log.i(TAG, confirm.getPayment().toJSONObject().toString(4));
                        parsePaypalResponse(confirm.toJSONObject().toString(4));
                        /**
                         *  TODO: send 'confirm' (and possibly confirm.getPayment() to your server for verification
                         * or consent completion.
                         * See https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
                         * for more details.
                         *
                         * For sample mobile backend interactions, see
                         * https://github.com/paypal/rest-api-sdk-python/tree/master/samples/mobile_backend
                         */

                    } catch (JSONException e) {
                        Log.e(TAG, "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(TAG, "The user canceled.");
            } else if (resultCode == com.paypal.android.sdk.payments.PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(TAG, "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }
        }
    }
    private void parsePaypalResponse(String paypalResponse) {
        try {
            JSONObject json = new JSONObject(paypalResponse);
            JSONObject response = json.getJSONObject("response");
            String responsePaymentID = response.getString("id");
            String responsePaymentState = response.getString("state");
            if (responsePaymentState.contains("approved")) {
                responsePaymentState = "success";
            } else {
                responsePaymentState = "failed";
            }

            navigateToSuccess();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void navigateToSuccess() {
        Intent intent = new Intent(PaymentActivity.this, SuccessPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed()
    {
        navigateToCheckout();
    }

    private void navigateToCheckout()
    {
        Intent intent = new Intent(PaymentActivity.this, CheckoutActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
