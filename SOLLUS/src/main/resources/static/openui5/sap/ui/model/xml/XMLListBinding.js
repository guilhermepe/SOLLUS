/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global','sap/ui/model/ChangeReason','sap/ui/model/ClientListBinding'],function(q,C,a){"use strict";var X=a.extend("sap.ui.model.xml.XMLListBinding");X.prototype.getContexts=function(s,l){this.iLastStartIndex=s;this.iLastLength=l;if(!s){s=0;}if(!l){l=Math.min(this.iLength,this.oModel.iSizeLimit);}var c=this._getContexts(s,l),b=[];if(this.bUseExtendedChangeDetection){for(var i=0;i<c.length;i++){b.push(this.getContextData(c[i]));}if(this.aLastContexts&&s<this.iLastEndIndex){c.diff=q.sap.arraySymbolDiff(this.aLastContextData,b);}this.iLastEndIndex=s+l;this.aLastContexts=c.slice(0);this.aLastContextData=b.slice(0);}return c;};X.prototype.getCurrentContexts=function(){if(this.bUseExtendedChangeDetection){return this.aLastContexts||[];}else{return this.getContexts(this.iLastStartIndex,this.iLastLength);}};X.prototype.getEntryData=function(c){return q.sap.serializeXML(c.getObject());};X.prototype.update=function(){var l=this.oModel._getObject(this.sPath,this.oContext);if(l){this.oList=[];var t=this;if(this.bUseExtendedChangeDetection){q.each(l,function(k,n){t.oList.push(n.cloneNode(true));});}else{this.oList=l.slice(0);}this.updateIndices();this.applyFilter();this.applySort();this.iLength=this._getLength();}else{this.oList=[];this.aIndices=[];this.iLength=0;}};X.prototype.checkUpdate=function(f){if(this.bSuspended&&!this.bIgnoreSuspend&&!f){return;}if(!this.bUseExtendedChangeDetection){var l=this.oModel._getObject(this.sPath,this.oContext)||[];if(l.length!=this.oList.length||f){this.update();this._fireChange({reason:C.Change});}}else{var c=false;var t=this;var l=this.oModel._getObject(this.sPath,this.oContext)||[];if(this.oList.length!=l.length){c=true;}if(!q.sap.equal(this.oList,l)){this.update();}var b=this._getContexts(this.iLastStartIndex,this.iLastLength);if(this.aLastContexts){if(this.aLastContexts.length!=b.length){c=true;}else{q.each(this.aLastContextData,function(i,L){var o=t.getContextData(b[i]);if(o!==L){c=true;return false;}});}}else{c=true;}if(c||f){this._fireChange({reason:C.Change});}}};return X;});
