import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSucess } from 'Types/Sale';
import { round } from 'Utility/Format';
import { BASE_URL } from 'Utility/requests';

type SeriesData = {
  name: string,
  data: number[]
}

type DataChart = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
}

function BarChart() {

  const [dataChart, setDataChart] = useState<DataChart>({ labels: { categories: [] }, series: [] });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`)
      .then(res => {
        const data = res.data as SaleSucess[];
        const newLabels = data.map(x => x.name);
        const newSeries = data.map(x => round((100.0 * x.deals / x.visited), 1));
        setDataChart({
          labels: {categories: newLabels},
          series: [{name: '% Sucesso', data: newSeries}]
        });
      })
  }, [])

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: dataChart.labels }}
      series={dataChart.series}
      type="bar"
      height="240" />
  );
}

export default BarChart;