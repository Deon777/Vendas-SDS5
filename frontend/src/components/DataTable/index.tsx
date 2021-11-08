import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "Types/Sale";
import { formatLocalDate } from "Utility/Format";
import { BASE_URL } from "Utility/requests";

function DataTable() {

  const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<SalePage>({
    last: true,
    totalElements: 0,
    totalPages: 0,
    number: 0,
    first: true
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales?page=${activePage}&size=10&sort=date,desc`)
      .then(res => {
        setPage(res.data);
      })
  }, [activePage])

  const changePage = (page: number) => {
    setActivePage(page);
  }

  return (
    <>
      <Pagination page={page} onPageChange={changePage}/>
      <div className="table-responsive">
        <table className="table table-striped table-sm">

          <thead>
            <tr>
              <th>Data</th>
              <th>Vendedor</th>
              <th>Clientes visitados</th>
              <th>Negócios fechados</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            {page.content?.map(sale => (
              <tr key={sale.id}>
                <td>{formatLocalDate(sale.date, "dd/MM/yyyy")}</td>
                <td>{sale.seller.name}</td>
                <td>{sale.visited}</td>
                <td>{sale.deals}</td>
                <td>{sale.amount}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default DataTable;