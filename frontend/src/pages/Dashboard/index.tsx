import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function Dashboard() {

    return (
        <>
            <NavBar />
            <div className="container">
                <h1 className="text-primary py-5">Dashboard de Vendas</h1>

                <div className="row">

                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Taxa de vendas (%)</h5>
                        <BarChart />
                    </div>
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Participação nas vendas</h5>
                        <DonutChart />
                    </div>

                </div>

                <div className="py-3">
                    <h2 className="text-primary">Todas Vendas</h2>
                    <DataTable />
                </div>
            </div>
            <Footer />
        </>
    )

}

export default Dashboard;