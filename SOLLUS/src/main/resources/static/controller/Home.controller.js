sap.ui.define([
  "sap/ui/core/mvc/Controller"
], function(Controller) {
  "use strict";
  return Controller.extend("Testing.controller.Home", {
		onInit: function() {},

    onButtonPress: function (oEvent) {
			var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
			this.getView().getParent().removeAllContent();
			oRouter.navTo("routed", false);
    }
  });
});