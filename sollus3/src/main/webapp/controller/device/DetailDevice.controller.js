/*global location */
sap.ui.define([
    'com/guiper/sollus/controller/BaseController',
    'jquery.sap.global',
    'sap/m/MessageToast',
    'sap/m/MessageBox',
    'sap/ui/model/json/JSONModel',
    'sap/ui/core/Fragment',
    'sap/ui/model/Filter',
    'sap/ui/model/FilterOperator'
], function (BaseController, MessageToast, Filter, FilterOperator, Fragment, MessageBox, JSONModel) {
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
            this.getRouter().getRoute("detailDevice").attachPatternMatched(this, this._onObjectMatched);
            this.getOwnerComponent().getModel().metadataLoaded().then(this._onMetadataLoaded.bind(this));

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
        _onObjectMatched: function (oEvent, oController) {
            var sObjectId = oEvent.getParameter("arguments").Id;
            oController.getView().getModel().metadataLoaded().then(function () {
                var sObjectPath = oController.getView().getModel().createKey("Equipamentos", {
                    Id: sObjectId
                });
                oController._bindView("/" + sObjectPath);
            }.bind(this));

            oController.setupPortsList(sObjectId);
        },

        /**
         * Binds the view to the object path. Makes sure that detail view displays
         * a busy indicator while data for the corresponding element binding is loaded.
         * @function
         * @param {string} sObjectPath path to the object to be bound to the view.
         * @private
         */
        _bindView: function (sObjectPath) {
            // Set busy indicator during view binding
            var oViewModel = this.getModel("detailDevice");

            // If the view was not bound yet its not busy, only if the binding requests data it is set to busy again
            oViewModel.setProperty("/busy", false);

            this.getView().bindElement({
                path: sObjectPath,
                parameters: {
                    expand: "PortaDetails"                    
                },
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
            var oView = this.getView();
            var oElementBinding = oView.getElementBinding();

            // No data for the binding
            if (!oElementBinding.getBoundContext()) {
                console.log("item não encontrado", sObjectId);
                //this.getRouter().getTargets().display("detailObjectNotFound");
                // if object could not be found, the selection in the master list
                // does not make sense anymore.
                //this.getOwnerComponent().oListSelector.clearMasterListSelection();
                return;
            } else {
                //console.log(oElementBinding);
            }

            var sPath = oElementBinding.getPath(),
                    oResourceBundle = this.getResourceBundle(),
                    oObject = oView.getModel().getObject(sPath),
                    sObjectId = oObject.ObjectID,
                    sObjectName = oObject.Name,
                    oViewModel = this.getModel("detailDevice");                    

            /*this.getOwnerComponent().oListSelector.selectAListItem(sPath);
             
             oViewModel.setProperty("/shareSendEmailSubject",
             oResourceBundle.getText("shareSendEmailObjectSubject", [sObjectId]));
             oViewModel.setProperty("/shareSendEmailMessage",
             oResourceBundle.getText("shareSendEmailObjectMessage", [sObjectName, sObjectId, location.href]));
             */
        },

        setupPortsList : function(idEquipamento) {

            /*Sets Up the ports displayed on device ports section*/

                // build filter array
                var aFilter = [], sQuery = idEquipamento,
                    // retrieve list control
                    oList = this.getView().byId("devicePortList"),
                    // get binding for aggregation 'items'
                    oBinding = oList.getBinding("items");    
                if (sQuery) {
                    aFilter.push(new sap.ui.model.Filter("EquipamentoId", sap.ui.model.FilterOperator.EQ, sQuery));
                }
                // apply filter. an empty filter array simply removes the filter
                // which will make all entries visible again
                oBinding.filter(aFilter);
        },

        _onMetadataLoaded: function () {
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
         * popOver for Port COnfiguration controller section
         */

        onPortDetailClicked: function (oEvent) {           

            //Cleans opopover reference for new instantiation
            if (this._oPopover) {
                this._oPopover.destroy();
            }
           
            var tipoPorta = oEvent.getSource().getBindingContext().getProperty("TipoPortaId");

             //Defines which fragment gona be used;           
            if (tipoPorta === 6) {
                this._oPopover = sap.ui.xmlfragment("com.guiper.sollus.view.device.PortSyncConfig", this);
            } else {
                this._oPopover = sap.ui.xmlfragment("com.guiper.sollus.view.device.PortConfig", this);
            }
              
            this.getView().addDependent(this._oPopover);            
            var sObjectPath = this.getView().getModel().createKey("Portas", {
                Id: oEvent.getSource().getBindingContext().getProperty("PortaId")
            });
            this._oPopover.bindElement("/"+sObjectPath);            
            this._oPopover.openBy(oEvent.getSource());  
        },

        handlePortConfigFormCancelButton: function(oEvent) {
            var oBundle = this.getModel("i18n").getResourceBundle();
            this._oPopover.getModel().resetChanges();   
            sap.m.MessageToast.show(oBundle.getText("changesDiscardedMessage"));
            this._oPopover.close();
        },

        unsetFutureSync: function(oEvent) {
            var oContext = this._oPopover.getBindingContext();
            var oModel = this._oPopover.getModel();
            var path = ("/Portas("+oContext.getProperty("Id")+"l)");
            var porta = this._oPopover.getModel().bindProperty(path);
            oModel.setProperty(path+"/CfgAcionamento", "");          
            oModel.refresh();
            oEvent.getSource.setVisible(false);
            sap.m.MessageToast.show(oBundle.getText("syncUnsetMessage"));
        },

        handlePortConfigFormSaveButton: function (oEvent) {    
            var oBundle = this.getModel("i18n").getResourceBundle();
            var oContext = this._oPopover.getBindingContext();
            var oModel = this._oPopover.getModel();            

            var acionada = oContext.getProperty("Acionada");
            var alterouStatus = oContext.getProperty("AlterouStatus");                        
            var path = ("/Portas("+oContext.getProperty("Id")+"l)");
            var porta = this._oPopover.getModel().bindProperty(path);

            var cfg = oModel.getProperty(path+"/CfgAcionamento");
            if (cfg !== "") {
                oModel.setProperty(path+"/Acionada", true);
                oModel.setProperty(path+"/AlterouStatus", false);
            }else {
                oModel.setProperty(path+"/Acionada", false);
                oModel.setProperty(path+"/AlterouStatus", true);

            }                    
            this._oPopover.getModel().submitChanges({
                success: function () {
                    sap.m.MessageToast.show(oBundle.getText("changesSavedMessage"));                    

                },
                error: function (error) {
                    sap.m.MessageToast.show(oBundle.getText("changesNotSavedErrorMessage")+error);
                }
            });
            this._oPopover.close();
        },

        onExit: function () {
            if (this._oPopover) {
                this._oPopover.destroy();
            }
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
        },

        onSavePressed: function (event) {
            var oBundle = this.getModel("i18n").getResourceBundle();        
            this.getView().getModel().submitChanges({
                success: function () {
                    sap.m.MessageToast.show(oBundle.getText("changesSavedMessage"));
                },
                error: function (error) {
                    sap.m.MessageToast.show(oBundle.getText("changesNotSavedErrorMessage")+error);
                    this.getView().getModel().refresh(true);
                }
            });
        },

        onCancelPressed: function (event) {
            var oBundle = this.getModel("i18n").getResourceBundle();        
            this.getView().getModel().resetChanges();             
            sap.m.MessageToast.show(oBundle.getText("changesDiscardedMessage"));

        }

    });

}
);