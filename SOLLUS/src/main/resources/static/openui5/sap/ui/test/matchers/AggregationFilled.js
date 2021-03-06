/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global','./Matcher'],function($,M){"use strict";return M.extend("sap.ui.test.matchers.AggregationFilled",{metadata:{publicMethods:["isMatching"],properties:{name:{type:"string"}}},isMatching:function(c){var a=this.getName(),A=c["get"+$.sap.charToUpperCase(a,0)];if(!A){this._oLogger.error("Control '"+c+"' does not have an aggregation called '"+a+"'");return false;}var f=!!A.call(c).length;if(!f){this._oLogger.debug("Control '"+c+"' aggregation '"+a+"' is empty");}return f;}});},true);
