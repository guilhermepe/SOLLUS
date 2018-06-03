/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.predefine('sap/ui/support/library',["sap/ui/core/library"],function(l){"use strict";sap.ui.getCore().initLibrary({name:"sap.ui.support",dependencies:["sap.ui.core"],types:["sap.ui.support.Severity"],interfaces:[],controls:[],elements:[],noLibraryCSS:true,version:"1.54.6",extensions:{"sap.ui.support":{internalRules:true}}});sap.ui.support.Severity={Medium:"Medium",High:"High",Low:"Low"};sap.ui.support.Audiences={Control:"Control",Internal:"Internal",Application:"Application"};sap.ui.support.Categories={Accessibility:"Accessibility",Performance:"Performance",Memory:"Memory",Bindings:"Bindings",Consistency:"Consistency",Functionality:"Functionality",Usability:"Usability",DataModel:"DataModel",Usage:"Usage",Other:"Other"};return sap.ui.support;});
jQuery.sap.registerPreloadedModules({
"name":"sap/ui/support/library-h2-preload",
"version":"2.0",
"modules":{
	"sap/ui/support/manifest.json":'{"_version":"1.9.0","sap.app":{"id":"sap.ui.support","type":"library","embeds":[],"applicationVersion":{"version":"1.54.6"},"title":"UI5 library: sap.ui.support","description":"UI5 library: sap.ui.support","resources":"resources.json","offline":true},"sap.ui":{"technology":"UI5","supportedThemes":[]},"sap.ui5":{"dependencies":{"minUI5Version":"1.54","libs":{"sap.ui.core":{"minVersion":"1.54.6"}}},"library":{"i18n":false,"css":false,"content":{"controls":[],"elements":[],"types":["sap.ui.support.Severity"],"interfaces":[]}}}}'
}});
/* Bundle format 'h2' not supported (requires ui5loader)
"sap/ui/support/Bootstrap.js":["jquery.sap.global.js"],
"sap/ui/support/library.js":["sap/ui/core/library.js"],
"sap/ui/support/supportRules/Analyzer.js":["jquery.sap.global.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/IssueManager.js"],
"sap/ui/support/supportRules/ExecutionScope.js":["jquery.sap.global.js"],
"sap/ui/support/supportRules/IssueManager.js":["jquery.sap.global.js","sap/ui/base/Object.js","sap/ui/support/supportRules/Constants.js"],
"sap/ui/support/supportRules/Main.js":["jquery.sap.global.js","sap/ui/base/ManagedObject.js","sap/ui/model/json/JSONModel.js","sap/ui/support/supportRules/Analyzer.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/CoreFacade.js","sap/ui/support/supportRules/ExecutionScope.js","sap/ui/support/supportRules/IssueManager.js","sap/ui/support/supportRules/RuleSerializer.js","sap/ui/support/supportRules/RuleSet.js","sap/ui/support/supportRules/RuleSetLoader.js","sap/ui/support/supportRules/WCBChannels.js","sap/ui/support/supportRules/WindowCommunicationBus.js","sap/ui/support/supportRules/report/AnalysisHistoryFormatter.js","sap/ui/support/supportRules/report/DataCollector.js","sap/ui/support/supportRules/ui/external/Highlighter.js"],
"sap/ui/support/supportRules/RuleSet.js":["jquery.sap.global.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/Storage.js"],
"sap/ui/support/supportRules/RuleSetLoader.js":["jquery.sap.global.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/RuleSerializer.js","sap/ui/support/supportRules/RuleSet.js","sap/ui/support/supportRules/WCBChannels.js","sap/ui/support/supportRules/WindowCommunicationBus.js","sap/ui/support/supportRules/util/Utils.js"],
"sap/ui/support/supportRules/Storage.js":["sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/RuleSerializer.js"],
"sap/ui/support/supportRules/WindowCommunicationBus.js":["jquery.sap.global.js"],
"sap/ui/support/supportRules/report/Archiver.js":["jquery.sap.global.js","sap/ui/core/util/File.js","sap/ui/thirdparty/jszip.js"],
"sap/ui/support/supportRules/report/DataCollector.js":["jquery.sap.global.js","sap/ui/core/support/ToolsAPI.js","sap/ui/thirdparty/URI.js"],
"sap/ui/support/supportRules/report/IssueRenderer.js":["jquery.sap.global.js"],
"sap/ui/support/supportRules/report/ReportProvider.js":["jquery.sap.global.js","sap/ui/support/supportRules/report/Archiver.js","sap/ui/support/supportRules/report/IssueRenderer.js","sap/ui/thirdparty/handlebars.js"],
"sap/ui/support/supportRules/ui/IFrameController.js":["jquery.sap.global.js","sap/ui/base/ManagedObject.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/WCBChannels.js","sap/ui/support/supportRules/WindowCommunicationBus.js"],
"sap/ui/support/supportRules/ui/controllers/Analysis.controller.js":["jquery.sap.global.js","sap/m/Button.js","sap/m/InputListItem.js","sap/m/Label.js","sap/m/List.js","sap/m/ListItemBase.js","sap/m/MessageToast.js","sap/m/Panel.js","sap/m/StandardListItem.js","sap/m/Toolbar.js","sap/m/ToolbarSpacer.js","sap/ui/model/json/JSONModel.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/RuleSerializer.js","sap/ui/support/supportRules/RuleSet.js","sap/ui/support/supportRules/Storage.js","sap/ui/support/supportRules/WCBChannels.js","sap/ui/support/supportRules/WindowCommunicationBus.js","sap/ui/support/supportRules/ui/controllers/BaseController.js","sap/ui/support/supportRules/ui/models/SharedModel.js"],
"sap/ui/support/supportRules/ui/controllers/BaseController.js":["sap/ui/core/mvc/Controller.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/Storage.js"],
"sap/ui/support/supportRules/ui/controllers/Issues.controller.js":["jquery.sap.global.js","sap/m/OverflowToolbarAssociativePopoverControls.js","sap/ui/model/json/JSONModel.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/IssueManager.js","sap/ui/support/supportRules/WCBChannels.js","sap/ui/support/supportRules/WindowCommunicationBus.js","sap/ui/support/supportRules/ui/controllers/BaseController.js","sap/ui/support/supportRules/ui/external/ElementTree.js","sap/ui/support/supportRules/ui/models/SharedModel.js","sap/ui/support/supportRules/ui/models/formatter.js"],
"sap/ui/support/supportRules/ui/controllers/Main.controller.js":["sap/m/library.js","sap/ui/model/json/JSONModel.js","sap/ui/support/supportRules/Constants.js","sap/ui/support/supportRules/Storage.js","sap/ui/support/supportRules/WCBChannels.js","sap/ui/support/supportRules/WindowCommunicationBus.js","sap/ui/support/supportRules/ui/controllers/BaseController.js","sap/ui/support/supportRules/ui/models/SharedModel.js","sap/ui/thirdparty/URI.js"],
"sap/ui/support/supportRules/ui/external/ElementTree.js":["jquery.sap.global.js"],
"sap/ui/support/supportRules/ui/models/SharedModel.js":["sap/ui/model/json/JSONModel.js","sap/ui/support/library.js"],
"sap/ui/support/supportRules/ui/views/Analysis.view.xml":["sap/m/Bar.js","sap/m/Button.js","sap/m/IconTabFilter.js","sap/m/IconTabHeader.js","sap/m/List.js","sap/m/NavContainer.js","sap/m/Page.js","sap/m/StandardListItem.js","sap/m/Text.js","sap/ui/core/mvc/XMLView.js","sap/ui/layout/Splitter.js","sap/ui/layout/VerticalLayout.js","sap/ui/support/supportRules/ui/controllers/Analysis.controller.js"],
"sap/ui/support/supportRules/ui/views/AnalyzeSettings.fragment.xml":["sap/m/CheckBox.js","sap/m/Input.js","sap/m/Popover.js","sap/m/RadioButton.js","sap/m/VBox.js","sap/ui/core/CustomData.js","sap/ui/core/Fragment.js","sap/ui/layout/VerticalLayout.js"],
"sap/ui/support/supportRules/ui/views/Issues.view.xml":["sap/m/Bar.js","sap/m/Button.js","sap/m/FlexBox.js","sap/m/FlexItemData.js","sap/m/FormattedText.js","sap/m/HBox.js","sap/m/Label.js","sap/m/Link.js","sap/m/Menu.js","sap/m/MenuButton.js","sap/m/MenuItem.js","sap/m/OverflowToolbarLayoutData.js","sap/m/Page.js","sap/m/Panel.js","sap/m/Select.js","sap/m/Text.js","sap/m/Title.js","sap/m/Toolbar.js","sap/m/ToolbarSpacer.js","sap/ui/core/HTML.js","sap/ui/core/Icon.js","sap/ui/core/ListItem.js","sap/ui/core/mvc/XMLView.js","sap/ui/layout/Splitter.js","sap/ui/layout/VerticalLayout.js","sap/ui/layout/form/SimpleForm.js","sap/ui/support/supportRules/ui/controllers/Issues.controller.js"],
"sap/ui/support/supportRules/ui/views/Main.view.xml":["sap/m/Bar.js","sap/m/Button.js","sap/m/FlexBox.js","sap/m/FlexItemData.js","sap/m/Image.js","sap/m/NavContainer.js","sap/m/Page.js","sap/m/ProgressIndicator.js","sap/m/Text.js","sap/m/Toolbar.js","sap/ui/core/Icon.js","sap/ui/core/mvc/XMLView.js","sap/ui/layout/FixFlex.js","sap/ui/support/supportRules/ui/controllers/Main.controller.js","sap/ui/support/supportRules/ui/views/Analysis.view.xml"],
"sap/ui/support/supportRules/ui/views/RuleDetails.fragment.xml":["sap/m/Bar.js","sap/m/IconTabFilter.js","sap/m/IconTabHeader.js","sap/m/Label.js","sap/m/Link.js","sap/m/Page.js","sap/m/Panel.js","sap/m/Text.js","sap/m/Title.js","sap/ui/codeeditor/CodeEditor.js","sap/ui/core/Fragment.js","sap/ui/layout/SplitterLayoutData.js","sap/ui/layout/VerticalLayout.js","sap/ui/layout/form/SimpleForm.js"],
"sap/ui/support/supportRules/ui/views/RuleUpdate.fragment.xml":["sap/m/Bar.js","sap/m/Button.js","sap/m/FlexItemData.js","sap/m/HBox.js","sap/m/IconTabFilter.js","sap/m/IconTabHeader.js","sap/m/Input.js","sap/m/Label.js","sap/m/Link.js","sap/m/MultiComboBox.js","sap/m/Page.js","sap/m/Panel.js","sap/m/RadioButton.js","sap/m/Text.js","sap/m/TextArea.js","sap/ui/codeeditor/CodeEditor.js","sap/ui/core/CustomData.js","sap/ui/core/Fragment.js","sap/ui/core/Icon.js","sap/ui/core/Item.js","sap/ui/layout/HorizontalLayout.js","sap/ui/layout/VerticalLayout.js","sap/ui/layout/form/SimpleForm.js"],
"sap/ui/support/supportRules/ui/views/StorageSettings.fragment.xml":["sap/m/Button.js","sap/m/CheckBox.js","sap/m/FlexBox.js","sap/m/Link.js","sap/m/Popover.js","sap/m/Text.js","sap/ui/core/Fragment.js","sap/ui/layout/HorizontalLayout.js","sap/ui/layout/VerticalLayout.js"]
*/
//# sourceMappingURL=library-h2-preload.js.map