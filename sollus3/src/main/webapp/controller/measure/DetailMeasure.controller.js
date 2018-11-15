sap.ui.define([
    'com/guiper/sollus/controller/BaseController',    
     'jquery.sap.global',
    "sap/ui/model/json/JSONModel",
    "sap/m/MessageToast",
    "sap/ui/model/Filter",
    "sap/ui/model/FilterOperator",
    "sap/ui/core/format/DateFormat"
], function (BaseController, Controller, JSONModel, MessageToast, Filter, FilterOperator, DateFormat) {
    "use strict";

    return BaseController.extend("com.guiper.sollus.controller.measure.DetailMeasure", {

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

            this.getView().setModel(oViewModel, "detailMeasure");
            this.getRouter().getRoute("detailMeasure").attachPatternMatched(this, this._onObjectMatched);
            this.getOwnerComponent().getModel().metadataLoaded().then(this._onMetadataLoaded.bind(this));
            
            /*
            var oView = this.getView();
            // set explored app's demo model on this sample
            var oJSONModel = this.initSampleDataModel();
            oView.setModel(oJSONModel);
            oView.setModel(new JSONModel({
                globalFilter: "",
                availabilityFilterOn: false,
                cellFilterOn: false
            }), "ui");
            this._oGlobalFilter = null;
            this._oPriceFilter = null;
            */
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
            var oViewModel = this.getModel("detailMeasure");

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
        
         _onMetadataLoaded: function () {
            // Store original busy indicator delay for the detail view
            var iOriginalViewBusyDelay = this.getView().getBusyIndicatorDelay();
            this.oViewModel = this.getModel("detailMeasure");

            // Make sure busy indicator is displayed immediately when
            // detail view is displayed for the first time
            this.oViewModel.setProperty("/delay", 0);

            // Binding the view will set it to not busy - so the view is always busy if it is not bound
            this.oViewModel.setProperty("/busy", true);
            // Restore original busy indicator delay for the detail view
            this.oViewModel.setProperty("/delay", iOriginalViewBusyDelay);
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
        },

        initSampleDataModel: function () {
            var oModel = new JSONModel();
            var oDateFormat = DateFormat.getDateInstance({source: {pattern: "timestamp"}, pattern: "dd/MM/yyyy"});            
            /*

            jQuery.ajax(jQuery.sap.getModulePath("sap.ui.demo.mock", "/products.json"), {
                dataType: "json",
                success: function (oData) {
                    var aTemp1 = [];
                    var aTemp2 = [];
                    var aSuppliersData = [];
                    var aCategoryData = [];
                    for (var i = 0; i < oData.ProductCollection.length; i++) {
                        var oProduct = oData.ProductCollection[i];
                        if (oProduct.SupplierName && jQuery.inArray(oProduct.SupplierName, aTemp1) < 0) {
                            aTemp1.push(oProduct.SupplierName);
                            aSuppliersData.push({Name: oProduct.SupplierName});
                        }
                        if (oProduct.Category && jQuery.inArray(oProduct.Category, aTemp2) < 0) {
                            aTemp2.push(oProduct.Category);
                            aCategoryData.push({Name: oProduct.Category});
                        }
                        oProduct.DeliveryDate = (new Date()).getTime() - (i % 10 * 4 * 24 * 60 * 60 * 1000);
                        oProduct.DeliveryDateStr = oDateFormat.format(new Date(oProduct.DeliveryDate));
                        oProduct.Heavy = oProduct.WeightMeasure > 1000 ? "true" : "false";
                        oProduct.Available = oProduct.Status == "Available" ? true : false;
                    }
                    oData.Suppliers = aSuppliersData;
                    oData.Categories = aCategoryData;
                    oModel.setData(oData);
                },
                error: function () {
                    jQuery.sap.log.error("failed to load json");
                }
            });
            return oModel;
            */
        },

        _filter: function () {
            var oFilter = null;

            if (this._oGlobalFilter && this._oPriceFilter) {
                oFilter = new sap.ui.model.Filter([this._oGlobalFilter, this._oPriceFilter], true);
            } else if (this._oGlobalFilter) {
                oFilter = this._oGlobalFilter;
            } else if (this._oPriceFilter) {
                oFilter = this._oPriceFilter;
            }

            this.byId("table").getBinding("rows").filter(oFilter, "Application");
        },

        filterGlobally: function (oEvent) {
            var sQuery = oEvent.getParameter("query");
            this._oGlobalFilter = null;

            if (sQuery) {
                this._oGlobalFilter = new Filter([
                    new Filter("Name", FilterOperator.Contains, sQuery),
                    new Filter("Category", FilterOperator.Contains, sQuery)
                ], false);
            }

            this._filter();
        },

        filterPrice: function (oEvent) {
            var oColumn = oEvent.getParameter("column");
            if (oColumn != this.byId("price")) {
                return;
            }

            oEvent.preventDefault();

            var sValue = oEvent.getParameter("value");

            function clear() {
                this._oPriceFilter = null;
                oColumn.setFiltered(false);
                this._filter();
            }

            if (!sValue) {
                clear.apply(this);
                return;
            }

            var fValue = null;
            try {
                fValue = parseFloat(sValue, 10);
            } catch (e) {
                // nothing
            }

            if (!isNaN(fValue)) {
                this._oPriceFilter = new Filter("Price", FilterOperator.BT, fValue - 20, fValue + 20);
                oColumn.setFiltered(true);
                this._filter();
            } else {
                clear.apply(this);
            }
        },

        clearAllFilters: function (oEvent) {
            var oTable = this.byId("table");

            var oUiModel = this.getView().getModel("ui");
            oUiModel.setProperty("/globalFilter", "");
            oUiModel.setProperty("/availabilityFilterOn", false);

            this._oGlobalFilter = null;
            this._oPriceFilter = null;
            this._filter();

            var aColumns = oTable.getColumns();
            for (var i = 0; i < aColumns.length; i++) {
                oTable.filter(aColumns[i], null);
            }
        },

        toggleAvailabilityFilter: function (oEvent) {
            this.byId("availability").filter(oEvent.getParameter("pressed") ? "X" : "");
        },

        formatAvailableToObjectState: function (bAvailable) {
            return bAvailable ? "Success" : "Error";
        },

        showInfo: function (oEvent) {
            try {
                jQuery.sap.require("sap.ui.table.sample.TableExampleUtils");
                sap.ui.table.sample.TableExampleUtils.showInfo(jQuery.sap.getModulePath("sap.ui.table.sample.Filtering", "/info.json"), oEvent.getSource());
            } catch (e) {
                // nothing
            }
        }

    });
});