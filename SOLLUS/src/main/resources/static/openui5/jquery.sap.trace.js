/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global','sap/ui/thirdparty/URI','sap/ui/Device','sap/ui/performance/E2ETrace/Passport','sap/ui/performance/Interaction','sap/ui/performance/FESR','sap/ui/Global'],function(q,U,D,P,I,F){"use strict";function l(){if(!(window.performance&&window.performance.getEntries)){q.sap.log.warning("Interaction tracking is not supported on browsers with insufficient performance API");}}q.sap.interaction={};q.sap.interaction.setActive=function(){l();I.setActive.apply(this,arguments);};q.sap.interaction.getActive=I.getActive;q.sap.interaction.notifyStepStart=I.notifyStepStart;q.sap.interaction.notifyStepEnd=I.notifyStepEnd;q.sap.interaction.notifyEventStart=I.notifyEventStart;q.sap.interaction.notifyScrollEvent=I.notifyScrollEvent;q.sap.interaction.notifyEventEnd=I.notifyEventEnd;q.sap.interaction.setStepComponent=I.setStepComponent;q.sap.fesr={};q.sap.fesr.setActive=function(){l();F.setActive.apply(this,arguments);};q.sap.fesr.getActive=F.getActive;q.sap.fesr.getCurrentTransactionId=P.getTransactionId;q.sap.fesr.getRootId=P.getRootId;q.sap.fesr.addBusyDuration=I.addBusyDuration;q.sap.passport={};q.sap.passport.setActive=P.setActive;q.sap.passport.traceFlags=P.traceFlags;function g(){var a=!!document.querySelector("meta[name=sap-ui-fesr][content=true]"),p=window.location.search.match(/[\?|&]sap-ui-(?:xx-)?fesr=(true|x|X|false)&?/);if(p){a=p[1]&&p[1]!="false";}return a;}q.sap.interaction.notifyStepStart(null,true);F.setActive(g());if(/sap-ui-xx-e2e-trace=(true|x|X)/.test(location.search)){sap.ui.requireSync("sap/ui/core/support/trace/E2eTraceLib");}return q;});
