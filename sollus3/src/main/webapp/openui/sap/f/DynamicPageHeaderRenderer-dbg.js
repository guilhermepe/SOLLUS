/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */

sap.ui.define([], function () {
	"use strict";


	/**
	 * oDynamicPage Header renderer.
	 * @namespace
	 */
	var DynamicPageHeaderRenderer = {};

	/**
	 * Renders the HTML for the given control, using the provided {@link sap.ui.core.RenderManager}.
	 *
	 * @param {sap.ui.core.RenderManager} oRm The RenderManager that can be used for writing to the Render-Output-Buffer
	 * @param {sap.ui.core.Control} oDynamicPageHeader An object representation of the control that should be rendered
	 */
	DynamicPageHeaderRenderer.render = function (oRm, oDynamicPageHeader) {
		var oDynamicPageHeaderState = oDynamicPageHeader._getState();

		// Dynamic Page Layout Header Root DOM Element.
		oRm.write("<header");
		oRm.writeControlData(oDynamicPageHeader);
		oRm.writeAccessibilityState({
			role: "region"
		});
		oRm.addClass("sapContrastPlus");
		oRm.addClass("sapFDynamicPageHeader");
		if (oDynamicPageHeaderState.headerHasContent) {
			oRm.addClass("sapFDynamicPageHeaderWithContent");
		}
		if (oDynamicPageHeaderState.headerPinnable) {
			oRm.addClass("sapFDynamicPageHeaderPinnable");
		}
		oRm.writeClasses();
		oRm.write(">");

		// Header Content
		this._renderHeaderContent(oRm, oDynamicPageHeaderState);

		// Collapse button
		oRm.renderControl(oDynamicPageHeaderState.collapseButton);

		oRm.write("</header>");
	};

	DynamicPageHeaderRenderer._renderHeaderContent = function (oRm, oDynamicPageHeaderState) {
		if (oDynamicPageHeaderState.headerHasContent) {
			oRm.write("<div");
			oRm.addClass("sapFDynamicPageHeaderContent");
			oRm.writeClasses();
			oRm.write(">");
			oDynamicPageHeaderState.content.forEach(oRm.renderControl);
			oRm.write("</div>");

			if (oDynamicPageHeaderState.headerPinnable) {
				this._renderPinUnpinArea(oRm, oDynamicPageHeaderState);
			}
		}
	};

	DynamicPageHeaderRenderer._renderPinUnpinArea = function (oRm, oDynamicPageHeaderState) {
		oRm.write("<div");
		oRm.addClass("sapFDynamicPageHeaderPinButtonArea");
		oRm.writeClasses();
		oRm.write(">");
		oRm.renderControl(oDynamicPageHeaderState.pinButton);
		oRm.write("</div>");
	};

	return DynamicPageHeaderRenderer;

}, /* bExport= */ true);