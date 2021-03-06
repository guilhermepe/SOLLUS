sap.ui.define([
	'com/guiper/sollus/controller/BaseController',
	'sap/m/MessageToast',
	'sap/ui/model/json/JSONModel',
	'sap/ui/model/Filter',
	'sap/ui/model/FilterOperator'
], function (BaseController, MessageToast, JSONModel, Filter, FilterOperator) {
	"use strict";
	return BaseController.extend("com.guiper.sollus.controller.measure.MasterMeasure", {

		onInit: function () {                    
			var oViewModel = new JSONModel({
					currentUser: "Administrator",
					lastLogin: new Date(Date.now() - 86400000)
				});

			this.setModel(oViewModel, "view");
			
		},

		/**
		 * Event handler for the list selection event
		 * @param {sap.ui.base.Event} oEvent the list selectionChange event
		 * @public
		 */
		onSelectionChange : function (oEvent) {                    
			// get the list item, either from the listItem parameter or from the event's source itself (will depend on the device-dependent mode).
			this._showDetail(oEvent.getParameter("listItem") || oEvent.getSource());
			
		},

		
		/**
		 * Shows the selected item on the detail page
		 * @param {sap.m.ObjectListItem} oItem selected Item
		 * @private
		 */
		_showDetail : function (oItem) {                        
			this.getRouter().navTo("detailMeasure",{Id:oItem.getBindingContext().getProperty("Id")}, true);
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
		},
                onUpdateFinished : function (oEvent) {                    
                    var oList = oEvent.getSource();                   
                    var itemCollection = oList.getItems();
                    itemCollection[0].firePress();
                }
	});
});