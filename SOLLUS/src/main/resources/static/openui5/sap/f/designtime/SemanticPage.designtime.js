/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define([],function(){"use strict";var s=function(c,a){return!(c&&c[a]&&c[a]()&&c[a]().getDomRef());};var i=function(c,a){var C;if(!c){return true;}C=c.$().find("sapFDynamicPageTitleActionsBar");return!!(C.length>0&&c[a]().length>0);};return{aggregations:{titleHeading:{domRef:function(c){return c.getTitleHeading().getDomRef();},ignore:function(c){return s(c,"getTitleHeading");}},titleBreadcrumbs:{domRef:function(c){return c.getTitleBreadcrumbs().getDomRef();},ignore:function(c){return s(c,"getTitleBreadcrumbs");}},titleSnappedContent:{domRef:":sap-domref .sapFDynamicPageTitleMainSnapContentVisible",actions:{move:{changeType:"moveControls"}},ignore:function(c){return!!(!c||c.getTitleSnappedContent().length===0||c.getHeaderExpanded());}},titleExpandedContent:{domRef:":sap-domref .sapFDynamicPageTitleMainExpandContentVisible",actions:{move:{changeType:"moveControls"}},ignore:function(c){return!!(!c||c.getTitleExpandedContent().length===0||!c.getHeaderExpanded());}},titleContent:{domRef:":sap-domref .sapFDynamicPageTitleMain > .sapFDynamicPageTitleMainInner > .sapFDynamicPageTitleMainContent",actions:{move:{changeType:"moveControls"}},ignore:function(c){return!!(!c||c.getTitleContent().length===0);}},titleMainAction:{domRef:function(c){return c.getTitleMainAction().getDomRef();},ignore:function(c){return s(c,"getTitleMainAction");}},editAction:{domRef:function(c){return c.getEditAction().getDomRef();},ignore:function(c){return s(c,"getEditAction");}},addAction:{domRef:function(c){return c.getAddAction().getDomRef();},ignore:function(c){return s(c,"getAddAction");}},deleteAction:{domRef:function(c){return c.getDeleteAction().getDomRef();},ignore:function(c){return s(c,"getDeleteAction");}},copyAction:{domRef:function(c){return c.getCopyAction().getDomRef();},ignore:function(c){return s(c,"getCopyAction");}},flagAction:{domRef:function(c){return c.getFlagAction().getDomRef();},ignore:function(c){return s(c,"getFlagAction");}},favoriteAction:{domRef:function(c){return c.getFavoriteAction().getDomRef();},ignore:function(c){return s(c,"getFavoriteAction");}},fullScreenAction:{domRef:function(c){return c.getFullScreenAction().getDomRef();},ignore:function(c){return s(c,"getFullScreenAction");}},exitFullScreenAction:{domRef:function(c){return c.getExitFullScreenAction().getDomRef();},ignore:function(c){return s(c,"getExitFullScreenAction");}},closeAction:{domRef:function(c){return c.getCloseAction().getDomRef();},ignore:function(c){return s(c,"getCloseAction");}},titleCustomTextActions:{domRef:":sap-domref .sapFDynamicPageTitleActionsBar",ignore:function(c){return i(c,"getTitleCustomTextActions");}},titleCustomIconActions:{domRef:":sap-domref .sapFDynamicPageTitleActionsBar",ignore:function(c){return i(c,"getTitleCustomIconActions");}},headerContent:{domRef:":sap-domref .sapFDynamicPageHeaderContent",actions:{move:{changeType:"moveControls"}},ignore:function(c){return!(c&&c.getHeaderContent().length>0);}},content:{domRef:":sap-domref .sapFDynamicPageContent",ignore:function(c){return s(c,"getContent");}},footerMainAction:{domRef:function(c){return c.getFooterMainAction().getDomRef();},ignore:function(c){return s(c,"getFooterMainAction");}},messagesIndicator:{domRef:function(c){return c.getMessagesIndicator().getDomRef();},ignore:function(c){return s(c,"getMessagesIndicator");}},draftIndicator:{domRef:function(c){return c.getDraftIndicator().getDomRef();},ignore:function(c){return s(c,"getDraftIndicator");}},positiveAction:{domRef:function(c){return c.getPositiveAction().getDomRef();},ignore:function(c){return s(c,"getPositiveAction");}},negativeAction:{domRef:function(c){return c.getNegativeAction().getDomRef();},ignore:function(c){return s(c,"getNegativeAction");}},footerCustomActions:{domRef:":sap-domref .sapFDynamicPageActualFooterControl",ignore:function(c){return!(c&&c.getFooterCustomActions()&&c.getFooterCustomActions().length>0);}},discussInJamAction:{domRef:function(c){return c.getDiscussInJamAction().getDomRef();},ignore:function(c){return s(c,"getDiscussInJamAction");}},saveAsTileAction:{domRef:function(c){return c.getSaveAsTileAction().getDomRef();},ignore:function(c){return s(c,"getSaveAsTileAction");}},shareInJamAction:{domRef:function(c){return c.getShareInJamAction().getDomRef();},ignore:function(c){return s(c,"getShareInJamAction");}},sendMessageAction:{domRef:function(c){return c.getSendMessageAction().getDomRef();},ignore:function(c){return s(c,"getSendMessageAction");}},sendEmailAction:{domRef:function(c){return c.getSendEmailAction().getDomRef();},ignore:function(c){return s(c,"getSendEmailAction");}},printAction:{domRef:function(c){return c.getPrintAction().getDomRef();},ignore:function(c){return s(c,"getPrintAction");}},customShareActions:{domRef:function(c){return c._getActionSheet().getDomRef();},ignore:function(c){return s(c,"_getActionSheet");}}},scrollContainers:[{domRef:":sap-domref .sapFDynamicPageContentWrapper",aggregations:["headerContent","content"]},{domRef:function(e){return e.$("vertSB-sb").get(0);}}],templates:{create:"sap/f/designtime/SemanticPage.create.fragment.xml"}};},false);
