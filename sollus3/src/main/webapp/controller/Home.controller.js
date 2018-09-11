sap.ui.define([
		'com/guiper/sollus/controller/BaseController',
		'sap/ui/model/json/JSONModel',
		'sap/ui/Device',
		'com/guiper/sollus/model/formatter'
	], function (BaseController, JSONModel, Device, formatter) {
		"use strict";
		return BaseController.extend("com.guiper.sollus.controller.Home", {
			formatter: formatter,

			onInit: function () {
				var oViewModel = new JSONModel({
					isPhone : Device.system.phone
				});
				this.setModel(oViewModel, "view");
				Device.media.attachHandler(function (oDevice) {
					this.getModel("view").setProperty("/isPhone", oDevice.name === "Phone");
				}.bind(this));
			}
		});
});