import React, { useEffect, useState } from "react";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

function GameRow({ game }) {
  return (
    <tr>
      <td>{game.title}</td>
    </tr>
  );
}

export default function GameTable() {
  const [data, setData] = useState(null);
  useEffect(() => {
    fetch(
      'http://localhost:8080/api/v1/games'
    )
      .then(response => response.json())
      .then(data => setData(data.content));
  }, [])

  const rows = [];

  data.foreach((game) => {
    rows.push(
      <GameRow
        game={game}
        key={game.id}
      />)
  });

  return (
    <>
      <h1>Games</h1>
      <pre>
        {JSON.stringify(data, null, 2)}
      </pre>

    </>
  );
}
