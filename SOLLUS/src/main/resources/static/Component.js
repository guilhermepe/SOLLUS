sap.ui.define(['sap/ui/core/UIComponent'],  
  function(UIComponent) {  
    "use strict";  
    var Component = sap.ui.core.UIComponent.extend("Testing.Component", {  
      metadata: {  
        rootView: "Testing.view.App",  
        dependencies: {  
          libs: [  
          "sap.m"
          ]  
        },  
      config: {  
        sample: {  
          files: [  
          "view/App.view.xml",  
          "controller/App.controller.js"  
          ]  
        }  
      },
      routing: {
            config: {
                viewType: "XML",
                viewPath: "Testing.view",
                controlId: "appShell",
                clearTarget: true,
                routerClass: "sap.ui.core.routing.Router"
            },
            routes: [{
                    pattern: "",
                    name: "home",
                    target: "home"
                },
                {
                    pattern: "routed",
                    name: "routed",
                    target: "routed"
                },
                {
                    pattern: "ManageUsers",
                    name: "ManageUsers",
                    target: "manageUsers"
                }
                ,
                {
                    pattern: "ManageDevices",
                    name: "ManageDevices",
                    target: "manageDevices"
                }
            ],
            targets: {
                home: {
                    viewName: "Home",
                    controlId: "appShell",
                    controlAggregation: "content",
                    clearAggregation: true
                },
                routed: {
                    viewName: "Routed",
                    controlId: "appShell",
                    controlAggregation: "content",
                    clearAggregation: true
                },
                manageUsers: {
                    viewName: "ManageUsers",
                    controlId: "appShell",
                    controlAggregation: "content",
                    clearAggregation: true
                },
                manageDevices: {
                    viewName: "ManageDevices",
                    controlId: "appShell",
                    controlAggregation: "content",
                    clearAggregation: true
                }
            }
        }
    },
    init: function () {
            // call the init function of the parent
            UIComponent.prototype.init.apply(this, arguments);
            // this component should automatically initialize the router
            this.getRouter().initialize();
        }
  });  
  return Component;  
});