sap.ui.define([
	], function () {
		"use strict";

		return {
			/**
			 * @public
			 * @param {boolean} bIsPhone the value to be checked
			 * @returns {string} path to image
			 */
			srcImageValue : function (bIsPhone) {
				var sImageSrc = "";
				if (bIsPhone === false) {
					sImageSrc = "./images/home_image.png";
				} else {
					sImageSrc = "./images/home_image_small.png";
				}
				return sImageSrc;
			}
		};
	}
);