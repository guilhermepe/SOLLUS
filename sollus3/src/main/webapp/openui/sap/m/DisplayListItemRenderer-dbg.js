/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */

sap.ui.define(['./ListItemBaseRenderer', 'sap/ui/core/Renderer', 'sap/ui/core/library'],
	function(ListItemBaseRenderer, Renderer, coreLibrary) {
	"use strict";


	// shortcut for sap.ui.core.TextDirection
	var TextDirection = coreLibrary.TextDirection;


	/**
	 * DisplayListItem renderer.
	 * @namespace
	 */
	var DisplayListItemRenderer = Renderer.extend(ListItemBaseRenderer);

	/**
	 * Renders the HTML for the given control, using the provided
	 * {@link sap.ui.core.RenderManager}.
	 *
	 * @param {sap.ui.core.RenderManager}
	 *          oRenderManager the RenderManager that can be used for writing to the
	 *          Render-Output-Buffer
	 * @param {sap.ui.core.Control}
	 *          oControl an object representation of the control that should be
	 *          rendered
	 */
	DisplayListItemRenderer.renderLIAttributes = function(rm, oLI) {
		rm.addClass("sapMDLI");
	};

	DisplayListItemRenderer.renderLIContent = function(rm, oLI) {

		var isLabel = oLI.getLabel();

		// List item label
		if (isLabel) {
			rm.write("<label for='" + oLI.getId() + "-value' class='sapMDLILabel'>");
			rm.writeEscaped(oLI.getLabel());
			rm.write("</label>");
		}

		var isValue = oLI.getValue();
		var sValueTextDir = oLI.getValueTextDirection();

		// List item value
		if (isValue) {
			rm.write("<div id='" + oLI.getId() + "-value' class='sapMDLIValue'");

			if (sValueTextDir != TextDirection.Inherit) {
				rm.writeAttribute("dir", sValueTextDir.toLowerCase());
			}

			rm.write(">");
			rm.writeEscaped(oLI.getValue());
			rm.write("</div>");
		}
	};


	return DisplayListItemRenderer;

}, /* bExport= */ true);
