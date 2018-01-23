package com.cdac.projectdemo.Utils;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;


public class Constabts {
    // sandbox
    public static final String PAYPAL_CLIENT_ID = "AacA6bC7XPeMLS8qpkGV6qIyS4dOwzrCYiHTCJILNSsS8tCI6sGgAJepSrHKOk85CvgW6TtQi4hXckSd";
    public static final String PAYPAL_CLIENT_SECRET = "EOMDqjpB493OJkI9hENHP0nNxgZBlD9-qHv4gn6F5Obp_NjOwPIMSu7ObvAAcYEZ8dPsbA63sRfe5LmC";
    // sandbox
    public static final String PAYPAL_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;

    // master
    // public static final String PAYPAL_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_PRODUCTION;

    public static final String PAYMENT_INTENT = PayPalPayment.PAYMENT_INTENT_SALE;
    public static final String DEFAULT_CURRENCY = "USD";

    public static final String API_TEST = "https://mserve.asianpaints.com/ConsumerApp/GetProductList";

}
