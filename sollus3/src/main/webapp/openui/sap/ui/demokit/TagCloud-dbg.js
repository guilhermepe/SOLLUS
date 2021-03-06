/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */

// Provides control sap.ui.demokit.TagCloud.
sap.ui.define(['sap/ui/core/Control', './library', "./TagCloudRenderer"],
	function(Control, library, TagCloudRenderer) {
	"use strict";



	/**
	 * Constructor for a new TagCloud.
	 *
	 * @param {string} [sId] id for the new control, generated automatically if no id is given
	 * @param {object} [mSettings] initial settings for the new control
	 *
	 * @class
	 * A simple TagCloud representing a set of weighted tags
	 * @extends sap.ui.core.Control
	 * @version 1.54.6
	 *
	 * @constructor
	 * @private
	 * @sap-restricted sdk
	 * @alias sap.ui.demokit.TagCloud
	 */
	var TagCloud = Control.extend("sap.ui.demokit.TagCloud", /** @lends sap.ui.demokit.TagCloud.prototype */ { metadata : {

		library : "sap.ui.demokit",
		properties : {

			/**
			 * Maximum font size that may be chosen for a tag in this cloud
			 */
			maxFontSize : {type : "int", group : "Misc", defaultValue : 30},

			/**
			 * Minimum font size that must be used for a tag in this cloud
			 */
			minFontSize : {type : "int", group : "Misc", defaultValue : 10}
		},
		defaultAggregation : "tags",
		aggregations : {

			/**
			 * The tags displayed in this tag cloud
			 */
			tags : {type : "sap.ui.demokit.Tag", multiple : true, singularName : "tag"}
		},
		events : {

			/**
			 * Fired when a Tag is clicked.
			 */
			press : {
				parameters : {

					/**
					 * Id of the selected Tag.
					 */
					tagId : {type : "string"}
				}
			}
		}
	}});

	//Called by a tag when an onclick event is triggered there.
	//The event is forwarded to the application coding.
	TagCloud.prototype.firePressEvent = function(tag){
	  this.firePress({tagId:tag.getId()});
	};


	return TagCloud;

});
