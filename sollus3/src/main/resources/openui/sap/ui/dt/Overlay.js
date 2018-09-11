/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global','sap/ui/core/Element','sap/ui/dt/MutationObserver','sap/ui/dt/ElementUtil','sap/ui/dt/OverlayUtil','sap/ui/dt/DOMUtil','sap/ui/dt/ScrollbarSynchronizer','sap/ui/dt/Util','sap/ui/dt/Map'],function(q,E,M,a,O,D,S,U,b){"use strict";var c="overlay-container";var o;var m;var d=E.extend("sap.ui.dt.Overlay",{metadata:{library:"sap.ui.dt",properties:{visible:{type:"boolean",defaultValue:true},focusable:{type:"boolean",defaultValue:false},isRoot:{type:"boolean",defaultValue:false}},associations:{element:{type:"sap.ui.core.Element"}},aggregations:{children:{type:"sap.ui.dt.Overlay",multiple:true},designTimeMetadata:{type:"sap.ui.dt.DesignTimeMetadata",altTypes:["function","object"],multiple:false}},events:{init:{},initFailed:{},afterRendering:{},beforeDestroy:{},destroyed:{parameters:{}},visibleChanged:{parameters:{visible:"boolean"}},geometryChanged:{},childAdded:{},scrollSynced:{},isRootChanged:{parameters:{value:{type:"boolean"}}}}},constructor:function(){this._aStyleClasses=this._aStyleClasses.slice(0);this._oScrollbarSynchronizers=new b();this._aBindParameters=[];E.apply(this,arguments);if(!this.getElement()){throw new Error("sap.ui.dt: can't create overlay without element");}this.asyncInit().then(function(){if(this._bShouldBeDestroyed){this.fireInitFailed({error:U.createError("Overlay#asyncInit","ElementOverlay is destroyed during initialization ('"+this.getId()+"')")});}else{this._bInit=true;this.fireInit();}}.bind(this)).catch(function(e){var f=U.wrapError(e);if(U.isForeignError(f)){var l='sap.ui.dt.Overlay#asyncInit';f.name='Error in '+l;f.message=U.printf("{0} / Can't initialize overlay (id='{1}') properly: {2}",l,this.getId(),f.message);}this.fireInitFailed({error:f});}.bind(this));},_bInit:false,_bRendered:false,_$DomRef:null,_aStyleClasses:['sapUiDtOverlay'],_bShouldBeDestroyed:false,_aBindParameters:null});d.getOverlayContainer=function(){if(!o){o=q("<div/>").attr('id',c).appendTo("body");}return o;};d.removeOverlayContainer=function(){if(o){o.remove();}o=undefined;};d.getMutationObserver=function(){if(!m){m=new M();}return m;};d.destroyMutationObserver=function(){if(m){m.destroy();m=null;}};d.prototype.asyncInit=function(){return Promise.resolve();};d.prototype._getAttributes=function(){return{"id":this.getId(),"data-sap-ui":this.getId(),"class":this._aStyleClasses.join(" "),"tabindex":this.isFocusable()?0:null};};d.prototype._renderChildren=function(){return this.getChildren().map(function(C){return C.isRendered()?C.$():C.render();});};d.prototype.render=function(s){if(this.isRendered()){return this.getDomRef();}this._$DomRef=q('<div/>').attr(this._getAttributes());this._$Children=q('<div/>').attr({"class":"sapUiDtOverlayChildren"}).appendTo(this._$DomRef);this._$Children.append(this._renderChildren());this._bRendered=true;if(!s){this.fireAfterRendering({domRef:this._$DomRef.get(0)});}return this._$DomRef;};d.prototype.isInit=function(){return this._bInit;};d.prototype.isRendered=function(){return this._bRendered;};d.prototype.isReady=function(){return this.isInit()&&this.isRendered();};d.prototype.addStyleClass=function(C){if(!this.hasStyleClass(C)){this._aStyleClasses.push(C);if(this.isReady()){this.$().addClass(C);}}};d.prototype.hasStyleClass=function(C){return this._aStyleClasses.indexOf(C)!==-1;};d.prototype.removeStyleClass=function(C){if(this.hasStyleClass(C)){this._aStyleClasses=this._aStyleClasses.filter(function(i){return i!==C;});if(this.isReady()){this.$().removeClass(C);}}};d.prototype.toggleStyleClass=function(C){this[(this.hasStyleClass(C)?'remove':'add')+'StyleClass'](C);};d.prototype.setElement=function(e){if(!this.getElement()){this.setAssociation("element",e);if(this._designTimeMetadataCache){this.setDesignTimeMetadata(this._designTimeMetadataCache);delete this._designTimeMetadataCache;}}};d.prototype.destroy=function(){if(this.bIsDestroyed){q.sap.log.error('FIXME: Do not destroy overlay twice (overlayId = '+this.getId()+')!');return;}this.fireBeforeDestroy();E.prototype.destroy.apply(this,arguments);};d.prototype.exit=function(){this._oScrollbarSynchronizers.forEach(function(s){s.destroy();});this._oScrollbarSynchronizers.clear();this.$().remove();delete this._bInit;delete this._bShouldBeDestroyed;delete this._$DomRef;delete this._oScrollbarSynchronizers;this.fireDestroyed();};d.prototype.setDesignTimeMetadata=function(v){if(!this.getElement()){this._designTimeMetadataCache=v;}else{this.setAggregation('designTimeMetadata',v);}};d.prototype.getDomRef=function(){return this.$().get(0);};d.prototype.getChildrenDomRef=function(){return this._$Children.get(0);};d.prototype.$=function(){return this._$DomRef||q();};d.prototype.getAssociatedDomRef=function(){throw new Error("This method is abstract and needs to be implemented");};d.prototype.getElementInstance=function(){return this.getElement();};d.prototype.getElement=function(){return a.getElementInstance(this.getAssociation('element'));};d.prototype.hasFocus=function(){return document.activeElement===this.getDomRef();};d.prototype.focus=function(){this.$().focus();};d.prototype.setFocusable=function(f){f=!!f;if(this.getFocusable()!==f){this.setProperty("focusable",f);this.toggleStyleClass("sapUiDtOverlayFocusable");this.$().attr("tabindex",f?0:null);}};d.prototype.isFocusable=function(){return this.getFocusable();};d.prototype._getRenderingParent=function(){return this.isRoot()?null:this.getParent().$();};d.prototype.applyStyles=function(i){if(!(typeof i==='boolean')){i=true;}if(this.isVisible()){var g=this.getGeometry(i);if(g&&g.visible){this._setSize(this.$(),g);var r=this._getRenderingParent();if(!this.isRoot()){var p=[];this.getParent()._oScrollbarSynchronizers.forEach(function(s){if(s._bSyncing){p.push(new Promise(function(R){s.attachEventOnce('synced',R);}));}});if(p.length){Promise.all(p).then(function(){this._applySizes(g,r);this.fireGeometryChanged();}.bind(this));}else{this._applySizes(g,r);}}else{this._applySizes(g,r);}}else{this.$().css("display","none");}}else{this.$().css("display","none");}if(!p||!p.length){this.fireGeometryChanged();}};d.prototype._applySizes=function(g,r){this._setPosition(this.$(),g,r);if(g.domRef){this._handleOverflowScroll(g,this.$(),this.getParent());}this.getChildren().forEach(function(C){C.applyStyles();});};d.prototype._setSize=function(t,g){t.css("display","block");var s=g.size;t.css("width",s.width+"px");t.css("height",s.height+"px");};d.prototype._setPosition=function(t,g,p){var r=sap.ui.getCore().getConfiguration().getRTL();var P=p?p.scrollTop():null;var i=p?p.scrollLeft():null;var e=p?p.offset():null;var f=D.getOffsetFromParent(g.position,e,P,i);if(r){var h=this.isRoot()?q(window).width():p.width();f.left=f.left-(h-g.size.width);}t.css("transform","translate("+f.left+"px, "+f.top+"px)");};d.prototype.attachBrowserEvent=function(e,h,l){if(e&&(typeof(e)==="string")){if(typeof h==="function"){if(!this._aBindParameters){this._aBindParameters=[];}l=l||this;var p=h.bind(l);this._aBindParameters.push({sEventType:e,fnHandler:h,oListener:l,fnProxy:p});this.$().bind(e,p);}}return this;};d.prototype.detachBrowserEvent=function(e,h,l){if(e&&(typeof(e)==="string")){if(typeof(h)==="function"){var $=this.$(),i,p;l=l||this;if(this._aBindParameters){for(i=this._aBindParameters.length-1;i>=0;i--){p=this._aBindParameters[i];if(p.sEventType===e&&p.fnHandler===h&&p.oListener===l){this._aBindParameters.splice(i,1);$.unbind(e,p.fnProxy);}}}}}return this;};d.prototype._deleteDummyContainer=function($){var e=$.find(">.sapUiDtDummyScrollContainer");if(e.length){e.remove();if(this.getParent()&&this.getParent().$){var p=this.getParent().$();p.removeClass("sapUiDtOverlayWithScrollBar");p.removeClass("sapUiDtOverlayWithScrollBarVertical");p.removeClass("sapUiDtOverlayWithScrollBarHorizontal");}this._oScrollbarSynchronizers.get($.get(0)).destroy();this._oScrollbarSynchronizers.delete($.get(0));}};d.prototype._handleOverflowScroll=function(g,$,e){var f=g.domRef;var s=g.size;var z=D.getZIndex(f);if(z){$.css("z-index",z);}var h=D.getOverflows(f);$.css("overflow-x",h.overflowX);$.css("overflow-y",h.overflowY);var i=f.scrollHeight;var j=f.scrollWidth;if(i>Math.ceil(s.height)||j>Math.ceil(s.width)){var k=$.find("> .sapUiDtDummyScrollContainer");if(!k.length){k=q("<div/>",{css:{height:i+"px",width:j+"px"}});k=q("<div class='sapUiDtDummyScrollContainer' style='height: "+i+"px; width: "+j+"px;'></div>");if(e&&D.hasVerticalScrollBar(f)){e.$().addClass("sapUiDtOverlayWithScrollBar");e.$().addClass("sapUiDtOverlayWithScrollBarVertical");}if(e&&D.hasHorizontalScrollBar(f)){e.$().addClass("sapUiDtOverlayWithScrollBar");e.$().addClass("sapUiDtOverlayWithScrollBarHorizontal");}$.append(k);var l=new S({synced:this.fireScrollSynced.bind(this)});l.addTarget(f,$.get(0));this._oScrollbarSynchronizers.set($.get(0),l);}else{k.css({"height":i,"width":j});var l=this._oScrollbarSynchronizers.get($.get(0));if(!l.hasTarget(f)){l.addTarget(f);}}}else{this._deleteDummyContainer($);}};d.prototype.getGeometry=function(f){if(f||!this._mGeometry){var $=this.getAssociatedDomRef();var C;if($){var i=this.isRoot();C=q.makeArray($).map(function(e){return D.getGeometry(e,i);});}else{C=this.getChildren().map(function(e){return e.getGeometry(true);});}if(C.length){this._mGeometry=C.length>1?O.getGeometry(C):C[0];}else{delete this._mGeometry;}}return this._mGeometry;};d.prototype.setVisible=function(v){v=!!v;if(this.getVisible()!==v){this.setProperty("visible",v);this.fireVisibleChanged({visible:v});}};d.prototype.isVisible=function(){return(this.getVisible()&&(this.isRoot()?true:this.getParent().isVisible()));};d.prototype.setIsRoot=function(v){v=!!v;if(this.getIsRoot()!==v){this.setProperty('isRoot',v);this.fireIsRootChanged({value:v});}};d.prototype.isRoot=function(){return this.getIsRoot();};return d;},true);
