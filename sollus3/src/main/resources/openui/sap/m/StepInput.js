/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(["jquery.sap.global","sap/ui/core/Icon","./Input","./InputRenderer","sap/ui/core/Control","sap/ui/core/IconPool",'sap/ui/Device',"sap/ui/core/library","sap/ui/core/Renderer","sap/m/library","./StepInputRenderer","jquery.sap.keycodes"],function(q,I,a,b,C,c,D,d,R,l,S){"use strict";var e=l.InputType;var T=d.TextAlign;var V=d.ValueState;var f=l.StepInputValidationMode;var g=l.StepInputStepModeType;var h=C.extend("sap.m.StepInput",{metadata:{interfaces:["sap.ui.core.IFormContent"],library:"sap.m",designtime:"sap/m/designtime/StepInput.designtime",properties:{min:{type:"float",group:"Data"},max:{type:"float",group:"Data"},step:{type:"float",group:"Data",defaultValue:1},stepMode:{type:"sap.m.StepInputStepModeType",group:"Data",defaultValue:g.AdditionAndSubtraction},largerStep:{type:"float",group:"Data",defaultValue:2},value:{type:"float",group:"Data",defaultValue:0},name:{type:"string",group:"Misc",defaultValue:null},placeholder:{type:"string",group:"Misc",defaultValue:null},required:{type:"boolean",group:"Misc",defaultValue:false},width:{type:"sap.ui.core.CSSSize",group:"Dimension"},valueState:{type:"sap.ui.core.ValueState",group:"Data",defaultValue:V.None},valueStateText:{type:"string",group:"Misc",defaultValue:null},editable:{type:"boolean",group:"Behavior",defaultValue:true},enabled:{type:"boolean",group:"Behavior",defaultValue:true},displayValuePrecision:{type:"int",group:"Data",defaultValue:0},description:{type:"string",group:"Misc",defaultValue:null},fieldWidth:{type:"sap.ui.core.CSSSize",group:"Appearance",defaultValue:'50%'},textAlign:{type:"sap.ui.core.TextAlign",group:"Appearance",defaultValue:T.End},validationMode:{type:"sap.m.StepInputValidationMode",group:"Misc",defaultValue:f.FocusOut}},aggregations:{_incrementButton:{type:"sap.ui.core.Icon",multiple:false,visibility:"hidden"},_decrementButton:{type:"sap.ui.core.Icon",multiple:false,visibility:"hidden"},_input:{type:"sap.ui.core.Control",multiple:false,visibility:"hidden"}},associations:{ariaLabelledBy:{type:"sap.ui.core.Control",multiple:true,singularName:"ariaLabelledBy"},ariaDescribedBy:{type:"sap.ui.core.Control",multiple:true,singularName:"ariaDescribedBy"}},events:{change:{parameters:{value:{type:"string"}}}}},constructor:function(i,s){C.prototype.constructor.apply(this,arguments);if(this.getEditable()){this._getOrCreateDecrementButton();this._getOrCreateIncrementButton();}if(typeof i!=="string"){s=i;}if(s&&s.value===undefined){this.setValue(this._getDefaultValue(undefined,s.max,s.min));}}});var L=sap.ui.getCore().getLibraryResourceBundle("sap.m");h.STEP_INPUT_INCREASE_BTN_TOOLTIP=L.getText("STEP_INPUT_INCREASE_BTN");h.STEP_INPUT_DECREASE_BTN_TOOLTIP=L.getText("STEP_INPUT_DECREASE_BTN");h.INITIAL_WAIT_TIMEOUT=500;h.ACCELLERATION=0.8;h.MIN_WAIT_TIMEOUT=50;h.INITIAL_SPEED=120;h._TOLERANCE=10;var n={"min":"aria-valuemin","max":"aria-valuemax","value":"aria-valuenow"};var F=["enabled","editable","name","placeholder","required","valueStateText","description","fieldWidth","textAlign"];var N=R.extend(b);N.openInputTag=function(r,o){var s=o.getParent(),i=s._getDecrementButton(),E=s.getEditable();if(E&&i){this.renderButton(r,o,i,["sapMStepInputBtnDecrease"]);}b.openInputTag.apply(this,arguments);};N.closeInputTag=function(r,o){var s=o.getParent(),i=s._getIncrementButton(),E=s.getEditable();b.closeInputTag.apply(this,arguments);if(E&&i){this.renderButton(r,o,i,["sapMStepInputBtnIncrease"]);}};N.renderButton=function(r,o,B,w){var i=o.getParent()._getIsDisabledButton(w[0]);B.addStyleClass("sapMStepInputBtn");w.forEach(function(s){B.addStyleClass(s);});i?B.addStyleClass("sapMStepInputIconDisabled"):B.removeStyleClass("sapMStepInputIconDisabled");r.renderControl(B);};N.writeInnerAttributes=function(r,o){r.writeAttribute("type",o.getType().toLowerCase());if(sap.ui.getCore().getConfiguration().getRTL()){r.writeAttribute("dir","ltr");}};N.getAccessibilityState=function(o){var A=b.getAccessibilityState(o),s=o.getParent(),m=s.getMin(),M=s.getMax(),i=s.getValue(),p=s.getAriaLabelledBy().join(" "),r=s.getAriaDescribedBy().join(" ");A["role"]="spinbutton";A["valuenow"]=i;if(typeof m==="number"){A["valuemin"]=m;}if(typeof M==="number"){A["valuemax"]=M;}if(r){A["describedby"]=r;}if(p){A["labelledby"]=p;}return A;};N.writeInnerId=function(r,o){r.writeAttribute("id",o.getId()+"-"+N.getInnerSuffix(o));};N.getInnerSuffix=function(){return"inner";};N._getDescriptionSuffix=function(){return"-Descr";};var j=a.extend("sap.m.internal.NumericInput",{constructor:function(i,s){return a.apply(this,arguments);},renderer:N});h.prototype.init=function(){this._iRealPrecision=0;this._attachChange();this._bPaste=false;};h.prototype.onBeforeRendering=function(){var m=this.getMin(),M=this.getMax(),v=this.getValue();this._iRealPrecision=this._getRealValuePrecision();this._getInput().setValue(this._getFormatedValue(v));if(this._isNumericLike(m)&&(m>v)){this.setValue(m);}if(this._isNumericLike(M)&&(M<v)){this.setValue(M);}this._disableButtons(v,M,m);};h.prototype.setProperty=function(p,v,s){this._writeAccessibilityState(p,v);C.prototype.setProperty.call(this,p,v,s);if(F.indexOf(p)>-1){this._getInput().setProperty(p,this.getProperty(p),s);}return this;};h.prototype.setValidationMode=function(v){if(this.getValidationMode()!==v){switch(v){case sap.m.StepInputValidationMode.FocusOut:this._detachLiveChange();break;case sap.m.StepInputValidationMode.LiveChange:this._attachLiveChange();break;}this.setProperty("validationMode",v);}return this;};h.prototype.setMin=function(m){var r,v=this.getValue(),s=(v!==0&&!v);if(m===undefined){return this.setProperty("min",m,true);}if(!this._validateOptionalNumberProperty("min",m)){return this;}r=this.setProperty("min",m,s);this._disableButtons(v,this.getMax(),m);this._verifyValue();return r;};h.prototype.setMax=function(m){var r,v=this.getValue(),s=(v!==0&&!v);if(m===undefined){return this.setProperty("max",m,true);}if(!this._validateOptionalNumberProperty("max",m)){return this;}r=this.setProperty("max",m,s);this._disableButtons(this.getValue(),m,this.getMin());this._verifyValue();return r;};h.prototype._validateOptionalNumberProperty=function(i,v){if(this._isNumericLike(v)){return true;}q.sap.log.error("The value of property '"+i+"' must be a number");return false;};h.prototype.setDisplayValuePrecision=function(i){var v,m=this.getValue(),s=(m!==0&&!m);if(k(i)){v=parseInt(i,10);}else{v=0;q.sap.log.warning(this+": ValuePrecision ("+i+") is not correct. It should be a number between 0 and 20! Setting the default ValuePrecision:0.");}return this.setProperty("displayValuePrecision",v,s);};h.prototype.setTooltip=function(t){this._getInput().setTooltip(t);};h.prototype._getIncrementButton=function(){return this.getAggregation("_incrementButton");};h.prototype._getDecrementButton=function(){return this.getAggregation("_decrementButton");};h.prototype._createIncrementButton=function(){var i,t=this,o=new I({src:c.getIconURI("add"),id:this.getId()+"-incrementBtn",noTabStop:true,press:this._handleButtonPress.bind(this,true),tooltip:h.STEP_INPUT_INCREASE_BTN_TOOLTIP});this.setAggregation("_incrementButton",o);i=this.getAggregation("_incrementButton");i.addEventDelegate({onAfterRendering:function(){i.$().attr("tabindex","-1");t._attachEvents(o,true);}});return i;};h.prototype._createDecrementButton=function(){var i,t=this,o=new I({src:c.getIconURI("less"),id:this.getId()+"-decrementBtn",noTabStop:true,press:this._handleButtonPress.bind(this,false),tooltip:h.STEP_INPUT_DECREASE_BTN_TOOLTIP});this.setAggregation("_decrementButton",o);i=this.getAggregation("_decrementButton");i.addEventDelegate({onAfterRendering:function(){i.$().attr("tabindex","-1");t._attachEvents(o,false);}});return i;};h.prototype._getIsDisabledButton=function(t){var E=this.getEnabled(),m=this.getMin(),M=this.getMax(),v=this.getValue(),i=false;switch(t){case"sapMStepInputBtnIncrease":i=!E||(v>=M);break;case"sapMStepInputBtnDecrease":i=!E||(v<=m);break;}return i;};h.prototype._getInput=function(){if(!this.getAggregation("_input")){var o=new j({id:this.getId()+"-input",textAlign:this.getTextAlign(),type:e.Number,editable:this.getEditable(),enabled:this.getEnabled(),description:this.getDescription(),fieldWidth:this.getFieldWidth(),liveChange:this._inputLiveChangeHandler});this.setAggregation("_input",o);}return this.getAggregation("_input");};h.prototype._handleButtonPress=function(i){var o=this._calculateNewValue(1,i),m=this.getMin(),M=this.getMax();this._btndown=undefined;this._disableButtons(o.displayValue,M,m);this.setValue(o.value);this._verifyValue();if(this._sOldValue!==this.getValue()){this.fireChange({value:this.getValue()});}this.$().focus();return this;};h.prototype._disableButtons=function(v,m,i){if(!this.getDomRef()||!this._isNumericLike(v)){return;}var M=this._isNumericLike(m),o=this._isNumericLike(i);if(this._getDecrementButton()){if(o&&i<v&&this.getEnabled()){this._getDecrementButton().$().removeClass("sapMStepInputIconDisabled");}if(o&&v<=i){this._getDecrementButton().$().addClass("sapMStepInputIconDisabled");}}if(this._getIncrementButton()){if(M&&v<m&&this.getEnabled()){this._getIncrementButton().$().removeClass("sapMStepInputIconDisabled");}if(M&&v>=m){this._getIncrementButton().$().addClass("sapMStepInputIconDisabled");}}return this;};h.prototype.onfocusout=function(){this._verifyValue();};h.prototype._verifyValue=function(){var m=this.getMin(),i=this.getMax(),v=parseFloat(this._getInput().getValue());if(!this._isNumericLike(v)){return;}if((this._isNumericLike(i)&&v>i)||(this._isNumericLike(m)&&v<m)||(this._areFoldChangeRequirementsFulfilled()&&(v%this.getStep()!==0))){this.setValueState(V.Error);}else{this.setValueState(V.None);}};h.prototype.setValue=function(v){var r;if(v==undefined){v=0;}this._sOldValue=this.getValue();if(!this._validateOptionalNumberProperty("value",v)){return this;}this._getInput().setValue(this._getFormatedValue(v));this._disableButtons(v,this.getMax(),this.getMin());r=this.setProperty("value",parseFloat(v),true);this._iRealPrecision=this._getRealValuePrecision();return r;};h.prototype._getFormatedValue=function(v){var p=this.getDisplayValuePrecision(),i,s;if(v==undefined){v=this.getValue();}if(p<=0){return parseFloat(v).toFixed(0);}s=v.toString().split(".");if(s.length===2){i=s[1].length;if(i>p){return parseFloat(v).toFixed(p);}return s[0]+"."+this._padZeroesRight(s[1],p);}else{return v.toString()+"."+this._padZeroesRight("0",p);}};h.prototype._padZeroesRight=function(v,p){var r="",m=v.length;for(var i=m;i<p;i++){r=r+"0";}r=v+r;return r;};h.prototype.onsappageup=function(E){this._applyValue(this._calculateNewValue(this.getLargerStep(),true).displayValue);this._verifyValue();E.preventDefault();};h.prototype.onsappagedown=function(E){this._applyValue(this._calculateNewValue(this.getLargerStep(),false).displayValue);this._verifyValue();E.preventDefault();};h.prototype.onsappageupmodifiers=function(E){if(this._isNumericLike(this.getMax())&&!(E.ctrlKey||E.metaKey||E.altKey)&&E.shiftKey){this._applyValue(this.getMax());}};h.prototype.onsappagedownmodifiers=function(E){if(this._isNumericLike(this.getMin())&&!(E.ctrlKey||E.metaKey||E.altKey)&&E.shiftKey){this._applyValue(this.getMin());}};h.prototype.onsapup=function(E){E.preventDefault();this._applyValue(this._calculateNewValue(1,true).displayValue);this._verifyValue();};h.prototype.onsapdown=function(E){E.preventDefault();this._applyValue(this._calculateNewValue(1,false).displayValue);this._verifyValue();};h.prototype.onkeydown=function(E){var v=false;this._bPaste=(E.ctrlKey||E.metaKey)&&(E.which===q.sap.KeyCodes.V);if(E.which===q.sap.KeyCodes.ARROW_UP&&!E.altKey&&E.shiftKey&&(E.ctrlKey||E.metaKey)){this._applyValue(this.getMax());v=true;}if(E.which===q.sap.KeyCodes.ARROW_DOWN&&!E.altKey&&E.shiftKey&&(E.ctrlKey||E.metaKey)){this._applyValue(this.getMin());v=true;}if(E.which===q.sap.KeyCodes.ARROW_UP&&!(E.ctrlKey||E.metaKey||E.altKey)&&E.shiftKey){E.preventDefault();this._applyValue(this._calculateNewValue(this.getLargerStep(),true).displayValue);v=true;}if(E.which===q.sap.KeyCodes.ARROW_DOWN&&!(E.ctrlKey||E.metaKey||E.altKey)&&E.shiftKey){E.preventDefault();this._applyValue(this._calculateNewValue(this.getLargerStep(),false).displayValue);v=true;}if(v){this._verifyValue();}};h.prototype.onsapescape=function(E){this._getInput().onsapescape(E);};h.prototype._attachLiveChange=function(){this._getInput().attachLiveChange(this._liveChange,this);};h.prototype._detachLiveChange=function(){this._getInput().detachLiveChange(this._liveChange,this);};h.prototype._attachChange=function(){this._getInput().attachChange(this._change,this);};h.prototype._liveChange=function(){this._verifyValue();this._disableButtons(this._getInput().getValue(),this.getMax(),this.getMin());};h.prototype._change=function(E){this._sOldValue=this.getValue();this._verifyValue();this.setValue(this._getDefaultValue(this._getInput().getValue(),this.getMax(),this.getMin()));if(this._sOldValue!==this.getValue()&&!this._isButtonFocused()){this.fireChange({value:this.getValue()});}};h.prototype._applyValue=function(i){if(!this.getEditable()||!this.getEnabled()){return;}this.getAggregation("_input")._$input.val(this._getFormatedValue(i));};h.prototype._calculateNewValue=function(s,i){var m=this.getStep(),M=this.getMax(),o=this.getMin(),r=this.getValue(),p=parseFloat(this._getDefaultValue(this._getInput().getValue(),M,o)),t=i?1:-1,u=Math.abs(m)*Math.abs(s),v=p+t*u,w,x,y=this.getDisplayValuePrecision();if(y>0){w=this._sumValues(p,u,t,y);}else{w=v;}if(this._areFoldChangeRequirementsFulfilled()){v=w=x=this._calculateClosestFoldValue(p,u,t);}else{x=this._sumValues(r,u,t,this._iRealPrecision);}if(this._isNumericLike(M)&&v>=M){x=M;w=M;}if(this._isNumericLike(o)&&v<=o){x=o;w=o;}return{value:x,displayValue:w};};h.prototype._getRealValuePrecision=function(){var s=this.getValue().toString().split("."),i=this.getStep().toString().split("."),m,o;m=(!s[1])?0:s[1].length;o=(!i[1])?0:i[1].length;return(m>o)?m:o;};h.prototype.setValueState=function(v){var E=false,w=false;switch(v){case V.Error:E=true;break;case V.Warning:w=true;break;case V.Success:case V.None:break;default:return this;}this._getInput().setValueState(v);q.sap.delayedCall(0,this,function(){this.$().toggleClass("sapMStepInputError",E).toggleClass("sapMStepInputWarning",w);});this.setProperty("valueState",v,true);return this;};h.prototype.setEditable=function(i){var r=h.prototype.setProperty.call(this,"editable",i);i=this.getEditable();if(this.getEditable()){this._getOrCreateDecrementButton().setVisible(true);this._getOrCreateIncrementButton().setVisible(true);}else{this._getDecrementButton()&&this._getDecrementButton().setVisible(false);this._getIncrementButton()&&this._getIncrementButton().setVisible(false);}return r;};h.prototype._getOrCreateDecrementButton=function(){return this.getAggregation("_decrementButton")?this._getDecrementButton():this._createDecrementButton();};h.prototype._getOrCreateIncrementButton=function(){return this.getAggregation("_incrementButton")?this._getIncrementButton():this._createIncrementButton();};h.prototype._inputLiveChangeHandler=function(E){var v=this.getParent()._restrictCharsWhenDecimal(E);this.setProperty("value",v?v:E.getParameter("newValue"),true);};h.prototype._restrictCharsWhenDecimal=function(E){var i=E.getParameter("value").indexOf("."),m=this.getDisplayValuePrecision(),v;if(i>0&&m>0){var s=E.getParameter("value"),o=s.split('.')[1],p=o?o.length:0,r=E.getSource().getProperty("value"),t=s.split('.')[0],u=r.substring(r.indexOf('.')+1,r.length);if(!this._bPaste){if(p>m){v=t+"."+u;}}else{if(s.indexOf(".")){v=s.split('.')[0]+"."+o.substring(0,m);}this._bPaste=false;}}this._getInput().updateDomValue(v);return v;};h.prototype._getDefaultValue=function(v,m,i){if(v!==""&&v!==undefined){return this._getInput().getValue();}if(this._isNumericLike(i)&&i>0){return i;}else if(this._isNumericLike(m)&&m<0){return m;}else{return 0;}};h.prototype._isNumericLike=function(v){return!isNaN(v)&&v!==null&&v!=="";};h.prototype._isInteger=function(v){return v===parseInt(v,10);};h.prototype._writeAccessibilityState=function(p,v){var $=this._getInput().getDomRef(N.getInnerSuffix());if(!$){return;}if(p&&n[p]){$.setAttribute(n[p],v);}};h.prototype._isButtonFocused=function(){return document.activeElement===this.getAggregation("_incrementButton").getDomRef()||document.activeElement===this.getAggregation("_decrementButton").getDomRef();};h.prototype._sumValues=function(v,i,s,p){var P=Math.pow(10,p);return(parseInt(v*P,10)+(s*parseInt(i*P,10)))/P;};h.prototype._areFoldChangeRequirementsFulfilled=function(){return this.getStepMode()===g.Multiple&&this.getDisplayValuePrecision()===0&&this._isInteger(this.getStep())&&this._isInteger(this.getLargerStep());};h.prototype._calculateClosestFoldValue=function(v,s,i){var r=Math.floor(v),m=s;do{r+=i;m--;}while(r%s!==0&&m);if(r%s!==0){q.sap.log.error("Wrong next/previous value "+r+" for "+v+", step: "+s+" and sign: "+i,this);}return r;};function k(v){return(typeof(v)==='number')&&!isNaN(v)&&v>=0&&v<=20;}h.prototype._calcWaitTimeout=function(){this._speed*=h.ACCELLERATION;this._waitTimeout=((this._waitTimeout-this._speed)<h.MIN_WAIT_TIMEOUT?h.MIN_WAIT_TIMEOUT:(this._waitTimeout-this._speed));return this._waitTimeout;};h.prototype._spinValues=function(i){var t=this;if(this._btndown){this._spinTimeoutId=setTimeout(function(){if(t._btndown){var o=t._calculateNewValue(1,i);t.setValue(o.value);if(t._getIsDisabledButton("sapMStepInputBtnIncrease")||t._getIsDisabledButton("sapMStepInputBtnDecrease")){_.call(t);t.fireChange({value:t.getValue()});}t._spinValues(i);}},t._calcWaitTimeout());}};h.prototype._attachEvents=function(B,i){var t=this;var E={onmousedown:function(o){if(o.button===0&&!t._btndown){t._waitTimeout=h.INITIAL_WAIT_TIMEOUT;t._speed=h.INITIAL_SPEED;t._btndown=true;t._spinValues(i);}},onmouseup:function(o){if(t._btndown){_.call(t);}},onmouseout:function(o){if(t._btndown){_.call(t);t.fireChange({value:t.getValue()});}},oncontextmenu:function(o){o.stopImmediatePropagation(true);o.preventDefault();o.stopPropagation();}};B.addDelegate(E,true);};function _(){if(this._btndown){this._btndown=undefined;clearTimeout(this._spinTimeoutId);this._waitTimeout=500;this._speed=120;}}return h;});
