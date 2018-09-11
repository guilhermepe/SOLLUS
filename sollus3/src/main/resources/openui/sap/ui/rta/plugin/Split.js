/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['sap/ui/rta/plugin/Plugin','sap/ui/dt/OverlayRegistry','sap/ui/rta/Utils','sap/ui/fl/Utils'],function(P,O,U,F){"use strict";var S=P.extend("sap.ui.rta.plugin.Split",{metadata:{library:"sap.ui.rta",properties:{},associations:{},events:{}}});S.prototype._isEditable=function(o){var s=this.getAction(o);if(s&&s.changeType&&s.changeOnRelevantContainer){return this.hasStableId(o)&&this.hasChangeHandler(s.changeType,o.getRelevantContainer());}else{return false;}};S.prototype.isAvailable=function(o){if(!this._isEditableByPlugin(o)){return false;}var s=this.getSelectedOverlays();if(s.length!==1){return false;}var v=this.getAction(o);var e=s[0].getElement();if(v&&v.getControlsCount(e)<=1){return false;}return true;};S.prototype.isEnabled=function(o){var a=this.getAction(o);if(!a||!this.isAvailable(o)){return false;}var A=true;if(typeof a.isEnabled!=="undefined"){if(typeof a.isEnabled==="function"){A=a.isEnabled(o.getElement());}else{A=a.isEnabled;}}return A;};S.prototype.handleSplit=function(s){var p=s.getParent();var e=O.getOverlay(s);var d=e.getDesignTimeMetadata();var f=this.getAction(e).getControlsCount(s);var v=F.getViewForControl(s);var n=[];for(var i=0;i<f-1;i++){n.push(v.createId(jQuery.sap.uid()));}var o=this.getAction(e);var V=this.getVariantManagementReference(e,o);var a=this.getCommandFactory().getCommandFor(s,"split",{newElementIds:n,source:s,parentElement:p},d,V);this.fireElementModified({"command":a});};S.prototype.getMenuItems=function(o){return this._getMenuItems(o,{pluginId:"CTX_UNGROUP_FIELDS",rank:100});};S.prototype.getActionName=function(){return"split";};S.prototype.handler=function(o,p){this.handleSplit(p.contextElement);};return S;},true);
