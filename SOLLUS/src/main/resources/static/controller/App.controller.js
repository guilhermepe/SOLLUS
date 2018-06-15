sap.ui.define([
  "sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel",
	"sap/ui/core/Fragment",
	'sap/m/MessageToast'
], function(Controller, JSONModel, Fragment, MessageToast) {
  "use strict";
  return Controller.extend("Sollus.controller.App", {
		onInit: function() {
			var oData = {userName: "Fulano de Outro"};
			var oModel = new JSONModel();
			oModel.setData(oData);
			this.getView().setModel(oModel);
		},

		handlePressConfiguration: function(oEvent) {
			var oItem = oEvent.getSource();
			var oShell = this.getView().byId("appShell");
			var bState = oShell.getShowPane();
			oShell.setShowPane(!bState);
			oItem.setShowMarker(!bState);
			oItem.setSelected(!bState);
		},

		handleNavigationListItemPressed: function(oEvent) {			
			var route_link = String(oEvent.getSource().getId());
			route_link = route_link.slice(route_link.indexOf("--")+2);
			//console.log(route_link);
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			var oShell = this.getView().byId("appShell");
			oShell.removeAllContent();
			oRouter.navTo(route_link, false);
		},

		handleUserItemPressed: function(oEvent) {
			var oButton = oEvent.getSource();
			if (!this._menu) {
				this._menu = sap.ui.xmlfragment(
					"Sollus.view.UserItem",
					this
				);
				this.getView().addDependent(this._menu);
			}
			var eDock = sap.ui.core.Popup.Dock;
			this._menu.open(this._bKeyboard, oButton, eDock.BeginTop, eDock.BeginBottom, oButton);
		}
  });
});