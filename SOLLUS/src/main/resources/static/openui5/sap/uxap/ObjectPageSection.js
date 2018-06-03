/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["sap/ui/core/InvisibleText","./ObjectPageSectionBase","sap/ui/Device","sap/m/Button","sap/ui/core/StashedControlSupport","./ObjectPageSubSection","./library","sap/m/library","./ObjectPageSectionRenderer"],function(I,O,D,B,S,a,l,m,b){"use strict";var c=m.ButtonType;var d=O.extend("sap.uxap.ObjectPageSection",{metadata:{library:"sap.uxap",properties:{showTitle:{type:"boolean",group:"Appearance",defaultValue:true},titleUppercase:{type:"boolean",group:"Appearance",defaultValue:true}},defaultAggregation:"subSections",aggregations:{subSections:{type:"sap.uxap.ObjectPageSubSection",multiple:true,singularName:"subSection"},ariaLabelledBy:{type:"sap.ui.core.InvisibleText",multiple:false,visibility:"hidden"},_showHideAllButton:{type:"sap.m.Button",multiple:false,visibility:"hidden"},_showHideButton:{type:"sap.m.Button",multiple:false,visibility:"hidden"}},associations:{selectedSubSection:{type:"sap.uxap.ObjectPageSubSection",multiple:false}},designtime:"sap/uxap/designtime/ObjectPageSection.designtime"}});d.MEDIA_RANGE=D.media.RANGESETS.SAP_STANDARD;d._getClosestSection=function(s){var o=(typeof s==="string"&&sap.ui.getCore().byId(s))||s;return(o instanceof a)?o.getParent():o;};d.prototype._expandSection=function(){O.prototype._expandSection.call(this)._updateShowHideAllButton(!this._thereAreHiddenSubSections());};d.prototype.init=function(){O.prototype.init.call(this);this._sContainerSelector=".sapUxAPObjectPageSectionContainer";};d.prototype.exit=function(){this._detachMediaContainerWidthChange(this._updateImportance,this);};d.prototype._getImportanceLevelToHide=function(C){var o=this._getObjectPageLayout(),M=C||this._getCurrentMediaContainerRange(),s=o&&o.getShowOnlyHighImportance();return this._determineTheLowestLevelOfImportanceToShow(M.name,s);};d.prototype._updateImportance=function(C){var o=this._getObjectPageLayout(),i=this._getImportanceLevelToHide(C);this.getSubSections().forEach(function(s){s._applyImportanceRules(i);});this._applyImportanceRules(i);this._updateShowHideAllButton(false);if(o&&this.getDomRef()){o._requestAdjustLayout();}};d.prototype._determineTheLowestLevelOfImportanceToShow=function(M,s){if(s||M==="Phone"){return l.Importance.High;}if(M==="Tablet"){return l.Importance.Medium;}return l.Importance.Low;};d.prototype.connectToModels=function(){this.getSubSections().forEach(function(s){s.connectToModels();});};d.prototype._allowPropagationToLoadedViews=function(A){this.getSubSections().forEach(function(s){s._allowPropagationToLoadedViews(A);});};d.prototype.onBeforeRendering=function(){var A="ariaLabelledBy";if(!this.getAggregation(A)){this.setAggregation(A,this._getAriaLabelledBy(),true);}this._detachMediaContainerWidthChange(this._updateImportance,this);this._updateImportance();};d.prototype.onAfterRendering=function(){this._attachMediaContainerWidthChange(this._updateImportance,this);};d.prototype._getAriaLabelledBy=function(){return new I({text:this._getTitle()}).toStatic();};d.prototype._isTitleVisible=function(){return this.getShowTitle()&&this._getInternalTitleVisible();};d.prototype._setSubSectionsFocusValues=function(){var s=this.getSubSections()||[],L=this.getSelectedSubSection(),p;if(s.length===0){return this;}if(s.length===1){s[0]._setToFocusable(false);return this;}s.forEach(function(o){if(L===o.sId){o._setToFocusable(true);p=true;}else{o._setToFocusable(false);}});if(!p){s[0]._setToFocusable(true);}return this;};d.prototype._disableSubSectionsFocus=function(){var s=this.getSubSections()||[];s.forEach(function(o){o._setToFocusable(false);});return this;};d.prototype._thereAreHiddenSubSections=function(){return this.getSubSections().some(function(s){return s._getIsHidden();});};d.prototype._updateShowHideSubSections=function(h){this.getSubSections().forEach(function(s){if(h&&s._shouldBeHidden()){s._updateShowHideState(true);}else if(!h){s._updateShowHideState(false);}});};d.prototype._getShouldDisplayShowHideAllButton=function(){return this.getSubSections().some(function(s){return s._shouldBeHidden();});};d.prototype._showHideContentAllContent=function(){var s=this._thereAreHiddenSubSections();if(this._getIsHidden()&&s){this._updateShowHideState(false);}this._updateShowHideSubSections(!s);this._updateShowHideAllButton(s);};d.prototype._updateShowHideState=function(h){this._updateShowHideButton(h);this._getShowHideAllButton().setVisible(this._getShouldDisplayShowHideAllButton());return O.prototype._updateShowHideState.call(this,h);};d.prototype._updateShowHideAllButton=function(h){this._getShowHideAllButton().setVisible(this._getShouldDisplayShowHideAllButton()).setText(this._getShowHideAllButtonText(h));};d.prototype._getShowHideAllButton=function(){if(!this.getAggregation("_showHideAllButton")){this.setAggregation("_showHideAllButton",new B({visible:this._getShouldDisplayShowHideAllButton(),text:this._getShowHideAllButtonText(!this._thereAreHiddenSubSections()),press:this._showHideContentAllContent.bind(this),type:c.Transparent}).addStyleClass("sapUxAPSectionShowHideButton"),true);}return this.getAggregation("_showHideAllButton");};d.prototype._getShowHideButtonText=function(h){return l.i18nModel.getResourceBundle().getText(h?"HIDE":"SHOW");};d.prototype._getShowHideAllButtonText=function(h){return l.i18nModel.getResourceBundle().getText(h?"HIDE_ALL":"SHOW_ALL");};d.prototype._updateShowHideButton=function(h){this._getShowHideButton().setVisible(this._shouldBeHidden()).setText(this._getShowHideButtonText(!h));};d.prototype._getShowHideButton=function(){if(!this.getAggregation("_showHideButton")){this.setAggregation("_showHideButton",new B({visible:this._shouldBeHidden(),text:this._getShowHideButtonText(!this._getIsHidden()),press:this._showHideContent.bind(this),type:c.Transparent}).addStyleClass("sapUxAPSectionShowHideButton"),true);}return this.getAggregation("_showHideButton");};S.mixInto(d);return d;});
