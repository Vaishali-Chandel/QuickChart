public String get360ChartUrl(Chart chart) {
            long agreePercentage = getRoundedSimulationScore(chart.getAgreePer());
            long disAgreePercentage = 100 - getRoundedSimulationScore(chart.getDisagreePer());
            QuickChart quickChart = new QuickChart();
            quickChart.setHeight(30);
            quickChart.setWidth(30);
            quickChart.setConfig("{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [{\n" +
                "      data: [" + agreePercentage + ", " + disAgreePercentage + "],\n" +
                "      backgroundColor: [\"#91a93e\", \"#dedede\"],\n" +
                "	   borderWidth: 0,\n" +	  
                "    }],\n" +
                "  },\n" +
                "  options: {\n" +
                "    cutoutPercentage: 80,\n" +
                "    plugins: {\n" +
                "      datalabels: { display: false },\n" +
                "      doughnutlabel: {\n" +
                "        labels: [{\n" +
                "          text: \"" + agreePercentage + "%\",\n" +
                "			color:[\"#91a93e\"],\n" +
                "          font: { size: 8 }\n" +
                "        }]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}");
            return quickChart.getUrl().replace("h=30", "h=30&f=svg");
        }
        
        public Long getRoundedSimulationScore(Double rawScore) {
            return Math.round(rawScore);
        }
