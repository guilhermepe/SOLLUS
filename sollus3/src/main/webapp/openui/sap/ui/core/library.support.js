/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
/**
 * Adds support rules to the core
 */
sap.ui.define(["jquery.sap.global",
		"./rules/Misc.support",
		"./rules/Config.support",
		"./rules/Model.support",
		"./rules/View.support",
		"./rules/App.support"],
	function(jQuery, MiscSupport, ConfigSupport, ModelSupport, ViewSupport, AppSupport) {
	"use strict";

	return {
		name: "sap.ui.core",
		niceName: "UI5 Core Library",
		ruleset: [
			MiscSupport,
			ConfigSupport,
			ModelSupport,
			ViewSupport,
			AppSupport
		]
	};
}, true);