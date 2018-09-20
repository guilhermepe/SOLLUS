/*global location */
sap.ui.define([
    'com/guiper/sollus/controller/BaseController',
    'sap/m/MessageToast',
    'sap/ui/model/json/JSONModel'
], function (BaseController, JSONModel) {
    "use strict";

    return BaseController.extend("com.guiper.sollus.controller.device.DetailDevice", {

        //formatter: formatter,

        /* =========================================================== */
        /* lifecycle methods                                           */
        /* =========================================================== */

        onInit: function () {
            
            // Model used to manipulate control states. The chosen values make sure,
            // detail page is busy indication immediately so there is no break in
            // between the busy indication for loading the view's meta data
            //  sap.ui.model.json.JSONModel used because of constructor unknown bug.
            var oViewModel = new sap.ui.model.json.JSONModel({
                busy: false,
                callbackData: [],
                delay: 0
            });

            

            this.getView().setModel(oViewModel, "detailDevice"); 
            
            this.getRouter().getRoute("detailDevice").attachPatternMatched(this,this._onObjectMatched);

            this.getOwnerComponent().getModel().metadataLoaded().then(this._onMetadataLoaded.bind(this));
        },

        /* =========================================================== */
        /* event handlers                                              */
        /* =========================================================== */

        /**
         * Event handler when the share by E-Mail button has been clicked
         * @public
         */
        onShareEmailPress: function () {
            var oViewModel = this._getModel("detailDevice");

            sap.m.URLHelper.triggerEmail(
                null,
                oViewModel.getProperty("/shareSendEmailSubject"),
                oViewModel.getProperty("/shareSendEmailMessage")
            );
        },



        /* =========================================================== */
        /* begin: internal methods                                     */
        /* =========================================================== */

        /**
         * Binds the view to the object path and expands the aggregated line items.
         * @function
         * @param {sap.ui.base.Event} oEvent pattern match event in route 'object'
         * @param {sap.ui.core.MvcController} oController Controller that matches the route pattern
         * @private
         * 
         */
        _onObjectMatched: function (oEvent,oController) {
            console.log("_onObjectMatched",oEvent);                      
            var sObjectId = oEvent.getParameter("arguments").Id; 
            console.log(sObjectId);
            oController.getView().getModel().metadataLoaded().then(function () {
                var sObjectPath = oController.getView().getModel().createKey("Equipamentos", {
                    Id: sObjectId
                });
                oController._bindView("/" + sObjectPath);
            }.bind(this));
        },

        /**
         * Binds the view to the object path. Makes sure that detail view displays
         * a busy indicator while data for the corresponding element binding is loaded.
         * @function
         * @param {string} sObjectPath path to the object to be bound to the view.
         * @private
         */
        _bindView: function (sObjectPath) {

            console.log("_bindView");
            // Set busy indicator during view binding
            var oViewModel = this.getModel("detailDevice");

            // If the view was not bound yet its not busy, only if the binding requests data it is set to busy again
            oViewModel.setProperty("/busy", false);

            this.getView().bindElement({
                path: sObjectPath,
                events: {
                    change: this._onBindingChange.bind(this),
                    dataRequested: function () {
                        oViewModel.setProperty("/busy", true);
                    },
                    dataReceived: function () {
                        oViewModel.setProperty("/busy", false);
                    }
                }
            });
        },

        _onBindingChange: function () {
            console.log("_onBindingChange");

            var oView = this.getView(),
                oElementBinding = oView.getElementBinding();

            // No data for the binding
            if (!oElementBinding.getBoundContext()) {
                console.log("item não encontrado", sObjectId)
                //this.getRouter().getTargets().display("detailObjectNotFound");
                // if object could not be found, the selection in the master list
                // does not make sense anymore.
                //this.getOwnerComponent().oListSelector.clearMasterListSelection();
                return;
            } else {
                console.log(oElementBinding);
            }

            var sPath = oElementBinding.getPath(),
                oResourceBundle = this.getResourceBundle(),
                oObject = oView.getModel().getObject(sPath),
                sObjectId = oObject.ObjectID,
                sObjectName = oObject.Name,
                oViewModel = this.getModel("detailDevice");

            this.getOwnerComponent().oListSelector.selectAListItem(sPath);

            oViewModel.setProperty("/shareSendEmailSubject",
                oResourceBundle.getText("shareSendEmailObjectSubject", [sObjectId]));
            oViewModel.setProperty("/shareSendEmailMessage",
                oResourceBundle.getText("shareSendEmailObjectMessage", [sObjectName, sObjectId, location.href]));
        },

        _onMetadataLoaded: function () {
            console.log("_onMetadataLoaded")
            // Store original busy indicator delay for the detail view
            var iOriginalViewBusyDelay = this.getView().getBusyIndicatorDelay();
                this.oViewModel = this.getModel("detailDevice");

            // Make sure busy indicator is displayed immediately when
            // detail view is displayed for the first time
            this.oViewModel.setProperty("/delay", 0);

            // Binding the view will set it to not busy - so the view is always busy if it is not bound
            this.oViewModel.setProperty("/busy", true);
            // Restore original busy indicator delay for the detail view
            this.oViewModel.setProperty("/delay", iOriginalViewBusyDelay);
        },       

        /**
         * Event handler for navigating back.
         * It there is a history entry we go one step back in the browser history
         * If not, it will replace the current entry of the browser history with the master route.
         * @public
         */
        onNavBack: function () {
            var sPreviousHash = History.getInstance().getPreviousHash();

            if (sPreviousHash !== undefined) {
                history.go(-1);
            } else {
                this.getRouter().navTo("master", {}, true);
            }
        }

    });

}
);