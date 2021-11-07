import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'Types/Sale';
import { BASE_URL } from 'Utility/requests';

type DataChart = {
  series: number[];
  labels: string[];
}

function DonutChart() {

  const [dataChart, setDataChart] = useState<DataChart>({ series: [], labels: [] });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
      .then(res => {
        const data = res.data as SaleSum[];
        const newLabels = data.map(x => x.name);
        const newSeries = data.map(x => x.amount);
        setDataChart({ series: newSeries, labels: newLabels });
      })
    }, []);

  const options = {
    legend: {
      show: true
    }
  }
  return (
    <Chart
      options={{ ...options, labels: dataChart.labels}}
      series={dataChart.series}
      type="donut"
      height="240" />
  );
}

export default DonutChart;