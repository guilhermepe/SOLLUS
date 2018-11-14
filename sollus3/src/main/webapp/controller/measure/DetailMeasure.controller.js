sap.ui.define([
	'com/guiper/sollus/controller/BaseController',	
	"sap/ui/model/json/JSONModel"
], function(BaseController, JSONModel) {
	"use strict";

	return BaseController.extend("com.guiper.sollus.controller.measure.DetailMeasure", {
		
		onInit  : function() {
			var lineChartData = {
				labels: ["January", "February", "March", "April", "May", "June", "July"],
			    datasets: [
			        {
			            label: "My First dataset",
			            fill: false,
			            lineTension: 0.1,
			            backgroundColor: "rgba(75,192,192,0.4)",
			            borderColor: "rgba(75,192,192,1)",
			            borderCapStyle: 'butt',
			            borderDash: [],
			            borderDashOffset: 0.0,
			            borderJoinStyle: 'miter',
			            pointBorderColor: "rgba(75,192,192,1)",
			            pointBackgroundColor: "#fff",
			            pointBorderWidth: 1,
			            pointHoverRadius: 5,
			            pointHoverBackgroundColor: "rgba(75,192,192,1)",
			            pointHoverBorderColor: "rgba(220,220,220,1)",
			            pointHoverBorderWidth: 2,
			            pointRadius: 1,
			            pointHitRadius: 10,
			            data: [65, 59, 80, 81, 56, 55, 40],
			            spanGaps: true
			        }
			    ]
			};
			
			var barChartData = {
				labels: ["January", "February", "March", "April", "May", "June", "July"],
			    datasets: [
			        {
			            label: "My First dataset",
			            backgroundColor: [
			                'rgba(255, 99, 132, 0.2)',
			                'rgba(54, 162, 235, 0.2)',
			                'rgba(255, 206, 86, 0.2)',
			                'rgba(75, 192, 192, 0.2)',
			                'rgba(153, 102, 255, 0.2)',
			                'rgba(255, 159, 64, 0.2)'
			            ],
			            borderColor: [
			                'rgba(255,99,132,1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 206, 86, 1)',
			                'rgba(75, 192, 192, 1)',
			                'rgba(153, 102, 255, 1)',
			                'rgba(255, 159, 64, 1)'
			            ],
			            borderWidth: 1,
			            data: [65, 59, 80, 81, 56, 55, 40],
			        }
			    ]
			};			
			
			
			this.getView().setModel( new JSONModel({
				lineChart: lineChartData,
				barChart: barChartData
			}), "temp");
			
		},
		
		/////////////////////////////////////
		// METHODS
		/////////////////////////////////////
		
		setupLineChart: function() {
			var oChart = this.getView().byId("line_chart");
			console.log(oChart);
			if( !oChart ) {
				return;
			}
			
			oChart.setGenerateLabelsCallback(function(chart){
				return Chart.defaults.global.legend.labels.generateLabels(chart);
			});
			oChart.setCustomTooltipCallback(function(tooltip){
				// tooltip will be false if tooltip is not visible or should be hidden
                if (!tooltip) {
                    return;
                }
			});
			oChart.setTooltipSortFunction(function(i0, i1){
				var v0 = i0.xLabel;  // or yLabel
			    var v1 = i1.xLabel;  // or yLabel
			    return (v0 < v1) ? -1 : (v0 > v1) ? 1 : 0;
			});
			oChart.setTooltipCallbacks({
				label: function(tooltipItem) {
		          var label = tooltipItem.yLabel;
		          return  'Scans : ' + label;
		        }
			});
		},
		
		/////////////////////////////////////
		// EVENTS
		/////////////////////////////////////
		
		onAnimationProgress: function(oEvent) {
			console.log("onAnimationProgress");
		},
		
		onAnimationComplete: function(oEvent) {
			console.log("onAnimationComplete");
		},
		
		onLegendItemClick: function(oEvent) {
			console.log("onLegendItemClick");
		},
		
		onLegendItemHover: function(oEvent) {
			console.log("onLegendItemHover");
		},
		
		onClick: function(oEvent) {
			console.log("onClick");
		},
		
		onHover: function(oEvent) {
			console.log("onHover");
		},
		
		onChangeDatasets: function(oEvent) {
			this.getView().getModel("temp").setProperty("/lineChart/labels/0/", "trolling?");
		},
		
		onTriggerUpdate: function(oEvent) {
			this.getView().byId("line_chart").updateChart();                       
		}

	});
});