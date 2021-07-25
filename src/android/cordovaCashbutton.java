package com.untaek.cordova.cashbutton;

import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.avatye.sdk.cashbutton.CashButtonConfig;
import com.avatye.sdk.cashbutton.ICashButtonBackPressedListener;
import com.avatye.sdk.cashbutton.ICashButtonCallback;
import com.avatye.sdk.cashbutton.ui.CashButtonLayout;

/**
 * This class echoes a string called from JavaScript.
 */
public class cordovaCashbutton extends CordovaPlugin {

    private CashButtonLayout cashButton;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        CashButtonConfig.initializer(cordova.getActivity().getApplication());
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "load": this.load(callbackContext); return true;
            case "getDockState": this.getDockState(callbackContext); return true;
            case "setDockState": this.setDockState(args, callbackContext); return true;
            case "getCashButtonState": this.getCashButtonState(callbackContext); return true;
            case "setCashButtonState": this.setCashButtonState(args, callbackContext); return true;
            default: return false;
        }
    }

    private void load(CallbackContext callbackContext) {
        CashButtonLayout.init(cordova.getActivity(), new ICashButtonCallback() {
            @Override
            public void onSuccess(CashButtonLayout cashButtonLayout) {
                cashButton = cashButtonLayout;
                callbackContext.success();
                Log.d("CashButton","SUCCESS");
            }
        });
    }


    private void getDockState(CallbackContext callbackContext) {
        if (cashButton == null) {
            callbackContext.error("Cash button has not initilaized.");
            return;
        }

        callbackContext.success(cashButton.getDockState() ? 1 : 0);
    }

    private void setDockState(JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (cashButton == null) {
            callbackContext.error("Cash button has not initilaized.");
            return;
        }

        if (args.length() < 1) {
            callbackContext.error("Require at least 1 argument.");
            return;
        }

        cashButton.setDockState(args.getBoolean(0));
        callbackContext.success();
    }

    private void getCashButtonState(CallbackContext callbackContext) {
        if (cashButton == null) {
            callbackContext.error("Cash button has not initilaized.");
            return;
        }

        callbackContext.success(cashButton.getCashButtonVisibility() ? 1 : 0);
    }

    private void setCashButtonState(JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (cashButton == null) {
            callbackContext.error("Cash button has not initilaized.");
            return;
        }

        if (args.length() < 1) {
            callbackContext.error("Require at least 1 argument.");
            return;
        }

        boolean wantToShow = args.getBoolean(0);

        if (wantToShow) {
            cashButton.setCashButtonShow();
        } else {
            cashButton.setCashButtonHide();
        }
        callbackContext.success();
    }
}
