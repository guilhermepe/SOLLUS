/* global QUnit*/

jQuery.sap.require("sap.ui.qunit.qunit-css");
jQuery.sap.require("sap.ui.thirdparty.qunit");
jQuery.sap.require("sap.ui.qunit.qunit-junit");
QUnit.config.autostart = false;

sap.ui.require([
	"sap/ui/test/Opa5",
	"com/guiper/sollus/test/integration/pages/Common",
	"sap/ui/test/opaQunit",
	"com/guiper/sollus/test/integration/pages/App",
	"com/guiper/sollus/test/integration/pages/Settings",
	"com/guiper/sollus/test/integration/pages/Statistics",
	"com/guiper/sollus/test/integration/pages/Home"
], function (Opa5, Common) {
	"use strict";
	Opa5.extendConfig({
		arrangements: new Common(),
		viewNamespace: "com.guiper.sollus.view."
	});

	sap.ui.require([
		"com/guiper/sollus/test/integration/NavigationJourney"
	], function () {
		QUnit.start();
	});
});