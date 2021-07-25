var exec = require('cordova/exec');

exports.cashButtonLoad = function (arg0, success, error) {
    exec(success, error, 'cordovaCashbutton', 'load', []);
}

exports.cashButtonGetDockState = function (arg0, success, error) {
    exec(success, error, 'cordovaCashbutton', 'getDockState', [])
}

exports.cashButtonSetDockState = function (arg0, success, error) {
    exec(success, error, 'cordovaCashbutton', 'setDockState', [arg0])
}

exports.cashButtonGetCashButtonState = function (arg0, success, error) {
    exec(success, error, 'cordovaCashbutton', 'getCashButtonState', [])
}

exports.cashButtonSetCashButtonState = function (arg0, success, error) {
    exec(success, error, 'cordovaCashbutton', 'setCashButtonState', [arg0])
}