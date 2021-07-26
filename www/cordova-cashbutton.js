var exec = require('cordova/exec');

const SERVICE_NAME = 'cordovaCashbutton'

exports.cashButtonLoad = function (arg0, success, error) {
    exec(success, error, SERVICE_NAME, 'load', []);
}

exports.cashButtonGetDockState = function (arg0, success, error) {
    exec(success, error, SERVICE_NAME, 'getDockState', [])
}

exports.cashButtonSetDockState = function (arg0, success, error) {
    exec(success, error, SERVICE_NAME, 'setDockState', [arg0])
}

exports.cashButtonGetCashButtonState = function (arg0, success, error) {
    exec(success, error, SERVICE_NAME, 'getCashButtonState', [])
}

exports.cashButtonSetCashButtonState = function (arg0, success, error) {
    exec(success, error, SERVICE_NAME, 'setCashButtonState', [arg0])
}

exports.overrideOnBackPressedBehavior = function (error) {
    exec(onBackPressed, error, SERVICE_NAME, 'overrideOnBackPressedBehavior', [])
}