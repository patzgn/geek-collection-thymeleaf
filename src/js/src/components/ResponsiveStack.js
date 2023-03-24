import * as React from "react";
import ActionAreaCard from "./ActionAreaCard";
import Grid from "@mui/material/Grid";

const games = [
  { title: "Mario Odyssey", shortDescription: "Fun game about Mario" },
  { title: "Pokemon", shortDescription: "Fun game about Pokemons" },
  {
    title: "Zelda Breath of The Wild",
    shortDescription: "Fun game about Link",
  },
];

export default function ResponsiveStack() {
  return (
    <div>
      <Grid container spacing={2}>
        {games.map((game) => (
          <ActionAreaCard game={game} />
        ))}
      </Grid>
    </div>
  );
}
