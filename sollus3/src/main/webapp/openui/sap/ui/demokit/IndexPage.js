/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global','sap/ui/commons/RichTooltip','./DemokitApp','./HexagonButton','./HexagonButtonGroup'],function(q,R,D,H,a){"use strict";var I=function(c){var d=D.getInstance(),h=3,C;function b(s,n){return s.split('/').slice(-n-1).join('/');}this.oDemokit=d;this.sPathToRoot=b("../../../../../../../",h);this.sRootUrl=window.location.pathname.split('/').slice(-h-1,-1).join('/')+'/';this.sColor="Blue";this.oHexGroup=new a({colspan:(C||5)});if(c&&d){var p=d.getPagesForCategory(c);for(var i=0;i<p.length;i++){this.add(true,p[i].text,'',this.sPathToRoot+p[i].ico,undefined,p[i].ref);}}};I.prototype.add=function add(e,c,t,i,l,r){var b=this,B;if(typeof e!=="boolean"){r=l;l=i;i=t;t=c;c=e;e=true;}r=r||this.sRootUrl+c+'.html';if(!l){l="sap.ui.commons";}if(!t){if(e){t="A short tutorial that explains how to use the "+c+". Click to start it.";}else{t="Here you should find a tutorial for the "+c+". Unfortunately we didn't write it in time. Please hover back soon ;-)";}}B=new H({enabled:e,color:"Gray",tooltip:new R({title:c,imageSrc:i||(e?"":this.sPathToRoot+"theme/img/Under-construction.png"),text:t}),press:function(){b.oDemokit.navigateTo(r);}});if(i){B.setIcon(i);}this.oHexGroup.addButton(B);return this;};I.prototype.placeAt=function(i){this.oHexGroup.placeAt(i);q(function(){if(q("#vistaico-license").size()==0){q("body").append('<div id="vistaico-license" class="license">Some icon(s) created by <a class="sapUiDemokitLink" href="http://VistaICO.com" target="_blank">VistaICO.com</a> and <a class="sapUiDemokitLink" href="http://www.iconarchive.com/artist/fatcow.html" target="_blank">Fatcow Web Hosting</a>,	used under Creative Commons 3.0 Attribution Unported license</div>');}});};return I;},true);
