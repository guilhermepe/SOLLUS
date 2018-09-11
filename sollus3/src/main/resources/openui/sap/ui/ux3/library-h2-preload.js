/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.predefine('sap/ui/ux3/library',['jquery.sap.global','sap/ui/core/library','sap/ui/commons/library'],function(q){"use strict";sap.ui.getCore().initLibrary({name:"sap.ui.ux3",version:"1.54.6",dependencies:["sap.ui.core","sap.ui.commons"],types:["sap.ui.ux3.ActionBarSocialActions","sap.ui.ux3.ExactOrder","sap.ui.ux3.FeederType","sap.ui.ux3.FollowActionState","sap.ui.ux3.NotificationBarStatus","sap.ui.ux3.ShellDesignType","sap.ui.ux3.ShellHeaderType","sap.ui.ux3.ThingViewerHeaderType","sap.ui.ux3.VisibleItemCountMode"],interfaces:["sap.ui.ux3.DataSetView"],controls:["sap.ui.ux3.ActionBar","sap.ui.ux3.CollectionInspector","sap.ui.ux3.DataSet","sap.ui.ux3.DataSetSimpleView","sap.ui.ux3.Exact","sap.ui.ux3.ExactArea","sap.ui.ux3.ExactBrowser","sap.ui.ux3.ExactList","sap.ui.ux3.FacetFilter","sap.ui.ux3.FacetFilterList","sap.ui.ux3.Feed","sap.ui.ux3.FeedChunk","sap.ui.ux3.Feeder","sap.ui.ux3.NavigationBar","sap.ui.ux3.NotificationBar","sap.ui.ux3.Overlay","sap.ui.ux3.OverlayContainer","sap.ui.ux3.OverlayDialog","sap.ui.ux3.QuickView","sap.ui.ux3.Shell","sap.ui.ux3.ThingInspector","sap.ui.ux3.ThingViewer","sap.ui.ux3.ToolPopup"],elements:["sap.ui.ux3.Collection","sap.ui.ux3.DataSetItem","sap.ui.ux3.ExactAttribute","sap.ui.ux3.NavigationItem","sap.ui.ux3.Notifier","sap.ui.ux3.ThingAction","sap.ui.ux3.ThingGroup"]});sap.ui.ux3.ActionBarSocialActions={Update:"Update",Follow:"Follow",Flag:"Flag",Favorite:"Favorite",Open:"Open"};sap.ui.ux3.ExactOrder={Select:"Select",Fixed:"Fixed"};sap.ui.ux3.FeederType={Large:"Large",Medium:"Medium",Comment:"Comment"};sap.ui.ux3.FollowActionState={Follow:"Follow",Hold:"Hold",Default:"Default"};sap.ui.ux3.NotificationBarStatus={Default:"Default",Min:"Min",Max:"Max",None:"None"};sap.ui.ux3.ShellDesignType={Standard:"Standard",Light:"Light",Crystal:"Crystal"};sap.ui.ux3.ShellHeaderType={Standard:"Standard",BrandOnly:"BrandOnly",NoNavigation:"NoNavigation",SlimNavigation:"SlimNavigation"};sap.ui.ux3.ThingViewerHeaderType={Standard:"Standard",Horizontal:"Horizontal"};sap.ui.ux3.VisibleItemCountMode={Fixed:"Fixed",Auto:"Auto"};return sap.ui.ux3;});jQuery.sap.registerPreloadedModules({"name":"sap/ui/ux3/library-h2-preload","version":"2.0","modules":{"sap/ui/ux3/manifest.json":'{"_version":"1.9.0","sap.app":{"id":"sap.ui.ux3","type":"library","embeds":[],"applicationVersion":{"version":"1.54.6"},"title":"Controls that implement the SAP User Experience (UX) Guidelines 3.0","description":"Controls that implement the SAP User Experience (UX) Guidelines 3.0","ach":"CA-UI5-CTR","resources":"resources.json","offline":true},"sap.ui":{"technology":"UI5","supportedThemes":["base","sap_hcb"]},"sap.ui5":{"dependencies":{"minUI5Version":"1.54","libs":{"sap.ui.core":{"minVersion":"1.54.6"},"sap.ui.commons":{"minVersion":"1.54.6"}}},"library":{"i18n":"messagebundle.properties","content":{"controls":["sap.ui.ux3.ActionBar","sap.ui.ux3.CollectionInspector","sap.ui.ux3.DataSet","sap.ui.ux3.DataSetSimpleView","sap.ui.ux3.Exact","sap.ui.ux3.ExactArea","sap.ui.ux3.ExactBrowser","sap.ui.ux3.ExactList","sap.ui.ux3.FacetFilter","sap.ui.ux3.FacetFilterList","sap.ui.ux3.Feed","sap.ui.ux3.FeedChunk","sap.ui.ux3.Feeder","sap.ui.ux3.NavigationBar","sap.ui.ux3.NotificationBar","sap.ui.ux3.Overlay","sap.ui.ux3.OverlayContainer","sap.ui.ux3.OverlayDialog","sap.ui.ux3.QuickView","sap.ui.ux3.Shell","sap.ui.ux3.ThingInspector","sap.ui.ux3.ThingViewer","sap.ui.ux3.ToolPopup"],"elements":["sap.ui.ux3.Collection","sap.ui.ux3.DataSetItem","sap.ui.ux3.ExactAttribute","sap.ui.ux3.NavigationItem","sap.ui.ux3.Notifier","sap.ui.ux3.ThingAction","sap.ui.ux3.ThingGroup"],"types":["sap.ui.ux3.ActionBarSocialActions","sap.ui.ux3.ExactOrder","sap.ui.ux3.FeederType","sap.ui.ux3.FollowActionState","sap.ui.ux3.NotificationBarStatus","sap.ui.ux3.ShellDesignType","sap.ui.ux3.ShellHeaderType","sap.ui.ux3.ThingViewerHeaderType","sap.ui.ux3.VisibleItemCountMode"],"interfaces":["sap.ui.ux3.DataSetView"]}}}}'}});