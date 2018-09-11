/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["jquery.sap.global","sap/ui/documentation/sdk/controller/BaseController","sap/ui/model/json/JSONModel","sap/ui/documentation/sdk/controller/util/JSDocUtil","sap/ui/documentation/sdk/controller/util/APIInfo"],function(q,B,J,a,A){"use strict";return B.extend("sap.ui.documentation.sdk.controller.ApiDetailDeprecatedExperimental",{onInit:function(){this.setModel(new J(),"deprecatedAPIs");this.setModel(new J(),"experimentalAPIs");this.getRouter().getRoute("deprecated").attachPatternMatched(this._onTopicDeprecatedMatched,this);this.getRouter().getRoute("experimental").attachPatternMatched(this._onTopicExperimentalMatched,this);this._currentMedia=this.getView()._getCurrentMediaContainerRange();this._hasMatched=false;},onBeforeRendering:function(){this.getView()._detachMediaContainerWidthChange(this._resizeMessageStrip,this);},onAfterRendering:function(){this._resizeMessageStrip();this.getView()._attachMediaContainerWidthChange(this._resizeMessageStrip,this);},onExit:function(){this.getView()._detachMediaContainerWidthChange(this._resizeMessageStrip,this);},_onTopicDeprecatedMatched:function(e){if(this._hasMatched){return;}this._hasMatched=true;this.getView().byId("deprecatedList").attachUpdateFinished(this._modifyLinks,this);A.getDeprecatedPromise().then(function(d){this.getModel("deprecatedAPIs").setData(d);q.sap.delayedCall(0,this,this._prettify);}.bind(this));},_onTopicExperimentalMatched:function(e){if(this._hasMatched){return;}this._hasMatched=true;this.getView().byId("experimentalList").attachUpdateFinished(this._modifyLinks,this);A.getExperimentalPromise().then(function(d){this.getModel("experimentalAPIs").setData(d);q.sap.delayedCall(0,this,this._prettify);}.bind(this));},_prettify:function(){q('pre').addClass('prettyprint');window.prettyPrint();},compareVersions:function(v,b){var w="WITHOUT VERSION";if(v===w||!v){return-1;}if(b===w||!b){return 1;}var c=v.split(".");var d=b.split(".");var e=parseInt(c[0],10);var f=parseInt(c[1],10);var g=parseInt(d[0],10);var h=parseInt(d[1],10);if(e>g||(e===g&&f>h)){return-1;}if(g>e||(g===e&&h>f)){return 1;}return 0;},formatTitle:function(t){return t?"As of "+t:"Version N/A";},formatDescription:function(t,s){if(s){t="As of version "+s+", "+t;}t=this.formatLinks(t);t=t.replace("<p>",'');t=t.replace("</p>",'');return t;},formatSenderLink:function(c,e,E){if(E==="methods"){return c+"#"+e;}if(E==="events"){return c+"#events:"+e;}if(E==="class"){return c;}return"";},formatLinks:function(t){return a.formatTextBlock(t,{linkFormatter:function(b,c){var h;if(b.match("://")){return'<a target="_blank" href="'+b+'">'+(c||b)+'</a>';}b=b.trim().replace(/\.prototype\./g,"#");h=b.indexOf("#");c=c||b;if(h<0){var l=b.lastIndexOf("."),C=b.substring(0,l),m=b.substring(l+1),d=m;if(d){if(d.static===true){b=C+'/methods/'+C+'.'+m;}else{b=C+'/methods/'+m;}}}if(h===0){return"<code>"+b.slice(1)+"</code>";}if(h>0){b=b.slice(0,h)+'/methods/'+b.slice(h+1);}return"<a class=\"jsdoclink\" href=\"#/api/"+b+"\" target=\"_self\">"+c+"</a>";}});},_resizeMessageStrip:function(m){var v=this.getView();m=m||v._getCurrentMediaContainerRange();var n=m.name,M=this.byId("deprecatedAPIStripContainer")||this.byId("experimentalAPIStripContainer");if(!M){return;}if(n==="Desktop"||n==="LargeDesktop"){M.setWidth("calc(100% - 3rem)");}else if(n==="Tablet"||n==="Phone"){M.setWidth("calc(100% - 2rem)");}},_modifyLinks:function(e){var i=e.getSource().getItems(),l=i.length,I;while(l--){I=i[l];if(I._getLinkSender){var c=I.getCustomData(),C=c[0].getValue(),E=c[1].getValue(),s=c[2].getValue(),h;if(c[3].getValue()){E=C+"."+E;}h="#/api/"+C;if(s!=="class"){h+="/"+s+"/"+E;}I._getLinkSender().setHref(h);}}}});});
