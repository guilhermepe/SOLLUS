/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["sap/ui/core/InvisibleText","sap/ui/Device","sap/m/library"],function(I,D,m){"use strict";var F={};F.render=function(r,c){var b=c.getBackgroundDesign();r.write("<div");r.writeControlData(c);r.addClass("sapFFCL");if(b!==m.BackgroundDesign.Transparent){r.addClass("sapFFCLBackgroundDesign"+b);}r.writeClasses();r.write(">");F.renderBeginColumn(r,c);F.renderMidColumn(r,c);F.renderEndColumn(r,c);r.write("</div>");};F.renderBeginColumn=function(r,c){var b=c.getAggregation("_beginColumnBackArrow");r.write("<div");r.writeAttribute("id",c.getId()+"-beginColumn");r.writeAccessibilityState(c,{role:"region",labelledBy:I.getStaticId("sap.f","FCL_BEGIN_COLUMN_REGION_TEXT")});r.addClass("sapFFCLColumn").addClass("sapFFCLColumnBegin").addClass("sapFFCLColumnActive");r.writeClasses();r.writeStyles();r.write(">");F.renderColumnContentWrapper(r);F.renderArrow(r,b);r.write("</div>");};F.renderMidColumn=function(r,c){var M=c.getAggregation("_midColumnForwardArrow"),o=c.getAggregation("_midColumnBackArrow");r.write("<div");r.writeAttribute("id",c.getId()+"-midColumn");r.writeAccessibilityState(c,{role:"region",labelledBy:I.getStaticId("sap.f","FCL_MID_COLUMN_REGION_TEXT")});r.addClass("sapFFCLColumn").addClass("sapFFCLColumnMid");r.writeClasses();r.writeStyles();r.write(">");F.renderArrow(r,M);F.renderColumnContentWrapper(r);F.renderArrow(r,o);r.write("</div>");};F.renderEndColumn=function(r,c){var e=c.getAggregation("_endColumnForwardArrow");r.write("<div");r.writeAttribute("id",c.getId()+"-endColumn");r.writeAccessibilityState(c,{role:"region",labelledBy:I.getStaticId("sap.f","FCL_END_COLUMN_REGION_TEXT")});r.addClass("sapFFCLColumn").addClass("sapFFCLColumnEnd");r.writeClasses();r.writeStyles();r.write(">");F.renderArrow(r,e);F.renderColumnContentWrapper(r);r.write("</div>");};F.renderArrow=function(r,a){if(!D.system.phone){a.addStyleClass("sapContrastPlus");r.renderControl(a);}};F.renderColumnContentWrapper=function(r){r.write("<div");r.addClass("sapFFCLColumnContent");r.writeClasses();r.write("></div>");};return F;},true);
