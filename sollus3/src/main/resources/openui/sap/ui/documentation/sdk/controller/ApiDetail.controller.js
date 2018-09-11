/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["jquery.sap.global","sap/ui/documentation/sdk/controller/BaseController","sap/ui/model/json/JSONModel","sap/ui/documentation/sdk/controller/util/ControlsInfo","sap/ui/documentation/sdk/util/ToggleFullScreenHandler","sap/ui/documentation/sdk/controller/util/APIInfo","sap/ui/core/library","sap/base/log"],function(q,B,J,C,T,A,a,L){"use strict";var V=a.mvc.ViewType;return B.extend("sap.ui.documentation.sdk.controller.ApiDetail",{NOT_AVAILABLE:'N/A',NOT_FOUND:'Not found',onInit:function(){this.getRouter().getRoute("apiId").attachPatternMatched(this._onTopicMatched,this);this._oModel=new J();this._oModel.setSizeLimit(10000);this._oContainerPage=this.getView().byId("apiDetailPageContainer");},_onTopicMatched:function(e){if(this._oView){this._oView.destroy();this._oContainerPage.setBusy(true);}var c=this.getOwnerComponent();this._sTopicid=e.getParameter("arguments").id;this._sEntityType=e.getParameter("arguments").entityType;this._sEntityId=e.getParameter("arguments").entityId;c.loadVersionInfo().then(c.fetchAPIIndex.bind(c)).then(this._processApiIndexAndLoadApiJson.bind(this)).then(this._findEntityInApiJsonData.bind(this)).then(this._buildBorrowedModel.bind(this)).then(this._createModelAndSubView.bind(this)).then(this._initSubView.bind(this)).catch(function(r){if(r===this.NOT_FOUND){this._oContainerPage.setBusy(false);this.getRouter().myNavToWithoutHash("sap.ui.documentation.sdk.view.NotFound","XML",false);}else if(typeof r==="string"){L.error(r);}else if(r.name){L.error(r.name,r.message);}else if(r.message){L.error(r.message);}}.bind(this));},_initSubView:function(v){var c=v.getController();this._oContainerPage.addContent(v);this._oContainerPage.setBusy(false);c.initiate({sTopicId:this._sTopicid,oModel:this._oModel,aApiIndex:this._aApiIndex,aAllowedMembers:this._aAllowedMembers,oEntityData:this._oEntityData,sEntityType:this._sEntityType,sEntityId:this._sEntityId,oOwnerComponent:this.getOwnerComponent(),oContainerView:this.getView(),oContainerController:this});},_createModelAndSubView:function(b){this._oControlData.borrowed=b;this._bindData(this._sTopicid);this._oView=sap.ui.view({height:"100%",viewName:"sap.ui.documentation.sdk.view.SubApiDetail",type:V.XML,async:true,preprocessors:{xml:{models:{data:this._oModel}}}});return this._oView.loaded();},_buildBorrowedModel:function(c){this._aAllowedMembers=this.getModel("versionData").getProperty("/allowedMembers");this._oControlData=c;return this.buildBorrowedModel(c);},_findEntityInApiJsonData:function(l){var b,i;for(i=0,b=l.length;i<b;i++){if(l[i].name===this._sTopicid){return l[i];}}return Promise.reject(this.NOT_FOUND);},_processApiIndexAndLoadApiJson:function(d){var e,f=false,l,i;this._aApiIndex=d;for(i=0,l=d.length;i<l;i++){if(d[i].name===this._sTopicid||d[i].name.indexOf(this._sTopicid)===0){e=d[i];this._oEntityData=e;f=true;break;}}if(f){return A.getLibraryElementsJSONPromise(e.lib).then(function(d){this._aLibsData=d;return Promise.resolve(d);}.bind(this));}return Promise.reject(this.NOT_FOUND);},_bindData:function(t){var c=this._oControlData,m,u;u=c['ui5-metadata'];c.hasProperties=false;c.hasOwnMethods=false;c.hasControlProperties=false;c.hasAssociations=false;c.hasAggregations=false;c.hasSpecialSettings=false;c.hasAnnotations=false;if(c.properties){c.properties=this.filterElements(c.properties);c.hasProperties=!!c.properties.length;}if(c.methods){c.methods=this.filterElements(c.methods);c.hasOwnMethods=!!c.methods.length;}if(u){if(u.properties){u.properties=this.filterElements(u.properties);c.hasControlProperties=!!u.properties.length;}if(u.associations){u.associations=this.filterElements(u.associations);c.hasAssociations=!!u.associations.length;}if(u.aggregations){u.aggregations=this.filterElements(u.aggregations);c.hasAggregations=!!u.aggregations.length;}if(u.specialSettings){u.specialSettings=this.filterElements(u.specialSettings);c.hasSpecialSettings=!!u.specialSettings.length;}c.hasAnnotations=!!(u.annotations&&u.annotations.length);}c.hasChildren=!!c.nodes;c.hasConstructor=c.hasOwnProperty("constructor")&&!!c.constructor;c.hasOwnEvents=!!c.events;c.hasEvents=!!(c.hasOwnEvents||(c.borrowed&&c.borrowed.events.length>0));c.hasMethods=!!(c.hasOwnMethods||(c.borrowed&&c.borrowed.methods.length>0));if(c.implements&&c.implements.length){c.implementsParsed=c.implements.map(function(i,b,d){var D=i.split("."),s=D[D.length-1];return{href:i,name:s};});c.hasImplementsData=true;}else{c.hasImplementsData=false;}c.isClass=c.kind==="class";c.isDerived=!!c.extends;c.extendsText=c.extends||this.NOT_AVAILABLE;c.sinceText=c.since||this.NOT_AVAILABLE;c.module=c.module||this.NOT_AVAILABLE;this._oModel.setData(c);if(this.extHookbindData){this.extHookbindData(t,m);}},buildBorrowedModel:function(c){var b,d,s,e,m,M,I,r=[],o,i;if(!c){return Promise.resolve({events:[],methods:[]});}e={methods:[],events:[]};s=c.extends;var v=function(f){return this._aAllowedMembers.indexOf(f.visibility)!==-1;}.bind(this);m=c.methods||[];M=m.map(function(f){return f.name;});var O=function(f){return M.indexOf(f.name)===-1;};I=[s];while(s){i=this._aApiIndex.length;while(i--){o=this._aApiIndex[i];if(o.name===s){s=o.extends;if(s){I.push(s);}if(r.indexOf(o.lib)===-1){r.push(o.lib);}break;}}if(i===-1){break;}}var p=r.map(function(l){return A.getLibraryElementsJSONPromise(l);});return Promise.all(p).then(function(R){var f=[];R.forEach(function(S){f=f.concat(S);});I.forEach(function(s){var g,i=f.length;while(i--){if(f[i].name===s){g=f[i];break;}}var h=function(j){return{name:j.name,link:"#/api/"+s+"/methods/"+j.name};};var E=function(j){return{name:j.name,link:"#/api/"+s+"/events/"+j.name};};if(g){b=(g.methods||[]).filter(v).filter(O).map(h);if(b.length){e.methods.push({name:s,methods:b});}d=(g.events||[]).filter(v).map(E);if(d.length){e.events.push({name:s,events:d});}}});return e;});},filterElements:function(e){var i,l=e.length,n=[],E;for(i=0;i<l;i++){E=e[i];if(this._aAllowedMembers.indexOf(E.visibility)>=0){n.push(E);}}return n;}});});
