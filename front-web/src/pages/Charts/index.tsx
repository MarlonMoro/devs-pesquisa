import React, { useEffect, useState } from 'react';
import Filters from '../../components/Filters';
import { barOptions, pieOptions } from './chart-options';
import Chart from 'react-apexcharts'
import './styles.css';
import axios from 'axios';
import { buildBarSeries, getPlatformChartData, getGenderChartData } from './helpers'

const BASE_URL = 'https://app-sdspequisa.herokuapp.com';

type PieChartData = {
    labels: string[];
    series: number[];
}

type BarChartData = {
    x: string;
    y: number;
}

const initialPieData = {
    labels: [],
    series: []
}

const Charts = () => {

    const [barCartData, setBarChartData] = useState<BarChartData[]>([]);
    const [platFormData, setPlatFormData] = useState<PieChartData>(initialPieData);
    const [genderData, setGenderData] = useState<PieChartData>(initialPieData);


    useEffect(() => {
        async function getData() {
            const recordsResponse = await axios.get(`${BASE_URL}/records`);
            const gamesResponse = await axios.get(`${BASE_URL}/games`);

            console.log(recordsResponse);
            console.log(gamesResponse);

            const barData = buildBarSeries(gamesResponse.data, recordsResponse.data.content);
            setBarChartData(barData);

            const platformChartData = getPlatformChartData(recordsResponse.data.content);
            setPlatFormData(platformChartData);

            const genderChartData = getGenderChartData(recordsResponse.data.content);
            setGenderData(genderChartData);
        }
        getData();
    }, [])

    return (
        <div className="page-container">
            <Filters link="/records" linkText="Ver Tabela" />
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">Jogos mais Votados</h1>
                    <div className="games-container">
                        <Chart 
                        options={barOptions}
                        type= "bar"
                        width= "900"
                        height= "650"
                        series= { [ { data: barCartData}] }
                        />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">Plataformas</h2>
                        <Chart 
                            options={{ ...pieOptions, labels: platFormData?.labels }}
                            type="donut"
                            series= {platFormData?.series}
                            width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2 className="chart-title">Gêneros</h2>
                        <Chart 
                            options={{ ...pieOptions, labels: genderData?.labels }}
                            type="donut"
                            series= {genderData?.series}
                            width="350"
                        />
                    </div>

                </div>

            </div>
        </div>
    );
}

export default Charts;