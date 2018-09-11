/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global'],function(q){"use strict";var t;var l={};var a=null;var L=["sap.ui.demokit","sap.ui.documentation"];var b=["themelib_"];function g(){if(l["index"]){return Promise.resolve(l["index"]);}return new Promise(function(r,j){q.ajax({async:true,url:"./docs/api/api-index.json",dataType:'json',success:function(R){var k=R.symbols||[];l["index"]=k;r(k);},error:function(){q.sap.log.error("failed to load api-index.json");l["index"]=[];r([]);}});});}function c(){if(l["deprecated"]){return Promise.resolve(l["deprecated"]);}return new Promise(function(r,j){q.ajax({async:true,url:"./docs/api/api-index-deprecated.json",dataType:'json',success:function(R){l["deprecated"]=R;r(R);},error:function(){j();}});});}function d(){if(l["experimental"]){return Promise.resolve(l["experimental"]);}return new Promise(function(r,j){q.ajax({async:true,url:"./docs/api/api-index-experimental.json",dataType:'json',success:function(R){l["experimental"]=R;r(R);},error:function(){j();}});});}function e(j){var r=[];if(!j){return r;}if(l[j]){return l[j];}q.ajax({async:false,url:t+j.replace(/\./g,'/')+'/designtime/apiref/api.json',dataType:'json',success:function(R){r=R.symbols;},error:function(){r=[];q.sap.log.error("failed to load api.json for: "+j);}});l[j]=r;return r;}function f(j){if(!j){return Promise.resolve([]);}if(l[j]){return Promise.resolve(l[j]);}return new Promise(function(r){q.ajax({async:true,url:t+j.replace(/\./g,'/')+'/designtime/apiref/api.json',dataType:'json',success:function(R){var k=R.symbols||[];l[j]=k;r(k);},error:function(k){q.sap.log.error("failed to load api.json for: "+j);l[j]=[];r([]);}});});}function i(o){var I=L.indexOf(o.name)!==-1;var S=b.some(function(p){return o.name.indexOf(p)===0;});return!I&&!S;}function h(j){if(a){return a;}j=j||sap.ui.getVersionInfo().libraries||[];j=j.filter(i);var p=j.map(function(o){return f(o.name);});a=Promise.all(p);return a;}function s(r){r=r==null?q.sap.getModulePath('','/')+'../test-resources/':r;if(r.slice(-1)!='/'){r+='/';}t=r;}s();return{_setRoot:s,getIndexJsonPromise:g,getDeprecatedPromise:c,getExperimentalPromise:d,getLibraryElementsJSONSync:e,getLibraryElementsJSONPromise:f,getAllLibrariesElementsJSONPromise:h};});
