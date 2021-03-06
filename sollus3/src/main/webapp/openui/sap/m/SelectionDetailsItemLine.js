/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["sap/ui/core/Element"],function(E){"use strict";var S=E.extend("sap.m.SelectionDetailsItemLine",{metadata:{library:"sap.m",properties:{label:{type:"string",group:"Data"},value:{type:"any",group:"Data"},displayValue:{type:"string",defaultValue:null,group:"Data"},unit:{type:"string",defaultValue:null,group:"Data"},lineMarker:{type:"string",defaultValue:null,group:"Data"}}}});S.prototype._getValueToRender=function(){var v="",V=this.getValue();if(jQuery.type(V)==="string"){v=V;}else if(jQuery.isPlainObject(V)){if(V.day&&V.day.length>0){v=V.day;}if(V.time&&V.time.length>0){v=(v.length>0)?V.time+" "+v:V.time;}}return v;};return S;});
