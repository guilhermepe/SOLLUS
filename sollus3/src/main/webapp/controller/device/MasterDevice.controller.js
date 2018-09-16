sap.ui.define([
	'com/guiper/sollus/controller/BaseController',
	'sap/m/MessageToast',
	'sap/ui/model/json/JSONModel',
	'sap/ui/model/Filter',
	'sap/ui/model/FilterOperator'
], function (BaseController, MessageToast, JSONModel, Filter, FilterOperator) {
	"use strict";
	return BaseController.extend("com.guiper.sollus.controller.settings.MasterSettings", {

		onInit: function () {
			var oViewModel = new JSONModel({
					currentUser: "Administrator",
					lastLogin: new Date(Date.now() - 86400000)
				});

			this.setModel(oViewModel, "view");
		},

		onMasterPressed: function (oEvent) {
			var oContext = oEvent.getParameter("listItem").getBindingContext("side");
			var sPath = oContext.getPath() + "/selected";
			oContext.getModel().setProperty(sPath, true);
			var sSelectedMasterElement = oContext.getProperty("title");
			var sKey = oContext.getProperty("key");
			switch (sSelectedMasterElement) {
				case "System Settings": {
					this.getRouter().navTo(sKey);
					break;
				}
				default: {
					MessageToast.show(sSelectedMasterElement + " was pressed");
					break;
				}
			}
		},

		onSavePressed: function () {
			MessageToast.show("Save was pressed");
		},

		onCancelPressed: function () {
			MessageToast.show("Cancel was pressed");
		},
		onNavButtonPress: function  () {
			this.getOwnerComponent().myNavBack();
		},
		onFilterDevices : function (oEvent) {

			// build filter array
			var aFilter = [], sQuery = oEvent.getParameter("query"),
				// retrieve list control
				oList = this.getView().byId("masterDeviceList"),
				// get binding for aggregation 'items'
				oBinding = oList.getBinding("items");

			if (sQuery) {
				aFilter.push(new Filter("Nome", FilterOperator.Contains, sQuery));
			}
			// apply filter. an empty filter array simply removes the filter
			// which will make all entries visible again
			oBinding.filter(aFilter);
		}
	});
});