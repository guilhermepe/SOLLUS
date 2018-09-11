/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2018 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global','sap/ui/base/ManagedObjectMetadata','./ASTUtils','./Doclet','sap/ui/demokit/js/esprima'],function(q,M,A,D,e){"use strict";var S=esprima.Syntax;var c;var I;var p;var C;var s;var a=A.createPropertyMap;var u=A.unlend;var g=M._guessSingularName;var b=D.get;var d=q.sap.log.error;var w=q.sap.log.warning;var v=q.sap.log.debug;function f(n){return(n&&n.type===S.CallExpression&&n.callee.type===S.MemberExpression&&n.callee.property.type===S.Identifier&&n.callee.property.name==='extend'&&n.arguments.length>=2&&n.arguments[0].type===S.Literal&&typeof n.arguments[0].value==="string"&&u(n.arguments[1]).type===S.ObjectExpression);}function h(n){return(n&&n.type===S.CallExpression&&n.callee.type===S.MemberExpression&&k(n.callee)==='sap.ui.define');}function k(n){if(n.type===S.MemberExpression){var i=k(n.object);return i?i+"."+n.property.name:null;}else if(n.type===S.Identifier){return s[n.name]?s[n.name]:n.name;}else{return null;}}function l(n,i){var j;if(n.type===S.Literal){return n.value;}else if(n.type===S.UnaryExpression&&n.prefix&&n.argument.type===S.Literal&&typeof n.argument.value==='number'&&(n.operator==='-'||n.operator==='+')){j=n.argument.value;return n.operator==='-'?-j:j;}else if(n.type===S.MemberExpression&&i){j=k(n);if(j.indexOf(i+".")===0){return j.slice(i.length+1);}else if(j.indexOf(i.split(".").slice(-1)[0]+".")===0){return j.slice(i.split(".").slice(-1)[0].length+1);}else{w("did not understand default value '%s', falling back to source",j);return j;}}else if(n.type===S.Identifier&&n.name==='undefined'){return undefined;}else if(n.type===S.ArrayExpression&&n.elements.length===0){return"[]";}d("unexpected type of default value (type='%s', source='%s'), falling back to '???'",n.type,JSON.stringify(n,null,"\t"));return'???';}function m(i,j){var E=k(i.callee.object);var F={metatype:'control',name:i.arguments[0].value,baseType:E,doc:j&&(j.classdesc||j.description),deprecation:j&&j.deprecated,since:j&&j.since,experimental:j&&j.experimental,specialSettings:{},properties:{},aggregations:{},associations:{},events:{},methods:{}};function G(n){return n.slice(0,1).toUpperCase()+n.slice(1);}function H(N,O,P){var Q,n,R,T;Q=N&&a(N.value);if(Q){for(n in Q){if(Q.hasOwnProperty(n)){T=b(Q[n]);R=a(Q[n].value,O);if(R==null){d("no valid metadata for "+n+" (AST type '"+Q[n].value.type+"')");continue;}P(n,R,T,Q[n]);}}}}var J=u(i.arguments[1]);var K=a(J);if(K&&K.metadata&&K.metadata.value.type!==S.ObjectExpression){w("class metadata exists but can't be analyzed. It is not of type 'ObjectExpression', but a '"+K.metadata.value.type+"'.");return null;}var L=K&&K.metadata&&a(K.metadata.value);if(L){v("  analyzing metadata for '"+F.name+"'");F["abstract"]=!!(L["abstract"]&&L["abstract"].value.value);F["final"]=!!(L["final"]&&L["final"].value.value);H(L.specialSettings,"readonly",function(n,N,O){F.specialSettings[n]={name:n,doc:O&&O.description,since:O&&O.since,deprecation:O&&O.deprecated,experimental:O&&O.experimental,visibility:(N.visibility&&N.visibility.value.value)||"public",type:N.type?N.type.value.value:"any",readonly:(N.readyonly&&N.readonly.value.value)||true};});H(L.properties,"type",function(n,O,P){var Q;var N=G(n);var R;F.properties[n]={name:n,doc:P&&P.description,since:P&&P.since,deprecation:P&&P.deprecated,experimental:P&&P.experimental,visibility:(O.visibility&&O.visibility.value.value)||"public",type:(Q=O.type?O.type.value.value:"string"),defaultValue:O.defaultValue?l(O.defaultValue.value,Q):null,group:O.group?O.group.value.value:'Misc',bindable:O.bindable?!!l(O.bindable.value):false,methods:(R={"get":"get"+N,"set":"set"+N})};if(F.properties[n].bindable){R["bind"]="bind"+N;R["unbind"]="unbind"+N;}});F.defaultAggregation=(L.defaultAggregation&&L.defaultAggregation.value.value)||undefined;H(L.aggregations,"type",function(n,O,P){var N=G(n);var Q;F.aggregations[n]={name:n,doc:P&&P.description,deprecation:P&&P.deprecated,since:P&&P.since,experimental:P&&P.experimental,visibility:(O.visibility&&O.visibility.value.value)||"public",type:O.type?O.type.value.value:"sap.ui.core.Control",singularName:O.singularName?O.singularName.value.value:g(n),cardinality:(O.multiple&&!O.multiple.value.value)?"0..1":"0..n",bindable:O.bindable?!!l(O.bindable.value):false,methods:(Q={"get":"get"+N,"destroy":"destroy"+N})};if(F.aggregations[n].cardinality==="0..1"){Q["set"]="set"+N;}else{var R=G(F.aggregations[n].singularName);Q["insert"]="insert"+R;Q["add"]="add"+R;Q["remove"]="remove"+R;Q["indexOf"]="indexOf"+R;Q["removeAll"]="removeAll"+N;}if(F.aggregations[n].bindable){Q["bind"]="bind"+N;Q["unbind"]="unbind"+N;}});H(L.associations,"type",function(n,O,P){var N=G(n);var Q;F.associations[n]={name:n,doc:P&&P.description,deprecation:P&&P.deprecated,since:P&&P.since,experimental:P&&P.experimental,visibility:(O.visibility&&O.visibility.value.value)||"public",type:O.type?O.type.value.value:"sap.ui.core.Control",singularName:O.singularName?O.singularName.value.value:g(n),cardinality:(O.multiple&&O.multiple.value.value)?"0..n":"0..1",methods:(Q={"get":"get"+N})};if(F.associations[n].cardinality==="0..1"){Q["set"]="set"+N;}else{var R=G(F.associations[n].singularName);Q["add"]="add"+R;Q["remove"]="remove"+R;Q["removeAll"]="removeAll"+N;}});H(L.events,null,function(n,O,P){var N=G(n);var Q=F.events[n]={name:n,doc:P&&P.description,deprecation:P&&P.deprecated,since:P&&P.since,experimental:P&&P.experimental,allowPreventDefault:!!(O.allowPreventDefault&&O.allowPreventDefault.value.value),parameters:{},methods:{"attach":"attach"+N,"detach":"detach"+N,"fire":"fire"+N}};H(O.parameters,null,function(R,T,U){Q.parameters[R]={name:R,doc:U&&U.description,deprecation:U&&U.deprecated,since:U&&U.since,experimental:U&&U.experimental,type:T&&T.type?T.type.value.value:""};});});}return F;}function o(n){var j=D.get(n);var E=k(n.expression.left);if(E&&j&&j.isPublic()){var T={metatype:"type",doc:undefined,deprecation:false,visibility:'public'};T.name=E;if(j){T.doc=j.description;T.deprecation=j.deprecation;T.since=j.since;T.experimental=j.experimental;}var F=n.expression.right.properties||[];T.values={};for(var i=0;i<F.length;i++){var G=D.get(F[i]);var H=F[i].key;var J=F[i].value;var K={};if(H.type==S.Identifier){K.name=H.name;}else if(H.type==S.Literal){K.name=H.value;}else{throw new Error();}if(J.type==S.Literal){K.value=J.value;}else{throw new Error();}if(G!=null){K.doc=G.description;K.deprecation=G.deprecation;K.since=G.since;K.experimental=G.experimental;}T.values[K.name]=K;}I.push(T);}}function r(n){var i=D.get(n);var j=n.expression.right.arguments[0].value;var E=A.createPropertyMap(n.expression.right.arguments[1]);var F=null;if(n.expression.right.arguments.length>2&&n.expression.right.arguments[2].type==S.CallExpression&&n.expression.right.arguments[2].callee.type==S.MemberExpression&&k(n.expression.right.arguments[2].callee)=="sap.ui.base.DataType.getType"&&n.expression.right.arguments[2].arguments.length>0&&n.expression.right.arguments[2].arguments[0].type==S.Literal){F=n.expression.right.arguments[2].arguments[0].value;}if(j&&i&&i.isPublic()){var T={metatype:"type",doc:undefined,deprecation:false,visibility:'public'};T.name=j;if(i){T.doc=i.description;T.deprecation=i.deprecation;T.since=i.since;T.experimental=i.experimental;}var G=E.defaultValue;if(G){T.defaultValue=l(G.value,j);}var H=E.isValid;if(H&&H.value.type==S.FunctionExpression&&H.value.body&&H.value.body.body.length>0&&H.value.body.body[0].type==S.ReturnStatement&&H.value.body.body[0].argument.type==S.CallExpression&&H.value.body.body[0].argument.callee.type==S.MemberExpression&&H.value.body.body[0].argument.callee.object.type==S.Literal&&H.value.body.body[0].argument.callee.object.value instanceof RegExp){var J=H.value.body.body[0].argument.callee.object.value.source;if(/^\^\(.*\)\$$/.test(J)){J=J.slice(2,-2);}T.pattern=J;}T.baseType=F;I.push(T);}}function t(i){return/^\.\//.test(i)?c+i.slice(1):i;}function x(P,j){var n='',E='',F,G,H=/{(.*)}/,J;for(var i=0;i<j.length;i++){if(j[i].tag!=='param'){continue;}J=H.exec(j[i].content);F=j[i].content.indexOf(P);if(J&&F>-1){n=J[1];G=F+P.length;E=j[i].content.substr(G);E=E.replace(/[-]/,'').trim();break;}}return{name:P,type:n,doc:E};}var y={"ExpressionStatement":function(n){if(h(n.expression)){var i=0;var E,F;if(i<n.expression.arguments.length&&n.expression.arguments[i].type===S.Literal){n.expression.arguments[i++].value;}if(i<n.expression.arguments.length&&n.expression.arguments[i].type===S.ArrayExpression){E=n.expression.arguments[i++].elements;}if(i<n.expression.arguments.length&&n.expression.arguments[i].type===S.FunctionExpression){F=n.expression.arguments[i++];}if(E&&F&&F.params){for(var j=0;j<E.length;j++){var G=E[j].type===S.Literal?t(E[j].value):null;var H=j<F.params.length?F.params[j].name:null;if(G&&H){s[H]=G.replace(/\//g,'.');}}}}if(n.expression.type==S.AssignmentExpression&&n.expression.right.type==S.ObjectExpression&&n.expression.left.type==S.MemberExpression){o(n);}if(n.expression.type===S.AssignmentExpression&&n.expression.right.type===S.CallExpression&&n.expression.right.callee.type===S.MemberExpression&&n.expression.right.callee.property.type===S.Identifier&&n.expression.right.callee.property.name==='createType'&&k(n.expression.right.callee.object)=='sap.ui.base.DataType'&&n.expression.right.arguments.length>=2&&n.expression.right.arguments[0].type===S.Literal&&n.expression.right.arguments[1].type===S.ObjectExpression){r(n);}if(f(n.expression)){var J=D.get(n)||D.get(n.expression);var K=m(n.expression,J);if(K){I.push(K);}}},"VariableDeclaration":function(n){if(n.declarations.length==1&&n.declarations[0].init&&f(n.declarations[0].init)){var i=D.get(n)||D.get(n.declarations[0]);var j=m(n.declarations[0].init,i);if(j){I.push(j);}}},"FunctionExpression":function(n){var F=n.body.body;F.forEach(function(i){if(i.expression&&i.expression.type!==S.AssignmentExpression){return;}var P=i;var j=D.get(i);if(j&&j.isPublic()&&P.expression&&P.expression.left&&P.expression.left.property&&P.expression.left.object&&P.expression.left.object.object&&P.expression.left.object.object.name===C){var E={},G=P.expression.right.params?P.expression.right.params:[];E.name=P.expression.left.property.name;E.doc=j.description;E.since=j.since;E.experimental=j.experimental;E.deprecation=j.deprecated;E.type=j.type?j.type:'';E.parameters=[];G.forEach(function(H){var J=x(H.name,j.tags);E.parameters.push(J);});p[E.name]=E;}});}};function z(i){i.methods=p;}function B(j,E,n){c=n.split('/').slice(0,-1).join('/');I=[];p={};s={};C=E.split('.').pop();var F=esprima.parse(j,{comment:true,attachComment:true});A.visit(F,y);for(var i=0;i<I.length;i++){if(I[i].name===E){z(I[i]);return I[i];}}}return{analyze:B};},false);
